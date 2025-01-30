package org.kherko.util;

public class SpecialFunctions {

    public static java.sql.Date convertFromUtilDateToSqlDate(java.util.Date utilDate){
        return new java.sql.Date(utilDate.getTime());
    }

    public static java.util.Date convertFromSqlDateToUtilDate(java.sql.Date sqlDate) {
        return new java.util.Date(sqlDate.getTime());
    }

}
