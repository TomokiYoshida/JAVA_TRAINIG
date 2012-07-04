package ch05.ex05_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BankAccount {

	private long number;
	private long balance;
	protected LinkedList<Action> lastActionList = new LinkedList<Action>();
	private int historyNumber = 0;

	public BankAccount(long number){
		this.number = number;
	}

	private void addLastAct(Action lastAct){
		if(lastActionList.size() == 10)lastActionList.poll();
		lastActionList.addLast(lastAct);
	}
	public History history(){
		return new History();
	}


	public class Action{
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		public String toString(){
			return number + ":" + act + " " + amount;
		}
	}
	public class History{
		private LinkedList<Action> actionList = (LinkedList<Action>)lastActionList.clone();

		public Action next(){
			return actionList.poll();
		}
	}
	public void deposit(long amount){
		balance += amount;
		addLastAct( new Action("deposit", amount));
	}

	public void withdraw(long amount){
		balance -= amount;
		addLastAct( new Action("withdraw", amount));
	}
	public void transfer(BankAccount other, long amount){
		other.withdraw(amount);
		deposit(amount);
		addLastAct( this.new Action("transfer", amount));
		other.addLastAct( other.new Action("transer", amount));
	}
	public static void main(String args[]){
		BankAccount b1 = new BankAccount(1);
		BankAccount b2 = new BankAccount(2);
		b1.deposit(1000);
		b1.withdraw(300);
		b1.transfer(b2, 500);
		History h1 = b1.history();
		History h2 = b2.history();

		Action a = h1.next();
		while(a != null){
			System.out.println(a);
			a = h1.next();
		}
		a = h2.next();
		while(a != null){
			System.out.println(a);
			a = h2.next();
		}

		BankAccount b3 = new BankAccount(3);
		b3.deposit(1000);
		b3.deposit(2000);
		b3.deposit(3000);
		b3.deposit(4000);
		b3.deposit(5000);
		b3.deposit(6000);
		b3.deposit(7000);
		b3.deposit(8000);
		b3.deposit(9000);
		b3.deposit(10000);
		b3.deposit(11000);
		History h3 = b3.history();
		a = h3.next();
		while(a != null){
			System.out.println(a);
			a = h3.next();
		}
	}


}


