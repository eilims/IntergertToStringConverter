import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IntegerToStringConverterTest {

    IntegerToStringConverter test;

    @Before
    public void setUp() throws Exception {
        test = new IntegerToStringConverter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parse() throws Exception {
        assertEquals("zero ", this.test.parse(0));
        assertEquals("one ", this.test.parse(1));
        assertEquals("ten ", this.test.parse(10));
        assertEquals("fifteen ", this.test.parse(15));
        assertEquals("twenty two ", this.test.parse(22));
        assertEquals("one hundred ", this.test.parse(100));
        assertEquals("one hundred and twenty two ", this.test.parse(122));
        assertEquals("one hundred thousand five hundred ", this.test.parse(100500));
        assertEquals("twenty thousand five hundred ", this.test.parse(20500));
        assertEquals("one hundred twenty five thousand four hundred and twenty two ", this.test.parse(125422));
        assertEquals("one million ", this.test.parse(1000000));
        assertEquals("one billion ", this.test.parse(1000000000));
    }

    @Test
    public void digitParse() throws Exception {
        ArrayList<Integer> realList = new ArrayList<Integer>();
        realList.add(5);
        realList.add(20);
        ArrayList<Integer> testList = new ArrayList<Integer>();
        this.test.digitParse(25, testList);
        assertEquals(realList, testList);
        testList.clear();
        realList.add(1);
        realList.add(5);
        realList.add(20);
        this.test.digitParse(25125, testList);
        assertEquals(realList, testList);
    }

    @Test
    public void wordParse() throws Exception {
    }

    @Test
    public void appendTens() throws Exception {
    }

    @Test
    public void appendPlace() throws Exception {
    }

}