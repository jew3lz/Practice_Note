import java.util.LinkedHashMap;

/**
 * Created by JEWELZ on 5/5/15.
 */
public class FindAppeareOnceOrTwice {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null)
            return;
        LinkedHashMap<Integer,Integer> hash=new LinkedHashMap<Integer,Integer>();
        for(int i: array)
        {
            if(hash.containsKey(i))
                hash.put(i, hash.get(i)+1);
            else
                hash.put(i, 1);
        }
        for(Integer key:hash.keySet())
        {
            if(hash.get(key)==1)
                if(num1[0] == 0) {
                    num1[0] = key;
                }else{
                    num2[0] = key;
                }

        }
    }
    public Character firstNotRepeating(String str)
    {
        if(str==null)
            return null;
        char[] strChar=str.toCharArray();
        LinkedHashMap<Character,Integer> hash=new LinkedHashMap<Character,Integer>();
        for(char item:strChar)
        {
            if(hash.containsKey(item))
                hash.put(item, hash.get(item)+1);
            else
                hash.put(item, 1);
        }
        for(char key:hash.keySet())
        {
            if(hash.get(key)==1)
                return key;
        }
        return null;

    }
}
