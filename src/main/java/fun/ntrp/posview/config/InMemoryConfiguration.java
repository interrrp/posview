package fun.ntrp.posview.config;

import java.util.HashMap;

public class InMemoryConfiguration implements IConfiguration {
    private final HashMap<String, Object> objects = new HashMap<>();

    @Override
    public int getInt(String name) {
        return (int) objects.get(name);
    }

    @Override
    public void setInt(String name, int value) {
        objects.put(name, value);
    }
}
