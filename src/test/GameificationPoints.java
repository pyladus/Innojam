package test;

public class GameificationPoints {
	private static int gameponits=0;
	private static Boolean connectProfile=true;
	

	public static int getGameponits() {
		return gameponits;
	}

	public static void addGameponits(int gameponits) {
		if(gameponits>0){
		 GameificationPoints.gameponits += gameponits;
		}
	}

	public static Boolean getConnectProfile() {
		return connectProfile;
	}

	public static void setConnectProfile(Boolean connectProfile) {
		GameificationPoints.connectProfile = connectProfile;
	}

}
