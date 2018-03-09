package com.example2.utilerias;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageUtils {
	
	/**
    *
    * @param URL direccion de la imagen dentro del proyecto
    * @return una Imagen redimensionada a 16 x 16
    */
   public static ImageIcon getScaledImage(String URL){
		   ImageIcon image = new ImageIcon(ClassLoader.getSystemResource(URL), "splash");
	       ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
	       return scaledIcon;   
       
   }
   public static ImageIcon getIcon(String path) {
		return new ImageIcon(ClassLoader.getSystemResource(path), "");
	}

}
