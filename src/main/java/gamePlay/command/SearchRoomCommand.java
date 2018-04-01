package gamePlay.command;

import gamePlay.Player;
import gamePlay.Room;

public class SearchRoomCommand implements Command{
    Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

//    public SearchRoomCommand(Player player){
//        this.player = player;
//    }

    @Override
    public void apply(String s) {
        Room room = player.getCurrentRoom();
        System.out.println(room.getInfo());
    }
}
