import Charecters.Creature;
import Charecters.Enemy;
import Charecters.Player;
import com.sun.org.apache.xpath.internal.SourceTree;

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
            scene(player, "a rock");
        }
    }
    public String attack(Creature one, Creature two){
        int a = one.attack(two);
        return one.getName() + " hit " + two.getName() + " for " + a + " damage.";
    }

    public void battle(Player one, Creature two){
        System.out.println(one);
        System.out.println(two);

        while(true){
            Scanner readChoice = new Scanner(System.in);
            System.out.print("\nWhat do you want to do(Attack, Run, Status, Use Potion): ");
            String userChoice = readChoice.nextLine();
            while (true) {
                if (!userChoice.equalsIgnoreCase("Status") && !userChoice.equalsIgnoreCase("Run") && !userChoice.equalsIgnoreCase("Attack") && !userChoice.equalsIgnoreCase("Use Potion")){
                    System.out.println("Choose a valid choice");
                    readChoice = new Scanner(System.in);
                    System.out.print("\nWhat do you want to do (Attack, Run, Status, Use Potion): ");
                    userChoice = readChoice.nextLine();
            }else{
                    break;
                }
        }
        if(userChoice.equalsIgnoreCase("Status")){
            System.out.println(one.status());

            continue;
        }

        if(userChoice.equalsIgnoreCase("Run")){
            int run =(int)(Math.random() * 100 + 1);
            if(run >= 50){
                System.out.println("You successfully run.");
                break;
            }else{
                System.out.println("Your enemy wont let you run.");

            }

        }else if(userChoice.equalsIgnoreCase("Attack")){
            System.out.println(attack(one, two));
            System.out.println(two.status());

            }
            if(!two.isDead()){
                System.out.println(attack(two, one));
                System.out.println(one.status());
                if(one.isDead()){
                    System.out.println("You died!");
                    break;
                }
            }else{
                System.out.println("You killed " + two.getName() + "\n");
                System.out.println("you gained " + one.gainXp(two) + " exp");
                if(one.checkXp()){
                    System.out.println("You leveled up, your health is restored!");
                    System.out.println("You have " + one.getXp() + " exp");
                }else{
                    System.out.println("You have " + one.getXp() + " exp");
                }
                System.out.println(one + "\n");
                break;
            }
        }
    }
    public void scene(Player one, String description){
        System.out.println(one.getName() + " arrives at " + description);

        int x =(int)(Math.random()* 3 + 1);

        for(int i =0; i < x; i++){
            if(one.isDead()){
                break;
            }
            Enemy randEnemy = new Enemy(one.getLevel());
            System.out.println("\nYou encounter " + randEnemy.getName() + " the " + randEnemy.getRole());
            battle(one,randEnemy);
        }
    }
}
