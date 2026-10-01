import javax.swing.*;
import javax.swing.ImageIcon;
public class Chancegui {

    Chancegui() {

        JFrame f = new JFrame();
        int n = (int) (Math.random() * 4) + 1;
        ImageIcon ikon;
        if (n == 1) {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Monopoly/src/chance1.png");
        } else if (n == 2) {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Monopoly/src/chance2.png");
        } else if (n == 3) {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Monopoly/src/chance3.png");
        } else {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Monopoly/src/chance4.png");
        }
        f.add(new JLabel(ikon));
        f.pack();
        f.setVisible(true);
    }



}