package ch17.ex17_03;

import java.util.Map;
import java.util.WeakHashMap;

/**ハッシュコードを使用する代わりに、キーを管理することで参照オブジェクトを使用するよう
に、リソース実装クラスを書き直しなさい。*/
public class Resourcelmpl implements Resource {
		int keyHash;
		boolean needsRelease = false;
		Map<Object, Object> map =  new WeakHashMap<Object, Object>();

		Resourcelmpl(Object key) {
		map.put(key, new Object());
		needsRelease = true;
		}
		public void use(Object key, Object...  args) {
		if (map.get(key) == null)
		throw new IllegalArgumentException("wrong key") ;
		}
		public synchronized void release(){
			if (needsRelease) {
				needsRelease = false;
			}
		}
		public static void main(String[] args){
			Resource r1 = new Resourcelmpl("r1");
			r1.use("r1", null);
			r1.release();

		}

	}
