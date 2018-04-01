package gamePlay.command;

import gamePlay.Player;
import gamePlay.Room;
//import gamePlay.ZorkGame;

public class MoveCommand implements Command{
    private Player player;

//    public MoveCommand(){
////        this.player = player;
//    }
    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

    @Override
    public void apply(String direction) {

        if(player.isBusy){
            System.out.println("Can't move. You are in the battle");
        }
        else {
            int status = player.move(direction);
            if (status == -1) {
                System.out.println("You can't move that way!");
            }
            else if(status==-2){
                System.out.println("You have to defeat the guardian first");
            }
            else {
                System.out.println("Moving " + direction + "..........");
                Command src = new SearchRoomCommand();
                System.out.println("test1");
                src.applyPlayer(player);
                System.out.println("test2");
                src.apply(direction);
                System.out.println("After apply in move cmd");
            }
        }

    }
}
