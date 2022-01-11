import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email; 
    private String alternateEmail;

    private int defaultPasswordLength = 8;
    private int mailboxCapacity = 500;
    private String companySuffix = "xyzcompany.com";
    private String passwordSet = "ABCDEFGJHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+-!@#$%^&*()_+";


    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(this.defaultPasswordLength);
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + 
        "@" + this.department.toLowerCase() + "." + this.companySuffix;
    }


    private String setDepartment() {
        String[] departments = {"None", "Sales", "Development", "Accounting"};

        System.out.println("Enter the department: ");

        for (int i = 0; i < departments.length; i++) {
            System.out.println(i + " for " + departments[i]);
        }

        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice <= departments.length && depChoice != 0)
            return departments[depChoice];       
        else
            return "";
    }

    private String randomPassword(int length) {
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    public String showInfo() {
        return "NAME: " + this.firstName + " " + this.lastName + "\n" +
        "COMPANY EMAIL: " + this.email + "\n" +
        "MAILBOX CAPACITY: " + this.mailboxCapacity + "mb";

    }

    public void setMailboxCapacity(int capacity) { this.mailboxCapacity = capacity; }

    public void setAlternateEmail(String altEmail) { this.alternateEmail = altEmail; }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return this.password; }

    public String getEmail() { return this.email; }

    public int getMailboxCapacity() { return this.mailboxCapacity; }

}