import java.util.*;

public class SymTG {
    public static class MethodInfo {
        public final String returnType;
        public final List<String> paramTypes = new ArrayList<>();

        public MethodInfo(String returnType) {
            this.returnType = returnType;
        }
    }

    public static class ClassInfo {
        public final Map<String, String> fields = new HashMap<>();
        public final Map<String, MethodInfo> methods = new HashMap<>();
    }

    private final Map<String, ClassInfo> classes = new HashMap<>();

    public boolean addClass(String name) {
        if (classes.containsKey(name)) return false;
        classes.put(name, new ClassInfo());
        return true;
    }

    public ClassInfo getClass(String name) {
        return classes.get(name);
    }

    public boolean hasClass(String name) {
        return classes.containsKey(name);
    }
}
