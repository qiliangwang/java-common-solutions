package commonsolutions.design.notification.render;

import java.util.HashMap;
import java.util.Map;

public class VariableContext {

    public interface Names {
        String NOMINATOR = "nominator";
        String NOMINEE = "nominee";
        String MEETING = "meeting";
        String RESEARCH = "research";
    }

    private Map<String, Object> variables = new HashMap<>();

    public VariableContext put(String variableName, Object dataHolder) {
        variables.putIfAbsent(variableName, dataHolder);
        return this;
    }

    public <T> T get(String variableName) {
        return (T) variables.get(variableName);
    }
}
