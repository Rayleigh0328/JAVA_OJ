package leetcode._24;

public class P2437 {
    public int countTime(String time) {
        int result = 0;
        for (int h=0;h<24;++h)
            for (int m=0;m<60;++m)
                if (match(time, h, m))
                    ++result;
        return result;
    }

    private boolean match(String time, int h, int m) {
        String hourTemplate = time.substring(0,2);
        String hourString = Integer.toString(h);
        if (hourString.length() == 1) hourString = "0" + hourString;
        if (!match(hourTemplate, hourString)) return false;

        String minuteTemplate = time.substring(3);
        String minuteString = Integer.toString(m);
        if (minuteString.length() == 1) minuteString = "0" + minuteString;
        if (!match(minuteTemplate, minuteString)) return false;

        return true;
    }

    private boolean match(String template, String actual) {
        if (!match(template.charAt(0), actual.charAt(0))) return false;
        if (!match(template.charAt(1), actual.charAt(1))) return false;
        return true;
    }

    private boolean match(char ch1, char ch2) {
        if (ch1 == '?') return true;
        return ch1 == ch2;
    }
}
