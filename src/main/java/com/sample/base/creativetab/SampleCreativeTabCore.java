package com.sample.base.creativetab;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Mod(modid = SampleCreativeTabCore.MODID, version = SampleCreativeTabCore.VERSION)
public class SampleCreativeTabCore
{
	public static final String MODID   = "CreativeTab";
	public static final String VERSION = "0.0.0";

	/*
	 * CreativeTabsを継承したクラスからインスタンスを生成する.
	 * この時点でCreativeTabsに登録される.
	 * 引数はローカライズ用の内部名になる.
	 * itemGroup.argc, すなわちこの場合はitemGroup.diamondTab=LocalizedName
	 */
	public static final CreativeTabs diamondTab = new DiamondCreativeTab("diamondTab");

	/*
	 * ほとんどの場合, クリエイティブタブはタブ名とアイコンだけ変えればよいので,
	 * 無名クラスを使ってもよい.
	 */
	public static final CreativeTabs emeraldTab = new CreativeTabs("emeraldTab")
	{
		@Override
		public Item getTabIconItem()
		{
			return Items.emerald;
		}
	};

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		// 何もしないけど形だけ用意.
		// クリエイティブタブのローカライズはresources/assets/creativetabs/lang/en_US.langを参照のこと.
	}
}
