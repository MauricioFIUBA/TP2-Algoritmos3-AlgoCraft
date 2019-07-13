package fiuba.algo3.vista.sonido;

import javafx.scene.media.AudioClip;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class EfectosDeSonido {
    static private Path soundPath;
    private float volumenCaminar = (float) (Math.log(1.01) / Math.log(10.0) * 20.0);

    public EfectosDeSonido() {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        String path = "file:" + currentPath.toString();
        soundPath = Paths.get(path, "sonidos");
    }

    private void playSonido(String nombreSonido) {
        soundPath = Paths.get(soundPath.toString(), nombreSonido);
        AudioClip sound = new AudioClip(soundPath.toString());
        sound.play();
    }

    public void playSonidoPasos() {
        AudioClip caminar;
        Random rand = new Random();
        Integer numero = rand.nextInt(4) + 1;
        Path walkPath = Paths.get(soundPath.toString(), "walk" + numero.toString() + ".mp3");
        caminar = new AudioClip(walkPath.toString());
        caminar.setVolume(volumenCaminar);
        caminar.play();
    }

    public void playSonidoRecolectar() {
        this.playSonido("recolecting.mp3");
    }

    public void playSonidoGolpear() {
        this.playSonido("mining.mp3");
    }
}
