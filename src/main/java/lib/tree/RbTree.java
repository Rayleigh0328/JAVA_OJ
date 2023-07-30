package lib.tree;

/*
    implementation of red-black tree
    properties of red-black tree
    0) every node is either black or red.
    1) root is always black
    2) leaf null node is always black
    3) a red node must have two black children (here child can be leaf null node)
    4) every path from a given node u to any of its descendant leaf null node have same number of black nodes
 */
public class RbTree<T extends Comparable<T>> {

    private RbTreeNode<T> root;

    public RbTree() {
        root = null;
    }

    public RbTreeNode<T> getRoot() {
        return root;
    }

    public int getSize() {
       return getSize(root);
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    // return subtree root after insertion
    public void insert(T val) {
        RbTreeNode<T> n= new RbTreeNode<>(val); // new node has color RED

        if (root == null) {
            root = n;
            root.color = Color.BLACK;
            return ;
        }

        insert(root, n);
        insertBalance(n);
    }

    public boolean contains(T val) {
        if (findNode(val) == null) return false;
        return true;
    }

    // return if there's a node erased
    public boolean erase(T val) {
        RbTreeNode<T> n = findNode(val);
        if (n == null) return false;
        deleteNode(n);
        return true;
    }

    // return number of nodes erased
    public int eraseAll(T val) {
        int count = 0;
        while (erase(val)) {
            ++count;
        }
        return count;
    }

    public T findGreater(T target) {
        return findGreater(root, target);
    }

    public T findGeq(T target) {
        return findGeq(root, target);
    }

    public T findLess(T target) {
        return findLess(root, target);
    }

    public T findLeq(T target) {
        return findLeq(root, target);
    }

    public int countLeq(T target) {
        return countLeq(root, target);
    }

    public int countLess(T target) {
        return countLess(root, target);
    }

    public int countGeq(T target) {
        return countGeq(root, target);
    }

    public int countGreater(T target) {
        return countGreater(root, target);
    }

    public String print() {
        return print(root);
    }

    /**** private helper functions ****/

    private boolean validateRbTree() {
        dfsValidateRbTree(root);
        return true;
    }

    private int dfsValidateRbTree(RbTreeNode<T> n) {
       if (n == null) return 1;
       int leftDepth = dfsValidateRbTree(n.left);
       int rightDepth = dfsValidateRbTree(n.right);
       assert(leftDepth == rightDepth);
       if (n.color == Color.BLACK) return leftDepth + 1;
       return leftDepth;
    }

    private int countLeq(RbTreeNode<T> n, T target) {
        if (n == null) return 0;
        if (n.data.compareTo(target) <= 0) return getSize(n.left) + 1 + countLeq(n.right, target);
        else return countLeq(n.left, target);
    }

    private int countLess(RbTreeNode<T> n, T target) {
        if (n == null) return 0;
        if (n.data.compareTo(target) < 0) return getSize(n.left) + 1 + countLess(n.right, target);
        else return countLeq(n.left, target);
    }

    private int countGeq(RbTreeNode<T> n, T target) {
        if (n == null) return 0;
        if (n.data.compareTo(target) >= 0) return getSize(n.right) + 1 + countGeq(n.left, target);
        else return countGeq(n.right, target);
    }

    private int countGreater(RbTreeNode<T> n, T target) {
        if (n == null) return 0;
        if (n.data.compareTo(target) > 0) return getSize(n.right) + 1 + countGreater(n.left, target);
        else return countGreater(n.right, target);
    }

    private T findGreater(RbTreeNode<T> n, T target) {
        if (n == null) return null;
        if (target.compareTo(n.data) < 0) {
            T tmp = findGreater(n.left, target);
            return tmp == null ? n.data : tmp;
        }
        return findGreater(n.right, target);
    }

    private T findGeq(RbTreeNode<T> n, T target) {
        if (n == null) return null;
        if (target.compareTo(n.data) <= 0) {
            T tmp = findGeq(n.left, target);
            return tmp == null ? n.data : tmp;
        }
        return findGeq(n.right, target);
    }

    private T findLess(RbTreeNode<T> n, T target) {
        if (n == null) return null;
        if (target.compareTo(n.data) > 0) {
            T tmp = findLess(n.right, target);
            return tmp == null ? n.data : tmp;
        }
        return findLess(n.left, target);
    }

    private T findLeq(RbTreeNode<T> n, T target) {
        if (n == null) return null;
        if (target.compareTo(n.data) >= 0) {
            T tmp = findLeq(n.right, target);
            return tmp == null ? n.data : tmp;
        }
        return findLeq(n.left, target);
    }

    private String print(RbTreeNode<T> cur) {
        if (cur == null) return "";
        return print(cur.left) + cur.toString() + print(cur.right);
    }

    private int getSize(RbTreeNode<T> n) {
        return n == null ? 0 : n.size;
    }

    // return
    private void deleteNode(RbTreeNode<T> n) {
        if (n == root && n.left == null && n.right == null) {
            // root is the only node in the tree
            root = null;
            return;
        }

        if (n.left != null && n.right != null) {
            // if n has two non-empty child
            // then find largest node x in left tree
            // swap data in n and x, delete x instead
            RbTreeNode<T> toReplace = getMaxNode(n.left);

            T tmp = n.data;
            n.data = toReplace.data;
            toReplace.data = tmp;

            deleteNode(toReplace);
            return;
        }

        RbTreeNode p = getParent(n);
        // now n has at most 1 non-empty child
        RbTreeNode<T> c = n.left == null ? n.right : n.left;

        // case 1: n is red, c must be black
        // case 1.1 if c is null, will not violate property
        // case 1.2 if c is not null, will not violate property either
        if (n.color == Color.RED) {
            assert(getColor(c) == Color.BLACK);
            eraseUpdateSize(n);
            replaceNode(n,c);
            return;
        }

        // case 2: n is black, c is red, simply change c to black
        if (getColor(c) == Color.RED) {
            c.color = Color.BLACK;
            eraseUpdateSize(n);
            replaceNode(n,c);
            return;
        }

        // case 3: both n,c is black
        eraseBalance(n);
        eraseUpdateSize(n);
        replaceNode(n);
    }

    private void replaceNode(RbTreeNode<T> n) {
        assert(n.left == null || n.right == null);
        RbTreeNode<T> c = (n.left == null ? n.right : n.left);
        replaceNode(n,c);
    }

    private void replaceNode(RbTreeNode<T> n, RbTreeNode<T> c){
        RbTreeNode<T> p = getParent(n);
        // replace n by c, note c can be null
        if (c != null) {
            c.parent = p;
        }
        if (p == null) { // n is root
            root = c;
        }
        else {
            if (p.left == n) p.left = c;
            else p.right = c;
        }
    }

    private void eraseUpdateSize(RbTreeNode<T> n) {
        if (n == null) return;
        --n.size;
        eraseUpdateSize(getParent(n));
    }

    // re-balance because black depth of sub-tree rooted at n is reduced by 1
    private void eraseBalance(RbTreeNode<T> n) {

        assert(n != null && n.color == Color.BLACK);
        // case 1: n is the root
        if (n.parent == null) return;

        RbTreeNode<T> p = getParent(n);
        RbTreeNode<T> s = getSibling(n);
        // because n is black, then its sibling must exist, otherwise property 5) is invalid
        assert(p != null && s != null);
        // note sl, sr can be null
        RbTreeNode<T> sl = s.left;
        RbTreeNode<T> sr = s.right;

        // case 2: p,s,sl,sr all black, paint s to red and recursion on p
        if (p.color == Color.BLACK && s.color == Color.BLACK && getColor(sl) == Color.BLACK && getColor(sr) == Color.BLACK) {
            s.color = Color.RED;
            eraseBalance(p);
            return;
        }

        // case 3: s is red. then sl, sr, p must be black.
        // rotate s to be the new root
        // paint s to black and p to red
        // now case3 is converted to case 4,5,6
        if (s.color == Color.RED) {
            s.color = Color.BLACK;
            p.color = Color.RED;
            if (s == p.right) rotate(p, Direction.LEFT);
            else rotate(p, Direction.RIGHT);
            eraseBalance(n);
            return;
        }

        // case 4: p is red, s,sl,sr are all black
        // swap color of s,p then black depth to n will be increased by 1
        if (p.color == Color.RED && getColor(sl) == Color.BLACK && getColor(sr) == Color.BLACK) {
            s.color = Color.RED;
            p.color = Color.BLACK;
            return;
        }

        // case 5: s is black, outer child of s is red. inner child and p can be any color
        // rotate p so that s is the new root
        // color outer child and p to be black, s to be p's original color
        if (p.right == s && getColor(sr) == Color.RED) {
            s.color = p.color;
            p.color = sr.color = Color.BLACK;
            rotate(p, Direction.LEFT);
            return;
        }
        else if (p.left == s && getColor(sl) == Color.RED) {
            s.color = p.color;
            p.color = sl.color = Color.BLACK;
            rotate(p, Direction.RIGHT);
            return;
        }

        // case 5: the remaining case, where s is black, inner child of s is red, outer child of s is black
        // rotate s so that the inner child is new root, swap color of s and inner child
        // reduce to case 5
        if (p.right == s) {
           rotate(s, Direction.RIGHT);
           sl.color = Color.BLACK;
           s.color = Color.RED;
           eraseBalance(n);
        }
        else {
            rotate(s, Direction.LEFT);
            sr.color = Color.BLACK;
            s.color = Color.RED;
            eraseBalance(n);
        }
    }

    // return right-most node in the subtree
    private RbTreeNode<T> getMaxNode(RbTreeNode cur) {
        assert(cur != null);
        if (cur.right != null) return getMaxNode(cur.right);
        else return cur;
    }

    // return left-most node in the subtree
    private RbTreeNode<T> getMinNode(RbTreeNode cur) {
        assert(cur != null);
        if (cur.left!= null) return getMinNode(cur.left);
        else return cur;
    }

    private RbTreeNode<T> findNode(T val) {
       return findNode(root, val);
    }

    private RbTreeNode<T> findNode(RbTreeNode<T> cur, T val) {
        if (cur == null) return null;
        if (val.compareTo(cur.data) == 0) return cur;
        else if (val.compareTo(cur.data) < 0) return findNode(cur.left, val);
        else return findNode(cur.right, val);
    }

    private RbTreeNode<T> insert(RbTreeNode<T> n, RbTreeNode<T> val) {
        if (n == null) return val;
        RbTreeNode<T> subTreeRoot;
        if (val.data.compareTo(n.data) < 0) {
            subTreeRoot = insert(n.left, val);
            n.left = subTreeRoot;
        }
        else {
            subTreeRoot = insert(n.right, val);
            n.right = subTreeRoot;
        }
        n.size = 1 + getSize(n.left) + getSize(n.right);
        subTreeRoot.parent = n;
        return n;
    }

    private void insertBalance(RbTreeNode<T> n) {

        // case 1: n is root
        if (root == n) {
            root.color = Color.BLACK;
            return;
        }

        RbTreeNode<T> p = getParent(n);
        // n is not root, it's parent must not be null
        assert(p != null);

        // case2: parent is black, no property will be violated
        if (p.color == Color.BLACK) return;

        // from now on, both n, p are red
        RbTreeNode<T> g = getGrandParent(n);
        // because p is red, p can not be the root, thus g must exist and must be black
        assert(g != null && g.color == Color.BLACK);

        RbTreeNode<T> u = getSibling(p);
        // case3: u is red, then paint p,u to black and root to red
        // recursively re-balance g
        if (getColor(u) == Color.RED) {
            p.color = u.color = Color.BLACK;
            g.color = Color.RED;
            insertBalance(g);
            return;
        }

        // case 4 u is black, note: u can be null
        // case 4.1 n is u's close nephew, i.e. n,p,g form a turn
        // rotate n,p turn into case 4.2
        if (!isSmooth(n, p, g)) {
            if (n == p.left) rotate(p, Direction.RIGHT);
            else rotate(p, Direction.LEFT);
            insertBalance(p);
            return;
        }

        // case 4.2 n is u's distant nephew
        if (p == g.left) {
            rotate(g, Direction.RIGHT);
        }
        else {
            rotate(g, Direction.LEFT);
        }
        p.color = Color.BLACK;
        g.color = Color.RED;
    }

    private boolean isSmooth(RbTreeNode<T> n, RbTreeNode<T> p, RbTreeNode<T> g) {
        if (n == p.left) {
            return p == g.left;
        }
        else {
            return p == g.right;
        }
    }

    private Color getColor(RbTreeNode<T> n) {
        if (n == null) return Color.BLACK;
        return n.color;
    }

    private RbTreeNode<T> getChild(RbTreeNode<T> n, Direction dir) {
        return dir == Direction.LEFT ? n.left : n.right;
    }

    private RbTreeNode<T> getParent(RbTreeNode<T> n) {
        return n == null ? null : n.parent;
    }

    private RbTreeNode<T> getGrandParent(RbTreeNode<T> n) {
        return getParent(getParent(n));
    }

    private RbTreeNode<T> getSibling(RbTreeNode<T> n) {
        RbTreeNode<T> p = getParent(n);
        assert(p != null);
        return p.left == n ? p.right : p.left;
    }

    // return the new root of the subtree
    private RbTreeNode<T> rotate(RbTreeNode<T> n, Direction direction) {
        RbTreeNode<T> p = getParent(n);
        RbTreeNode<T> a = getChild(n, direction);
        RbTreeNode<T> b = getChild(n, direction.getOpposite());
        assert(b != null);
        RbTreeNode<T> c = getChild(b, direction);
        RbTreeNode<T> d = getChild(b, direction.getOpposite());


        // connect subtree root
        if (p != null) {
            if (n == p.left) {
                p.left = b;
            }
            else {
                p.right = b;
            }
        }
        else {
            root = b;
        }
        b.parent = p;

        if (direction == Direction.LEFT) {
            b.left = n;
            n.parent = b;

            n.right = c;
            if (c != null) c.parent = n;
        }
        else {
            b.right = n;
            n.parent = b;

            n.left = c;
            if (c != null) c.parent = n;
        }

        n.size = 1 + getSize(c) + getSize(a);
        b.size = 1 + getSize(d) + getSize(n);
        return b;
    }

    /**** helper classes ****/

    private class RbTreeNode<T extends Comparable<T>> {
        Color color;
        RbTreeNode<T> parent, left, right;
        int size;
        T data;

        RbTreeNode(T d) {
            data = d;
            size = 1;
            color = Color.RED;
            parent = left = right = null;
        }

        @Override
        public String toString() {
            return " {" +
                "color=" + color +
                ", size=" + size +
                ", data=" + data +
                "} ";
        }
    }

    private enum Color {
        RED,
        BLACK
    }

    private enum Direction {
        LEFT(0),
        RIGHT(1);

        private int value;
        Direction(int v) {
            value = v;
        }

        public Direction getOpposite() {
            return value == 0 ? RIGHT : LEFT;
        }
    }
}
