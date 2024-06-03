import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Screen extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Panel panel;
    private List<DiceButton> diceButtons;

    private DiceButton dice1;

    public Screen() throws HeadlessException {
        dice1 = new DiceButton("resource/dice1.png", 365, 625, 64, 64);

        Panel panel = new Panel();
        panel.add(dice1);
        windowConfiguration(panel);
    }

    void floatScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Screen frame = new Screen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void windowConfiguration(Panel panel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 785, 749);
        setContentPane(panel);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
