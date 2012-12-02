package ex2_4;
import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;

public class PrefsUtil {
    private static Preferences prefs;
    private static final String KEY_PREFIX = "tyoshida";

    public PrefsUtil() {
        prefs = Preferences.userNodeForPackage(this.getClass());
    }
    public void save(String key, String value) {
        try {
            System.out.println("Save the key : value: " + key + ":" + value);
            prefs.put(KEY_PREFIX + key, value);
            prefs.flush();
        } catch (BackingStoreException ex) {
            ex.printStackTrace();
        }
    }

    public String load(String KEY, String defaultValue) {
        String name = prefs.get(KEY_PREFIX + KEY, defaultValue);
        System.out.println("Load the name: " + name);
        return name;
    }
}