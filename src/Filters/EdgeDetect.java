package Filters;

import java.awt.image.BufferedImage;

/**
 * Created by Gerben on 21-10-2015.
 */
public class EdgeDetect extends Filter {


    public EdgeDetect(BufferedImage in, BufferedImage out, int x, int y) {
        super(in, out, x, y);
    }

    @Override
    public void processPixel() {
        byte greyScale = 0;
        int[] in;
        int[] out = new int[3];
        int[] own = getRGB(0,0);
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                in = getRGB(x, y);
                if(x != 0 || y != 0) {
                    greyScale = (byte) (greyScale << 1);
                    if (in != null && in[0] + in[1] + in[2] > own[0] + own[1] + own[2]) {
                        greyScale += 1;
                    } else {
                        greyScale += 0;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            out[i] = greyScale;
        }
        setRGB(out);
    }
}
