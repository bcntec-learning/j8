package houseware.learn.j8;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author fphilip@houseware.es
 */
public class LambdaLetterCount {


    public static final String NOTE = "This note is a ransom";

    public static final String MAGAZINE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
            "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident," +
            " sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
            "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam " +
            "rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt " +
            "explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia " +
            "consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui " +
            "dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora " +
            "incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum " +
            "exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem " +
            "vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui " +
            "dolorem eum fugiat quo voluptas nulla pariatur?" +
            " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
            "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident," +
            " sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
            "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam " +
            "rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt " +
            "explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia " +
            "consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui " +
            "dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora " +
            "incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum " +
            "exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem " +
            "vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui " +
            "dolorem eum fugiat quo voluptas nulla pariatur?";

    @Test
    public void java_style() {
        long s = System.currentTimeMillis();
        Map<Character, Integer> note = processJavaStyle(NOTE);
        Map<Character, Integer> magazine = processJavaStyle(MAGAZINE);
        System.err.println("Java Time elapsed?"+(System.currentTimeMillis()-s));

        Map<Character, Integer> missing = calculateJavaStyle(note, magazine);

        int i = 0;
        for (Character character : note.keySet()) {
            Integer o = note.get(character);
            Integer q = magazine.get(character);
            System.out.println(character + " > " + o + " >" + q);
            if (q == null || q < o) {
                i++;
            }
        }
        if (i > 0) {
            System.out.println("This magazine can't used to create this ransom");
        }


    }







    @Test
    public void lambda_style() {

        long s = System.currentTimeMillis();
        Map<Character, Integer> note = processLmbdaStyle(NOTE);
        Map<Character, Integer> magazine = processLmbdaStyle(MAGAZINE);
        System.err.println("Lambda Time elapsed?"+(System.currentTimeMillis()-s));

    }







    @Test
    public void lambda_optimized() {

        long s = System.currentTimeMillis();
        Map<Character, Integer> note = processLmbdaStyle(NOTE);
//        Map<Character, Integer> magazine = processLmbdaStyle(MAGAZINE);

        Stream<Character> i = Stream.of(toCharacter(MAGAZINE));
        final Map<Character, Integer> count =
                i.filter(not(Character::isWhitespace)).
                        filter(note::containsKey).
                        collect(TreeMap::new, (m, c) -> m.merge(c, 1, Integer::sum), Map::putAll);

        System.err.println("Lambda Optimized Time elapsed?"+(System.currentTimeMillis()-s));
    }
















    private Map<Character, Integer> calculateJavaStyle(Map<Character, Integer> note, Map<Character, Integer> magazine) {
        Map<Character, Integer> missing = new HashMap<>();
        for (Character character : note.keySet()) {
            Integer o = note.get(character);
            Integer q = magazine.get(character);
            if (q == null || q < o) {
                magazine.put(character, q == null ? o : Integer.sum(q, o));
            }
        }
        return missing;
    }







    private Map<Character, Integer> processJavaStyle(String text) {
        char[] charArray = text.toCharArray();
        Map<Character, Integer> frequency = new LinkedHashMap<>();

        for (char key : charArray) {
            if (!Character.isWhitespace(key)) {
                Integer z = frequency.get(key);
                Integer i = (z == null ? 0 : z) + 1;
                frequency.put(key, i);
            }
        }

        return frequency;
    }


    public Map<Character, Integer> processLmbdaStyle(String text) {
        if (text == null) {
            return null;
        }

        Stream<Character> i = Stream.of(toCharacter(text));
        final Map<Character, Integer> count =
                i.filter(not(Character::isWhitespace)).
                        collect(TreeMap::new, (m, c) -> m.merge(c, 1, Integer::sum), Map::putAll);

        return count;
    }

    static <T> Predicate<T> not(Predicate<T> p) {
        return t -> !p.test(t);
    }


    public static Character[] toCharacter(final String text) {

        char[] array = text.toCharArray();

        final Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Character.valueOf(array[i]);
        }
        return result;
    }

}
