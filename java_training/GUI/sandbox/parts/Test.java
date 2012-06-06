package sandbox.parts;
import java.awt.*;

class Test{
    public static void main(String args[]){
        BallCanvas canvas = new BallCanvas();
        Thread     t = new Thread(canvas);

        /* フレームを作成します。*/
        Frame frm = new Frame("18-31");

        /* フレームのサイズを変更します。*/
        frm.setSize(new Dimension(400,150));

        /* フレームに独自のキャンバスを追加します。*/
        frm.setLayout(new GridLayout());
        frm.add(canvas);

        /* スレッドをスタートさせます */
        t.start();

        /* フレームを見えるようにします。*/
        frm.setVisible(true);
    }
}

/* 独自のキャンバスクラス */
class BallCanvas extends Canvas implements Runnable{
    int      timing     = 10;           /* 再描画のタイミング */
    int      ballSize   = 50;           /* ボールの大きさ */
    int      dx         = 2;            /* ボールの移動量 */
    int      cx         = 0;            /* 現在のボールのX座標 */
    boolean  flagUpdate = true;         /* ボールの移動(true)か、それともただの再描画(false)か */
    Image    imgBuffer;                 /* バッファ用のイメージ */
    Graphics gBuffer;                   /* バッファ用のGraphicsクラス */

    /* スレッド本体 */
    public void run(){
        while(true){
            /* 指定時間待機します。*/
            try{
                Thread.sleep(timing);
            }catch(Exception e){}

            /* ボールの移動を要求 */
            flagUpdate = true;

            /* 再描画の要求 */
            repaint();
        }
    }

    /* Componentクラスは描画が必要になるとpaintメソッドが自動で呼ばれる。*/
    /* この時に渡されるGraphicsオブジェクトを利用することで、描画が可能になる。*/
    /* またrepaintメソッドを読んだ場合も、paintメソッドが呼ばれる */
    public void paint(Graphics g){
        /* キャンバスのサイズを取得する */
        Dimension d = getSize();

        /* バッファ用のイメージが作られていないかサイズが変わったら作り直し */
        /* 毎回作るようにしても良いが、処理に時間がかかる処理なので、必要な時にしか作らないようにする */
        if( imgBuffer == null || imgBuffer.getWidth(this) != d.width || imgBuffer.getHeight(this) != d.height ){
            imgBuffer = createImage(d.width, d.height);
            gBuffer = null;
        }

        /* バッファ用Graphicsがなければ作る */
        if( gBuffer == null ){
            gBuffer = imgBuffer.getGraphics();
        }

        /* バッファをクリアする */
        /* バッファなのでクリアしてもちらつかない */
        gBuffer.clearRect(0, 0, d.width, d.height);

        /* 描画色を設定 */
        gBuffer.setColor(Color.red);

        /* ボールの描画位置を決める */
        /* Y座標は、キャンバスの真ん中あたり */
        /* X座標は、flagUpdateがtrue(スレッドから再描画要求があった場合)ならX座標を更新する。*/
        /* flagUpdateがfalse(フレームのサイズが変わったり、上に別のウインドウが被さったりなどで*/
        /* 再描画する場合は座標は変えない。*/
        Dimension size = getSize();
        int y = (size.height - ballSize) / 2;
        int x = (flagUpdate ? cx + dx : cx );

        /* カレントのＸ座標を更新 */
        cx = x;

        /* ボールをバッファに描画 */
        gBuffer.fillOval(x, y, ballSize, ballSize);

        /* バッファを画面にコピーする */
        g.drawImage( imgBuffer, 0, 0, this);

        /* ボールが右端に行った場合、移動量をマイナスに変更する。*/
        /* また、フレームのサイズが変わって、現在のボールの位置よりも小さくなった場合はフレームのサイズに */
        /* 応じて座標を更新する。*/
        if( cx >= d.width - ballSize ){
            dx = -Math.abs(dx) ;
            cx = d.width - ballSize;
        }

        /* ボールが左端に行ったら移動量を＋にする */
        else if( cx <= 0 )
            dx = Math.abs(dx);

        /* フラグを戻す */
        flagUpdate = false;
    }


    /* 画面がクリアされないようにオーバーライドしておく */
    public void update(Graphics g){
        paint(g);
    }
}