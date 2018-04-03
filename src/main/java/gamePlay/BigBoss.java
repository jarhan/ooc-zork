package gamePlay;

public class BigBoss extends InteractObj{

    private String name;

    private int hp;

    public BigBoss(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    public String getName(){
            return this.name;
        }

    public void lose(int ap){
            this.hp -= ap;
        }

    @Override
    public String getInfo() {
            return "BigBoss, Name: " + this.name + ", HP: " + this.hp;
        }

    public boolean isDead(){
            return this.hp <= 0;
        }


    public int getHP() {
            return this.hp;
        }

}
