package ch03.ex03_05;

class RoopBenchmark extends Benchmark{

	private int roopNumber;

	RoopBenchmark(int roopNumber){
		this.roopNumber = roopNumber;
	}

	void benchmark(){
		for(int i = 0; i < roopNumber; i ++){

		}
	}
	public static void main(String[] args){
		int count = Integer.parseInt(args[0]);
		int roopNumber = Integer.parseInt(args[1]);
		long time = new RoopBenchmark(roopNumber).repeat(count);
		System.out.println(count + " methods * " + roopNumber + " roops in " + time + " nanoseconds");
	}

}
