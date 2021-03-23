package utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataHelper {

    public static Date StringToDate(String dob) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date =  formatter.parse(dob);
        return date;
    }

    public static int ParseToInt(String data){
        int result = Integer.parseInt(data.trim());
        return result;
    }

    public static float ParseToFloat(String data){
        float result = Float.parseFloat(data.trim());
        return result;
    }

}
