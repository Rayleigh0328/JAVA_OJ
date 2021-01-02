package leetcode._17;

public class P1704 {
    public boolean halvesAreAlike(String s) {
        String sl = s.toLowerCase();
        int c1 = count(sl.substring(0, s.length() / 2));
        int c2 = count(sl.substring(s.length() / 2));
        return c1 == c2;
    }

    private int count(String st){
        int result = 0;
        for (int i=0;i<st.length();++i){
            char ch = st.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ++result;
        }
        return result;
    }
}
