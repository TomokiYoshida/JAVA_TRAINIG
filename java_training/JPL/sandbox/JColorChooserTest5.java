package sandbox;
import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;

public class JColorChooserTest5 extends JFrame implements ActionListener{

  JPanel p;

  public static void main(String[] args){
    JColorChooserTest5 frame = new JColorChooserTest5();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  JColorChooserTest5(){
    JButton button = new JButton("color");
    button.addActionListener(this);

    p = new JPanel();
    p.add(button);

    getContentPane().add(p, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent e){
    JColorChooser colorchooser = new JColorChooser();

    Color color = colorchooser.showDialog(this, "色の選択", Color.white);

    if(color != null){
      p.setBackground(color);
    }
  }
}