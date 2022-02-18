import static java.lang.String.valueOf;
import static java.util.stream.IntStream.range;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import lombok.SneakyThrows;

public class ImageToAsciiService {

    private static final String CHARS = "Ñ@#W$9876543210?!abc;:+=-,._ ";

    void createAsciiImage(Graphics graphics, BufferedImage image, int fontSize) {

        range(0, image.getHeight()).parallel().forEach(y ->
            range(0, image.getWidth()).parallel().forEach(x -> {
                var color = new Color(image.getRGB(x, y));
                int averageColor = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                graphics.drawString(valueOf(CHARS.charAt(averageColor / CHARS.length())), x * fontSize, y * fontSize);
            })
        );

        graphics.dispose();
    }
}
