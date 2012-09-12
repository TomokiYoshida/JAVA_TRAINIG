package ch17.ex17_01;
/**
 * 起動時と多くのオブジェクトを生成した後で、利用可能なメモリ量を調べるプログラムを書き
なさい。ガーベッジコレクタを呼び出して、空きメモリ量がどのように変化するかを調べなさい。もちろん、
新たに生成されたオブジェクトヘの参照を間違いなく保持していないようにしてください。
 * @author tom
 *
 */
public class MemorySurvey {
	public static void main(String[] args){
	Runtime rt = Runtime.getRuntime();
	long mem = rt.freeMemory();

		System.out.println(mem);

		String[] test = new String[10000];
		for(int i = 0 ; i < 10000; i ++){
			test[i] = new String("test");
		}
		mem = rt.freeMemory();

		System.out.println(mem);

		rt.runFinalization();
		rt.gc();
		mem = rt.freeMemory();

		System.out.println(mem);

}
}
