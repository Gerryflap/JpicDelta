package Filters;

import java.awt.image.BufferedImage;

/**
 * Created by Gerben on 21-10-2015.
 */
public abstract class Filter {
    private BufferedImage in;
    private BufferedImage out;
    private int x;
    private int y;

    public Filter(BufferedImage in, BufferedImage out, int x, int y) {
        this.in = in;
        this.out = out;
        this.x = x;
        this.y = y;
    }

    public abstract void processPixel();

    public int[] getRGB(int dx, int dy){
        if (x + dx >= in.getWidth() || x + dx < 0 || y + dy >= in.getHeight() || y + dy < 0){
            return null;
        }
        long rgb = in.getRGB(x + dx, y + dy);
        if(rgb < 0){
            rgb = rgb + Integer.MAX_VALUE + 1;
        }
        int[] out = new int[3];
        for (int i = 0; i < 3; i++) {
            out[i] = (int) (rgb/(Math.pow(2, 8 * (2-i) ) ) );
            rgb = (int) (rgb%(Math.pow(2, 8 * (2-i) ) ));
        }
        return out;

    }

    public void setRGB(int[] rgb) {
        long rgbInt = 0;
        for (int i = 0; i < 3; i++) {
            rgbInt += (long) rgb[i] * Math.pow(2, 8 * (2-i));
        }
        out.setRGB(x, y, (int) rgbInt);
    }

}
