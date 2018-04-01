package gamePlay.command;

import gamePlay.Player;

public interface Command {
    void apply(String s);
    void applyPlayer(Player p);
}