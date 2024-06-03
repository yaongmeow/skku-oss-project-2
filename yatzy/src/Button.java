import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Button extends JButton {
    public Button(String text, String iconImagePath, int x, int y, int width, int height) {
        super(text);
        this.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        this.setBounds(x, y, width, height);
    }
}
