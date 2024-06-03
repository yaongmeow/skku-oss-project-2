import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DiceMouseListener extends MouseAdapter {
    @Override
    public void mouseEntered(MouseEvent e) {
        JButton source = (JButton) e.getSource();
        source.setBorderPainted(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton source = (JButton) e.getSource();
        source.setBorderPainted(false);
    }
}
