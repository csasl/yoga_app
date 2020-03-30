package ui;

import javax.swing.*;
import java.awt.*;

public class IconCreator {

    public static ImageIcon makeIcon(String fileName, int width, int height) {
        ImageIcon icon = new ImageIcon(fileName);
        Image image = icon.getImage();
        Image resizeImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizeImage);
    }
}
