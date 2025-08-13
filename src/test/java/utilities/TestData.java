package utilities;

import static utilities.LoadProperties.userData;

public class TestData {
    public static final String VALID_NAME = userData.getProperty("VALID_NAME");
    public static final String VALID_PASSWORD = userData.getProperty("VALID_PASSWORD");
    public static final String EXISTING_EMAIL = userData.getProperty("EXISTING_EMAIL");
    public static final String UNIQUE_EMAIL = System.currentTimeMillis() + userData.getProperty("UNIQUE_EMAIL");
    public static final String EMAIL = System.currentTimeMillis() + System.currentTimeMillis() + userData.getProperty("UNIQUE_EMAIL");

    public static final int BIRTH_DAY = Integer.parseInt(userData.getProperty("BIRTH_DAY"));
    public static final String BIRTH_MONTH = userData.getProperty("BIRTH_MONTH");
    public static final int BIRTH_YEAR = Integer.parseInt(userData.getProperty("BIRTH_YEAR"));

    public static final String FIRST_NAME = userData.getProperty("FIRST_NAME");
    public static final String LAST_NAME = userData.getProperty("LAST_NAME");
    public static final String COMPANY = userData.getProperty("COMPANY");
    public static final String FIRST_ADDRESS = userData.getProperty("FIRST_ADDRESS");
    public static final String SECOND_ADDRESS = userData.getProperty("SECOND_ADDRESS");
    public static final String COUNTRY = userData.getProperty("COUNTRY");
    public static final String STATE = userData.getProperty("STATE");
    public static final String CITY = userData.getProperty("CITY");
    public static final int ZIP_CODE = Integer.parseInt(userData.getProperty("ZIP_CODE"));
    public static final String MOBILE = userData.getProperty("MOBILE");

    public static final String Wrong_EMAIL = userData.getProperty("Wrong_EMAIL");
    public static final String Wrong_PASSWORD = userData.getProperty("Wrong_PASSWORD");

    public static final String PRODUCT_NAME = userData.getProperty("PRODUCT_NAME");
    public static final int PRODUCT_QUANTITY = Integer.parseInt(userData.getProperty("PRODUCT_QUANTITY"));

    public static final String NUMBER = userData.getProperty("NUMBER");
    public static final String CVV = userData.getProperty("CVV");
    public static final String EXPIRY_MONTH = userData.getProperty("EXPIRY_MONTH");
    public static final String EXPIRY_YEAR = userData.getProperty("EXPIRY_YEAR");


}