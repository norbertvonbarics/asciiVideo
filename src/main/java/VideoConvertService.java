import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.BLACK;
import static java.awt.Font.BOLD;

@AllArgsConstructor
public class VideoConvertService extends JComponent {

    private static final String FONT = "Ariel";

    ImageToAsciiService asciiService;
    private static final int fontSize = 10;

    @Override
    @SneakyThrows
    public void paint(Graphics graphics) {
        super.paint(graphics);

        // Webcam webcam = Webcam.getDefault();
        // webcam.open();
        Robot robot = new Robot();
        GraphicsDevice[] screens = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        GraphicsConfiguration screenOneConfig = screens[0].getConfigurations()[0];
        BufferedImage screen = robot.createScreenCapture(screenOneConfig.getBounds());

        graphics.setColor(BLACK);
        graphics.setFont(new Font(FONT, BOLD, fontSize));
        BufferedImage bufferedImage = resizeImage(screen, screen.getWidth() / fontSize, screen.getHeight() / fontSize);
        asciiService.createAsciiImage(graphics, bufferedImage, fontSize);

        repaint();
    }

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}
