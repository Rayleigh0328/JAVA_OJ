package lib.string.trie;

public class TrieNodeWithData<E> extends BaseTrieNode implements ITrieNode{

    private E data;

    public TrieNodeWithData(){
        data = null;
    }

    public TrieNodeWithData(E data){
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
