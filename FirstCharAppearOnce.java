import java.util.LinkedHashMap;

/**
 * Created by JEWELZ on 30/7/15.
 */
public class FirstCharAppearOnce {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }
        char[] strChar = str.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char item : strChar) {
            if (map.containsKey(item))
                map.put(item, map.get(item) + 1);
            else
                map.put(item, 1);
        }
        for (char key : map.keySet()) {
            if (map.get(key) == 1)
                return str.indexOf(key);
        }
        return -1;
    }
}
