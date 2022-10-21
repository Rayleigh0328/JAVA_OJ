package lib.string.trie;

import java.util.HashMap;
import java.util.Map;

public final class GeneralTrieNode<E> extends BaseTrieNode<E> implements ITrieNode<E> {

    private Map<Character, GeneralTrieNode<E>> nextMap;

    public GeneralTrieNode() {
        this(null);
    }

    public GeneralTrieNode(E data) {
        super(data);
        nextMap = new HashMap<>();
    }


    @Override
    protected ITrieNode<E> setNext(Character ch, ITrieNode<E> target) {
        assert target instanceof GeneralTrieNode;

        nextMap.put(ch, (GeneralTrieNode<E>) target);
        return target;
    }

    @Override
    public ITrieNode<E> moveTo(Character ch) {
        return nextMap.get(ch);
    }
}
