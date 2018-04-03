package gamePlay.command;

import gamePlay.Player;
import gamePlay.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class UseCommand implements Command {
    private Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

    @Override
    public void apply(String s) {
        if(s.equals("healingpotion")) {
            int status = player.useHealPotion();
            if (status == -2) {
                System.out.println("You don't have healing potion!");
            } else if (status == 0) {
                System.out.println("Your HP is already full.");
            } else {
                System.out.println("Successfully heal, your current HP is: " + player.checkHP());
            }
        }
        else {
            System.out.println("Invalid input");
        }
    }


}
