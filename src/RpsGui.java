import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;




public class RpsGui extends JFrame implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.print("hi!!");


    }


    @Override
    public void windowClosing(WindowEvent e) {
        System.out.print("bye!!");
        finish=5;


    }


    @Override
    public void windowClosed(WindowEvent e) {


    }


    @Override
    public void windowIconified(WindowEvent e) {


    }


    @Override
    public void windowDeiconified(WindowEvent e) {


    }


    @Override
    public void windowActivated(WindowEvent e) {


    }


    @Override
    public void windowDeactivated(WindowEvent e) {


    }


    private JLabel imageLabel;




    private ImageIcon[] images;


    private int win;
    private int loss;


    private ImageIcon bg;
    private JLabel myLabel;
    private JFrame frame;
    public String winner;


    public int finish=0;




    public RpsGui(String title)
    {
        setSize(400, 300);
        setLayout(new BorderLayout());
        addWindowListener(this);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // load images
        images = new ImageIcon[9]; // set the images that we will use
        images[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/newthem.png"); // Change the paths to your images
        images[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/younew.png");
        images[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/losenew.png");
        images[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/tienew.png");
        images[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/rcnew.png");
        images[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/pcnew.png");
        images[6] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/scnew.png");
        images[7] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/finalwin.png");
        images[8] = new ImageIcon("/Users/celinaarakji/IdeaProjects/trial/src/finallost.png");













        // Top Panel with Labels
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label1 = new JLabel("Wins: "+ getWin());
        JLabel label2 = new JLabel("Losses: " + getLoss());
        topPanel.add(label1);
        topPanel.add(label2);
        label1.setForeground(Color.BLACK); // Set label text color
        label2.setForeground(Color.BLACK);
        label1.setBackground(Color.ORANGE); // Set label background color
        label2.setBackground(Color.ORANGE);
        label1.setOpaque(true); // Enable background color
        label2.setOpaque(true);
        add(topPanel, BorderLayout.NORTH);


        // Middle Panel with Image
        JPanel imagePanel = new JPanel(new BorderLayout());
        imageLabel = new JLabel(images[0]); // Assign to instance variable
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.CENTER);








        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button1 = new JButton("Rock");
        JButton button2 = new JButton("Paper");
        JButton button3 = new JButton("Scissors");
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        bottomPanel.add(button3);
        add(bottomPanel, BorderLayout.SOUTH);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Wins: " + getWin());
                label2.setText("Losses: " + getLoss());
                determine(1);




            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Wins: " + getWin());
                label2.setText("Losses: " + getLoss());
                determine(2);
            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Wins: " + getWin());
                label2.setText("Losses: " + getLoss());
                determine(3);
            }
        });


    }












    public void win() {
        imageLabel.setIcon(images[1]);
        win++;
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                imageLabel.setIcon(images[0]);
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();




    }


    public void lose() {
        imageLabel.setIcon(images[2]);
        loss++;
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                imageLabel.setIcon(images[0]);
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();




    }


    public void tie() {


        imageLabel.setIcon(images[3]);
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                imageLabel.setIcon(images[0]);
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();




    }


    public void determine(int userChoice)
    {
        int aiChoice = (int) (Math.random() * 3 + 1);
        computerChoice(aiChoice);




        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                if (aiChoice == userChoice) {
                    tie();
                    checkWinner();
                } else if (userChoice == 1) {
                    if (aiChoice == 2) {
                        lose();
                        checkWinner();
                    } else {
                        win();
                        checkWinner();
                    }
                } else if (userChoice == 2) {
                    if (aiChoice == 1) {
                        win();
                        checkWinner();
                    } else {
                        lose();
                        checkWinner();
                    }
                } else
                {
                    if (aiChoice == 1) {
                        lose();
                        checkWinner();
                    } else {
                        win();
                        checkWinner();
                    }


                }
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();










    }


    public void computerChoice(int n ) {
        if (n==1){
            imageLabel.setIcon(images[4]);


        }
        else if (n==2){
            imageLabel.setIcon(images[5]);


        }
        else{
            imageLabel.setIcon(images[6]);


        }






    }


    // Method to set the winner
    public void checkWinner() {
        if (win == 3) {
            winner="user";
            imageLabel.setIcon(images[7]);
            Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                public void actionPerformed(ActionEvent e) {
                    finish=5;
                    dispose();
                    ((Timer) e.getSource()).stop();
                }
            });
            t.start();
        } else if (loss == 3) {
            winner="computer";
            imageLabel.setIcon(images[8]);
            Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                public void actionPerformed(ActionEvent e) {
                    finish=5;
                    dispose();
                    ((Timer) e.getSource()).stop();
                }
            });
            t.start();
        }
    }








    public int getLoss() {
        return loss;
    }


    public int getWin() {
        return win;
    }
}
