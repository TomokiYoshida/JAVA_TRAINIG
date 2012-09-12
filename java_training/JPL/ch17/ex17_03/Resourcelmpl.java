package ch17.ex17_03;
/**ハッシュコードを使用する代わりに、キーを管理することで参照オブジェクトを使用するよう
に、リソース実装クラスを書き直しなさい。*/
public class Resourcelmpl implements Resource {
		int keyHash;
		boolean needsRelease = false;
		Resourcelmpl(Object key) {
		keyHash = System.identityHashCode(key);
		needsRelease = true;
		}
		public void use(Object key, Object...  args) {
		if (System.identityHashCode(key) != keyHash)
		throw new IllegalArgumentException("wrong key") ;
		}
		public synchronized void release(){
			if (needsRelease) {
				needsRelease = false;
			}
		}
	}
