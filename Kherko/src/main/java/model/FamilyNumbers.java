package model;


import builders.FamilyNumbersBulder;

public class FamilyNumbers {
    private int statusId;
    private int mailNumbers;
    private int femailNumbers;

    public FamilyNumbers(int statusId , int mailNumbers , int femailNumbers){
        this.statusId = statusId ;
        this.mailNumbers = mailNumbers ;
        this.femailNumbers = femailNumbers ;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getMailNumbers() {
        return mailNumbers;
    }

    public void setMailNumbers(int mailNumbers) {
        this.mailNumbers = mailNumbers;
    }

    public int getFemailNumbers() {
        return femailNumbers;
    }

    public void setFemailNumbers(int femailNumbers) {
        this.femailNumbers = femailNumbers;
    }

    @Override
    public String toString() {
        return "FamilyNumbers{" +
                "statusId=" + statusId +
                ", mailNumbers=" + mailNumbers +
                ", femailNumbers=" + femailNumbers +
                '}';
    }

    public static FamilyNumbersBulder builder(){return new FamilyNumbersBulder();}
}
