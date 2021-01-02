package leetcode._17;


import java.util.Deque;
import java.util.LinkedList;

public class P1702 {
    public String maximumBinaryString(String binary) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i=0;i<binary.length();++i)
            if (binary.charAt(i) == '0') queue.addLast(i);
        int p;
        while (queue.size() >= 2){
            p = queue.pollFirst();
            queue.pollFirst();
            queue.addFirst(p+1);
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<binary.length();++i) sb.append('1');
        while (!queue.isEmpty()){
            p = queue.pollFirst();
            sb.setCharAt(p,  '0');
        }
        return sb.toString();
    }
}
