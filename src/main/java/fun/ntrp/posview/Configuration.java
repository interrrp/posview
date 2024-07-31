package fun.ntrp.posview;

import java.util.HashMap;

public class Configuration {
    private static Configuration instance;

    private final HashMap<String, Object> objects = new HashMap<>();

    private Configuration() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null) {
                    instance = new Configuration();
                }
            }
        }
        return instance;
    }

    public int getInt(String name) {
        return (int) objects.get(name);
    }

    public void setInt(String name, int value) {
        objects.put(name, value);
    }
}
