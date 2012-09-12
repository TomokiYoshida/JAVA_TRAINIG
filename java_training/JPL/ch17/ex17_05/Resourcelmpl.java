package ch17.ex17_05;
/**
 * 刈り取リスレッドを使用しないようにリソースマネジャーを再設計しなさい。リソースマネ
ジャーが持つセマンテイックスを明確にし、リソースがいつ解放されるかについても明確にしなさい。
 * @author tom
 *
 */
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
