import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;




public class TicTacToe implements ActionListener {


    Random random = new Random(); //Random object to decide first turn
    JFrame frame = new JFrame(); //Main frame
    JPanel title_panel = new JPanel(); //Panel to hold the title
    JPanel button_panel = new JPanel(); //Panel to hold the buttons
    JLabel textfield = new JLabel(); //Label to display messages
    JButton[] buttons = new JButton[9];//Array to hold the buttons
    boolean player1_turn; //Boolean to track player's turn
    boolean vsComputer; // Flag to indicate if it's player vs. computer mode


    //Constructor to set up the game
    TicTacToe(boolean vsComputer) {
        this.vsComputer = vsComputer; // Set the mode


        //Frame setup
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        //Textfield setup
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(255, 50, 200));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);


        //Title panel setup
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);


        //Button panel setup
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);


        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(100, 100, 100));


        //Initialize buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);


        firstTurn();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        if (!vsComputer)
                            check();
                        else
                            computerTurn();
                    }
                }
            }
        }
    }


    //Method to determine the first turn
    public void firstTurn() {
        try {
            Thread.sleep(4000); //Wait before starting the game
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("Player X turn");
        } else {
            player1_turn = false;
            if (vsComputer)
                computerTurn();// If vsComputer mode, computer starts



        }
    }


    //Method to check for win conditions
    public void check() {
        // Debugging: Print out button texts
        System.out.println("Button texts:");
        for (int i = 0; i < 9; i++) {
            System.out.print(buttons[i].getText() + " ");
        }
        System.out.println();
        // Check win conditions...
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);


        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);


        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);


        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);


        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);


        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);


        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);


        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")


        ) {
            xWins(2, 4, 6);


        }


        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);




        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);




        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);




        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);




        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);




        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);




        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);




        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);




        }
    }




    //Method to handle computer's turn
    public void computerTurn() {
        int index = -1;
        while (index == -1 || !buttons[index].getText().equals("")) {
            index = random.nextInt(9);
        }
        buttons[index].setForeground(new Color(0, 0, 255));
        buttons[index].setText("O");
        player1_turn = true;
        textfield.setText("Player X turn");
        check(); // Check for win after computer's turn
    }


    //Method to handle X wins
    public void xWins(int a, int b, int c) {
        // X wins...
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);




        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player X wins");
    }




    //Method to handle O wins
    public void oWins(int a, int b, int c) {
        // O wins...
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);




        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player O wins");
    }


    //Main method to start the game
    public static void main(String[] args) {
        boolean vsComputer = true; // Set to true for player vs. computer mode
        new TicTacToe(vsComputer);
    }


}
