package data;

import java.util.ArrayList;
import java.util.List;

import gui.TilePane;
import component.Tile;
import javafx.scene.image.Image;
// import javafx.scene.media.AudioClip;

public class ResourceLoader {
	private static final ResourceLoader instance = new ResourceLoader();

	private List<TilePane> tilePaneList;
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

	public ResourceLoader() {
		tilePaneList = new ArrayList<TilePane>();
	}

	public static ResourceLoader getInstance() {
		return instance;
	}

	public static void loadResource() {
		betweenTwoMountain = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/BETWEEN_TWO_MOUNTAIN.png"));
		castleOnAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CASTLE_ON_ABYSS.png"));
		castleOnMountain = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CASTLE_ON_MOUNTAIN.png"));
		crossroadRiver = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CROSSROAD_RIVER.png"));
		curveOfDeath = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CURVE_OF_DEATH.png"));
		curveRiverBesideAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CURVE_RIVER_BESIDE_ABYSS.png"));
		curveRiverTurnLeftAtAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CURVE_RIVER_TURN_LEFT_AT_ABYSS.png"));
		curveRiverTurnRightAtAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CURVE_RIVER_TURN_RIGHT_AT_ABYSS.png"));
		curveRiver = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/CURVE_RIVER.png"));
		deepAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/DEEP_ABYSS.png"));
		empty = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/EMPTY.png"));
		mountainBase = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/MOUNTAIN_BASE.png"));
		straightRiverBesideAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/STRAIGHT_RIVER_BESIDE_ABYSS.png"));
		straightRiver = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/STRAIGHT_RIVER.png"));
		tjunctionRiver = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/TJUNCTION_RIVER.png"));
		tjunctionRiverBesideAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/TJUNCTION_RIVER_BESIDE_ABYSS.png"));
		waterfallToAbyss = new Image(ClassLoader.getSystemResourceAsStream(
				"tempTilePic/WATERFALL_TO_ABYSS.png"));
		
		// explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}

	public void add(TilePane tilePane) {
		tilePaneList.add(tilePane);
	}

	public List<TilePane> getTilePaneList() {
		return tilePaneList;
	}
}
