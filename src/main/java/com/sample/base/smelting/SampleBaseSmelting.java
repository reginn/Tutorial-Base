package com.sample.base.smelting;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

@Mod(modid = SampleBaseSmelting.MODID, version = SampleBaseSmelting.VERSION)
public class SampleBaseSmelting
{
	public final static String MODID   = "SmeltingRecipe";
	public final static String VERSION = "0.0.0";

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		/*
		 * 土を精錬するとダイアモンドに,
		 * ダイアモンドを精錬すると土に,
		 * 黒い羊毛を精錬すると白い羊毛する精錬レシピを追加する.
		 * 引数は
		 * (精錬するBlock,     精錬結果のItemStack, 精錬後に入手できる経験値) : Blockの場合
		 * (精錬するItem,      精錬結果のItemStack, 精錬後に入手できる経験値) : Itemの場合
		 * (精錬するItemStack, 精錬結果のItemStack, 精錬後に入手できる経験値) : メタデータ付きのBlock/Itemの場合
		 */
		GameRegistry.addSmelting(Blocks.dirt,   new ItemStack(Items.diamond), 0.5F);
		GameRegistry.addSmelting(Items.diamond, new ItemStack(Items.coal),    0.5F);
        GameRegistry.addSmelting(new ItemStack(Blocks.wool, 1, 15), new ItemStack(Blocks.wool, 1, 0), 0.5F);
	}
}
