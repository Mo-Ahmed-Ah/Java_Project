package builders;

import model.FamilyNumbers;

public class FamilyNumbersBulder {
    private int statusId;
    private int mailNumbers;
    private int femailNumbers;

    public FamilyNumbersBulder statusId(int statusId){
        this.statusId = statusId;
        return this;
    }

    public FamilyNumbersBulder mailNumbers(int mailNumbers){
        this.mailNumbers = mailNumbers;
        return this;
    }

    public FamilyNumbersBulder femailNumbers(int femailNumbers){
        this.femailNumbers = femailNumbers;
        return this;
    }

    public FamilyNumbers build() {
        return new FamilyNumbers(
                statusId,
                mailNumbers,
                femailNumbers
        );
    }
}
