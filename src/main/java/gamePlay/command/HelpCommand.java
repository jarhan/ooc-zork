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
        System.out.println("info            check what does this room contain. And the direction you can move to another room");
        System.out.println("move {dir}      moving to the dir direction where dir can be 'w','a','s','d'");
        System.out.println("take {item}     to pick up items, potion includes 'healingpotion',can store atmost 6 items, \n" +
                           "                but in the game there are only 3 potion \uD83D\uDE02");
        System.out.println("use {potion}    use potion. potion includes 'healingpotion'");
        System.out.println("attack          engage in battle if there is the boss in the room");
        System.out.println("ans {xxx}       find the difference character in the board the Boss in each room gives eg. A8, H12, or J4");
        System.out.println("drop {i}        drop item in the i'th slot");
//        System.out.println("position => check the current postion of the character");
//        System.out.println("checkbag => check all item inside your bag");
//        System.out.println("checkhp => check current HP of the player");
        System.out.println("quit            quit the game \uD83D\uDE22");

        System.out.println("\n=====================================================================================================================\n");

        System.out.println("When you start attack Boss in the room, you cannot go to other rooms unless it's dead");
        System.out.println("If you win, enemy lose HP depends on your AP. If you lose, you lose HP randomly depends on Boss.");
        System.out.println("Healing potion can heal a total of 10 HP per potion and heal maximum of your MAX HP at that time");
        System.out.println("You can stored only upto 6 potions");

    }

}
