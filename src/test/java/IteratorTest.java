import iterator.MyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Author: timofeevdv
 * Date: 01.02.2017
 */
public class IteratorTest {

    MyLinkedList<String> list;

    @Before
    public void init() {
        list = new MyLinkedList();
    }

    @Test
    public void testNewObjectNotNull() {
        assertNotNull(list);
    }

    @Test
    public void testPositionIsZeroOnAddOneElement() {
        list.add("first");
        assertEquals(new Integer(0), list.getPosition());
    }

    @Test
    public void testPositionIsNullOnEmpty() {
        assertNull(list.getPosition());
    }

    @Test
    public void testGetRandomElement() {
        Integer listSize = 4;
        Random random = new Random();
        int testPosition = random.nextInt(listSize);
        String expectedResult = null;
        for (int i = 0; i < listSize; i++) {
//            String listElement = new Integer(random.nextInt()).toString();
            String listElement = new Integer(i).toString();
            list.add(listElement);
            if (i == testPosition) {
                expectedResult = listElement;
            }
        }
        assertEquals(expectedResult, list.get(testPosition));
    }

    @Test
    public void testIteratorIsNotNull() {
        assertNotNull(list.listIterator());
    }
}
