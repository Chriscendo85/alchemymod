package com.symstudios.alchemymod.circle;

import com.symstudios.alchemymod.AlchemyBlocks;
import com.symstudios.alchemymod.api.circle.AlchemyCircle;
import com.symstudios.alchemymod.api.recipe.Ingredient;
import com.symstudios.alchemymod.tileentity.TileEntityAlchemyCircle;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireCircle1 extends AlchemyCircle {

	public FireCircle1() {
		super("fire1");
		this.addIngredient(new Ingredient(Items.BEETROOT, 1));
	}
	
	@Override
	public void onCircleActivated(TileEntityAlchemyCircle circle, World world, BlockPos pos, BlockState state, PlayerEntity player) {
		System.out.println("Fire Circle 1");
		//TileEntityAlchemyCircle circle2 = (TileEntityAlchemyCircle)world.getTileEntity(pos);
		world.setBlockState(pos, AlchemyBlocks.FIRECIRCLELEVEL1.get().getDefaultState(), 2);
		world.setTileEntity(pos, circle);
	}

}
