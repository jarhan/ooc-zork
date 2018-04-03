package gamePlay.command;

import gamePlay.Player;

public class HelpCommand implements Command {
    private Player player;

    @Override
    public void applyPlayer(Player player){
        this.player = player;
    }

    @Override
    public void apply(String direction) {

        System.out.println("Here are the lists of commands you can use:");
        System.out.println("info => check what does this room contain.");
        System.out.println("go {dir} => moving to the dir direction where dir can be 'north','east','west','south'");
        System.out.println("take {item} => to pick up items, potion includes 'healingpotion','debuffpotion',can store atmost 6 items, \n" +
                "                          you can also pick 'key1' and 'key2' in the second floor, it will be stored separately in quest bags");
        System.out.println("use {potion} => use potion. potion includes 'healingpotion','debuffpotion'");
        System.out.println("attack => engage in battle if there is the guardian in the room");
        System.out.println("rock => play rock, can be used when in battle");
        System.out.println("paper => play paper, can be used when in battle");
        System.out.println("scissors => play scissors, can be used when in battle");
        System.out.println("drop {i} => drop item in the i'th slot");
        System.out.println("flee => to escape from the current room the the last visited one");
        System.out.println("position => check the current postion of the character");
        System.out.println("checkbag => check all item inside your bag");
        System.out.println("checkhp => check current HP of the player");
        System.out.println("combine => combine quest key to move to final boss room");
        System.out.println("quit => quit the game :(");

        System.out.println("\n=====================================================================================================================\n");

        System.out.println("When there is a Guardian in the room, you cannot go to other rooms unless it's dead");
        System.out.println("If you decide to flee, you will lose 5 HP.");
        System.out.println("If you win, enemy lose 10 HP. If you lose, you lose 5 hp.");
        System.out.println("Healing potion can heal a total of 10 HP per potion");
        System.out.println("Debuff potion will make Guardian impossible to play rock for 1 round");
        System.out.println("You can stored only upto 6 potions");

    }

}
