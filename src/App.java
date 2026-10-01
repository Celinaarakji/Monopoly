import javax.swing.*;


// main class definition
public class App {
    // main method
    public static void main(String[] args) {
        // makes sure GUI updates are performed on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable(){
            // override the run() method of the Runnable interface
            @Override
            public void run() {
                // create a new instance of the Hangman class and set its visibility to true
                new Hangman().setVisible(true);
            }
        });
    }
}
