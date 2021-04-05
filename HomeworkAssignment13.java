import java.util.Scanner;

class HomeworkAssignment13 {
    public static void main (String[] args) {
        LoginSystem ls = new LoginSystem(4, 10);
        ls.run();
    }
}

class LoginSystem {
    // 2-dimensional String array holding Lab#s and corresponding Computer#s
    String[][]  labs;

    /**
     * CLASS CONSTRUCTOR:
     * This constructor takes in two parameters - number of labs
     * labNum and number of computers compNum. It creates an array of arrays with length
     * labNum, and subarrays with lengths = compNum. After, it assigns values of all
     * elements in subarrays to "empty".
     * PARAMETERS:
     * int labNum, int compNum
     **/
    LoginSystem(int labNum, int compNum) {
        labs = new String [labNum][compNum];
        for (int i = 0; i < labNum; i++){
            for (int a = 0; a < compNum; a++){
                labs[i][a] = "empty";
            }
        }
    }

    /**
     * MEMBER FUNCTION NAME:
     * void run()
     * PURPOSE:
     * The function shows status and menu for the console application.
     * Serves as user interface
     * PARAMETER:
     * -
     * RETURN VALUE:
     * void
     **/
    void run() {
        showStatus();
        showMenu();
    }

    /**
     * MEMBER FUNCTION NAME:
     * showStatus()
     * PURPOSE:
     * The function shows the status of the computers in labs.
     * PARAMETER:
     * -
     * RETURN VALUE:
     * void
     **/
    void showStatus() {
        int compCount;
        String result = "";
        System.out.println("STATUS");
        System.out.println("Lab#" + '\t' + "Computers");
        for (int i = 0; i < labs.length; i++){
            result = result + (i +1) + '\t';
            for (int a = 0; a < labs[i].length; a++){
                result = result + '\t' + (a + 1) + ": " + labs[i][a];
            }
            System.out.println(result);
            result = "";
        }
    }
    /**
     * MEMBER FUNCTION NAME:
     * showMenu()
     * PURPOSE:
     * The function shows menu for the application, scans users' input and starts
     * chosen function based on it.
     * PARAMETER:
     * -
     * RETURN VALUE:
     * void
     **/
    void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SELECTION MENU");
        System.out.println("1. LOGIN");
        System.out.println("2. LOGOUT");
        System.out.println("3. SEARCH");
        System.out.println("4. QUIT");
        String menu = scanner.nextLine();
            if (menu.equals("1")) {
                login();
                run();
            } else if (menu.equals("2")) {
                logout();
                run();
            } else if (menu.equals("3")) {
                search();
                run();
            } else if (menu.equals("4")) {
                System.exit(0);
            } else {
                System.out.println("Wrong input. Please enter options 1-4.");
                run();
            }
    }
    /**
     * MEMBER FUNCTION NAME:
     * login()
     * PURPOSE:
     * The function allows user to log in to computers in labs. It checks if username
     * is valid, if the user already logged in and if the chosen computer is already
     * being used by another user.
     * PARAMETER:
     * -
     * RETURN VALUE:
     * void
     **/
    void login() {
        String userID;
        int labNum;
        int compNum;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your 5-character ID to login: ");
            userID = scanner.nextLine();
        } while(userID.length() != 5 || userID.equals("empty"));
        do {
            System.out.println("Enter the Lab number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: That's not a number!");
                scanner.next();
                System.out.println("Enter the Lab number: ");
            }
            labNum = scanner.nextInt();
        } while(labNum > labs.length || labNum < 1);
        do {
            System.out.println("Enter the Computer number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: That's not a number!");
                scanner.next();
                System.out.println("Enter the Computer number: ");
            }
            compNum = scanner.nextInt();
        } while(compNum > labs[labNum-1].length || compNum < 1);
        for (int i = 0; i < labs.length; i++){
            for (int a = 0; a < labs[i].length; a++){
                if (labs[i][a].equals(userID)){
                    System.out.println("User " + userID + " is in Lab #" + (i + 1) + " at Computer #" + (a + 1));
                    run();
                }
            }
        }
        if (!labs[labNum-1][compNum-1].equals("empty")){
            System.out.println("ERROR, user " + labs[labNum-1][compNum-1] +" is already logged into that station");
            login();
        } else {
            labs[labNum-1][compNum-1] = userID;
        }
        showStatus();
        showMenu();
    }
    /**
     * MEMBER FUNCTION NAME:
     * logout()
     * PURPOSE:
     * The function allows user to log out from the login system. It checks if username
     * is valid, if the user logged in and logs user out if everything correct.
     * PARAMETER:
     * -
     * RETURN VALUE:
     * void
     **/
    void logout() {
        Scanner scanner = new Scanner(System.in);
        String userID;
        String result = "That user is not logged in.";
        do {
            System.out.println("Enter your 5-character ID to log out: ");
            userID = scanner.nextLine();
        } while(userID.length() != 5 || userID.equals("empty"));
        for (int i = 0; i < labs.length; i++){
            for (int a = 0; a < labs[i].length; a++){
                if (labs[i][a].equals(userID)){
                    labs[i][a] = "empty";
                    result = "User " + userID + "  successfully logged out";
                }
            }
        }
        System.out.println(result);
        showStatus();
        showMenu();
    }
    /**
     * MEMBER FUNCTION NAME:
     * search()
     * PURPOSE:
     * The function shows the number of the lab and the computer where the
     * user is logged in. If user is not - message is displayed.
     * PARAMETER:
     * -
     * RETURN VALUE:
     * void
     **/
    void search() {
        Scanner scanner = new Scanner(System.in);
        String userID;
        String result = "That user is not logged in.";
        do {
            System.out.println("Enter a 5-character ID to search: ");
            userID = scanner.nextLine();
        } while(userID.length() != 5 || userID.equals("empty"));
        for (int i = 0; i < labs.length; i++){
            for (int a = 0; a < labs[i].length; a++){
                if (labs[i][a].equals(userID)){
                    result = "User " + userID + "  is in Lab #" + (i+1) + " at Computer #" + (a+1);
                }
            }
        }
        System.out.println(result);
        showStatus();
        showMenu();
    }
}