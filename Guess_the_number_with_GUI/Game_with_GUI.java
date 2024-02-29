package Guess_the_number_with_GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Game_with_GUI extends JFrame implements ActionListener {

    private final Random random = new Random();
    private final int target;
    private int maxAttempts;
    private int attemptsTaken = 0;
    private JLabel instructionsLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel feedbackLabel;

    public Game_with_GUI() {
        super("Guess the Number");

        target = random.nextInt(101);
        maxAttempts = 10;

        instructionsLabel = new JLabel("Guess the number between 1 and 100. Can you guess it?");
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        feedbackLabel = new JLabel("");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(instructionsLabel, gbc);

        gbc.gridy++;
        panel.add(guessField, gbc);

        gbc.gridy++;
        panel.add(guessButton, gbc);

        gbc.gridy++;
        panel.add(feedbackLabel, gbc);

        guessButton.addActionListener(this);

        add(panel);
        Dimension preferredSize = new Dimension(400, 150);
        setPreferredSize(preferredSize);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            if (attemptsTaken >= maxAttempts) {
                feedbackLabel.setText("You've run out of guesses! The number was: " + target);
                guessButton.setEnabled(false);
                return;
            }

            try {
                int guess = Integer.parseInt(guessField.getText());

                if (guess < 1 || guess > 100) {
                    feedbackLabel.setText("Invalid guess. Please enter a number between 1 and 100.");
                    return;
                }

                attemptsTaken++;

                if (guess == target) {
                    feedbackLabel.setText("Congratulations! You guessed the number in " + attemptsTaken + " attempts.");
                    guessButton.setEnabled(false);
                    return;
                } else {
                    if (guess > target) {
                        feedbackLabel.setText("Your guess is too high. Try again.");
                    } else {
                        feedbackLabel.setText("Your guess is too low. Try again.");
                    }
                }
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Invalid guess. Please enter a valid number.");
            }

            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        new Game_with_GUI();
    }
}
