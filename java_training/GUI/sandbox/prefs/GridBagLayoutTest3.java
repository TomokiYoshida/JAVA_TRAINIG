package sandbox.prefs;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;

public class GridBagLayoutTest3 extends JFrame{

  public static void main(String[] args){
    GridBagLayoutTest3 frame = new GridBagLayoutTest3();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  GridBagLayoutTest3(){
    GridBagLayout layout = new GridBagLayout();
    JPanel p = new JPanel();
    p.setLayout(layout);

    GridBagConstraints gbc = new GridBagConstraints();

    JButton button1 = new JButton("Google");

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 2;
    gbc.weightx = 1.0d;
    gbc.weighty = 1.0d;
    layout.setConstraints(button1, gbc);

    JButton button2 = new JButton("Yahoo!");
    button2.setFont(new Font("Arial", Font.PLAIN, 30));

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.weightx = 1.0d;
    gbc.weighty = 1.0d;
    layout.setConstraints(button2, gbc);

    JButton button3 = new JButton("MSN");

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 1.0d;
    gbc.weighty = 1.0d;
    layout.setConstraints(button3, gbc);

    p.add(button1);
    p.add(button2);
    p.add(button3);

    getContentPane().add(p, BorderLayout.CENTER);
  }
}