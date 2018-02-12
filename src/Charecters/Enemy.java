package Charecters;

public class Enemy extends Creature {

    public Enemy(int leveled){
        super("Filler", "Filler");
        this.level =1;
        this.setName(randomName());
        this.setRole(randomRole());

        rollStats();
        if(leveled > 1){
            for(int i=1; i<leveled; i++){
                levelUp();
            }
        }
        this.curHp = maxHp;
    }
    public String randomName(){
        String[] names={"Hasgoth", "Dameen", "kil'jaden"};
        int index =(int)(Math.random() * names.length);

        return names [index];

    }
    public String randomRole(){
        String[] roles = {"Orc", "Demon", "Dragon"};
        int index =(int)(Math.random() * roles.length);

        return roles[index];
    }
    public void rollStats(){
        int hp = 0;
        int att =0;
        switch(roleToNumber()){
            case 1: hp = 16; att = 10; break;
            case 2: hp = 13; att = 13; break;
            case 3: hp = 12; att = 14; break;
        }
        maxHp = (roll(6) + hp);
        maxAtt =(roll(6) + att);
        minAtt =(maxAtt - 3);
    }

    private int roll(int sides){
        int aRoll = (int)(Math.random() * sides +1);
        return aRoll;
    }

    private int roleToNumber(){
        if(role.equalsIgnoreCase("Orc")){
            return 1;
        }else if(role.equalsIgnoreCase("Demon")){
            return 2;
        }else if(role.equalsIgnoreCase("Dragon")){
            return 3;
        }else{
            return 0;
        }
    }
    public void levelUp(){
        level++;
        int hp = 0;
        int att = 0;
        switch(roleToNumber()){
            case 1: hp = 24; att = 14; break;
            case 2: hp = 19; att = 19; break;
            case 3: hp = 16; att = 22; break;
        }
        maxHp += (hp * Math.random()/2 +.5);
        maxAtt += (att * Math.random()/2 +.5);
        minAtt = maxAtt - 3;
        this.curHp = maxHp;
    }
}
