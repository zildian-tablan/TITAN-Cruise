
package com.mycompany.titanproj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TitanCInfo {
    private static final Map<String, Object[][]> cruiseDetails = new HashMap<>();
    public static String[] cruiseNames = {"Celestyal Olympia", "Norwegian Encore" , "Sapphire Princess","Anthem of the Seas","Superstar Aquarius"};
    public static String[] ports = {"Manila(PHMNL)", "Cebu(PHCEB)", "Subic Bay(PHSFS)","Unavailable.","Unavailable."};
    public static String[] departureDates = {"December 1, 2023", "December 12, 2023", "December 8, 2023","",""};
    public static String[][] arrivalDates = { {"December 5, 2023", "December 6, 2023", "December 10, 2023"},
                                              {"December 19, 2023", "December 22, 2023", "December 29, 2023"},
                                              {"December 19, 2023", "December 23, 2023", "December 29, 2023"},
                                              {""},
                                               {""}
                                              
    };
    public static String[][] destinations  = {
            {"South Korea(KRKAN)","Japan(JPOSA)", "Singpore(SGSIN)"},
            {"Malaysia(MYPGU)","Thailand(THLCH)", "Australia(AUMEL)"},
            {"Indonesia(IDSUB)", "India(INKAT)", "New Zealand(NZAKL)"},
              {""},
              {""}
            
    };

   // public static int[] days = {5, 4, 6};

    static {
        for (int i = 0; i < cruiseNames.length; i++) {
            cruiseDetails.put(cruiseNames[i], generateData(i));
        }
    }

    private static Object[][] generateData(int cruiseIndex) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        Object[][] data = new Object[destinations[cruiseIndex].length][4];
        try {
            for (int i = 0; i < destinations[cruiseIndex].length; i++) {
                data[i][0] = ports[cruiseIndex];
                data[i][1] = destinations[cruiseIndex][i];
                data[i][2] = departureDates[cruiseIndex];
                data[i][3] = arrivalDates[cruiseIndex][i];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void updateTitanCInfo(String cruiseName, Object[][] newData) {
        cruiseDetails.put(cruiseName, newData);
    }

    public static Object[][] getTitanCInfo(String cruiseName) {
        return cruiseDetails.get(cruiseName);
    }
}
