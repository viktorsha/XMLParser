import java.util.Scanner;

public class Developers {
    private String name, surname, position;
    private String age;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public static Developers enterCredentials()
    {
        Developers developer = new Developers();
        Scanner input;
        String choice;
        System.out.println("Enter id of developer:");
        input = new Scanner(System.in);
        choice = input.nextLine();
        developer.setId(choice);
        System.out.println("Enter name of developer:");
        input = new Scanner(System.in);
        choice = input.nextLine();
        developer.setName(choice);
        System.out.println("Enter surname of developer:");
        input = new Scanner(System.in);
        choice = input.nextLine();
        developer.setSurname(choice);
        System.out.println("Enter age of developer:");
        input = new Scanner(System.in);
        choice = input.nextLine();
        developer.setAge(choice);
        System.out.println("Enter position of developer:");
        input = new Scanner(System.in);
        choice = input.nextLine();
        developer.setPosition(choice);
        return developer;
    }

}
