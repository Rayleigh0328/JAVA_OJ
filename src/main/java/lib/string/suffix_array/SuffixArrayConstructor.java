package lib.string.suffix_array;

public interface SuffixArrayConstructor{
    int[] buildRank(int[] paddedArray);
    int[] buildSaFromRank(int[] rank);
}
