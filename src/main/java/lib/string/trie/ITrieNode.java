package lib.string.trie;

public interface ITrieNode{
    ITrieNode moveTo(Character ch);
    ITrieNode expandTo(Character ch);
}
