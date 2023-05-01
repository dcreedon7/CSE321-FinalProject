import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private Yahtzee game;
    private JButton[] diceButtons;
    private JButton rollButton;
    private JLabel scoreLabel;

    public GUI() {
        game = new Yahtzee(new Player("Player 1"));
        initComponents();
    }

    private void initComponents() {
        setTitle("Yahtzee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 300);

        JPanel dicePanel = new JPanel(new GridLayout(1, 5));
        diceButtons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            diceButtons[i] = new JButton();
            diceButtons[i].setText(String.valueOf(game.getDice()[i].getValue()));
            dicePanel.add(diceButtons[i]);
        }
        add(dicePanel, BorderLayout.CENTER);

        rollButton = new JButton("Roll");
        rollButton.addActionListener(new RollButtonActionListener());
        add(rollButton, BorderLayout.SOUTH);

        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel, BorderLayout.NORTH);
    }
    
    private class RollButtonActionListener implements ActionListener {
        private int numRolls;

        public RollButtonActionListener() {
            numRolls = 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (numRolls < 3) {
                game.playTurn();
                updateDiceButtons();
                numRolls++;
                scoreLabel.setText("Score: " + game.getPlayer().getScore());
            } else {
                JOptionPane.showMessageDialog(GUI.this, "You can only roll 3 times per turn.", "Roll Limit Reached", JOptionPane.WARNING_MESSAGE);
            }
        }

        private void updateDiceButtons() {
            for (int i = 0; i < diceButtons.length; i++) {
                diceButtons[i].setText(String.valueOf(game.getDice()[i].getValue()));
            }
        }
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI yahtzeeGUI = new GUI();
                yahtzeeGUI.setVisible(true);
            }
        });
    }

}
