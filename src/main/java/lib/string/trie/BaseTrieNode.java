package lib.string.trie;

import java.util.HashMap;
import java.util.Map;

public class BaseTrieNode implements ITrieNode{

    protected Map<Character, ITrieNode> children;

    public BaseTrieNode() {
        children = new HashMap<>();
    }

    @Override
    public ITrieNode moveTo(Character ch) {
        return getChildren().get(ch);
    }

    @Override
    public ITrieNode expandTo(Character ch) {
        ITrieNode next = getChildren().get(ch);
        if (next != null) return next;

        try {
            next = this.getClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        getChildren().put(ch, next);
        return next;
    }

    private Map<Character, ITrieNode> getChildren() {
        return children;
    }
}
