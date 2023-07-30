import lib.tree.RbTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RbTreeTest {
    @Test
    public void test() {
        RbTree<Integer> rbTree = new RbTree<>();
        rbTree.insert(1); System.out.println(rbTree.print());
        rbTree.insert(3); System.out.println(rbTree.print());
        rbTree.insert(3); System.out.println(rbTree.print());
        rbTree.insert(4); System.out.println(rbTree.print());
        rbTree.insert(4); System.out.println(rbTree.print());
        rbTree.insert(2); System.out.println(rbTree.print());
        assertEquals(6, rbTree.countLeq(5));
        assertEquals(4, rbTree.countLess(4));
        assertEquals(4, rbTree.countGeq(3));
        assertEquals(4, rbTree.countGreater(2));
        rbTree.eraseAll(3); System.out.println(rbTree.print());
        rbTree.eraseAll(3); System.out.println(rbTree.print());
    }
}
