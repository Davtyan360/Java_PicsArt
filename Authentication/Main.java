package Authentication;

import java.util.Scanner;

public class Main implements PasswordCrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Login or Reg : ");
        String z = sc.next();
        while(z!="exit"){
            if(z=="login")new Login();
            if(z=="reg")new Registeration();
            z = sc.next();
        }
    }
}
