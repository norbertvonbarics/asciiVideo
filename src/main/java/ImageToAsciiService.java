import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.String.valueOf;
import static java.util.stream.IntStream.range;

public class ImageToAsciiService {

    // private static String CHARS = "Ñ@#W$9876543210?!abc;:+=-,._ ";
    private static String CHARS = CharService.getChars();

    void createAsciiImage(Graphics graphics, BufferedImage image, int fontSize) {
        range(0, image.getHeight()).parallel().forEach(y ->
                range(0, image.getWidth()).parallel().forEach(x -> {
                    var color = new Color(image.getRGB(x, y));
                    int averageColor = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                    graphics.drawString(valueOf(CHARS.charAt(averageColor/ 5)), x * fontSize, y * fontSize);
                })
        );

        graphics.dispose();
    }
}
