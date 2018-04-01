package gamePlay;

public class Potion extends InteractObj{
    private int healingAmount = 0;

    private String name = "";
    private String description = "";

    public Potion(String s){
        if (s.equals("heal")) {
            this.healingAmount = 10;
            this.name = "healing potion";
            this.description = "this potion can heal you 10 hp";
        }
        else if (s.equals("hint")) {
            this.name = "hangman hint potion";
            this.description = "this potion can give you one character in the hangman game";
        }
        else if (s.equals("jump")) {
            this.name = "jump 1 step upper potion";
            this.description = "this potion can teleport you one step upper in the boss fight";
        }
    }

    @Override
    public String getInfo() {
        return this.name+", " + this.description;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
