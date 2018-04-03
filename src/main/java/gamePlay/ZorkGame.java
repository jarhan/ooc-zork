package gamePlay;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import gamePlay.command.*;

public class ZorkGame {
    private static Player player;

    final static Map<String, Command> commands = new HashMap<String, Command>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("move", new MoveCommand());
            put("info", new SearchRoomCommand());
            put("quit", new ExitCommand());
            put("attack", new AttackCommand());
            put("ans", new AnswerCommand());
//            put();


//            put("flee", new FleeCommand());
//
//            put("attack", new AttackCommand());
//            put("rock",new RockCommand());
//            put("paper",new PaperCommand());
//            put("scissors",new ScissorCommand());
//
//
//            put("use", new UsePotionCommand());
//            put("position",new PositionCommand());
//            put("take", new PickItemCommand());
//            put("drop",new DropItemCommand());
//            put("checkbag",new CheckBagCommand());
//            put("checkhp",new CheckHPCommand());
//            put("info",new LookAroundCommand());
//            put("quit", new ExitCommand());
//            put("help", new HelpCommand());
//            put("combine", new CombineKeyCommand());

//                put("useQuestItem", new UseItemCommand());


        }
    };

    public static Command getCommand(String cmd) {
        return commands.get(cmd);
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Welcome to Zork Game ❤️");
        System.out.println("In this game, you have to pass all 3 floors to clear the game.");
        System.out.println("Now, you are in the first floor. GOOD LUCK HAVE FUN \uD83C\uDF40");
        System.out.print("Create your name within one word: ");
        String[] playerName = scanner.nextLine().split("\\s+");
        player = new Player(playerName[0]);
        System.out.println("OK, I got it. Your name is " + player.getName() + " and now your HP is " + player.getHp() +
                            " and your Attack power(AP) is " + player.getAp());

        while (!quit) {
            System.out.print("You: ");
            String[] commandLine = scanner.nextLine().split("\\s+");

            Command command = null;
            try {
                command = ZorkGame.getCommand(commandLine[0]);
                command.applyPlayer(player);
            }
            catch (ArrayIndexOutOfBoundsException ai) {
            }
            if (null == command) {
                System.out.println("Unknown command try 'help'.");
            }
            else {
//                System.out.println(commandLine.length);
                if (commandLine.length < 2) {
                    command.apply("");
                }
                else {
                    command.apply(commandLine[1]);
                }
            }
        }

    }
}