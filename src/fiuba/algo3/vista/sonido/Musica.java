package fiuba.algo3.vista.sonido;

import javafx.scene.media.AudioClip;

import java.nio.file.Path;
import java.nio.file.Paths;

import static javafx.scene.media.AudioClip.INDEFINITE;

public class Musica {

    static private Path soundPath;
    private float volumenMusica = (float) (Math.log(1.1) / Math.log(10.0) * 20.0);

    public Musica() {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        String path = "file:" + currentPath.toString();
        soundPath = Paths.get(path, "sonidos");
    }

    public void playMainTheme() {
        Path themePath = Paths.get(soundPath.toString(), "theme.mp3");
        AudioClip sonidoAmbiente = new AudioClip(themePath.toString());
        sonidoAmbiente.setCycleCount(INDEFINITE);
        sonidoAmbiente.setVolume(volumenMusica);
        sonidoAmbiente.play();
    }
}
