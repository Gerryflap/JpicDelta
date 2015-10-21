package Filters;

import java.awt.image.BufferedImage;

/**
 * Created by Gerben on 21-10-2015.
 */
public class ColorEdgeDetect extends Filter {


    public ColorEdgeDetect(BufferedImage in, BufferedImage out, int x, int y) {
        super(in, out, x, y);
    }

    @Override
    public void processPixel() {
        int[] in;
        int[] out = new int[3];
        int[] own = getRGB(0,0);
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                in = getRGB(x, y);
                if(x != 0 || y != 0) {
                    for (int i = 0; i < 3; i++) {
                        out[i] = (byte) (out[i] << 1);
                        if (in != null && in[i] > own[i]) {
                            out[i] += 1;
                        } else {
                            out[i] += 0;
                        }
                    }

                }
            }
        }
        setRGB(out);
    }
}
