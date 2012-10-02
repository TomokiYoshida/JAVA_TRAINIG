package ch16.ex16_11;
/**
 * 16.11:GameとPlayerを発展させて三目並べのような簡単なゲームを実装しなさい。いくつかの
Playerの実装を、それぞれ何回か実行してスコアーを取りなさい。
 * @author tom
 *
 */
public class Game {

	static String[] playerList = {"tom", "sam"};
	static int playerIndex = 0;
	public static void main(String[] args){
		String name; //クラス名

		while((name = getNextPlayer()) != null){
			try{
				PlayerLoader loader = new PlayerLoader();
				Class <? extends Player> classOf = loader.loadClass(name).asSubclass(Player.class);
				Player player = classOf.newInstance();
				Game game = new Game();
				player.play(game);
				game.reportScore(name);
			}catch(Exception e){
				reportException(name, e);
			}
		}
	}
	static void reportException(String name, Exception e){
	}
	void reportScore(String name){

	}
	static String getNextPlayer(){
		if(playerIndex < playerList.length)
		return playerList[playerIndex];
		else return null;
	}
}
