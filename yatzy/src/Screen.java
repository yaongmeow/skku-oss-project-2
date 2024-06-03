import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Panel panel = new Panel();
    private List<DiceButton> diceButtons = new ArrayList<>();

    private DiceButton dice1;
    private DiceButton dice2;
    private DiceButton dice3;
    private DiceButton dice4;
    private DiceButton dice5;

    public Screen() throws HeadlessException {
        createDiceButtons();
        placeButtons(panel);
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

    void createDiceButtons() {
        dice1 = new DiceButton("resource/dice1.png", 365, 625, 64, 64);
        dice2 = new DiceButton("resource/dice1.png", 513, 625, 64, 64);
        dice3 = new DiceButton("resource/dice1.png", 587, 625, 64, 64);
        dice4 = new DiceButton("resource/dice1.png", 661, 625, 64, 64);
        dice5 = new DiceButton("resource/dice1.png", 439, 625, 64, 64);
        diceButtons.add(dice1);
        diceButtons.add(dice2);
        diceButtons.add(dice3);
        diceButtons.add(dice4);
        diceButtons.add(dice5);
    }


    void placeButtons(Panel panel) {
        panel.add(dice1);
        panel.add(dice2);
        panel.add(dice3);
        panel.add(dice4);
        panel.add(dice5);
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
