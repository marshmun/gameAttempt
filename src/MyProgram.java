import Charecters.Creature;
import Charecters.Player;

import java.util.Scanner;

public class MyProgram{

    public void run(){
        Scanner readName = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = readName.nextLine();

        Scanner readRole = new Scanner(System.in);
        System.out.print("Choose your role (Warrior, Rogue, Mage): ") ;
        String userRole = readRole.nextLine();
        while (true){
            if(userRole.equalsIgnoreCase("Warrior") || userRole.equalsIgnoreCase("Rogue") || userRole.equalsIgnoreCase("Mage")){
                break;
            }else{
                System.out.println("Choose a valid role");
                readRole = new Scanner(System.in);
                System.out.print("Choose your role ( Warrior, Rogue, Mage): ");
                userRole = readRole.nextLine();
            }
        }
        System.out.println("");
        Player player = new Player(userName, userRole);

        scene(player, "a mansion");
        if(!player.isDead()){
            scence(player, "a rock");
        }
    }
    public String attack(Creature one, Creature Two)
}
