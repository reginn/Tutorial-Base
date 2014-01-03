package com.sample.base.config;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = SampleBaseConfig.MODID, version = SampleBaseConfig.VERSION)
public class SampleBaseConfig
{
	public final static String MODID   = "Config";
	public final static String VERSION = "0.0.0";

	/*
	 * BlockIDやItemIDなどをフィールド(変数)にする
	 *
	 * private int hogeBlockID;
	 * private int piyoBlockID;

	 * private int hogeItemID;
	 * private int piyoItemID;
	 */

	private boolean isHoge;

	/*
	 * コンフィグファイルは初期化の前処理(Pre Initialization)で行う.
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * event.getSuggestedConfigurationFile()は, このModのModID.cfgという形式のファイルで, 自動生成される.
		 * コンフィグファイルはjars/config以下に生成される.
		 */
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		/*
		 * ファイルへの書き込み/読み込み処理のため例外処理をはさむ必要がある.
		 */
		try
		{
			/*
			 *  ファイルをロードする.
			 */
			config.load();

			/*
			 * ない場合は設定している値がデフォルトになるが, コンフィグファイルが存在している場合は,
			 * コンフィグファイル内の数値が優先される.
			 * なお, ブロックIDの場合に限り, 他のModと(ロードした時点で)IDが重複していた場合, 4095から逆順にIDが自動で割り振られる.
			 * 1.7からBlockIDを利用しなくなったのでgetBlockメソッドも存在しない
			 *
			 * hogeBlockID = config.getBlock("HOGEBLOCK", 4050).getInt();
			  */
			/*
			 * コンフィグファイルにコメントをする場合.
			 * Propertyクラスのフィールドに直接文字列を渡す.
			 *
			 * Property piyoBlockProp = config.getBlock("PIYOBLOCK", 4051);
			 * piyoBlockProp.comment = "This is PIYOBLOCK comment";
			 */

			/*
			 * アイテムの場合も同じだが, ItemIDは重複していても自動で割り振られないことに注意.
			 *
			 * hogeItemID = config.getItem("HOGEITTEM", 20000).getInt();
			 * Property piyoItemProp = config.getItem("PIYOITEM", 20001);
			 * piyoItemProp.comment = "This is PIYOITEM comment";
			 */

			/*
			 * 真偽値をコンフィグファイルからとる場合.
			 * getの引数は(カテゴリ, キー名, デフォルト値)である.
			 */
			isHoge = config.get("GENERAL", "isHOGE", false).getBoolean(false);

			/*
			 * もしItemIDでもBlockIDでもない数値をコンフィグファイルから設定したい場合は
			 * xxx = config.get("Category", "key", 100).getInt();
			 * のようにする.
			 */
		}
		catch (Exception e)
		{
			/*
			 * ファイルの読み込み/書き込み時に例外が発生した場合, ログに残す.
			 */
			FMLLog.severe("Error Message");
		}
		finally
		{
			/*
			 * 最後に必ずセーブする.
			 */
			config.save();
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		/*
		 * Configの生成のみなので今回は何もしない
		 */
	}
}
