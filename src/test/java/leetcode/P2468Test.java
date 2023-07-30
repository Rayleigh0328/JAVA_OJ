package leetcode;

import leetcode._24.P2468;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class P2468Test {

    private static final Logger log = LoggerFactory.getLogger(P2468Test.class);

    P2468 underTest = new P2468();

    @Test
    public void test1() {
        String [] result = underTest.splitMessage(
            "this is really a very awesome message",
            9
        );
        for (String st : result){
            log.info(st);
        }
    }

}
