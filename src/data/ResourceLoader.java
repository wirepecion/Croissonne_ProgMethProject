package data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import gui.TilePane;
import component.Tile;
import javafx.scene.image.Image;
// import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import logic.GameLogic;
import utils.TileType;

public class ResourceLoader {
	private static final ResourceLoader instance = new ResourceLoader();

	public static Image background;
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
	public static Image mountainBase;
	public static Image straightRiverBesideAbyss;
	public static Image straightRiver;
	public static Image tjunctionRiver;
	public static Image tjunctionRiverBesideAbyss;
	public static Image waterfallToAbyss;
	
	// public static AudioClip  explosionSound;

	static {
		loadResource();
	}

	public static void loadResource() {
		
		background = new Image(ClassLoader.getSystemResourceAsStream(
				"BACKGROUND.png"));
		
		String tilePath = "tilePic";
		
		betweenTwoMountain = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/BETWEEN_TWO_MOUNTAIN.png"));
		castleOnAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CASTLE_ON_ABYSS.png"));
		castleOnMountain = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CASTLE_ON_MOUNTAIN.png"));
		crossroadRiver = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CROSSROAD_RIVER.png"));
		curveOfDeath = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CURVE_OF_DEATH.png"));
		curveRiverBesideAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CURVE_RIVER_BESIDE_ABYSS.png"));
		curveRiverTurnLeftAtAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CURVE_RIVER_TURN_LEFT_AT_ABYSS.png"));
		curveRiverTurnRightAtAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CURVE_RIVER_TURN_RIGHT_AT_ABYSS.png"));
		curveRiver = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/CURVE_RIVER.png"));
		deepAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/DEEP_ABYSS.png"));
		empty = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/EMPTY.png"));
		mountainBase = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/MOUNTAIN_BASE.png"));
		straightRiverBesideAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/STRAIGHT_RIVER_BESIDE_ABYSS.png"));
		straightRiver = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/STRAIGHT_RIVER.png"));
		tjunctionRiver = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/TJUNCTION_RIVER.png"));
		tjunctionRiverBesideAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/TJUNCTION_RIVER_BESIDE_ABYSS.png"));
		waterfallToAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				tilePath + "/WATERFALL_TO_ABYSS.png"));
		
		// explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}
	
	public static Image getBackgroundImage() {
		return background;
	}

	public static Image getTileImage(TileType tiletype) {
		String string;
		if (tiletype != null) string = toCamelCase(tiletype.name());
		else string = "empty";
		try {
			Field field = ResourceLoader.class.getField(string);
			Image img = (Image) field.get(ResourceLoader.class);
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
	
}
