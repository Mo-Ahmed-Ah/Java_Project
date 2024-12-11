package database;



import model.FamilyNumbers;

import java.util.List;

public interface FemailNumbersDB {

    void addingMailAndFemail(int mailnumber ,int femailnumber ,int id );

    void updateMail(int newmailnumbers , int id );
    void updateFemail(int newfemailnumbers , int id );

    int getMailNumbers(int id);
    int getFemailNumbers(int id);

    FamilyNumbers getBoth(int id);
}
