package database;



import model.FamilyNumbers;

import java.util.List;

public interface FemailNumbersDB {

    void addingMail(int mailnumber , int id );
    void addingFemail(int femailnumbers , int id );

    void updateMail(int newmailnumbers , int id );
    void updateFemail(int newfemailnumbers , int id );

    int getMailNumbers(int id);
    int getFemailNumbers(int id);

    FamilyNumbers getBoth(int id);
}
