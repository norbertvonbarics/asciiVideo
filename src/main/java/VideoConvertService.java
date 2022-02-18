import static java.awt.Color.BLACK;
import static java.awt.Font.BOLD;

import com.github.sarxos.webcam.Webcam;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class VideoConvertService extends JComponent {

    private static final String FONT = "Ariel";

    ImageToAsciiService asciiService;
    int divider;
    int fontSize;

    @Override
    @SneakyThrows
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Webcam webcam = Webcam.getDefault();
        webcam.open();
        BufferedImage image = webcam.getImage();

        graphics.setColor(BLACK);
        graphics.setFont(new Font(FONT, BOLD, fontSize));
        asciiService.createAsciiImage(graphics, image, fontSize);

        repaint();
    }
}
