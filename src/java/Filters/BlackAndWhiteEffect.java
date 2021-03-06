/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Luis
 */
public class BlackAndWhiteEffect {

    private BufferedImage myImage = null;
    private int width;
    private int height;

    public void ApplyFilter() {
        this.setWidth(this.getMyImage().getWidth());
        this.setHeight(this.getMyImage().getHeight());

        int pixel, alpha, red, green, blue, avg;

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                pixel = this.getMyImage().getRGB(j, i);
                alpha = (pixel >> 24) & 0xFF;
                red = (pixel >> 16) & 0xFF;
                green = (pixel >> 8) & 0xFF;
                blue = pixel & 0xFF;
                avg = (red + green + blue) / 3;
                pixel = (alpha << 24) | (avg << 16) | (avg << 8) | avg;
                this.getMyImage().setRGB(j, i, pixel);
            }
        }

//        File f = new File("C:\\Users\\becho\\Desktop\\BIP\\BIP\\src\\java\\Images\\blackandwhiteImage.jpg");
//        try {
//            ImageIO.write(this.getMyImage(), "jpg", f);
//        } catch (IOException ex) {
//            Logger.getLogger(BlackAndWhiteEffect.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public BufferedImage getMyImage() {
        return myImage;
    }

    public void setMyImage(BufferedImage myImage) {
        this.myImage = myImage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
