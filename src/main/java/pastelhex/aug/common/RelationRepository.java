package pastelhex.aug.common;

import java.util.HashSet;
import java.util.Set;

public class RelationRepository {

    private static Set<String> allRelationsNames = new HashSet<>();

    public static void addRelationName(String name) {
        System.out.println("Adding relation " + name);
        allRelationsNames.add(name);
    }

    public static boolean isThereRelation(String name) {
        return allRelationsNames.contains(name);
    }

}
