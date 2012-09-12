package ch17.ex17_04;
/**
 * 刈り取リスレッドを修正して、すべての割り当てられたリツースが解放されるまで、シャット
ダウンの後も生き続けるようにしなさい。
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
