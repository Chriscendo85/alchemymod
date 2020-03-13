package com.symstudios.alchemymod;

import java.util.function.Supplier;

import com.symstudios.alchemymod.block.ActivatedChalkBlock;
import com.symstudios.alchemymod.block.ChalkBlock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlchemyBlocks {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "alchemymod");

	public static final RegistryObject<Block> CHALK_BLOCK = createBlock("chalk_block", ChalkBlock::new);
	public static final RegistryObject<Block> FIRECIRCLELEVEL1 = createBlock("fire_circle_level1", ActivatedChalkBlock::new);
	
	public static <I extends Block> RegistryObject<I> createBlock(String name, Supplier<? extends I> supplier) {
		RegistryObject<I> block = AlchemyBlocks.BLOCKS.register(name, supplier);
		return block;
	}

    
}
