package tzb.Utils;

public class Check_Search_Val {
    public static boolean check_search_val(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        return j == t.length();
    }
}
