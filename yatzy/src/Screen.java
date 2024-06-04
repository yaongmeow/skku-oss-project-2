import dice.Dice;
import score.*;
import score.Choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Screen extends JFrame implements ActionListener {
    private static ScreenConfiguration screenConfiguration = new ScreenConfiguration();
    private static final long serialVersionUID = 1L;
    private Panel panel = new Panel();
    private List<Button> diceButtons = new ArrayList<>();
    private List<Score> scores = new ArrayList<>();
    private List<Button> scoreBoard = new ArrayList<>();

    private List<Dice> dices = new ArrayList<>();
    private boolean[] fixDice = new boolean[5];
    private boolean[] specialDice = new boolean[5];


    private JButton item1;
    private JButton item2;

    private JButton submitBtn;
    private JButton scoreChart;
    private JButton infoItem1;
    private JButton infoItem2;

    private JButton rollButton;
    private JLabel subScoreLabel;
    private JLabel totalScoreLabel;
    private JLabel randomDice;
    private JLabel bonusLabel;


    private Button dice1;
    private Button dice2;
    private Button dice3;
    private Button dice4;
    private Button dice5;

    /* Variables for checking condition */
    private int numOfSpecialDice;
    private int rollcount;
    private int count;
    private int numOfRandDice;

    /* Flags to manage program flow */
    private boolean issubmitted;
    private boolean item2used;
    private boolean clickedItem1;
    private boolean clickedItem2;

    public Screen() throws HeadlessException {
        createDiceButtons();
        createLabels();
        createScoreButtons();
        createTextFields();
        createActionButtons();
        createScores();
        resetDices();
        start();
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
        dice1 = screenConfiguration.createDice("resource/dice1.png", 365, 625, 64, 64, panel, diceButtons);;
        dice2 = screenConfiguration.createDice("resource/dice1.png", 513, 625, 64, 64, panel, diceButtons);;
        dice3 = screenConfiguration.createDice("resource/dice1.png", 587, 625, 64, 64, panel, diceButtons);;
        dice4 = screenConfiguration.createDice("resource/dice1.png", 661, 625, 64, 64, panel, diceButtons);;
        dice5 = screenConfiguration.createDice("resource/dice1.png", 439, 625, 64, 64, panel, diceButtons);;
    }

    void createScoreButtons() {
        Button score1 = screenConfiguration.createScoreButtons(253, 145, 120, 44, panel, this, scoreBoard);
        Button score2 = screenConfiguration.createScoreButtons(253, 197, 120, 44, panel, this, scoreBoard);
        Button score3 = screenConfiguration.createScoreButtons(253, 249, 120, 44, panel, this, scoreBoard);
        Button score4 = screenConfiguration.createScoreButtons(253, 301, 120, 44, panel, this, scoreBoard);
        Button score5 = screenConfiguration.createScoreButtons(253, 353, 120, 44, panel, this, scoreBoard);
        Button score6 = screenConfiguration.createScoreButtons(253, 405, 120, 44, panel, this, scoreBoard);

        Button score7 = screenConfiguration.createScoreButtons(605, 145, 120, 44, panel, this, scoreBoard);
        Button score8 = screenConfiguration.createScoreButtons(605, 197, 120, 44, panel, this, scoreBoard);
        Button score9 = screenConfiguration.createScoreButtons(605, 249, 120, 44, panel, this, scoreBoard);
        Button score10 = screenConfiguration.createScoreButtons(605, 301, 120, 44, panel, this, scoreBoard);
        Button score11 = screenConfiguration.createScoreButtons(605, 353, 120, 44, panel, this, scoreBoard);
        Button score12 = screenConfiguration.createScoreButtons(605, 405, 120, 44, panel, this, scoreBoard);
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
        Label totalScoreLabel = new Label("0", "Arial", 16, 605, 463, 120, 64, panel);

        Label title = new Label("resource/title.png", 44, 24, 404, 113, panel);
        randomDice = new Label("resource/dice1.png", 661, 550, 64, 64, panel);
        Label diceInfo = new Label("resource/diceinfo.png", 513, 550, 138, 59, panel);
        diceInfo.setHorizontalAlignment(SwingConstants.CENTER);
        Label bonusLabel = new Label("0", "Arial", 15, 253, 496, 120, 31, panel);
        Label userNameLabel = new Label("USERNAME", "Arial", 12, 217, 552, 81, 31, panel);
        Label ageLabel = new Label("AGE", "Arial", 12, 408, 552, 51, 31, panel);
    }

    void createActionButtons() {
        rollButton = new JButton("");
        rollButton.setIcon(new ImageIcon(Screen.class.getResource("resource/roll.png")));
        rollButton.setBounds(254, 625, 81, 64);
        panel.add(rollButton);

        scoreChart = new JButton("");
        scoreChart.setIcon(new ImageIcon(Screen.class.getResource("resource/chart.png")));
        scoreChart.setBounds(469, 62, 256, 64);
        panel.add(scoreChart);

        submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 12));
        submitBtn.setBounds(217, 593, 286, 23);
        panel.add(submitBtn);

        item1 = new JButton("");
        item1.setIcon(new ImageIcon(Screen.class.getResource("resource/item1.png")));
        item1.setBounds(32, 625, 81, 64);
        panel.add(item1);

        item2 = new JButton("");
        item2.setIcon(new ImageIcon(Screen.class.getResource("resource/item2.png")));
        item2.setBounds(141, 625, 81, 64);
        panel.add(item2);

        infoItem1 = new JButton("");
        infoItem1.setIcon(new ImageIcon(Screen.class.getResource("resource/informationicon.png")));
        infoItem1.setBounds(50, 573, 44, 44);
        panel.add(infoItem1);

        infoItem2 = new JButton("");
        infoItem2.setIcon(new ImageIcon(Screen.class.getResource("resource/informationicon.png")));
        infoItem2.setBounds(159, 573, 44, 44);
        panel.add(infoItem2);

        makeButtonTransparent(rollButton);
        rollButton.addMouseListener(new DiceMouseListener());
        rollButton.addActionListener(this);

        makeButtonTransparent(scoreChart);
        scoreChart.addMouseListener(new DiceMouseListener());
        scoreChart.addActionListener(this);

        makeButtonTransparent(submitBtn);
        submitBtn.setBorderPainted(true);
        submitBtn.addActionListener(this);

        item1.addActionListener(this);
        item1.addMouseListener(new DiceMouseListener());
        makeButtonTransparent(item1);

        item2.addActionListener(this);
        item2.addMouseListener(new DiceMouseListener());
        makeButtonTransparent(item2);

        infoItem1.addActionListener(this);
        infoItem1.addMouseListener(new DiceMouseListener());
        makeButtonTransparent(infoItem1);

        infoItem2.addActionListener(this);
        infoItem2.addMouseListener(new DiceMouseListener());
        makeButtonTransparent(infoItem2);
    }

    void createTextFields() {
        TextField userIDField = new TextField(296, 552, 114, 31, panel);
        TextField ageField = new TextField(457, 552, 46, 31, panel);
    }

    void createScores() {
        scores.add(new Aces());
        scores.add(new Deuces());
        scores.add(new Threes());
        scores.add(new Fours());
        scores.add(new Fives());
        scores.add(new Sixes());
        scores.add(new Choice());
        scores.add(new FourOfKind());
        scores.add(new FullHouse());
        scores.add(new SmallStraight());
        scores.add(new LargeStraight());
        scores.add(new Yacht());
    }

    void resetDices() {
        rollcount = 0;
        dices.clear();
        for (int i = 0; i < 5; i++) {
            dices.add(new Dice());
            setDiceImage(i + 1, 1);
            fixDice[i] = false;
            specialDice[i] = false;
            numOfSpecialDice = 0;
            diceButtons.get(i).setContentAreaFilled(true);
            diceButtons.get(i).setBackground(Color.WHITE);
        }
        for (int i = 0; i < 12; i++) {
            JButton button = scoreBoard.get(i);
            if (button.isEnabled()) {
                button.setText("0");
            }
        }

        count = 0;
        numOfRandDice = 0;
        clickedItem1 = false;
        clickedItem2 = false;
        item2.setEnabled(false);
        item2used = false;
        issubmitted = false;

    }

    public void rollDices() {
        Random random = new Random();
        int randomInt;
        for (int i = 0; i < 5; i++) {
            /* User fixed dice not to be changed */
            if (fixDice[i])
                continue;

            /* If the dice is special dice, change the value not by random */
            if (specialDice[i]) {
                specialDice[i] = false;
                diceButtons.get(i).setContentAreaFilled(true);
                diceButtons.get(i).setBackground(Color.WHITE);
                dices[i].setNum(numOfRandDice);
                continue;
            }
            /* If it is just normal dice and not fixed, its value will be a random number */
            randomInt = random.nextInt(6) + 1;
            dices[i].setNum(randomInt);
        }
    }

    public void matchDice() {
        for (int i = 0; i < 5; i++) {
            int num = dices[i].getNum();
            setDiceImage(i + 1, num); // 주사위 번호는 1부터 시작하므로 i + 1을 전달
        }
    }

    private void setDiceImage(int diceNumber, int num) {
        JButton diceButton = null;

        // Set the button according to the dice number
        switch (diceNumber) {
            case 1:
                diceButton = dice1;
                break;
            case 2:
                diceButton = dice2;
                break;
            case 3:
                diceButton = dice3;
                break;
            case 4:
                diceButton = dice4;
                break;
            case 5:
                diceButton = dice5;
                break;
        }

        // Set image based on numbers
        switch (num) {
            case 1:
                diceButton.setIcon(new ImageIcon(Screen.class.getResource("resource/dice1.png")));
                break;
            case 2:
                diceButton.setIcon(new ImageIcon(Screen.class.getResource("resource/dice2.png")));
                break;
            case 3:
                diceButton.setIcon(new ImageIcon(Screen.class.getResource("resource/dice3.png")));
                break;
            case 4:
                diceButton.setIcon(new ImageIcon(Screen.class.getResource("resource/dice4.png")));
                break;
            case 5:
                diceButton.setIcon(new ImageIcon(Screen.class.getResource("resource/dice5.png")));
                break;
            case 6:
                diceButton.setIcon(new ImageIcon(Screen.class.getResource("resource/dice6.png")));
                break;
        }
    }

    private void setScore() {
        for (int i = 0; i < 12; i++) {
            JButton button = scoreBoard.get(i);
            if (button.isEnabled()) {
                Score score = scores.get(i);
                Integer calculatedScore = score.calculatedScore(dices);
                button.setText(Integer.toString(calculatedScore));
            }
        }
    }

    private void setResult() {
        int total = 0;
        int subtotal = 0;
        // Calculate sub score
        for (int i = 0; i < 6; i++) {
            JButton button = scoreBoard.get(i);
            if (!button.isEnabled()) {
                subtotal += scores.get(i).calculatedScore(dices);
            }
        }
        subScoreLabel.setText(Integer.toString(subtotal) + "/63");
        // If subscore exceeds 63, get a bonus score
        if (subtotal >= 63) {
            bonusLabel.setText("35");
            total += 35;
        }

        // Calculate total score
        total += subtotal;
        for (int i = 6; i < 12; i++) {
            JButton button = scoreBoard.get(i);
            if (!button.isEnabled()) {
                total += scores.get(i).calculatedScore(dices);
            }
        }
        totalScoreLabel.setText(Integer.toString(total));
    }
    private void start() {
        SwingWorker<Void, Integer> randDice = new SwingWorker<Void, Integer>() {

            /* In background, just update the random dice number */
            @Override
            protected Void doInBackground() throws Exception {
                while (true) {
                    Thread.sleep(300);
                    numOfRandDice++;
                    if (numOfRandDice > 6)
                        numOfRandDice = 1;
                    publish(numOfRandDice);
                }
            }
            protected void process(List<Integer> chunks) {
                int num = chunks.get(chunks.size() - 1);
                switch (num) {
                    case 1:
                        randomDice.setIcon(new ImageIcon(Screen.class.getResource("resource/dice1.png")));
                        break;
                    case 2:
                        randomDice.setIcon(new ImageIcon(Screen.class.getResource("resource/dice2.png")));
                        break;
                    case 3:
                        randomDice.setIcon(new ImageIcon(Screen.class.getResource("resource/dice3.png")));
                        break;
                    case 4:
                        randomDice.setIcon(new ImageIcon(Screen.class.getResource("resource/dice4.png")));
                        break;
                    case 5:
                        randomDice.setIcon(new ImageIcon(Screen.class.getResource("resource/dice5.png")));
                        break;
                    case 6:
                        randomDice.setIcon(new ImageIcon(Screen.class.getResource("resource/dice6.png")));
                        break;
                }
            }

        };
        randDice.execute();
    }

    private void windowConfiguration(Panel panel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 785, 749);
        setContentPane(panel);
        setResizable(false);
    }

    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
