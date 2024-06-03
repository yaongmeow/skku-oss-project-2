import javax.swing.*;

public class DiceButton extends JButton {
    public DiceButton(String iconImagePath, int x, int y, int width, int height) {
        this.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        this.setBounds(x, y, width, height);
    }
}
