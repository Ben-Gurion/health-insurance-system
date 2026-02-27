public class Dependent extends Member{
    String mainMemberID;
    String relationship;

    Dependent(String mainMemberID, String relationship, String memberName, int memberAge, String memberID){
        super(memberName, memberAge, memberID);

        this.mainMemberID = mainMemberID;
        this.relationship = relationship;
    }
}
