import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DesktopReminder {

    public static void main(String[] args) {
        // Display loading page
        displayLoadingPage();

        // Prompt the user to input reminder message
        String reminderMessage = JOptionPane.showInputDialog("Enter your reminder message:");

        // Prompt the user to input time for reminder (in minutes)
        String timeString = JOptionPane.showInputDialog("Enter time in minutes for the reminder:");

        // Convert timeString to milliseconds
        long time = Long.parseLong(timeString) * 60 * 1000; // convert minutes to milliseconds

        // Create a Timer object
        Timer timer = new Timer();

        // Schedule a reminder task after the specified time
        timer.schedule(new ReminderTask(reminderMessage), time);
    }

    static void displayLoadingPage() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Loading, please wait...");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JOptionPane.showMessageDialog(null, panel, "Loading", JOptionPane.INFORMATION_MESSAGE);
    }

    static class ReminderTask extends TimerTask {
        private String reminderMessage;

        public ReminderTask(String reminderMessage) {
            this.reminderMessage = reminderMessage;
        }

        public void run() {
            // Display reminder message
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, reminderMessage, "Reminder", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
