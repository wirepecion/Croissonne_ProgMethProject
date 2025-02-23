package logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

import utils.TileArea;
import utils.TileType;

public class TileAreaDeterminer {
	
	private static final EnumMap<TileType, List<TileArea>> tileAreaMap = new EnumMap<>(TileType.class);
	
	private static List<TileArea> createTileAreas(TileArea... areas) {
        return Arrays.asList(areas);
    }
	
	public static List<TileArea> determineTileArea(TileType tileType) {
        return tileAreaMap.getOrDefault(tileType, Collections.emptyList());
    }
	
	static {
        tileAreaMap.put(TileType.CASTLE_ON_MOUNTAIN, 
        		createTileAreas(TileArea.MOUNTAIN, TileArea.MOUNTAIN, 
        						TileArea.MOUNTAIN, TileArea.MOUNTAIN));

        tileAreaMap.put(TileType.MOUNTAIN_BASE, 
        		createTileAreas(TileArea.ABYSS, TileArea.MOUNTAIN, 
        						TileArea.MOUNTAIN, TileArea.MOUNTAIN));

        tileAreaMap.put(TileType.BETWEEN_TWO_MOUNTAIN, 
        		createTileAreas(TileArea.MOUNTAIN, TileArea.ABYSS, 
        						TileArea.MOUNTAIN, TileArea.ABYSS));

        tileAreaMap.put(TileType.CURVE_OF_DEATH, 
        		createTileAreas(TileArea.ABYSS, TileArea.ABYSS, 
        						TileArea.MOUNTAIN, TileArea.MOUNTAIN));

        tileAreaMap.put(TileType.DEEP_ABYSS, 
        		createTileAreas(TileArea.ABYSS, TileArea.ABYSS, 
        						TileArea.MOUNTAIN, TileArea.ABYSS));

        tileAreaMap.put(TileType.CASTLE_ON_ABYSS, 
        		createTileAreas(TileArea.ABYSS, TileArea.ABYSS, 
        						TileArea.ABYSS, TileArea.ABYSS));

        tileAreaMap.put(TileType.WATERFALL_TO_ABYSS, 
        		createTileAreas(TileArea.ABYSS, TileArea.ABYSS, 
        						TileArea.RIVER, TileArea.ABYSS));

        tileAreaMap.put(TileType.STRAIGHT_RIVER, 
        		createTileAreas(TileArea.MOUNTAIN, TileArea.RIVER, 
        						TileArea.MOUNTAIN, TileArea.RIVER));

        tileAreaMap.put(TileType.CURVE_RIVER, 
        		createTileAreas(TileArea.MOUNTAIN, TileArea.MOUNTAIN, 
        						TileArea.RIVER, TileArea.RIVER));

        tileAreaMap.put(TileType.STRAIGHT_RIVER_BESIDE_ABYSS, 
        		createTileAreas(TileArea.ABYSS, TileArea.RIVER, 
        						TileArea.MOUNTAIN, TileArea.RIVER));
        
        tileAreaMap.put(TileType.CURVE_RIVER_TURN_LEFT_AT_ABYSS, 
                createTileAreas(TileArea.ABYSS, TileArea.MOUNTAIN, 
                                TileArea.RIVER, TileArea.RIVER));
        
        tileAreaMap.put(TileType.CURVE_RIVER_TURN_RIGHT_AT_ABYSS, 
                createTileAreas(TileArea.ABYSS, TileArea.RIVER, 
                                TileArea.RIVER, TileArea.MOUNTAIN));
        
        tileAreaMap.put(TileType.CURVE_RIVER_BESIDE_ABYSS, 
                createTileAreas(TileArea.ABYSS, TileArea.ABYSS, 
                                TileArea.RIVER, TileArea.RIVER));
        
        tileAreaMap.put(TileType.TJUNCTION_RIVER, 
                createTileAreas(TileArea.MOUNTAIN, TileArea.RIVER, 
                                TileArea.RIVER, TileArea.RIVER));
        
        tileAreaMap.put(TileType.TJUNCTION_RIVER_BESIDE_ABYSS, 
                createTileAreas(TileArea.ABYSS, TileArea.RIVER, 
                                TileArea.RIVER, TileArea.RIVER));
        
        tileAreaMap.put(TileType.CROSSROAD_RIVER, 
                createTileAreas(TileArea.RIVER, TileArea.RIVER, 
                                TileArea.RIVER, TileArea.RIVER));
        
        tileAreaMap.put(TileType.EMPTY, 
                createTileAreas(TileArea.EMPTY, TileArea.EMPTY, 
                                TileArea.EMPTY, TileArea.EMPTY));
	}
}
