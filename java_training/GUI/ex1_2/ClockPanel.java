package ex1_2;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Calendar;

public class ClockPanel extends Panel implements Runnable{

	/**時間を入れる変数*/
	static int h;
	/**分を入れる変数*/
	static int m;
	/**秒*/
	static int s;
    Calendar now = Calendar.getInstance();

    static Thread thread;
	boolean isClockActive = true;

    public ClockPanel(){

    	//windowサイズ
		setSize(100, 100);
		//デジタル時計のスレッドを開始
		thread = new Thread(this);
		thread.start();
		//表示開始
		setVisible(true);
	}
    @Override
	public void paint(Graphics g)
    {
    	//時刻を表示
       g.drawString(h+":"+m+":"+s,50,109);
        System.out.println( h+":"+m+":"+s);
    }

	@Override
	public void run(){
	    while(isClockActive == true){
	    	//時を代入
            h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            //分を代入
            m =  Calendar.getInstance().get(Calendar.MINUTE);
            //秒を代入
            s =  Calendar.getInstance().get(Calendar.SECOND);
            repaint();
            try{
                Thread.sleep(1000);  //スリープ１秒
            }catch(InterruptedException e){
            }
      }
	}



}
