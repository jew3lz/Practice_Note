import java.util.LinkedHashMap;

/**
 * Created by JEWELZ on 5/5/15.
 */
public class ReverseWordsInSentence {
    public static void main(String[] args) {
        String str = new ReverseWordsInSentence().reverseSentence("I am a student.");
        System.out.println("'"+str+"'");
        String str11 = "ddd ";
        str11 = str11.trim();
        System.out.println("'"+str11+"'");
    }

    String reverse(String str) {
        char[] pData = str.toCharArray();
        for (int i = 0; i < (pData.length + 1) / 2; i++) {
            char temp = pData[i];
            pData[i] = pData[pData.length - 1 - i];
            pData[pData.length - 1 - i] = temp;
        }
        String str1 = String.valueOf(pData);
        return str1;
    }


    String reverseSentence(String str) {
        if (str == null)
            return null;

        String Reversed = reverse(str);

        String[] strings = Reversed.split(" ");
        String res = "";
        for (String s : strings) {
            res = res + reverse(s) + " ";
        }
        return res;
    }
}
