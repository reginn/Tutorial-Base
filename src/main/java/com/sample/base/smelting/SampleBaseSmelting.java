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
		 * 土を精錬するとダイアモンドになる精錬レシピを追加する.
		 * 引数は(精錬するブロック, 精錬結果のItemStack, 精錬後に入手できる経験値)
		 * アイテムとブロックの場合の2つのメソッドが用意された.
		 */
		GameRegistry.addSmelting(Blocks.dirt,   new ItemStack(Items.diamond), 0.5F);
		GameRegistry.addSmelting(Items.diamond, new ItemStack(Items.coal),    0.5F);

		/*
		 * メタデータを持つブロック/アイテムの精錬レシピを追加するAPIがFMLに用意されていない(Forge#985時点).
		 * そのためFurnaceRecipesを直接呼び出して精錬レシピを追加する.
		 * 引数は(精錬するブロック/アイテムのItemStack, 精錬結果のItemStack, 精錬後に入手できる経験値)
		 * 今回は黒い羊毛ブロックを白い羊毛ブロックに精錬するレシピを追加している.
		 */
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Blocks.wool, 1, 15), new ItemStack(Blocks.wool, 1, 0), 0.5F);
	}
}
