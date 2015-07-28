/**
 * Created by JEWELZ on 4/5/15.
 */
public class RegularExpressionsMatching {
    boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null)
            return true;
        if (str == null || pattern == null)
            return false;

        return matchCore(str, 0, str.length, pattern, 0, pattern.length);


    }

    private boolean matchCore(char[] str, int i, int length,
                              char[] pattern, int j, int length2) {
        if (i == length && j == length2)//主串完事，匹配串也完事
            return true;
        if (i != length && j == length2)//主串没有完事，匹配串完事
            return false;
        if (j + 1 < length2 && pattern[j + 1] == '*') {
            if (i < length && (str[i] == pattern[j] || pattern[j] == '.')) {//主串和模式串当前字符匹配
                return matchCore(str, i + 1, length, pattern, j, length2) || //主串向后移动，匹配串不变aaa和a*
                        matchCore(str, i + 1, length, pattern, j + 2, length2) || //主串向后移动，匹配串跳过a*
                        matchCore(str, i, length, pattern, j + 2, length2);  //主串不变，匹配模式串后2个字符，跳过a*
            } else
                return matchCore(str, i, length, pattern, j + 2, length2);//主串和模式串不匹配，略过c和*
        }
        if (i < length && (str[i] == pattern[j] || (pattern[j] == '.'))) {//主串当前字符不为空，要么和模式串匹配，要么模式串为.
            return matchCore(str, i + 1, length, pattern, j + 1, length2);
        }
        return false;
    }
}
