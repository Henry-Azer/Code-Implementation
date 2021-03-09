package DesignPatterns.Flyweight.Point;

import java.util.HashMap;
import java.util.Map;

public class PointIconFactory {
    private final Map<PointType, PointIcon> iconMap = new HashMap<>();

    public PointIcon getPointIcon(PointType type) {
        if (!iconMap.containsKey(type)) {
            var icon = new PointIcon(type, null);
            iconMap.put(type, icon);
        }

        return iconMap.get(type);
    }
}
