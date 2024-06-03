import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        createLabels();
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
        dice1 = new DiceButton("resource/dice1.png", 365, 625, 64, 64, panel);
        dice2 = new DiceButton("resource/dice1.png", 513, 625, 64, 64, panel);
        dice3 = new DiceButton("resource/dice1.png", 587, 625, 64, 64, panel);
        dice4 = new DiceButton("resource/dice1.png", 661, 625, 64, 64, panel);
        dice5 = new DiceButton("resource/dice1.png", 439, 625, 64, 64, panel);
    }

    void createLabels() {
        Label acesLabel = new Label("resource/aces.png", 44, 147, 199, 42, panel);
        Label deucesLabel = new Label("resource/deuces.png", 44, 199, 199, 42, panel);
        Label threesLabel = new Label("resource/Threes.png", 44, 251, 199, 42, panel);
        Label foursLabel = new Label("resource/Fours.png", 44, 303, 199, 42, panel);
        Label fivesLabel = new Label("resource/Fives.png", 44, 355, 199, 42, panel);
        Label sixesLabel = new Label("resource/Sixes.png", 44, 407, 199, 42, panel);
        Label choiceLabel = new Label("resource/Choice.png", 396, 147, 199, 42, panel);
        Label fourOfKindLabel = new Label("resource/4ofakind.png", 396, 199, 199, 42, panel);
        Label fullHouseLabel = new Label("resource/fullhouse.png", 396, 251, 199, 42, panel);
        Label sStraightLabel = new Label("resource/sstraight.png", 396, 303, 199, 42, panel);
        Label lStraightLabel = new Label("resource/lstraight.png", 396, 355, 199, 42, panel);
        Label yachtLabel = new Label("resource/yacht.png", 396, 407, 199, 42, panel);
        Label subTotalLabel = new Label("resource/subtotal.png", 44, 463, 199, 64, panel);
        Label totalLabel = new Label("resource/total.png", 396, 463, 199, 64, panel);
        Label subScoreLabel = new Label("0/63", "Arial", 15, 253, 463, 120, 31, panel);
        Label totalScoreLebel = new Label("0", "Arial", 16, 605, 463, 120, 64, panel);
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
