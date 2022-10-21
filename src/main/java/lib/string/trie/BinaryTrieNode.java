package lib.string.trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class BinaryTrieNode<E> extends BaseTrieNode<E> implements ITrieNode<E> {

    public static final Set<Character> ALPHABET = new HashSet<>(Arrays.asList('0', '1'));

    private BinaryTrieNode<E> children[];

    public BinaryTrieNode() {
        this(null);
    }

    public BinaryTrieNode(E data) {
        super(data);
        children = new BinaryTrieNode[2];
    }

    @Override
    public ITrieNode<E> moveTo(Character ch) {
        assert ALPHABET.contains(ch);

        return getChildren()[ch - '0'];
    }

    @Override
    protected ITrieNode<E> setNext(Character ch, ITrieNode<E> target) {
        assert ALPHABET.contains(ch);
        assert target instanceof BaseTrieNode;

        return children[ch - '0'] = (BinaryTrieNode<E>) target;
    }

    private BinaryTrieNode<E>[] getChildren() {
        return children;
    }

}
