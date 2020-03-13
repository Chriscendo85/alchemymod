package com.symstudios.alchemymod.api.effect;

import com.symstudios.alchemymod.tileentity.TileEntityAlchemyCircle;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EffectBase {
	private String name;

	public EffectBase(String name) {
		this.name = name;
	}

	public void onEffectActivated(TileEntityAlchemyCircle circle, World world, BlockPos pos, BlockState state, PlayerEntity player) {
		// DO THIS LATER
		/*Style style = new Style();
		TextComponentString textComponentString = new TextComponentString("You have gained a negative effect!");
		style.setColor(TextFormatting.DARK_PURPLE);
		textComponentString.setStyle(style);
		player.sendStatusMessage(textComponentString, true);*/
	}

	public String getName() {
		return this.name;
	}

}
