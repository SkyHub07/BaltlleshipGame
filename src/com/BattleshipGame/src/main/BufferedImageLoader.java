package com.BattleshipGame.src.main;
import javax.imageio.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
public class BufferedImageLoader {
private BufferedImage image;
public BufferedImage LoadImage(String path) throws IOException{
	image=ImageIO.read(getClass().getResource(path));
	return image;
}
}
