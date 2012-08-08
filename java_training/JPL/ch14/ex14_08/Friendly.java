package ch14.ex14_08;

/**Friendlyプログラムを試しなさい。使用しているシステムでどの程度の頻度で実際にデッド
ロックが発生しますか。→ほぼ必ず。yield呼び出しを追加したら、デッドロックの頻度を変更できますか。→時々起こらない。もし可能な
ら、この練習問題を1種類以上のシステムで試しなさい。同期を削除することなくデッドロックの可能性を取
り除いてみなさい。*/
public class Friendly {
	private Friendly partner;
	private String name;
	private Object lock1 = new Object();
	private Object lock2= new Object();

	public Friendly(String name){
		this.name = name;
	}
	public void hug(){
		synchronized (lock1) {
			System.out.println(Thread.currentThread().getName() + " in " + name + ".hug() trying to invoke " + partner.name + ".hugBack()");
			partner.hugBack();
		}
	}
	private void hugBack(){
			synchronized (lock2) {
			System.out.println(Thread.currentThread().getName() +
					" in " + name + ".hugBack()");
			}
	}
	public void becomeFriend(Friendly partner){
		this.partner = partner;
	}

	public static void main(String[] args){
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		new Thread(new Runnable() {
			public void run(){ jareth.hug();}
		}, "Thread1").start();
		new Thread(new Runnable() {
			public void run(){ cory.hug();}
		}, "Thread2").start();
	}
}

