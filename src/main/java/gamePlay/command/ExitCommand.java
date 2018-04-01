package gamePlay.command;

import gamePlay.Player;

public class ExitCommand implements Command{
    Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = null;
    }

    @Override
    public void apply(String s) {
        System.out.println("Quitting game");
        System.exit(0);
    }
}
