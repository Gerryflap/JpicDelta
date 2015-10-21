package Filters;

import java.awt.image.BufferedImage;

/**
 * Created by Gerben on 21-10-2015.
 */
public class Shift extends Filter {

    public Shift(BufferedImage in, BufferedImage out, int x, int y) {
        super(in, out, x, y);
    }

    @Override
    public void processPixel() {
        int[] rgb = getRGB(1,1);
        if (rgb == null){
            setRGB(new int[3]);
        } else {
            setRGB(rgb);
        }
    }
}
