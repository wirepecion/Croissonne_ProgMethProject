package data;

import java.lang.reflect.Field;
import javafx.scene.image.Image;

import utils.TileType;

public class ImageLoader {
	private static final ImageLoader instance = new ImageLoader();

	public static Image startGameBackground;
	public static Image selectPlayerBackground;
	public static Image selectColorBackground;
	public static Image howToPlayBackground;
	public static Image howToPlayPageOneBackground;
	public static Image howToPlayPageTwoBackground;
	public static Image howToPlayPageThreeBackground;
	public static Image howToPlayPageFourBackground;
	public static Image inGameBackground;
	
	public static Image betweenTwoMountain;
	public static Image castleOnAbyss;
	public static Image castleOnMountain;
	public static Image crossroadRiver;
	public static Image curveOfDeath;
	public static Image curveRiverBesideAbyss;
	public static Image curveRiverTurnLeftAtAbyss;
	public static Image curveRiverTurnRightAtAbyss;
	public static Image curveRiver;
	public static Image deepAbyss;
	public static Image empty;
	public static Image emptyAlert;
	public static Image mountainBase;
	public static Image straightRiverBesideAbyss;
	public static Image straightRiver;
	public static Image tjunctionRiver;
	public static Image tjunctionRiverBesideAbyss;
	public static Image waterfallToAbyss;

	static {
		loadImage();
	}

	public static void loadImage() {
		
		startGameBackground = nameToBgImage("startGameBackgroundImage");
		selectPlayerBackground = nameToBgImage("selectPlayerBackgroundImage");
		selectColorBackground = nameToBgImage("selectColorBackgroundImage");
		inGameBackground = nameToBgImage("inGameBackgroundImage");
		howToPlayBackground = nameToBgImage("howToPlayBackgroundImage");
		howToPlayPageOneBackground = nameToBgImage("howToPlayPageOneBackgroundImage");
		howToPlayPageTwoBackground = nameToBgImage("howToPlayPageTwoBackgroundImage");
		howToPlayPageThreeBackground = nameToBgImage("howToPlayPageThreeBackgroundImage");
		howToPlayPageFourBackground = nameToBgImage("howToPlayPageFourBackgroundImage");
		
		
		betweenTwoMountain = nameToTileImage("betweenTwoMountain");
		castleOnAbyss = nameToTileImage("castleOnAbyss");
		castleOnMountain = nameToTileImage("castleOnMountain");
		crossroadRiver = nameToTileImage("crossroadRiver");
		curveOfDeath = nameToTileImage("curveOfDeath");
		curveRiverBesideAbyss = nameToTileImage("curveRiverBesideAbyss");
		curveRiverTurnLeftAtAbyss = nameToTileImage("curveRiverTurnLeftAtAbyss");
		curveRiverTurnRightAtAbyss = nameToTileImage("curveRiverTurnRightAtAbyss");
		curveRiver = nameToTileImage("curveRiver");
		deepAbyss = nameToTileImage("deepAbyss");
		empty = nameToTileImage("empty");
		emptyAlert = nameToTileImage("emptyAlert");
		mountainBase = nameToTileImage("mountainBase");
		straightRiverBesideAbyss = nameToTileImage("straightRiverBesideAbyss");
		straightRiver = nameToTileImage("straightRiver");
		tjunctionRiver = nameToTileImage("tjunctionRiver");
		tjunctionRiverBesideAbyss = nameToTileImage("tjunctionRiverBesideAbyss");
		waterfallToAbyss = nameToTileImage("waterfallToAbyss");
		
	}
	
	public static Image getTileEmptyAlert() {
		return emptyAlert;
	}
	
	public static Image getStartGameBackgroundImage() {
		return startGameBackground;
	}
	
	public static Image getSelectPlayerBackground() {
		return selectPlayerBackground;
	}
	
	public static Image getSelectColorBackgroundImage() {
		return selectColorBackground;
	}
	
	public static Image getHowToPlayImage() {
		return howToPlayBackground;
	}
	
	public static Image getHowToPlayPageOneBackground() {
		return howToPlayPageOneBackground;
	}
	
	public static Image getHowToPlayPageTwoBackground() {
		return howToPlayPageTwoBackground;
	}

	public static Image getHowToPlayPageThreeBackground() {
		return howToPlayPageThreeBackground;
	}
	
	public static Image getHowToPlayPageFourBackground() {
		return howToPlayPageFourBackground;
	}
	
	public static Image getInGameBackgroundImage() {
		return inGameBackground;
	}

	public static Image getTileImage(TileType tiletype) {
		String string;
		if (tiletype != null) string = toCamelCase(tiletype.name());
		else string = "empty";
		try {
			Field field = ImageLoader.class.getField(string);
			Image img = (Image) field.get(ImageLoader.class);
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String toCamelCase(String str) {
        String[] words = str.split("_");
        StringBuilder camelCaseString = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            camelCaseString.append(words[i].substring(0, 1).toUpperCase())
                           .append(words[i].substring(1).toLowerCase());
        }

        return camelCaseString.toString();
    }
	
	private static Image nameToTileImage(String string) {
		return 	new Image(ClassLoader.getSystemResource(
				"tilePic/" + convertToSnakeCase(string) + ".png").toString());
	}
	
	private static Image nameToBgImage(String string) {
		return new Image(ClassLoader.getSystemResource(
				"background/" + convertToSnakeCase(string) + ".png").toString());
	}
	
	private static Image nameToBtImage(String string) {
		return new Image(ClassLoader.getSystemResource(
				"button/" + convertToSnakeCase(string) + ".png").toString());
	}
	
	private static String convertToSnakeCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append("_");
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
	
}
