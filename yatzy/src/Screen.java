import dice.Dice;
import score.*;
import score.Choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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

    private JTextField userIDField;
    private JTextField ageField;


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
    private boolean isSubmitted;
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
        dice1 = screenConfiguration.createDice("resource/dice1.png", 365, 625, 64, 64, panel, diceButtons, this);;
        dice2 = screenConfiguration.createDice("resource/dice1.png", 513, 625, 64, 64, panel, diceButtons, this);;
        dice3 = screenConfiguration.createDice("resource/dice1.png", 587, 625, 64, 64, panel, diceButtons, this);;
        dice4 = screenConfiguration.createDice("resource/dice1.png", 661, 625, 64, 64, panel, diceButtons, this);;
        dice5 = screenConfiguration.createDice("resource/dice1.png", 439, 625, 64, 64, panel, diceButtons, this);;
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
        screenConfiguration.createStaticComponents(panel);
        subScoreLabel = new Label("0/63", "Arial", 15, 253, 463, 120, 31, panel);
        totalScoreLabel = new Label("0", "Arial", 16, 605, 463, 120, 64, panel);
        randomDice = new Label("resource/dice1.png", 661, 550, 64, 64, panel);
        bonusLabel = new Label("0", "Arial", 15, 253, 496, 120, 31, panel);
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
        userIDField = new TextField(296, 552, 114, 31, panel);
        ageField = new TextField(457, 552, 46, 31, panel);
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
        isSubmitted = false;

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
                dices.get(i).setNum(numOfRandDice);
                continue;
            }
            /* If it is just normal dice and not fixed, its value will be a random number */
            randomInt = random.nextInt(6) + 1;
            dices.get(i).setNum(randomInt);
        }
    }

    public void matchDice() {
        for (int i = 0; i < 5; i++) {
            int num = dices.get(i).getNum();
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

    private boolean validInput() {
        String userID = userIDField.getText();
        String age = ageField.getText();
        /* if input is invalid, shows the message */
        try {
            if (userID.isEmpty() || age.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter Input", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (userID.length() != 5) {
                JOptionPane.showMessageDialog(null, "Username's length should be 5", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
            for (char c : userID.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    JOptionPane.showMessageDialog(null, "Enter only alphabet or number in the user field", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }

            int num = Integer.valueOf(age);

            if (num < 0) {
                JOptionPane.showMessageDialog(null, "Age can't be below 0", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter only number in the age filed", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
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
        JButton clickButton = (JButton) e.getSource();

        // 유저가 주사위를 클릭한 경우 발생하는 이벤트
        for (int i = 0; i < 5; i++) {
            JButton button = diceButtons.get(i);
            if (clickButton == button) {
                if (rollcount == 0 || rollcount > 2) {
                    if (!clickedItem2)
                        return;
                }
                if (clickedItem1) {
                    if (fixDice[i])
                        return;
                    // 아이템을 사용하여 유저는 스페셜 주사위를 사용할 수 있음
                    // 이미 고정된 주사위는 스페셜 주사위가 될 수 없음
                    // 스페셜 주사위는 분홍색 주사위로 표시된다
                    if (!specialDice[i]) {
                        if (numOfSpecialDice >= 2)
                            return;
                        specialDice[i] = true;
                        button.setContentAreaFilled(true);
                        button.setBackground(Color.PINK);
                        numOfSpecialDice++;
                        return;
                    } else {
                        specialDice[i] = false;
                        button.setContentAreaFilled(true);
                        button.setBackground(Color.WHITE);
                        numOfSpecialDice--;
                        return;
                    }
                }

                // 유저는 주사위를 고정할 수도, 고정하지 않을 수도 있다
                // 고정된 주사위는 roll 버튼을 눌러도 주사위 눈이 변하지 않는다
                // 고정된 주사위는 회색 주사위로 표시된다
                if (!fixDice[i]) {
                    fixDice[i] = true;
                    button.setContentAreaFilled(true);
                    button.setBackground(Color.GRAY);
                    return;
                } else {
                    fixDice[i] = false;
                    button.setContentAreaFilled(true);
                    button.setBackground(Color.WHITE);
                    return;
                }
            }
        }

        // 유저가 roll 버튼을 누르면 주사위를 굴린다
        // 일반 주사위인 경우 주사위의 눈은 랜덤한 숫자이다
        if (clickButton == rollButton) {
            // 각 게임마다 유저는 최대 3번의 주사위를 굴릴 수 있다
            // 그러나 아이템 2가 사용되면, 유저는 주사위를 한번 더 굴릴 수 있다
            if (rollcount >= 3 && !clickedItem2) {
                JOptionPane.showMessageDialog(null, "You can't roll anymore", "",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // 아이템을 클릭한 채로 roll 버튼을 누르면 아이템이 소모된다
                if (clickedItem1) {
                    item1.setEnabled(false);
                    clickedItem1 = false;
                }
                if (clickedItem2) {
                    item2.setEnabled(false);
                    item2used = true;
                    clickedItem2 = false;
                    rollcount--;
                }
                
                // 주사위를 굴린다
                rollDices();
                matchDice();
                setScore();
                rollcount++;

                // 만약 유저가 주사위를 3번 굴리고 아이템2가 사용되지 않은 상태이면, 유저는 아이템 2를 사용할 수 있는 상태가 된다
                if (rollcount == 3 && !item2used) {
                    item2.setEnabled(true);
                }
            }
        }

        // 유저는 본인의 주사위를 토대로 점수를 획득할 수 있다
        for (JButton button : scoreBoard) {
            if (clickButton == button) {
                // 유저가 점수를 획득하려면 주사위를 최소 한번은 굴려야 한다
                if (rollcount == 0) {
                    JOptionPane.showMessageDialog(null, "Roll dices first", "", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                // setScore(clickButton);
                clickButton.setEnabled(false);
                setResult();
                resetDices();
                count++;
                item2.setEnabled(false);
                if (clickedItem1) {
                    item1.setEnabled(false);
                    clickedItem1 = false;
                }
            }
        }

        // 유저가 scoreChart 버튼을 누르면 족보를 확인할 수 있다
        if (clickButton == scoreChart) {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("scorechart.png"));
            JOptionPane.showMessageDialog(null, "", "Score Chart", JOptionPane.INFORMATION_MESSAGE, icon);
        }

        // 유저는 아이템 1 버튼을 눌러 아이템 1을 선택할 수 있다
        if (clickButton == item1) {
            // 만약 유저가 아직 주사위를 던지지 않았다면, 아이템 1을 선택할 수 없다
            // 아이템 1은 주사위를 적어도 한 번 사용해야 선택할 수 있다
            if (rollcount == 0) {
                JOptionPane.showMessageDialog(null, "Roll first before using item1", "",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }


            // 아이템 버튼은 토글 버튼처럼 동작함
            if (!clickedItem1) {
                // 동시에 같은 아이템은 사용할 수 없음
                if (clickedItem2) {
                    JOptionPane.showMessageDialog(null, "You can use only 1 item at a time", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                clickedItem1 = true;
                clickButton.setContentAreaFilled(true);
                clickButton.setBackground(Color.GRAY);
                return;
            } else {
                clickedItem1 = false;
                clickButton.setContentAreaFilled(true);
                clickButton.setBackground(Color.WHITE);
                for (int i = 0; i < 5; i++) {
                    if (specialDice[i]) {
                        diceButtons.get(i).setContentAreaFilled(true);
                        diceButtons.get(i).setBackground(Color.WHITE);
                        specialDice[i] = false;
                    }
                }
                numOfSpecialDice = 0;
                return;
            }
        }

        // 아이템 버튼은 토글 버튼처럼 동작함
        if (clickButton == item2) {
            if (!clickedItem2) {
                // 동시에 같은 아이템은 사용할 수 없음
                if (clickedItem1) {
                    JOptionPane.showMessageDialog(null, "You can use only 1 item at a time", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                clickedItem2 = true;
                clickButton.setContentAreaFilled(true);
                clickButton.setBackground(Color.GRAY);
                return;
            } else {
                clickedItem2 = false;
                clickButton.setContentAreaFilled(true);
                clickButton.setBackground(Color.WHITE);
                return;
            }
        }

        // 유저가 inforItem1 버튼을 누르면, Item1에 대한 설명이 나옴
        if (clickButton == infoItem1) {
            JOptionPane.showMessageDialog(null,
                    "Set special dice to random dice.\n Click when the desired dice number appears",
                    "Item 1 information", JOptionPane.INFORMATION_MESSAGE);
        }

        // 유저가 inforItem2 버튼을 누르면, Item2에 대한 설명이 나옴
        if (clickButton == infoItem2) {
            JOptionPane.showMessageDialog(null, "You can reroll the dice once more", "Item 2 information",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        // 유저가 submit 버튼을 눌러 게임결과를 저장할 수 있음
        if (clickButton == submitBtn) {
            // 게임이 끝나지 않았는데 submit 버튼을 누른 경우, 메세지 창을 팝업
            if (count != 12) {
                JOptionPane.showMessageDialog(null, "You must finish the game to submit", "Submit failed",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // 게임이 종료되었고 textField 의 필드가 유효하다면, 제출 완료 메세지를 출력
            if (validInput()) {
                // 만약 제출을 이미 한 상태에서 submit 버튼을 누르면, 이미 제출이 완료되었다는 메세지를 출력
                if (isSubmitted) {
                    JOptionPane.showMessageDialog(null, "You already submit the result!", "Submit succeed",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                try {
                    int totalScore = 0;
                    for (Score score : scores) {
                        totalScore += score.calculatedScore(dices);
                    }
                    // 게임 결과를 txt 파일에 저장
                    PrintWriter writer = new PrintWriter(new FileOutputStream("YatzyResult.txt", true));
                    writer.println("USERNAME : " + userIDField.getText() + " AGE : " + ageField.getText()
                            + " Total Score : " + Integer.toString(totalScore));
                    writer.close();
                    // 유저에게 제출이 완료되었음을 알림
                    JOptionPane.showMessageDialog(null, "You submit the result!", "Submit succeed",
                            JOptionPane.INFORMATION_MESSAGE);
                    isSubmitted = true;
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
