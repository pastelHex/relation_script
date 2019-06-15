import java.util.HashSet;

public class LogicSet {

    public static HashSet<Integer> setOperation(java.util.Set<Integer> firstSet, String operator, java.util.Set<Integer> secondSet) {
        HashSet<Integer> result = new HashSet<>();
        switch (operator) {
            case "+":
                result.addAll(firstSet);
                result.addAll(secondSet);
                break;
            case "-":
            case "\\":
                result.addAll(firstSet);
                secondSet.stream().forEach(a -> result.remove(a));
                break;
        }
        return result;
    }
}
