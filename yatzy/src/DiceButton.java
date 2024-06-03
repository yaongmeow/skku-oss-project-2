import javax.swing.*;

public class DiceButton extends JButton {
    public DiceButton(String iconImagePath, int x, int y, int width, int height) {
        this.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        this.setBounds(x, y, width, height);
        makeButtonTransparent(this);
    }

    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}
