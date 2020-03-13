package com.symstudios.alchemymod.block;

import javax.annotation.Nullable;

import com.symstudios.alchemymod.AlchemyItems;
import com.symstudios.alchemymod.api.AlchemyAPI;
import com.symstudios.alchemymod.api.circle.AlchemyCircle;
import com.symstudios.alchemymod.api.effect.EffectBase;
import com.symstudios.alchemymod.api.recipe.Ingredient;
import com.symstudios.alchemymod.api.recipe.RecipeInput;
import com.symstudios.alchemymod.item.GloveItem;
import com.symstudios.alchemymod.tileentity.TileEntityAlchemyCircle;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ChalkBlock extends Block {
	
	public ChalkBlock() {
		super(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.0f));
	}
	
	@Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityAlchemyCircle();
    }
    
    @Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
		
		// Variable And Object Declaration
    	TileEntityAlchemyCircle circle = null;
    	if (world.getTileEntity(pos) instanceof TileEntityAlchemyCircle)
    		circle = (TileEntityAlchemyCircle)world.getTileEntity(pos);
    	else
    		return ActionResultType.FAIL;
		RecipeInput inputRecipe = new RecipeInput(circle.getItems());
		AlchemyCircle circleType = AlchemyAPI.findCircleFromRecipe(inputRecipe);
		Ingredient ingredient = new Ingredient(AlchemyItems.INVISIBILIA.get().getRegistryName().toString(), 1);

		// Necessary Checks For Activating Circles
		if (!world.isRemote && !player.getHeldItemMainhand().isEmpty() && player.getHeldItemMainhand().getItem() != Items.AIR) {
			Item heldItem = player.getHeldItemMainhand().getItem();

			// Unactivated Circle
			if (!circle.getTileData().getBoolean("Activated")) {
				
				// Not Activation Item
				if (heldItem != AlchemyItems.ACTIVATION_ITEM.get()) {
					
					// Level 1
					if (heldItem != AlchemyItems.INVISIBILIA.get() && circle.getTileData().getInt("HasIt") != 1) {
						circle.addItem(heldItem.getRegistryName().toString());
						player.getHeldItemMainhand().shrink(1);
					}
					
					// Level 2
					else {
						if (circle.getTileData().getInt("HasIt") < 1) {
							circle.addItem(heldItem.getRegistryName().toString());
							player.getHeldItemMainhand().shrink(1);
							System.out.println("test");
							circle.getTileData().putInt("HasIt", 1);
						}
						if (heldItem != AlchemyItems.INVISIBILIA.get()) {
							circle.addItem(heldItem.getRegistryName().toString());
							player.getHeldItemMainhand().shrink(1);
							System.out.println("test");
						}
					}
				}
				
				// Activation Item
				else {
					if (circleType != null) 
						circleType.onCircleActivated(circle, world, pos, state, player);
					
					// Level 2 Effects
					else if (inputRecipe.getIngredients().contains(ingredient)) {
						EffectBase effect = AlchemyAPI.findRandomEffect2(); 
						effect.onEffectActivated(circle, world, pos, state, player);
					}
					
					// Level 1 Effects
					else {
						EffectBase effect = AlchemyAPI.findRandomEffect();
						effect.onEffectActivated(circle, world, pos, state, player);
					}
				}

				return ActionResultType.PASS;
			}
			
			// Activated Circle
			else if (circle.getTileData().getBoolean("Activated") && player.getHeldItem(hand).getItem() instanceof GloveItem) {
				ItemStack itemStack = player.getHeldItem(hand);
				CompoundNBT compound = itemStack.hasTag() ? itemStack.getTag() : new CompoundNBT();
				compound.putString("CircleName", circle.getTileData().getString("CircleName"));
				itemStack.setTag(compound);
				player.setHeldItem(hand.MAIN_HAND, itemStack);
			}
		}
		return ActionResultType.FAIL;
	}

}
