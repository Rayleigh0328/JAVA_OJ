package lib;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lib.string.Manacher;

public class ManacherTest {

    private static final Logger logger = LoggerFactory.getLogger(ManacherTest.class);

    @Test
    public void loggerTest(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.info("[{}]", String.join(",", "a", "b", "c"));
    }

    @Test
    public void testLongestPalindrome(){
        String st = "aabaa";
        Manacher m = new Manacher(st);
        System.out.println(m.getPaddedString());
        int[] span = m.getSpan();
        for (int i=0;i<span.length;++i) System.out.print(span[i]);
    }
}
