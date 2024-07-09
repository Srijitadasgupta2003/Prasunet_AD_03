package Prasunet_AD_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class StopwatchApp {
    private JFrame frame;
    private JLabel timerLabel;
    private JButton startButton;
    private JButton pauseButton;
    private JButton resetButton;
    private Timer timer;
    private long startTime;
    private long pausedTime;
    private boolean isRunning;

    public StopwatchApp() {
        frame = new JFrame("Stopwatch App");
        frame.setLayout(new FlowLayout());

        timerLabel = new JLabel("00:00:000", JLabel.CENTER);
        timerLabel.setFont(new Font("Verdana", Font.PLAIN, 28));
        timerLabel.setPreferredSize(new Dimension(250, 50));

        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        resetButton = new JButton("Reset");

        startButton.addActionListener(new StartButtonListener());
        pauseButton.addActionListener(new PauseButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

        frame.add(timerLabel);
        frame.add(startButton);
        frame.add(pauseButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        timer = new Timer(10, new TimerListener());
        timer.setInitialDelay(0);
    }
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isRunning) {
                startTime = System.currentTimeMillis() - pausedTime;
                timer.start();
                isRunning = true;
                startButton.setEnabled(false);
                pauseButton.setEnabled(true);
                resetButton.setEnabled(true);
            }
        }
    }

    private class PauseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isRunning) {
                timer.stop();
                pausedTime = System.currentTimeMillis() - startTime;
                isRunning = false;
                startButton.setEnabled(true);
                pauseButton.setEnabled(false);
            }
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            isRunning = false;
            startButton.setEnabled(true);
            pauseButton.setEnabled(true);
            resetButton.setEnabled(false);
            timerLabel.setText("00:00:000");
            pausedTime = 0;
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            int minutes = (int) (elapsedTime / 60000);
            int seconds = (int) ((elapsedTime / 1000) % 60);
            int milliseconds = (int) (elapsedTime % 1000);

            DecimalFormat df = new DecimalFormat("00");
            DecimalFormat dfMillis = new DecimalFormat("000");

            String timeText = df.format(minutes) + ":" +
                              df.format(seconds) + ":" +
                              dfMillis.format(milliseconds);

            timerLabel.setText(timeText);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StopwatchApp());
    }
}


