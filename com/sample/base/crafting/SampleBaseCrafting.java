package com.sample.base.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
	modid = "CraftingRecipe",
	name  = "CraftingRecipe",
	version = "0.0.0"
)
public class SampleBaseCrafting {

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * 定形レシピの追加
		 * 土を縦に3つ並べるとダイア3つにするレシピ
		 * レシピの指定はObject配列内の文字列で行う.
		 * 空白はちゃんと空白として扱われる, つまり
		 * " X "     "X"
		 * " X "     "X"
		 * " X "  ,  "X"
		 * この2つは似たレシピだが, 前者は(ワークベンチでは)真ん中1列に素材を置く必要があるが,
		 * 後者は縦1列ならどこでもいい. すなわち
		 * "X"   "X  "  " X "   "  X"
		 * "X" は "X  ", " X " , "  X" の3つの場合にマッチングする.
		 * "X"   "X  "  " X "   "  X"
		 */
		GameRegistry.addRecipe(
				new ItemStack(Item.diamond, 3),
					new Object[] {
						" X ",
						" X ",
						" X ",
						'X', Block.dirt
					});

		/*
		 * 不定形レシピの追加
		 * 土と石をどんな形においてもダイアが作れるレシピ
		 */
		GameRegistry.addShapelessRecipe(
				new ItemStack(Item.diamond),
					new Object[] {
						Block.dirt, Block.stone
					});
	}
}
