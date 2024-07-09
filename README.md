# Prasunet_AD_03
It is a stopwatch app that displays minutes, seconds, and milliseconds and allows users to start, pause and reset the timer.
<br>
Author- Srijita Dasgupta

Explanation:

1. Swing Components:
   - JFrame, JLabel, and JButton are used to create the main window, display the timer, and handle user interactions respectively.
   
2. Timer Initialization:
   - A Timer object (javax.swing.Timer) is used to update the timer display every 10 milliseconds (timer = new Timer(10, new TimerListener())).

3. Button Listeners:
   - StartButtonListener, PauseButtonListener, and ResetButtonListener handle actions when the corresponding buttons are clicked.
   - StartButtonListener starts the timer, PauseButtonListener pauses the timer and calculates paused time, and ResetButtonListener resets the timer display and paused time.

4. TimerListener:
   - TimerListener is an inner class that updates the timer display (timerLabel) every time the Timer fires (actionPerformed method).

5. Main Method:
   - main method creates an instance of StopwatchApp on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater() for thread safety.

Running the Application:

1. Compile StopwatchApp.java using javac StopwatchApp.java.
2. Run the compiled class using java StopwatchApp.
3. The GUI window will appear with the timer display and buttons.
4. Click Start to start the stopwatch, Pause to pause it, and Reset to reset the stopwatch.
