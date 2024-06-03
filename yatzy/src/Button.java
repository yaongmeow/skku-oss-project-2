import javax.swing.*;

public class Button extends JButton {
    public Button(String iconImagePath, int x, int y, int width, int height, Panel panel) {
        this.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        this.setBounds(x, y, width, height);
        makeButtonTransparent(this);
        panel.add(this);
    }

    public Button(int x, int y, int width, int height, Panel panel, Screen screen) {
        this.setBounds(x, y, width, height);
        makeButtonTransparent(this);
        this.setBorderPainted(true);
        this.addActionListener(screen);
        panel.add(this);
    }

    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}
