# SimpleTweetBot
遊びで作ってるTwitterのBot　　
IntelliJ(java8)で書かれています。

# 動かし方
IntellijのプロジェクトですのでIntellijにてArtifactを作成して動かします。  
コンパイル前に`OAthTwitter.java`にCONSUMER_KEY等のTwitterのTweetに必要なものを書き込んでおく必要があります。  
コンパイル後はcatword.txtと同一のディレクトリで  
`java -jar TweetBot.jar`
で動作させることが出来ます。  
サーバなどでバックグラウンドでsshを切っても動かしたい場合は  
`nohup java -jar TweetBot.jar > out.log 2> err.log < /dev/null &`
と動かせばsshを切断してもバックグランドで動作し続けます。


# ライセンス
このソフトウェア自体はApache License 2.0です。  

	Copyright 2017 Khromium

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	Distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.



また、このソフトウェアはTwitter4Jを用いています。  
Twitter4J部分のライセンスについては以下からご覧いただけます。  
http://twitter4j.org/ja/index.html
