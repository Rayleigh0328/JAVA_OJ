package lib.array.range_sum;

import lib.common.ArithmeticHelper;

import java.util.ArrayList;
import java.util.List;

public class RangeSumCalculator<E extends Number> {

    private int n = 0;
    private ArrayList<E> prefixSum = null;

    public RangeSumCalculator(List<E> list){
        if (list == null || list.isEmpty()) {
            return;
        }
        n = list.size();
        prefixSum = new ArrayList<>();
        prefixSum.add(list.get(0));
        for (int i=1;i<n;++i){
            prefixSum.add((E) ArithmeticHelper.add(list.get(i),prefixSum.get(i-1)));
        }
    }

    public E getRangeSum(int from, int to) {
        if (from == 0) return getPrefixSum(to);
        return (E) ArithmeticHelper.subtract(getPrefixSum(to), getPrefixSum(from - 1));
    }

    public E getPrefixSum(int index) {
        return prefixSum.get(index);
    }

}
