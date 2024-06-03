import javax.swing.*;

public class DiceButton extends JButton {
    public DiceButton(String iconImagePath, int x, int y, int width, int height, Panel panel) {
        this.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        this.setBounds(x, y, width, height);
        makeButtonTransparent(this);
        panel.add(this);
    }

    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}
