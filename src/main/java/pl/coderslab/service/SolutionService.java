package pl.coderslab.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolutionService {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Date dateConversion(String possibleDate) {
        try {
            if (possibleDate != null) {
                Date date = dateFormat.parse(possibleDate);
                return date;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
