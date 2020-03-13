package com.symstudios.alchemymod.tileentity;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.symstudios.alchemymod.AlchemyBlocks;
import com.symstudios.alchemymod.AlchemyMod;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlchemyCircle extends TileEntity {

	private int circleType;
	private ArrayList<String> items = new ArrayList<String>();
	
	public TileEntityAlchemyCircle() {
        super(AlchemyMod.tileEntityDataType);
    }
    
    @Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		this.setCircle(compound.getInt("circleType"));
		int size = compound.getInt("itemListSize");
		for (int i = 0; i < size; i++)
		{
			items.add(compound.getString("itemListEntry" + i));
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putInt("itemListSize", items.size());
		for (int i = 0; i < items.size(); i++)
		{
			compound.putString("itemListEntry" + i, items.get(i));
		}
		compound.putInt("circleType", this.circleType);
		return compound;
	}
	
	@Override
	@Nullable
	   public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbtTag = getUpdateTag();
		return new SUpdateTileEntityPacket(getPos(), 1, nbtTag);
	   }
	
	public void setCircle(int type) {
		this.circleType = type;
	}
	
	public void addItem(String itemName)
	{
		items.add(itemName);
	}
	
	public int getItems(String itemName)
	{
		int targetItem = 0;
		for (int i = 0; i < items.size(); i++)
		{
			if (items.get(i).equals(itemName) && !this.world.isRemote) {
				targetItem++;
			}
		}
		return targetItem;
	}
	
	public ArrayList<String> getItems()
	{
		return items;
	}
	
	public void setNBTData(String circleType)
	{
		this.getTileData().putBoolean("Activated", true);
		this.getTileData().putString("CircleName", circleType);
	}

	
}
