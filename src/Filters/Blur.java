package Filters;

import java.awt.image.BufferedImage;

/**
 * Created by Gerben on 21-10-2015.
 */
public class Blur extends Filter {

    public Blur(BufferedImage in, BufferedImage out, int x, int y) {
        super(in, out, x, y);
    }

    @Override
    public void processPixel() {
        int[] out = new int[3];
        int[] in;

        int total = 0;
        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                in = getRGB(x, y);
                if(in != null) {
                    total += 1;
                    for (int i = 0; i < in.length && i < 3; i++) {
                        out[i] +=  in[i];
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            out[i] = out[i]/total;
        }
        setRGB(out);
    }
}
