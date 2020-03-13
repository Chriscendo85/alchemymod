package com.symstudios.alchemymod;

import java.util.List;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.symstudios.alchemymod.item.BaseItem;
import com.symstudios.alchemymod.item.ChalkItem;
import com.symstudios.alchemymod.item.GloveItem;
import com.symstudios.alchemymod.item.InvisibiliaItem;
import com.symstudios.alchemymod.item.armor.InvisibilityArmorMaterial;
import com.symstudios.alchemymod.item.armor.RevealingArmorMaterial;
import com.symstudios.alchemymod.item.questbooks.GoldQuestBookItem;
import com.symstudios.alchemymod.item.questbooks.LightningQuestBookItem;
import com.symstudios.alchemymod.item.questbooks.QuestBookItem;
import com.symstudios.alchemymod.item.tools.SoulToolMaterial;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlchemyItems {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "alchemymod");
	public static final List<RegistryObject<Item>> SPAWN_EGGS = Lists.newArrayList();

	// Items
	public static final RegistryObject<Item> CHALK_ITEM = createItem("chalk", ChalkItem::new);
	public static final RegistryObject<Item> SOUL = createItem("soul", BaseItem::new);
	public static final RegistryObject<Item> INVISIBILIA = createItem("invisibilia", InvisibiliaItem::new);
	public static final RegistryObject<Item> GLOVE = createItem("glove", GloveItem::new);
	public static final RegistryObject<Item> QUEST_BOOK = createItem("quest_book", QuestBookItem::new);
	public static final RegistryObject<Item> GOLD_QUEST_BOOK = createItem("gold_quest_book", GoldQuestBookItem::new);
	public static final RegistryObject<Item> LIGHTNING_QUEST_BOOK = createItem("lightning_quest_book", LightningQuestBookItem::new);
	
	// Armor
	public static final RegistryObject<Item> ACTIVATION_ITEM = createItem("activation_item", BaseItem::new);public static final RegistryObject<Item> GOAT_HELMET = createItem("revealing_helmet", () -> new ArmorItem(RevealingArmorMaterial.REVEALING, EquipmentSlotType.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> INVISIBILITY_CLOAK = createItem("goat_chestplate", () -> new ArmorItem(InvisibilityArmorMaterial.INVISIBILITY, EquipmentSlotType.CHEST, new Item.Properties()));
	
	// Tools
	public static final RegistryObject<Item> SOUL_STEALER = createItem("soul_stealer",   () -> new SwordItem(SoulToolMaterial.SOUL, 3, -2.4F, group(ItemGroup.COMBAT)));
	
	public static <I extends Item> RegistryObject<I> createItem(String name, Supplier<? extends I> supplier) { 
		RegistryObject<I> item = AlchemyItems.ITEMS.register(name, supplier);
		return item;
	}
	
	//public static final Item GOAT_CHEESE = new ItemFood(6, 0.3F, true).setRegistryName("goat_cheese").setUnlocalizedName("goat_cheese");
	/**
	 * Short cut for ItemBlock registering
	 * 
	 * @param blockIn
	 * @param itemGroupIn
	 * @return
	 */
	private static Item register(Block blockIn, ItemGroup itemGroupIn) {
		return new BlockNamedItem(blockIn, (new Item.Properties()).group(itemGroupIn));
	}

	/**
	 * Short cut builder for just group in properties
	 * 
	 * @param itemGroupIn
	 * @return
	 */
	private static Item.Properties group(ItemGroup itemGroupIn) {
		return (new Item.Properties()).group(itemGroupIn);
	}

}
