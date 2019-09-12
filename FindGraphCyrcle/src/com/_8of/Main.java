package com._8of;

import java.util.*;

public class Main {

    static boolean findCyrcle(Map<String, Map> graph, Set<Map> nodes) {
        for (String key : graph.keySet()) {
            Map<String, Map> node = graph.get(key);
            if (nodes.contains(node)) {
                return true;
            } else {
                if (!node.keySet().isEmpty()) {
                    nodes.add(node);
                }

                boolean isCyrcle = findCyrcle(node, nodes);
                if (isCyrcle) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map <String, Map> graph0 = new IdentityHashMap<>() {{
            put("a", new HashMap<>() {{
                put("a2", new HashMap());
                put("a3", new HashMap());
            }});
            put("b", new HashMap<>() {{
                put("b2", new HashMap());
            }});
        }};
        graph0.put("c", graph0);
        System.out.println(findCyrcle(graph0, new HashSet<Map>())); // true

        Map <String, Map> graph1 = new IdentityHashMap<>() {{
            put("a", new HashMap<>() {{
                put("a2", new HashMap());
                put("a3", new HashMap());
            }});
            put("b", new HashMap<>() {{
                put("b2", new HashMap());
            }});
        }};
        System.out.println(findCyrcle(graph1, new HashSet<Map>())); // false
    }
}
