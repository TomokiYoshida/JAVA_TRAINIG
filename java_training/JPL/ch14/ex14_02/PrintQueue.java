package ch14.ex14_02;

import java.awt.PrintJob;

public class PrintQueue {

	private SingleLinkQueue<PrintJob> queue = new SingleLinkQueue<PrintJob>();

	public synchronized void add(PrintJob j){
		queue.add(j);
	}
	public synchronized PrintJob remove() throws InterruptedException{
		while(queue.size() == 0)
			wait();
		return queue.remove();

	}

}
