import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Screen extends JFrame implements ActionListener {
    private JPanel panel;

    public Screen() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 100, 100);
        setResizable(false);
        Panel panel = new Panel();
    }

    void floatScreen() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Screen screen = new Screen();
                    screen.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
