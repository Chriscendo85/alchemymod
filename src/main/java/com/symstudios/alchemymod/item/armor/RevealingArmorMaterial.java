package com.symstudios.alchemymod.item.armor;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum RevealingArmorMaterial implements IArmorMaterial {
	REVEALING("alchemymod:alchemy", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
	      return Ingredient.fromItems(Items.LEATHER);
	   });

	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	   private final String name;
	   private final int maxDamageFactor;
	   private final int[] damageReductionAmountArray;
	   private final int enchantability;
	   private final SoundEvent soundEvent;
	   private final float toughness;
	   private final LazyValue<Ingredient> repairMaterial;

	   private RevealingArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughness, Supplier<Ingredient> repairMaterialSupplier) {
	      this.name = nameIn;
	      this.maxDamageFactor = maxDamageFactorIn;
	      this.damageReductionAmountArray = damageReductionAmountsIn;
	      this.enchantability = enchantabilityIn;
	      this.soundEvent = equipSoundIn;
	      this.toughness = toughness;
	      this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
	   }

	   @Override
	   public int getDurability(EquipmentSlotType slotIn) {
	      return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	   }

	   @Override
	   public int getDamageReductionAmount(EquipmentSlotType slotIn) {
	      return this.damageReductionAmountArray[slotIn.getIndex()];
	   }

	   @Override
	   public int getEnchantability() {
	      return this.enchantability;
	   }

	   @Override
	   public SoundEvent getSoundEvent() {
	      return this.soundEvent;
	   }

	   @Override
	   public Ingredient getRepairMaterial() {
	      return this.repairMaterial.getValue();
	   }

	   @Override
	   @OnlyIn(Dist.CLIENT)
	   public String getName() {
	      return this.name;
	   }

	   @Override
	   public float getToughness() {
	      return this.toughness;
	   }

}
