package data;

import java.lang.reflect.Field;

import javafx.scene.media.AudioClip;

public class SoundLoader {
	
	private static final SoundLoader instance = new SoundLoader();
	
	public static AudioClip tileSound0;
	public static AudioClip tileSound1;
	public static AudioClip tileSound2;
	public static AudioClip tileSound3;
	
	static {
		loadSound();
	}
	
	public static void loadSound() {
		
		tileSound0 = nameToTileSound("tileSound0");
		tileSound1 = nameToTileSound("tileSound1");
		tileSound2 = nameToTileSound("tileSound2");
		tileSound3 = nameToTileSound("tileSound3");
		
	}
	
	public static void playTileSound() {
		String string = "tileSound" + ((int) (Math.random() * 4));
		try {
			Field field = SoundLoader.class.getField(string);
			AudioClip audio = (AudioClip) field.get(SoundLoader.class);
			audio.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static AudioClip nameToTileSound(String string) {
		return 	new	AudioClip(ClassLoader.getSystemResource(
				"tileSound/" + convertToSnakeCase(string) + ".wav").toString());
	}
	
	private static String convertToSnakeCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append("_");
                result.append(Character.toLowerCase(c));
            } else if (Character.isDigit(c)) {
            	result.append("_");
            	result.append(c);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
	
}
