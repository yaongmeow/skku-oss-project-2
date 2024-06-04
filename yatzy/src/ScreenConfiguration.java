import javax.swing.*;
import java.util.List;

public class ScreenConfiguration {

    public Button createDice(String iconImagePath, int x, int y, int width, int height, Panel panel, List<Button> diceButtons) {
        Button dice = new Button();
        dice.setIcon(new ImageIcon((Screen.class.getResource(iconImagePath))));
        dice.setBounds(x, y, width, height);
        makeButtonTransparent(dice);
        panel.add(dice);
        diceButtons.add(dice);
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
