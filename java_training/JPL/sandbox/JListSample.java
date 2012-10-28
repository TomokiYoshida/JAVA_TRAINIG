package sandbox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JListSample extends JFrame implements MouseListener{
  protected JList list;
  protected DefaultListModel model;

  public static void main(String[] args){
    JListSample test = new JListSample("JListSample");

    /* 終了処理を変更 */
    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    test.setBounds( 10, 10, 250, 130);
    test.setVisible(true);
  }

  JListSample(String title){
    setTitle(title);

    model = new DefaultListModel();
    String[] initData = {"Blue", "Green", "Red", "Whit", "Black"};
    for (int i = 0 ; i < initData.length ; i++){
      /* 指定した文字列を持つチェックボックスをJListに登録する */
      model.addElement(new JCheckBox(initData[i]));
    }
    list = new JList(model);

    /* CellRendererを設定する */
    MyCellRenderer renderer = new MyCellRenderer();
    list.setCellRenderer(renderer);

    /* MouseListenerをセットする */
    list.addMouseListener(this);

    JScrollPane sp = new JScrollPane();
    sp.getViewport().setView(list);
    sp.setPreferredSize(new Dimension(200, 80));

    JPanel p = new JPanel();
    p.add(sp);

    getContentPane().add(p, BorderLayout.CENTER);
  }

  class MyCellRenderer extends JCheckBox implements ListCellRenderer{
    public MyCellRenderer() {
    }

    public Component getListCellRendererComponent(
      JList list,
      Object value,
      int index,
      boolean isSelected,
      boolean cellHasFocus){

      /* 項目の値を読み出して改めて表示する */
      JCheckBox checkBox = (JCheckBox)value;
      setText(checkBox.getText());

      setSelected(checkBox.isSelected());

      return this;
    }
  }

  public void mouseClicked(MouseEvent e){
    /* クリックされた座標からIndex番号を取り出す */
    Point p = e.getPoint();
    int index = list.locationToIndex(p);

    JCheckBox checkBox = (JCheckBox)model.getElementAt(index);
    if (checkBox.isSelected()){
      checkBox.setSelected(false);
    }else{
      checkBox.setSelected(true);
    }

    /* 再描画してみる */
    list.repaint();
  }

  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
}