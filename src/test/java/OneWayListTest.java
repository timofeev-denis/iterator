import iterator.OneWayList;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Author: timofeevdv
 * Date: 03.02.2017
 */
public class OneWayListTest {

    private OneWayList<String> list;

    @Before
    public void setUp() {
        list = new OneWayList<String>();
    }

    @Test
    public void testAddElement() {
        list.add("1");
        list.add("2");
        list.add("3");
    }

    @Test
    public void testInsertAtPosition() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.insert("1.5", 1);
        assertEquals("1", list.get(0));
        assertEquals("1.5", list.get(1));
        assertEquals("2", list.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertAtIncorrectPosition() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.insert("1.5", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertAtNegativePosition() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.insert("1.5", -1);
    }

    @Test
    public void testCorrectSize() {
        list.add("1");
        assertEquals(new Integer(1), list.getSize());
    }

}
