package com.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CsvUtil {

    private static final SimpleDateFormat IN_DATE = new SimpleDateFormat("yyyyMMdd");

    
    public static Date parseObsDate(String datetimeUtc) {
        try {
            if (datetimeUtc == null) return null;

            datetimeUtc = datetimeUtc.trim();
            if (datetimeUtc.isEmpty()) return null;


            String ymd = datetimeUtc.split("-", 2)[0]; 
            java.util.Date parsed = IN_DATE.parse(ymd);
            return new Date(parsed.getTime());
        } catch (Exception e) {
            return null; 
        }
    }

    public static String cleanString(String s) {
        if (s == null) return null;
        s = s.trim();
        return s.isEmpty() ? null : s;
    }

    public static Double cleanDouble(String v) {
        try {
            if (v == null) return null;
            v = v.trim();
            if (v.isEmpty()) return null;

            
            if (v.equalsIgnoreCase("N/A")) return null;
            if (v.equalsIgnoreCase("NA")) return null;
            if (v.equalsIgnoreCase("NULL")) return null;
            if (v.equalsIgnoreCase("NONE")) return null;
            if (v.equalsIgnoreCase("M")) return null;
            if (v.equals("-")) return null;
            if (v.equals("--")) return null;
            if (v.equals("-9999")) return null;

            
            v = v.replace(",", "");

            return Double.parseDouble(v);
        } catch (Exception e) {
            return null; 
        }
    }
}