package data;

import java.lang.reflect.Field;

import javafx.scene.media.AudioClip;

public class AudioLoader {
	
	private static final AudioLoader instance = new AudioLoader();
	
	public static AudioClip tileAudio0;
	public static AudioClip tileAudio1;
	public static AudioClip tileAudio2;
	public static AudioClip tileAudio3;
	
	public static AudioClip backgroundAudio;
	
	static {
		loadAudio();
	}
	
	public static void loadAudio() {
		
		tileAudio0 = nameToTileAudio("tileAudio0");
		tileAudio1 = nameToTileAudio("tileAudio1");
		tileAudio2 = nameToTileAudio("tileAudio2");
		tileAudio3 = nameToTileAudio("tileAudio3");
		
		backgroundAudio = nameToBgAudio("backgroundAudio");
		
	}
	
	public static void playTileAudio() {
		String string = "tileAudio" + ((int) (Math.random() * 4));
		try {
			Field field = AudioLoader.class.getField(string);
			AudioClip audio = (AudioClip) field.get(AudioLoader.class);
			audio.play(0.3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void playBgAudio() {
		String string = "backgroundAudio";
		try {
			Field field = AudioLoader.class.getField(string);
			AudioClip audio = (AudioClip) field.get(AudioLoader.class);
			audio.setCycleCount(AudioClip.INDEFINITE);
			audio.play(1.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static AudioClip nameToTileAudio(String string) {
		return 	new	AudioClip(ClassLoader.getSystemResource(
				"tileAudio/" + convertToSnakeCase(string) + ".wav").toString());
	}
	
	private static AudioClip nameToBgAudio(String string) {
		return 	new	AudioClip(ClassLoader.getSystemResource(
				"backgroundAudio/" + convertToSnakeCase(string) + ".wav").toString());
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
