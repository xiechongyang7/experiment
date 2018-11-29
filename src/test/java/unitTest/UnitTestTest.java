package unitTest;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestTest {

    @BeforeEach
    void setUp() {
        System.out.println("\nBeforeEach text");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach text");
    }

    /**
     * 1	void assertEquals(boolean expected, boolean actual)	检查两个变量或者等式是否平衡
     * 2	void assertTrue(boolean expected, boolean actual)	检查条件为真
     * 3	void assertFalse(boolean condition)	检查条件为假
     * 4	void assertNotNull(Object object)	检查对象不为空
     * 5	void assertNull(Object object)	检查对象为空
     * 6	void assertSame(boolean condition)	检查两个相关对象是否指向同一个对象
     * 7	void assertNotSame(boolean condition)	检查两个相关对象是否不指向同一个对象
     * 8	void assertArrayEquals(expectedArray, resultArray)	检查两个数组是否相等
     */
    @Test
    void isTrue() {
        System.out.println("text start");
        Assert.assertTrue("is false",new UnitTest().isTrue(1));
        Assert.assertTrue("is false",new UnitTest().isTrue(0));
        /**
         * Expected :true
         * Actual   :false
         */
        Assert.assertTrue("is false",new UnitTest().isTrue(-1));
        System.out.println("text end");
    }

    @Test
    void isnull() {

        String a  = null;
        System.out.println(String.valueOf(a));
    }
    @Test
    public void getUUID(){
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}