package com.bnb.gj.general.printer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.util.FSImageWriter;

public class FileTest {

	
	public static void main(String[] args) {
		try {
			File file = new File("./src/main/java/com/bnb/gj/general/printer/test.xhtml");
			int width = 500;
			int height = 10;
			Java2DRenderer renderer = new Java2DRenderer(file,1000);
			BufferedImage image = renderer.getImage();

			// write it out full size png defaults to png.
			FSImageWriter imagWriter = FSImageWriter.newJpegWriter(.76f);
			imagWriter.write(image, "./src/main/java/com/bnb/gj/general/printer/full-image.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
