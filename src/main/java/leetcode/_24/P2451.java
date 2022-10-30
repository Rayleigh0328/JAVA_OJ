package leetcode._24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P2451 {

    public static class MyType implements Comparable<MyType> {
        private String data;
        private String signature;

        public MyType(String data, String signature) {
            this.data = data;
            this.signature = signature;
        }

        public String getData() {
            return data;
        }

        public String getSignature() {
            return signature;
        }

        @Override
        public int compareTo(MyType o) {
            return signature.compareTo(o.getSignature());
        }
    };

    public String oddString(String[] words) {
        List<MyType> list = Arrays.stream(words).map(s -> getSignature(s)).collect(Collectors.toList());
        list.sort(MyType::compareTo);
        if (list.get(1).getSignature().equals(list.get(0).getSignature())) return list.get(list.size() - 1).getData();
        else return list.get(0).getData();
    }

    private MyType getSignature(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<s.length();++i)
            sb.append(s.charAt(i) - s.charAt(i-1) + 50);
        return new MyType(s, sb.toString());
    }
}
