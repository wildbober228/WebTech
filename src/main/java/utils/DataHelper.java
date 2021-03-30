package utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataHelper {

    public static Date StringToDate(String dob) throws ParseException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dob);
            return date;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    public static int ParseToInt(String data){
        try {
            int result = Integer.parseInt(data.trim());
            return result;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return -1;
    }

    public static float ParseToFloat(String data){
        try {
            float result = Float.parseFloat(data.trim());
            return result;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return -1;
    }

}
