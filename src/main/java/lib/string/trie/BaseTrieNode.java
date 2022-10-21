package lib.string.trie;

public abstract class BaseTrieNode<E> implements ITrieNode<E> {

    protected E data;
    protected Integer prefixCount;
    protected Integer endCount;

    public BaseTrieNode() {
        this(null);
    }

    public BaseTrieNode(E data) {
        this.data = data;
        prefixCount = 0;
        endCount = 0;
    }

    protected abstract ITrieNode<E> setNext(Character ch, ITrieNode<E> target);

    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data = data;
    }

    @Override
    public ITrieNode<E> expandTo(Character ch) {
        ++prefixCount;
        ITrieNode<E> next = moveTo(ch);
        if (next != null) {
            return next;
        }

        try {
            next = this.getClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return setNext(ch, next);
    }


    @Override
    public Integer getWordEndCount() {
        return endCount;
    }

    @Override
    public Integer setWordEndCount(int value) {
        return endCount = value;
    }

    @Override
    public Integer getWordPrefixCount() {
        return prefixCount;
    }

    public Integer setWordPrefixCount(int value) {
        return prefixCount = value;
    }
}
