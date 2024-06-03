import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class Panel extends JPanel {
    public Panel() {
        this.setBackground(new Color(255, 255, 255));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
    }
    void floatDiceButtons(List<DiceButton> diceButtons) {
        for (DiceButton diceButton : diceButtons) {
            this.add(diceButton);
        }
    }
}
