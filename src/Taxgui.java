import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taxgui {
    Taxgui(){

        JFrame f = new JFrame();
        ImageIcon ikon= new ImageIcon("/Users/celinaarakji/IdeaProjects/Monopoly/src/taxi.png");
        f.add(new JLabel(ikon));
        f.pack();
        f.setVisible(true);
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                JFrame fi = new JFrame();
                ImageIcon ikoni= new ImageIcon("/Users/celinaarakji/IdeaProjects/Monopoly/src/taxi2.png");
                fi.add(new JLabel(ikoni));
                fi.pack();
                fi.setVisible(true);
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();

    }
}
