Tutorial-Base
=============

開発環境
* Minecraft 1.6.4
* Minecraft Forge #964
* IntelliJ IDEA 12.6

Eclipse向け

src/main/java/comフォルダ以下をsrc/minecraft/にコピー.

src/main/resources/assetsフォルダをbin/minecraft/にコピー.

Eclipse上で実行する場合, assetsフォルダはeclipse/minecraft/bin/assets/にコピー.

IDEA+ForgeGradle向け

root/srcに上書きするか, githubからclone→モジュール化しない→setting.gradleのincludeにディレクトリ名を追加

チュートリアル内容
==================

com.sample.base.crafting

* クラフトレシピの追加

com.sample.base.smelting

* 精錬レシピの追加

com.sample.base.config

* コンフィグファイルの利用方法
