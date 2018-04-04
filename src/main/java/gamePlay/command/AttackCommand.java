package gamePlay.command;

import gamePlay.Player;
import gamePlay.ZorkGame;

public class AttackCommand implements Command {
    private Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

    @Override
    public void apply(String s) {
        System.out.println(player.isBusy);
        if(player.validAttack()){
            System.out.println("Engage in fight");
            player.fight();
        }
        else {
            System.out.println("There is no Boss in this room.");
        }

    }


}
