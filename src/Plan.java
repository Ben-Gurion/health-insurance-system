public class Plan {
    String planID;
    String planName;
    int coverageAmount;
    boolean isFamilyShared;

    Plan(String planID, String planName, int coverageAmount, boolean isFamilyShared){
        this.planID = planID;
        this.planName = planName;
        this.coverageAmount = coverageAmount;
        this.isFamilyShared = isFamilyShared;
    }
}
