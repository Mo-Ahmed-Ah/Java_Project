package util;

public class Utils {
    /*
     * This function git java.util.Data and return java.sql.Data , Because the preparedStatement.setDate take sql Data not util data.
     * This function create with me not prepackage.
    */
    public static java.sql.Date getSqlDate(java.util.Date utilDate){
        return new java.sql.Date(utilDate.getTime());

    }


//    public static java.sql.Date getUtilDate(java.sql.Date sqlDate){
//        return new java.util.Date(sqlDate.getTime());
//
//    }
}
