package lib.disjoint_set;

/*
    label is from 0 to size - 1 inclusive
 */
public class DisjointSet {
    private int [] leader;
    private int [] weight;
    private int countSet;

    public DisjointSet(int size) {
        leader = new int[size];
        weight = new int[size];
        for (int i=0;i<size;++i) {
            leader[i] = i;
            weight[i] = 1;
        }
        countSet = size;
    }

    public int findSet(int k) {
        if (leader[k] == k) return k;
        leader[k] = findSet(leader[k]);
        weight[k] = weight[leader[k]];
        return leader[k];
    }

    public void unionSet(int x, int y) {
        if (findSet(x) == findSet(y)) return;
        if (weight[findSet(x)] < weight[findSet(y)]) {
            unionSet(y,x);
            return;
        }
        else {
            weight[findSet(x)] += weight[findSet(y)];
            leader[findSet(y)] = findSet(x);
            --countSet;
        }
    }

    public int getWeight(int k) {
        return weight[findSet(k)];
    }

    public int getNumberOfSets() {
        return countSet;
    }
}
