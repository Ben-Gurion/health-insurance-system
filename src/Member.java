public class Member {
    String memberID;
    String memberName;
    int memberAge;
    String[] insurancePlan;
    String[] claims;

    // Constructor
    Member(String memberName, int memberAge, String memberID){
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberID = memberID;
    }

}
