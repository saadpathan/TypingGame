package typinggame;

/*
 * @author Saad_Ahmed_Pathan_22114077
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypingGame extends JFrame implements ActionListener {

    private final String targetText = "The quick brown fox jumps over the lazy dog.";
    private JTextArea textArea;
    private JLabel promptLabel, timerLabel, resultLabel;
    private JButton startButton;
    private long startTime;
    private Timer timer;

    public TypingGame() {
        super("Typing Game");
        createGUI();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setSize(600, 400);
        setVisible(true);
    }

    private void createGUI() {
        setLayout(new BorderLayout());
        promptLabel = new JLabel("Type the following text:");
        promptLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        promptLabel.setForeground(new Color(106, 90, 205)); // Slate Blue

        JLabel targetTextLabel = new JLabel(targetText);
        targetTextLabel.setFont(new Font("Serif", Font.BOLD, 18));
        targetTextLabel.setForeground(new Color(106, 90, 205)); // Forest Green

        textArea = new JTextArea(10, 50);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        startButton = new JButton("Start");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        startButton.setForeground(new Color(255, 69, 0)); // Red Orange
        startButton.addActionListener(this);

        timerLabel = new JLabel(" Timer: 00:00:000 ", JLabel.CENTER);
        timerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        timerLabel.setForeground(new Color(75, 0, 130)); // Indigo

        resultLabel = new JLabel(" ", JLabel.CENTER);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        resultLabel.setForeground(new Color(255, 140, 0)); // Dark Orange

        JPanel northPanel = new JPanel(new GridLayout(0, 1));
        northPanel.add(promptLabel);
        northPanel.add(targetTextLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.add(new JScrollPane(textArea));

        JPanel southPanel = new JPanel(new GridLayout(0, 1));
        southPanel.add(timerLabel);
        southPanel.add(startButton);
        southPanel.add(resultLabel);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (startButton.getText().equals("Start")) {
                startGame();
            } else {
                endGame();
            }
        }
    }

    private void startGame() {
        textArea.setEditable(true);
        textArea.setText("");
        startButton.setText("Submit");
        startTime = System.currentTimeMillis();
        timer = new Timer(10, e -> updateTimer());
        timer.start();
    }

    private void endGame() {
        timer.stop();
        textArea.setEditable(false);
        startButton.setText("Start");
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        if (textArea.getText().equals(targetText)) {
            resultLabel.setText("Correct! Time: " + formatTime(timeTaken));
        } else {
            resultLabel.setText("Incorrect, try again!");
        }
    }

    private void updateTimer() {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - startTime;
        timerLabel.setText(" Timer: " + formatTime(timeElapsed) + " ");
    }

    private String formatTime(long time) {
        long minutes = (time / 60000) % 60;
        long seconds = (time / 1000) % 60;
        long millis = time % 1000;
        return String.format("%02d:%02d:%03d", minutes, seconds, millis);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TypingGame::new);
    }
}
