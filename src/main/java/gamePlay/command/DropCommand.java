package gamePlay.command;

import gamePlay.Player;
import gamePlay.ZorkGame;

public class DropCommand implements Command {
    private Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

    @Override
    public void apply(String s){
        if(s.equals("")){
            System.out.println("Can't drop nothing");
        }
        else {
            try {
                if(player.dropItem(Integer.parseInt(s)))
                    System.out.println("Successfully drop "+s+"'s slot item");
                else {
                    System.out.println("There is no item in "+s+"'s slot.");
                }
            }
            catch (Exception e){
                System.out.println("Invalid item to be dropped");
            }
        }

    }
}
