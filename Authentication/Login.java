package Authentication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Login {
    public Login() {
        boolean bo = true;
        while (bo) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter userName : ");
            String userName = sc.next();

            System.out.print("Enter Password : ");
            String pass = sc.next();

            bo = check(userName, pass);
        }
    }

    private boolean check(String name, String password) {
        try {
            String[] users = Files.readAllLines(Paths.get("C:\\Users\\Aram\\Desktop\\java-home7\\test.txt")).toArray(new String[0]);

            for (int i = 0; i < users.length; i++) {
                if (users[i].split(",")[0].equals(name)) {

                    if (users[i].split(",")[3].equals(PasswordCrypt.crypt(password))) {
                        System.out.println("Logged in");
                        return false;
                    }

                    System.out.println("Something goes wrong try again");
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;

    }
}
