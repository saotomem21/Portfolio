# Team C4
<img src="https://avatars.githubusercontent.com/u/86935766?s=64&v=4" width="16px"> s1280124, Ogata Toshiki  
<img src="https://avatars.githubusercontent.com/u/87118475?s=64&v=4" width="16px"> s1280147, Saotome Makoto  
<img src="https://avatars.githubusercontent.com/u/110616994?s=64&v=4" width="16px"> s1280153, Hagihara Shun  
___

# 📊 ファイナルプレゼンテーション
## リリースされているものの使い方
あらかじめJava 17 の JRE のインストール + パスを通す  
`java -jar SortVisualizer.jar` を実行    
https://github.com/se04-aizu-2022/se04project-c4/releases  

## デバッグ + ビルド方法
**環境構築 デバッグ実行**  
Eclipse 2022 FullEdition (AdoptJDK 17.0.5)  
https://mergedoc.osdn.jp/  

Swing  
Eclipseのマーケットプレイスをから導入する

JFreeChart  
https://sourceforge.net/projects/jfreechart/files/  
ダウンロードして解凍  
`jcommon-1.0.x.jar` と `jfreechart-1.0.x.jar` をビルドパスに追加する  

デバッグでの実行はこの段階から可能

**ビルド**  
プロジェクトを右クリックから `エクスポート`  
`Java` -> `実行可能 JAR ファイル`  
起動構成を `MainFrame` にしてエクスポートする  

生成された `.jar` と同じ階層に `sort_target.csv` を作成する  
中身を `1,9,3,4,2,7,6,5,8` の形式で保存する  

`java -jar SortVisualizer.jar` で実行

## プレゼンテーションに使用したスライド
Google Slides - Google Drive  
https://docs.google.com/presentation/d/1ve0vgBss23rN30fmD9qv884bGLVB6LQ5h1or2W5_SRo/edit?usp=sharing  

リポジトリの中には `Final Presentation.pdf` として存在しています  
  ﾠﾠﾠ  
# 🏅 プロジェクトの目標
**🎉 目標達成 🎉**

- [x] 複数のソートアルゴリズムの動きを視覚的に見ることができる**GUIアプリケーション**を作成する。  
- [x] 最終的には `.jar` 形式の実行可能な形にする(はず)(予定)  

<img width="600"  src="https://user-images.githubusercontent.com/86935766/214166002-554077b4-d522-4a39-a628-dfb6d6615756.png">


# 📝 実装していく中での注意
`Javaの基本文法` + `ライブラリの扱い方` + `アルゴリズムの理解力` があれば多分乗り越えられる。  

## ネット上にあるコードをコピペしない  
- コードの書き方がファイルごとに違うと可読性が下がるため  
- ネット上にあるものはコードが冗長であったり間違っていたりするため  
- そもそも行為としてよろしくない  

コードを参考にする程度に留めて、**自分達の方法で**実装すること  
わからないことがあればメンバーに聞く  

## 適切な命名を行うこと
書いたコードは他の人が見て使うことがあるので気を配る  
以下は良くない例
- `a` → 使用用途が一発でわからない  
- `numberOfSortedList` → 無駄に長い  
- `data` → 中身が推定できない  

詳しくは [これ](https://qiita.com/rkonno/items/1b30daf83854fecbb814) を見るといいかもしれない(見た方がいい)  
ちなみに、ブランチ切るときも同様。  
`-` で区切って2から3節くらいで作るのがベスト  

## 自分が作ったブランチ以外は弄らない
面倒くさいことになるので禁止‼️  
`main`ブランチも同様‼️  
  ﾠﾠﾠ  
# 🔧 Gitの使い方
## よくわからない状態になったら
以下、**２つのどっちかにする。**
- 一旦作業をやめて s1280124 にLINEかなんかで連絡する  
- 次回の演習までそのままの状態で放置する  
  
くれぐれも適当に検索して、よくわからないサイトの手順を踏まないように😱  

## 基本操作
※コピペするときは `$` 以降をコピペする
```
プル: 作業前、ブランチを切る前、プッシュ前には”必ず”これを実行する
$ git pull origin main

ステータス: 追加、変更、削除のあったファイルを確認できる
$ git status

アッド: リモートにアップロードしたいファイルを選ぶ
$ git add ファイル名

コミット: addをした対象にコメントをつける
$ git commit -m "ここにコメント(変更内容)"

プッシュ: リモートにアップロードする
$ git push origin 自分が今作業しているブランチ名
```
> ※このプロジェクトでは`main`にプッシュすることは、今後一切ないと考えて良い

## 担当箇所の実装を開始するとき
※コピペするときは `$` 以降をコピペする
```
ブランチ: 作業するブランチを作る
$ git branch ブランチ名

スイッチ: 作業するブランチの移動
$ git switch ブランチ名
```
> 「mainブランチで作業してしまった！」がないように注意  

  ﾠﾠﾠ  
# 💻 環境構築
Eclipse 2022 FullEdition (AdoptJDK 17.0.5)  
https://mergedoc.osdn.jp/  

Visual Studio Code  
https://code.visualstudio.com/download  

GitHubとのssh接続(鍵の設定)  
https://qiita.com/shizuma/items/2b2f873a0034839e47ce  

ターミナルで現在のブランチを見れるようにするやつ  
https://qiita.com/mikan3rd/items/d41a8ca26523f950ea9d  

# 📄 ドキュメント
Google Drive  
https://drive.google.com/drive/folders/1cjWlOPVpT_OMJzk7GwvEBbioD36h45lT?usp=share_link  
