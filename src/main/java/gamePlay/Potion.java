package gamePlay;

public class Potion extends InteractObj{
    private int healingAmount = 0;

    private String name = "";

    public Potion(String s){
        if (s.equals("heal")) {
            this.healingAmount = 10;
            this.name = "healing potion";
        }
        else if (s.equals("hint")) {
            this.name = "hangman hint potion";
        }
        else if (s.equals("jump")) {
            this.name = "jump 1 step upper potion";
        }
    }

    @Override
    public String getInfo() {
        return this.name+", can heal: "+this.healingAmount;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
