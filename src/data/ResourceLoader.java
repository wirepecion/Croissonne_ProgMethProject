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
		
		background = new Image(ClassLoader.getSystemResource(
				"BACKGROUND.png").toString());
		
		String tilePath = "tilePic";
		
		betweenTwoMountain = new Image(ClassLoader.getSystemResource(
				tilePath + "/BETWEEN_TWO_MOUNTAIN.png").toString());
		castleOnAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/CASTLE_ON_ABYSS.png").toString());
		castleOnMountain = new Image(ClassLoader.getSystemResource(
				tilePath + "/CASTLE_ON_MOUNTAIN.png").toString());
		crossroadRiver = new Image(ClassLoader.getSystemResource(
				tilePath + "/CROSSROAD_RIVER.png").toString());
		curveOfDeath = new Image(ClassLoader.getSystemResource(
				tilePath + "/CURVE_OF_DEATH.png").toString());
		curveRiverBesideAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/CURVE_RIVER_BESIDE_ABYSS.png").toString());
		curveRiverTurnLeftAtAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/CURVE_RIVER_TURN_LEFT_AT_ABYSS.png").toString());
		curveRiverTurnRightAtAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/CURVE_RIVER_TURN_RIGHT_AT_ABYSS.png").toString());
		curveRiver = new Image(ClassLoader.getSystemResource(
				tilePath + "/CURVE_RIVER.png").toString());
		deepAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/DEEP_ABYSS.png").toString());
		empty = new Image(ClassLoader.getSystemResource(
				tilePath + "/EMPTY.png").toString());
		mountainBase = new Image(ClassLoader.getSystemResource(
				tilePath + "/MOUNTAIN_BASE.png").toString());
		straightRiverBesideAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/STRAIGHT_RIVER_BESIDE_ABYSS.png").toString());
		straightRiver = new Image(ClassLoader.getSystemResource(
				tilePath + "/STRAIGHT_RIVER.png").toString());
		tjunctionRiver = new Image(ClassLoader.getSystemResource(
				tilePath + "/TJUNCTION_RIVER.png").toString());
		tjunctionRiverBesideAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/TJUNCTION_RIVER_BESIDE_ABYSS.png").toString());
		waterfallToAbyss = new Image(ClassLoader.getSystemResource(
				tilePath + "/WATERFALL_TO_ABYSS.png").toString());
		
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
