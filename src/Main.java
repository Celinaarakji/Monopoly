import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;


public class Main extends JFrame {
    private JTextArea gameTextArea;
    private JButton rollDiceButton;
    private Player[] players;
    private int currentPlayerIndex;
    private Map<Integer, Property> properties;
    private JLabel[] playerLabels;
    private JLayeredPane layeredPane;
    private ImageIcon boardImage;
    private ImageIcon[] playerIcons;
    private int[][] playerPositions;

    public Main() {
        setTitle("Monopoly Game");
        setSize(1100, 1100); // Adjusted frame size to accommodate 800x800 board image
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize layered pane to hold the board and player icons
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 800));

        // Load and scale down the board image
        try {
            BufferedImage originalImage = ImageIO.read(new File("/Users/celinaarakji/Downloads/Laudery.png"));
            Image scaledImage = originalImage.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
            boardImage = new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        JLabel boardLabel = new JLabel(boardImage);
        boardLabel.setBounds(0, 0, 800, 800);

        // Add board image to the layered pane at the default layer
        layeredPane.add(boardLabel, JLayeredPane.DEFAULT_LAYER);

        // Initialize players
        String player1Name = JOptionPane.showInputDialog(this, "Enter player 1 name:");
        Player player1 = new Player(this, player1Name, 1500); // Starting with $1500

        String player2Name = JOptionPane.showInputDialog(this, "Enter player 2 name:");
        Player player2 = new Player(this, player2Name, 1500); // Starting with $1500

        players = new Player[]{player1, player2};
        currentPlayerIndex = 0;

        // Initialize jail
        Dice dice = new Dice();
        Jail jail = new Jail(this, false, false, 0, dice, 1500);

        // Create and initialize all properties with their positions
        properties = new HashMap<>();
        properties.put(1, new Property("Wakanda Way", 60, 0.2 * 60));
        properties.put(3, new Property("Pali City", 60, 0.2 * 60));
        properties.put(6, new Property("Array Alley", 100, 0.2 * 100));
        properties.put(8, new Property("Loopy Lane", 100, 0.2 * 100));
        properties.put(9, new Property("Taffy Lane", 120, 0.2 * 120));
        properties.put(12, new Property("Pinkity Drinkty", 140, 0.2 * 140));
        properties.put(14, new Property("Kitty Ave", 140, 0.2 * 140));
        properties.put(16, new Property("Fried Chicken Ave", 180, 0.2 * 180));
        properties.put(18, new Property("Watermelon Ave", 180, 0.2 * 180));
        properties.put(19, new Property("Spicer Headquarter", 200, 0.2 * 200));
        properties.put(21, new Property("Arnavo Ave", 220, 0.2 * 220));
        properties.put(23, new Property("Mukbang Station", 220, 0.2 * 220));
        properties.put(24, new Property("Bunny Palace", 240, 0.2 * 240));
        properties.put(27, new Property("Nado Lane", 260, 0.2 * 260));
        properties.put(29, new Property("Chinatown", 260, 0.2 * 260));
        properties.put(31, new Property("Lil Baby Valley", 300, 0.2 * 300));
        properties.put(32, new Property("St. Hala Palace", 300, 0.2 * 300));
        properties.put(34, new Property("Kaitlyn Outlet", 360, 0.2 * 360));
        properties.put(37, new Property("Boardwalk", 400, 0.2 * 400));
        properties.put(39, new Property("Lauder Land", 700, 0.2 * 700));

        // Initialize player icons and labels
        playerIcons = new ImageIcon[2];
        playerIcons[0] = new ImageIcon(new ImageIcon("/Users/celinaarakji/Downloads/Car.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        playerIcons[1] = new ImageIcon(new ImageIcon("//Users/celinaarakji/Downloads/Dog.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        playerLabels = new JLabel[2];
        playerLabels[0] = new JLabel(playerIcons[0]);
        playerLabels[1] = new JLabel(playerIcons[1]);

        // Initial positions (corresponding to the board layout)
        playerPositions = new int[40][2];
        // Fill in playerPositions array with coordinates corresponding to each tile on the board
        playerPositions[0] = new int[]{750, 750}; // Go
        playerPositions[1] = new int[]{600, 750}; // Position 1
        playerPositions[2] = new int[]{550, 750}; // Position 2
        playerPositions[3] = new int[]{500, 750}; // Position 3
        playerPositions[4] = new int[]{450, 750}; // Position 4
        playerPositions[5] = new int[]{375, 750}; // Position 5
        playerPositions[6] = new int[]{320, 750}; // Position 6
        playerPositions[7] = new int[]{270, 750}; // Position 7
        playerPositions[8] = new int[]{200, 750}; // Position 8
        playerPositions[9] = new int[]{145, 750};  // Position 9
        playerPositions[10] = new int[]{0, 750};  // Jail
        playerPositions[11] = new int[]{0, 597};  // Position 11
        playerPositions[12] = new int[]{0, 565};  // Position 12
        playerPositions[13] = new int[]{0, 555};  // Position 13
        playerPositions[14] = new int[]{0, 450};  // Position 14
        playerPositions[15] = new int[]{0, 375};  // Position 15
        playerPositions[16] = new int[]{0, 320};  // Position 16
        playerPositions[17] = new int[]{0, 255};  // Position 17
        playerPositions[18] = new int[]{0, 150};  // Position 18
        playerPositions[19] = new int[]{0, 100};   // Position 19
        playerPositions[20] = new int[]{0, 0};    // Free Parking
        playerPositions[21] = new int[]{120, 0};   // Position 21
        playerPositions[22] = new int[]{150, 0};  // Position 22
        playerPositions[23] = new int[]{255, 0};  // Position 23
        playerPositions[24] = new int[]{320, 0};  // Position 24
        playerPositions[25] = new int[]{375, 0};  // Position 25
        playerPositions[26] = new int[]{450, 0};  // Position 26
        playerPositions[27] = new int[]{500, 0};  // Position 27
        playerPositions[28] = new int[]{570, 0};  // Position 28
        playerPositions[29] = new int[]{675, 0};  // Position 29
        playerPositions[30] = new int[]{750, 0};  // Go to Jail
        playerPositions[31] = new int[]{750,145}; // Position 31
        playerPositions[32] = new int[]{750, 200}; // Position 32
        playerPositions[33] = new int[]{750, 265}; // Position 33
        playerPositions[34] = new int[]{750, 320}; // Position 34
        playerPositions[35] = new int[]{750, 375}; // Position 35
        playerPositions[36] = new int[]{750, 450}; // Position 36
        playerPositions[37] = new int[]{750, 500}; // Position 37
        playerPositions[38] = new int[]{750, 600}; // Position 38
        playerPositions[39] = new int[]{750, 625}; // Position 39

        for (int i = 0; i < playerLabels.length; i++) {
            playerLabels[i].setBounds(playerPositions[0][0], playerPositions[0][1], 40, 40);
            layeredPane.add(playerLabels[i], JLayeredPane.PALETTE_LAYER);
        }

        rollDiceButton = new JButton("Roll Dice");
        rollDiceButton.setPreferredSize(new Dimension(300,100));
        rollDiceButton.setFont(new Font("Arial", Font.BOLD, 20));
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRollDice();
            }
        });

        // Add the layered pane to the frame
        add(layeredPane, BorderLayout.CENTER);

        // Initialize the control panel to hold the text area and roll button
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());

        // Initialize the text area and add it to a scroll pane
        gameTextArea = new JTextArea();
        gameTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gameTextArea);

        // Add the roll button to the control panel
        controlPanel.add(rollDiceButton, BorderLayout.NORTH);

        // Add the control panel and scroll pane to the right side
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(controlPanel, BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the right panel to the frame
        add(rightPanel, BorderLayout.EAST);

        printToGameTextArea(players[currentPlayerIndex].getName() + ", it's your turn.");
    }

    private void handleRollDice() {
        Player currentPlayer = players[currentPlayerIndex];

        // Simulate dice roll
        int diceRoll = rollDice();
        printToGameTextArea(currentPlayer.getName() + " rolled a " + diceRoll);

        // Update player position
        int oldPosition = currentPlayer.getPosition();
        int newPosition = (oldPosition + diceRoll) % 40; // Assuming board has 40 positions
        currentPlayer.setPosition(newPosition);

        // Check if the player lands on the "Go to Jail" tile (position 30)
        if (newPosition == 30) {
            currentPlayer.getJail().gotoJail();
            currentPlayer.setPosition(30); // Move to Jail position
            printToGameTextArea(currentPlayer.getName() + " landed on Go to Jail. Going to Jail.");
            currentPlayer.getJail().promptJailOptions();
        } else if (newPosition==5 || newPosition == 35){
            new TicTacToe(true);
        }
        else if (newPosition == 11){
            RpsGui rps= new RpsGui("rps");
            rps.setVisible(true);
        }
        else if (newPosition == 25){
            Mazegui maze = new Mazegui();
            maze.setVisible(true);
        }
        else if (newPosition == 2 || newPosition == 17 ||newPosition == 26|| newPosition == 33)
        {
            new Communitygui();
        }
        else if (newPosition == 7 || newPosition == 15 ||newPosition == 22|| newPosition == 36)
        {
            new Chancegui();
        }
        else if (newPosition  == 4 ||newPosition == 38)
        {
            new Taxgui();
        }


        else {
            // Update player icon position on the board
            playerLabels[currentPlayerIndex].setBounds(playerPositions[newPosition][0], playerPositions[newPosition][1], 40, 40);

            printToGameTextArea(currentPlayer.getName() + " moved to position " + newPosition);

            Property property = properties.get(newPosition);
            if (property != null) {
                property.handleLanding(currentPlayer, this);
            } else {
                printToGameTextArea("No property at this position.");
            }
        }

        // Switch to next player
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        printToGameTextArea(players[currentPlayerIndex].getName() + ", it's your turn.");
    }

    private int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // Generates a number between 1 and 6
    }

    public void printToGameTextArea(String message) {
        gameTextArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
