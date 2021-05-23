package Registration;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.StringJoiner;

public class Registeration {
    String name;
    String userName;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        Scanner sc = new Scanner(System.in);
        try {
            String[] users = Files.readAllLines(Paths.get("C:\\Users\\Aram\\Desktop\\java-home7\\test.txt")).toArray(new String[0]);
            while (checkUserName(users,userName)) {
                System.out.print("userName already exists : ");
                userName = sc.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userName = userName;
    }

    public boolean checkUserName(String[] users,String userName) {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].split(",")[0]+" "+userName);
            if (users[i].split(",")[0].equals(userName))
                return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Scanner sc = new Scanner(System.in);
        while (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            System.out.print("Email was invalid please try again : ");
            email = sc.next();
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Scanner sc = new Scanner(System.in);
        while (!checkPassword(password)) {
            System.out.print("Password was invalid please try again : ");
            password = sc.next();
        }
        this.password = PasswordCrypt.crypt(password);
    }

    private boolean checkPassword(String pass) {
        int num = 0, letters = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) >= 65 && pass.charAt(i) <= 90)
                letters++;
            if (pass.charAt(i) >= 48 && pass.charAt(i) <= 57)
                num++;
        }
        if (num >= 3 && letters >= 2 && pass.length() > 8)
            return true;
        return false;
    }

    public Registeration() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name Surname : ");
        setName(sc.nextLine());
        System.out.print("UserName : ");
        setUserName(sc.next());
        System.out.print("Email : ");
        setEmail(sc.next());
        System.out.print("Password : ");
        setPassword(sc.next());

        StringJoiner sj = new StringJoiner(",");
        sj.add(this.userName).add(this.name).add(this.email).add(this.password).add("\n");
        try {
            Files.write(Paths.get("C:\\Users\\Aram\\Desktop\\java-home7\\test.txt"), sj.toString().getBytes(), StandardOpenOption.APPEND);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
