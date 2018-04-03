package gamePlay.command;

import gamePlay.Player;
import gamePlay.ZorkGame;

public class PickUpCommand implements Command {
    private Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

    @Override
    public void apply(String s) {
        if(s.contains("key")){
            if(player.collect(s,-1) == 0){
                System.out.println("Successfully collect " + s +" to quest bag");
            }
            else {
                System.out.println("This room doesn't contain "+s);
            }
        }
        else {
            int emptySlot = player.itemEmptySlot();
            if (emptySlot > -1) {
                if (s.equals("healingpotion")) {
                    if (player.collect("healing potion", emptySlot) == 1) {
                        System.out.println("Healing potion successfully collected. It's stored in slot " + emptySlot);
                    } else {
                        System.out.println("This room doesn't have healing potion");
                    }
                }
                else {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Your item bag is full");
            }
        }
    }
}
