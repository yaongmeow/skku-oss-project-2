import javax.swing.*;
import java.util.List;

public class ScreenConfiguration {

    public void createStaticComponents(Panel panel) {
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

        Label userNameLabel = new Label("USERNAME", "Arial", 12, 217, 552, 81, 31, panel);
        Label ageLabel = new Label("AGE", "Arial", 12, 408, 552, 51, 31, panel);

        Label diceInfo = new Label("resource/diceinfo.png", 513, 550, 138, 59, panel);
        diceInfo.setHorizontalAlignment(SwingConstants.CENTER);

        Label title = new Label("resource/title.png", 44, 24, 404, 113, panel);
    }

    public Button createDice(String iconImagePath, int x, int y, int width, int height, Panel panel, List<Button> diceButtons, Screen screen) {
        Button dice = new Button();
        dice.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        dice.setBounds(x, y, width, height);
        makeButtonTransparent(dice);
        panel.add(dice);
        diceButtons.add(dice);

        dice.addMouseListener(new Hovering());
        dice.addActionListener(screen);
        return dice;
    }

    public Button createScoreButtons(int x, int y, int width, int height, Panel panel, Screen screen, List<Button> scoreBoard) {
        Button scoreButton = new Button();
        scoreButton.setBounds(x, y, width, height);
        makeButtonTransparent(scoreButton);
        scoreButton.setBorderPainted(true);
        scoreButton.addActionListener(screen);
        panel.add(scoreButton);
        scoreBoard.add(scoreButton);
        return scoreButton;
    }

    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

}
