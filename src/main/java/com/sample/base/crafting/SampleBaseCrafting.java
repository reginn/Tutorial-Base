package com.sample.base.crafting;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid = SampleBaseCrafting.MODID, version = SampleBaseCrafting.VERSION)
public class SampleBaseCrafting
{
	public final static String MODID = "CraftingRecipe";
	public final static String VERSION = "0.0.0";

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
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
				new ItemStack(Items.diamond, 3),
					new Object[]
					{
						" X ",
						" X ",
						" X ",
						'X', Blocks.dirt
					});

		/*
		 * 不定形レシピの追加
		 * 土と石をどんな形においてもダイアが作れるレシピ
		 */
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.diamond),
					new Object[]
					{
						Blocks.dirt, Blocks.stone
					});
	}
}
