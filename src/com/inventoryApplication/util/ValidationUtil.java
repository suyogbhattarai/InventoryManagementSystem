
package com.inventoryApplication.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+[ A-Za-z]*$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d+[-]*$");
     private static final Pattern LOCATION_PATTERN = Pattern.compile("^[a-zA-Z]+[,]*$");
private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+(\\.\\d+)?$");
      private static final Pattern ID_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern STATUS_PATTERN = Pattern.compile("^(Pending|Completed|On Hold)$");
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");
    
    
    
    
    /**
     * Validates if a string is null or empty.
     *
     * @param value the string to validate
     * @return true if the string is null or empty, otherwise false
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


    public static boolean isValidName(String name) {
        return !isNullOrEmpty(name) && NAME_PATTERN.matcher(name).matches();
    }

    /**
     * Validates if the LMU ID is exactly 7 digits.
     *
     * @param Id the LMU ID to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidId(int Id) {
        return ID_PATTERN.matcher(String.valueOf(Id)).matches();
    }
    
      public static boolean isValidValue(double Value) {
//        return NUMBER_PATTERN.matcher(String.valueOf(Value)).matches();
return NUMBER_PATTERN.matcher(String.valueOf(Value)).matches();
    }

    /**
     * Validates if the program is one of the allowed options.
     *
     * @param status the program to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidStatus(String status) {
        return !isNullOrEmpty(status) && STATUS_PATTERN.matcher(status).matches();
    }

    /**
     * Validates if the contact number starts with 98 and has 10 digits in total.
     *
     * @param contact the contact number to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidContact(String contact) {
        return !isNullOrEmpty(contact) &&  CONTACT_PATTERN.matcher(contact).matches() ;
    }
    

   
}