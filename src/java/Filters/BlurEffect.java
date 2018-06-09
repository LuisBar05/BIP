/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Luis
 */
public class BlurEffect {

    private BufferedImage myImage = null;

    public void ApplyFilter() {
        float[] matrix = new float[400];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = 1.0f / 400.0f;
        }
        Kernel kernel = new Kernel(20, 20, matrix);

        BufferedImageOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        this.myImage = op.filter(this.myImage, null);

//        try {
//            File myFile = new File("C:\\Users\\becho\\Desktop\\BIP\\BIP\\src\\java\\Images\\blurImage.jpg");
//            ImageIO.write(this.myImage, "jpg", myFile);
//        } catch (IOException ex) {
//            Logger.getLogger(BlurEffect.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void setMyImage(BufferedImage myImage) {
        this.myImage = myImage;
    }

    public BufferedImage getMyImage() {
        return myImage;
    }
}
