package sandbox.prefs;
import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;

public class PrefsTest1 {
    private Preferences prefs;
    private static final String KEY = "name";

    public PrefsTest1() {
        prefs = Preferences.userNodeForPackage(this.getClass()); // (1)
    }

    public void save(String name) {
        try {
            System.out.println("Save the name: " + name);
            prefs.put(KEY, name);                                // (2)
            prefs.flush();                                       // (2)
        } catch (BackingStoreException ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        String name = prefs.get(KEY, "no data");                 // (3)
        System.out.println("Load the name: " + name);
    }

    public static void main(String[] args) {
   	args = new String[3];
    	args[0] = "test1";
        PrefsTest1 test = new PrefsTest1();
        if (args.length > 0) {
            test.save(args[0]);
        } else {
            test.load();
        }
    }
}