package com.sergioarboleda.rent_car.services;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Utilities {

    /**
     *
     * @param pattern
     * @param candidate
     * @return
     */
    public static boolean validateRegex(String pattern, String candidate){
        Pattern pattern_obj = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern_obj.matcher(candidate);
        return matcher.find();
    }

    /**
     *
     * @param plate
     * @return
     */
    public static boolean validatePlate(String plate){
        String platePattern = "[A-Z]{3}[0-9]{3}";
        return validateRegex(platePattern, plate);
    }

    /**
     *
     * @param email
     * @return
     */
    public static boolean validateEmail(String email){
       String emailPattern = "[a-z][a-z0-9_]*@(gmail.com|outlook.com)";
       return validateRegex(emailPattern, email);
    }
}
