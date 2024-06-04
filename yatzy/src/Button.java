import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Button extends JButton {
    public Button() {
    }

    public Button(String text, String font, int x, int y, int width, int height, Panel panel) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, 12));
        this.setBounds(x, y, width, height);
        panel.add(this);
    }
    public Button(String iconImagePath, int x, int y, int width, int height, Panel panel) {
        this.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        this.setBounds(x, y, width, height);
        makeButtonTransparent(this);
        panel.add(this);
    }

    public Button(int x, int y, int width, int height, Panel panel, Screen screen, List<Button> scoreBoard) {
        this.setBounds(x, y, width, height);
        makeButtonTransparent(this);
        this.setBorderPainted(true);
        this.addActionListener(screen);
        panel.add(this);
        scoreBoard.add(this);
    }

    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}
