package lib.string.trie;

public interface ITrieNode<T> {

    T getData();
    void setData(T data);

    ITrieNode<T> moveTo(Character ch);
    ITrieNode<T> expandTo(Character ch);

    Integer getWordEndCount();
    Integer setWordEndCount(int value);

    Integer getWordPrefixCount();
}
