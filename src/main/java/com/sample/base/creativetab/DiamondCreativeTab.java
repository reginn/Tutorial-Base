package com.sample.base.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DiamondCreativeTab extends CreativeTabs
{
	public DiamondCreativeTab(String diamondTab)
	{
		super(diamondTab);
	}

	@Override
	public Item getTabIconItem()
	{
		return Items.diamond;
	}
}
