package ch03.ex03_05;

class MethodBenchmark extends Benchmark{

	void benchmark(){

	}
	public static void main(String[] args){
		int count = Integer.parseInt(args[0]);
		long time = new MethodBenchmark().repeat(count);
		System.out.println(count + " methods in " + time + " nanoseconds");
	}

}
