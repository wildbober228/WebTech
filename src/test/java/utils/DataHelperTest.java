package utils;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelperTest extends TestCase {

    @Test
    public void testStringToDateGood() throws ParseException {
        //создаем тестовые данные
        String testString = "2020-12-22";
        Date expected  = DataHelper.StringToDate(testString);
        String date = "2020-12-22";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date actual  = format.parse(date);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testStringToDateError() throws ParseException {
        //создаем тестовые данные
        String testString = "202djd";
        Date expected  = DataHelper.StringToDate(testString);
        Assert.assertEquals(expected, null);
    }

    @Test
    public void testParseToIntGood() {
        //создаем тестовые данные
        String testString = "     202";
        int expected = DataHelper.ParseToInt(testString);
        int actual = 202;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testParseToIntError() {
        //создаем тестовые данные
        String testString = "abc";
        int expected = DataHelper.ParseToInt(testString);
        int actual = -1;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testParseToFloatGood() {
        //создаем тестовые данные
        String testString = "     202.0";
        float expected = DataHelper.ParseToFloat(testString);
        float actual = 202.0f;
        Assert.assertEquals(expected, actual, 0);

    }

    @Test
    public void testParseToFloatError() {
        //создаем тестовые данные
        String testString = "abc";
        float expected = DataHelper.ParseToFloat(testString);
        int actual = -1;
        Assert.assertEquals(expected, actual, 0);

    }

    public void testParseToFloat() {

    }
}