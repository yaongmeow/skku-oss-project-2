import javax.swing.*;

public class Label extends JLabel {
    public Label(String iconImagePath, int x, int y, int width, int height, Panel panel) {
        this.setIcon(new ImageIcon(Screen.class.getResource(iconImagePath)));
        this.setBounds(x, y, width, height);
        panel.add(this);
    }
}
