import javafx.scene.media.AudioClip;

public final class AudioResources {

    private static AudioClip create(String name) {
    	return new AudioClip(ClassLoader.getSystemResource(name).toString());
    }

	public static AudioClip getMenuAudio() {
		return create("files/kit-auto-fantastico-series-tv- NUEVO.mp3");
	}

	public static AudioClip getChoqueAudio() {
		return create("files/mi_explosion_03_hpx (1).mp3");
	}
	
	public static AudioClip getWinnerAudio() {
		return create("files/we-are-the-champions-copia (mp3cut.net).mp3");
	}

	public static AudioClip getFrenaAudio() {
		return create("files/car-skidding-skidding.mp3");
	}

	public static AudioClip getAceleraAudio() {
		return create("files/4CylSportsCarVari PE070901 NUEVO.mp3");
	}
	
}
