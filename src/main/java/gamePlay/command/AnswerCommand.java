package gamePlay.command;

import gamePlay.Player;
import gamePlay.ZorkGame;

public class AnswerCommand implements Command {
    private Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

    @Override
    public void apply(String ans) {
        int result = player.attackWith(ans);
        if(result == -2){
            System.out.println("You are not in the battle");
        }
        else if(result==1){
            System.out.println("You win. Your enemy health is "+player.getCurrentRoom().getBoss().getHP());
        }
        else if(result==4){
            System.out.println("You win. Your enemy is now dead.");
        }
        else {
            System.out.println("You lose. Your health is "+player.checkHP());
            if(player.isDead()){
                System.out.println("Sorry, you died");
                new ExitCommand().apply("");
            }
        }
        if(player.getFloor()==1 && player.canGoNextFloor()){
            player.goNextFloor(1);
            System.out.println("Congratulation, the final boss of first floor is dead.");
            System.out.println("You are now proceeding to the second floor");
            Command src = new SearchRoomCommand();
            src.applyPlayer(player);
            src.apply("");
        }
        else if(player.getFloor()==2 && player.canGoNextFloor()){
            player.goNextFloor(2);
            System.out.println("Congratulation, the final boss of first floor is dead.");
            System.out.println("You are now proceeding to the second floor");
            Command src = new SearchRoomCommand();
            src.applyPlayer(player);
            src.apply("");
        }
        else if(player.getFloor()==3 && player.canGoNextFloor()){
            System.out.println("You've done it. Congratulation on your escapes");
            new ExitCommand().apply("");
        }
    }
}
