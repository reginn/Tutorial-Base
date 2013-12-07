package com.sample.base.smelting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
	modid = "SmeltingRecipe",
	name  = "SmeltingRecipe",
	version = "0.0.0"
)
public class SampleBaseSmelting {

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * 土を精錬するとダイアモンドになる精錬レシピを追加する.
		 * 引数は(精錬するブロック/アイテムのID, 精錬結果のItemStack, 精錬後に入手できる経験値)
		 */
		GameRegistry.addSmelting(Block.dirt.blockID, new ItemStack(Item.diamond), 0.5F);

		/*
		 * メタデータを持つブロック/アイテムの精錬レシピを追加するAPIがFMLに用意されていない(Forge#943時点).
		 * そのためFurnaceRecipesを直接呼び出して精錬レシピを追加する.
		 * 引数は(精錬するブロック/アイテムのID, 対象のメタデータ, 精錬結果のItemStack, 精錬後に入手できる経験値)
		 * 今回は黒い羊毛ブロックを白い羊毛ブロックに精錬するレシピを追加している.
		 */
		FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15, new ItemStack(Block.cloth, 1, 0), 0.5F);
	}
}
