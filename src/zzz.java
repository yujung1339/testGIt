import javax.swing.*;
import java.awt.*;

public class zzz {
    public static void main(String[] args) {
        JFrame frame = new JFrame("이미지 출력");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("img/mymelody.png");
        JLabel imageLabel = new JLabel(imageIcon);

        frame.getContentPane().add(imageLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}