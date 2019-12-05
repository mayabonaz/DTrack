package android.rgu.dtrack.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReadingUtils {

    // function takes time as input, formats and returns a string
    public static String dateFromLong(long time) {
        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy 'at' hh:mm aaa", Locale.UK);
        return format.format(new Date(time));
    }
}