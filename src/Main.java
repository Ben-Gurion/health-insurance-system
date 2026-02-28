import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Member> members = new ArrayList<Member>();
    static ArrayList<Dependent> dependents = new ArrayList<Dependent>();

    public static void main(String[] args){
        System.out.println("\n========== Health Insurance Management ==========\n");


        String continueManagement = "";

        do{
            printMenu();

            System.out.print("Enter option: ");

            while(!scanner.hasNextInt()){
                System.out.print("Enter a valid choice: ");
                scanner.next();
            }

            int selection = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer

            switch (selection){
                case 1 -> addMember();
                case 2 -> addDependent();
                case 3 -> System.out.println("3");
                case 4 -> System.out.println("4");
                case 5 -> System.out.println("5");
                case 6 -> viewMembers();
                case 7 -> System.out.println("7");
                case 8 -> System.out.println("8");
                default -> System.out.println("Default");
            }


            System.out.print("Do you want to continue? (Yes/No): ");

            continueManagement = scanner.next().toLowerCase();


        }while(continueManagement.equals("yes") || continueManagement.equals("y"));

        System.out.println("Have a Nice Day!");

        scanner.close();

    }

    static void printMenu(){
        System.out.println("MENU");
        System.out.println("1. Create Member");
        System.out.println("2. Add Dependent");
        System.out.println("3. Create a Plan");
        System.out.println("4. Assign a Plan");
        System.out.println("5. Submit a Claim");
        System.out.println("6. View Members");
        System.out.println("7. View Plans");
        System.out.println("8. Quit");
    }

    static void addMember(){
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int memberAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Insurance member ID: ");
        String memberID = scanner.nextLine();

        Member member = new Member(memberName, memberAge, memberID);
        members.add(member);

        System.out.printf("%s has been added successfully!%n", member.memberName);
    }

    static void viewMembers(){
        System.out.printf("There are a total of %d members%n", members.size() + dependents.size());

        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).memberName);
        }
    }
    static void addDependent(){
        if(members.size() <= 0){
            System.out.println("There are no members yet. Add atleast one Member to proceed.");
        }else{
            System.out.print("Enter main member ID: ");
            String mainMemberID = scanner.nextLine();

            boolean isMainMemberFound = false;
            for (int i = 0; i < members.size(); i++){
                if(mainMemberID.equals( members.get(i).memberID)){
                    isMainMemberFound = true;
                }
            }
            if(!isMainMemberFound){
                System.out.printf("There is no member with ID: %s%n", mainMemberID);
            }else{
                System.out.print("Enter member name: ");
                String memberName = scanner.nextLine();


                System.out.println("Select the relationship: ");
                System.out.println("1. SPOUSE ");
                System.out.println("2. CHILD ");

                while(!scanner.hasNextInt()){
                    System.out.print("Enter a valid choice: ");
                    scanner.next();
                }

                String relationship;

                // replace with switch to handle defaults for non 1 or 2 implementations
                if(scanner.nextInt() == 1){
                    relationship = "SPOUSE";
                }else{
                    relationship = "CHILD";
                }
                scanner.nextLine();


                System.out.print("Enter Age: ");
                int memberAge = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Insurance member ID: ");
                String memberID = scanner.nextLine();

                Dependent dependent = new Dependent(mainMemberID, relationship, memberName, memberAge, memberID);
                dependents.add(dependent);

                System.out.printf("%s has been added successfully!%n", dependent.memberName);
            }
        }

    }
}
