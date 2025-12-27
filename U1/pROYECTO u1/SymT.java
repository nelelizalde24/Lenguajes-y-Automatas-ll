import java.util.HashMap;
import java.util.Map;

public class SymT {
    private final Map<String, String> locals = new HashMap<>();

    public boolean add(String id, String type) {
        if (locals.containsKey(id)) return false;
        locals.put(id, type);
        return true;
    }

    public String lookup(String id) {
        return locals.get(id);
    }

    public boolean contains(String id) {
        return locals.containsKey(id);
    }
}
