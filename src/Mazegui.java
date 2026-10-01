import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;


import java.util.List;
public class Mazegui extends JFrame {


    private JLabel centerLabel;


    public int win=-1;
    public String[] quest;


    public int[] ans;


    private ImageIcon[] walking;


    private ImageIcon[] images;


    public int move=0;
    public String winner="none";
    public int finalN;








    public Mazegui() {


        quest = new String[7];
        quest[0]= "A string is a primary data type";
        quest[1]= "A for loop can be infinite";
        quest [2]=" Creativity is the key for success";
        quest[3]= "An object is an instance of an interface";
        quest [4]= "An array is a list";
        quest[5]="Good afternoon";
        quest[6]="Have a great weeknd";


        ans = new int[6];
        ans[0]=2;
        ans[1]=1;
        ans[2]=2;
        ans[3]=2;
        ans[4]=1;
        ans[5]=1;


        walking = new ImageIcon[6]; // set the images that we will use
        walking[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/first.png"); // Change the paths to your images
        walking[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/second.png");
        walking[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/third.png");
        walking[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/fourth.png");
        walking[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/fifth.png");
        walking[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/fifth.png");


        images = new ImageIcon[5]; // set the images that we will use
        images[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/board.png"); // Change the paths to your images
        images[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/true.png");
        images[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/wrong.png");
        images[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/winner.png");
        images[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/loser.png");


        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setTitle("GUI Panel Example");


        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);


        // Create the top panel with GridLayout for 1 row and 3 columns
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        JLabel label1 = new JLabel("(Answer right to move) ");
        JLabel label2 = new JLabel("Tries left: " + (5-move));
        topPanel.add(label1);
        topPanel.add(label2);
        mainPanel.add(topPanel, BorderLayout.NORTH);


        // Create the middle panel for displaying images
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerLabel = new JLabel(images[0]);
        middlePanel.add(centerLabel,  BorderLayout.CENTER);
        mainPanel.add(middlePanel, BorderLayout.CENTER);


        // Create the bottom panel with the label and buttons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel bottomLabel = new JLabel(quest[move]);
        labelPanel.add(bottomLabel);
        bottomPanel.add(labelPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton firstButton = new JButton("True");
        JButton secondButton = new JButton("False");
        buttonPanel.add(firstButton);
        buttonPanel.add(secondButton);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);




        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determine(1);
                finalN=1;
                bottomLabel.setText(quest[move]);
                label2.setText("Tries left: " + (5-move));
            }
        });


        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determine(2);
                finalN=2;
                bottomLabel.setText(quest[move]);
                label2.setText("Tries left: " + (5-move));
            }
        });


    }






    public void determine(int n){
        if(n==ans[move]){
            win();
        }
        else{
            lose();
        }
        move++;
        checkloss();
    }


    public void win(){
        win++;
        centerLabel.setIcon(images[1]);
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                centerLabel.setIcon(walking[win]);
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();


    }


    public void lose(){
        centerLabel.setIcon(images[2]);
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                if (win==-1){
                    centerLabel.setIcon(images[0]);


                }
                else {
                    centerLabel.setIcon(walking[win]);
                }
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();


    }


    public void checkloss(){
        if (move>=6){
            if (win==5){
                System.out.println("you won!");
                winner= "user";
                centerLabel.setIcon(images[3]);
                Timer t = new Timer(1000 * 3, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        ((Timer) e.getSource()).stop();
                    }
                });
                t.start();
            }
            else {
                System.out.println("you lose");
                winner="computer";
                centerLabel.setIcon(images[4]);
                Timer t = new Timer(1000 * 3, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        ((Timer) e.getSource()).stop();
                    }
                });
                t.start();
            }
        }
    }


}
