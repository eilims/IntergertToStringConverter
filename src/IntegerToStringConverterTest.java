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
        assertEquals("one hundred and two ", this.test.parse(102));
        assertEquals("one hundred and twenty two ", this.test.parse(122));
        assertEquals("one thousand and two ", this.test.parse(1002));
        assertEquals("one thousand and twelve ", this.test.parse(1012));
        assertEquals("one thousand and twenty two ", this.test.parse(1022));
        assertEquals("one thousand two hundred and twenty two ", this.test.parse(1222));
        assertEquals("twelve thousand two hundred and twenty two ", this.test.parse(12222));
        assertEquals("twenty two thousand two hundred and twenty two ", this.test.parse(22222));
        assertEquals("twelve thousand and two ", this.test.parse(12002));
        assertEquals("one hundred thousand five hundred ", this.test.parse(100500));
        assertEquals("twenty thousand five hundred ", this.test.parse(20500));
        assertEquals("one hundred twenty five thousand four hundred and twenty two ", this.test.parse(125422));
        assertEquals("one million ", this.test.parse(1000000));
        assertEquals("one billion ", this.test.parse(1000000000));
    }

    @Test
    public void digitParse() throws Exception {

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