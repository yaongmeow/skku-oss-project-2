import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String iconImagePath, int x, int y, int width, int height, Panel panel) {
        this.setIcon(new ImageIcon(Screen.class.getResource(iconImagePath)));
        this.setBounds(x, y, width, height);
        panel.add(this);
    }

    public Label(String text, String font, int fontSize, int x, int y, int width,int height, Panel panel) {
        super(text);
        this.setFont(new Font(font, Font.BOLD, fontSize));
        this.setBackground(new Color(255, 255, 255));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBounds(x, y, width, height);
        this.setOpaque(true);
        this.setBackground(Color.lightGray);
        panel.add(this);
    }
}
