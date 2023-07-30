package lib.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitwiseHelperTest {

    @Test
    public void testHighBit() {
        assertEquals(0x0008, BitwiseHelper.highBit(13));
    }
}
