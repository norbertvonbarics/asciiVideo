import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharService {

    public static String getChars() {
        String collect = IntStream.range(33, 85)
                .mapToObj(e -> "" + (char) e)
                .sorted((i, j) -> Float.compare(getBrightness(i), getBrightness(j)))
                .collect(Collectors.joining());
        return new StringBuilder(collect).reverse().toString();
    }

    private static float getBrightness(String c) {
        BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setFont(new Font("Monaco", Font.PLAIN, (int) (img.getHeight() * 0.5)));

        g.drawString(c, 0, g.getFont().getSize());
        g.dispose();

        int totalBrightness = 0;
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                totalBrightness += img.getRGB(x, y) & 0xFF;
            }
        }

        return totalBrightness / (float) (img.getWidth() * img.getHeight());
    }
}
