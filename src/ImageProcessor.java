import Filters.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Gerben on 21-10-2015.
 */
public class ImageProcessor {
    BufferedImage in;
    BufferedImage out;
    File outFile;


    public ImageProcessor(String in, String out){
        try {
            this.in = ImageIO.read(new File(in));
        } catch (IOException e) {
            System.err.printf("Input file \"%s\" could not be opened", in);
            System.exit(2);
        }

        this.out = new BufferedImage(this.in.getWidth(), this.in.getHeight(), this.in.getType());
        this.outFile = new File(out);

        processImage();

        String format = in.substring(in.lastIndexOf(".") + 1);
        try {
            ImageIO.write(this.out, format, outFile);
        } catch (IOException e) {
            System.err.printf("Output file \"%s\" could not be written", out);
            System.exit(2);
        }


    }

    public void processImage() {
        Filter f;
        for (int x = 0; x < in.getWidth(); x++) {
            for (int y = 0; y < in.getHeight(); y++) {
                f = new Blur(in, out, x, y);
                f.processPixel();
            }
        }
    }
}
