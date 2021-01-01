package lib.string.trie;

public class BinaryTrieNodeWithData<E> implements ITrieNode {

    private E data;
    private BinaryTrieNodeWithData<E> children[];

    public BinaryTrieNodeWithData() {
        this.data = null;
        children = new BinaryTrieNodeWithData[2];
    }

    public BinaryTrieNodeWithData(E data){
        this.data = data;
        children = new BinaryTrieNodeWithData[2];
    }

    private BinaryTrieNodeWithData[] getChildren(){
        return children;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public ITrieNode moveTo(Character ch) {
        return getChildren()[ch-'0'];
    }

    @Override
    public ITrieNode expandTo(Character ch) {
        BinaryTrieNodeWithData next = getChildren()[ch-'0'];
        if (next != null) return next;

        next = new BinaryTrieNodeWithData<E>();
        getChildren()[ch-'0'] = next;
        return next;
    }
}
