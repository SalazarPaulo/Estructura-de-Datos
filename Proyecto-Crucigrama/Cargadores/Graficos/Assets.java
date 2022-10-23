package Cargadores.Graficos;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage logo;

    public static void init () {
        logo = Loader.ImageLoader("/Assets/logoutp.png");
    }
}
