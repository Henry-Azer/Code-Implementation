package DesignPatterns.Flyweight.SpreadSheet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CellContextFactory {
    private final Map<Integer, CellContext> contextMap = new HashMap<>();

    public CellContext getContext(String fontFamily, int fontSize, boolean isBold) {
        var hash = Objects.hash(fontFamily, fontSize, isBold);
        if (!contextMap.containsKey(hash))
            contextMap.put(hash, new CellContext(fontFamily, fontSize, isBold));

        return contextMap.get(hash);
    }
}
