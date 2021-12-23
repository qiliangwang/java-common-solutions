package commonsolutions.notification.composer;

import java.util.HashMap;
import java.util.Map;

public class VariableContext {
    private Map<String, Object> variables = new HashMap<>();

    public VariableContext put(String variableName, Object dataHolder) {
        variables.putIfAbsent(variableName, dataHolder);
        return this;
    }

    public <T> T get(String variableName) {
        return (T) variables.get(variableName);
    }
}
