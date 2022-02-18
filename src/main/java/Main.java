import static java.awt.Toolkit.getDefaultToolkit;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Main {

    public static final String ASCII_VIDEO_CONVERTER = "asciiVideoConverter";

    public static void main(String[] args) {

        JFrame frame = new JFrame(ASCII_VIDEO_CONVERTER);
        VideoConvertService service = new VideoConvertService(new ImageToAsciiService(),2,4);
        frame.add(service);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        frame.setVisible(true);
        // frame.pack();
    }

}
