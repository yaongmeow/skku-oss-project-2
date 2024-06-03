import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {
    public TextField(int x, int y, int width, int height, Panel panel) {
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setColumns(10);
        this.setBounds(x, y, width, height);
        panel.add(this);
    }
}
