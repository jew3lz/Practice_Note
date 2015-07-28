/**
 * Created by JEWELZ on 7/7/15.
 */
public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        if(str == null)
            return null;
        char[] arr = str.toString().toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < arr.length;i++){
            if(arr[i]==' ')
                res.append("%20");
            else
                res.append(arr[i]);
        }
        return res.toString();
    }
}
