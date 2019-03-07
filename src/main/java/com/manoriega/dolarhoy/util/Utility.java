package com.manoriega.dolarhoy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utility {

    public static String dateformat(String fecha) {
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");
        String d1 = df2.format(fecha);
        return d1;
    }
}
