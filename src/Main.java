/**
 * Created by Gerben on 21-10-2015.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.printf("Please supply 2 arguments: <path of file to read> <path of file to write>\n");
            System.exit(1);
        }
        ImageProcessor imageProcessor = new ImageProcessor(args[0], args[1]);
        imageProcessor.processImage();

    }
}
