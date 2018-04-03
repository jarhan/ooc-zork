package gamePlay;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BossFight {
//    private int game_n = 0;
//
//    public void getGame(int floor) {
//        ArrayList game = bossFight.get(floor);
//
//        if (floor == 1) {
//            System.out.println("  ABCDE");
//            for (int i = 0; i < firstFloor; i++) {
//                System.out.println((i+i) + " " + game.get(i));
//            }
//        }
//        game_n++;
//    }

    public final Map<Integer, ArrayList> bossFight = new HashMap<Integer, ArrayList>();
    private final ArrayList firstFloorGame = (new GenerateGame()).firstGame();
    private final ArrayList secondFloorGame = (new GenerateGame()).secondGame();
    private final ArrayList thirdFloorGame = (new GenerateGame()).thirdGame();

    {
        bossFight.put(1,firstFloorGame);
        bossFight.put(2,secondFloorGame);
        bossFight.put(3,thirdFloorGame);
    }

    public final Map<Integer, ArrayList> bossAns = new HashMap<Integer, ArrayList>();
    private final ArrayList<String> firstFloorAns = (new GenerateGame()).firstGameAns();
    private final ArrayList<String> secondFloorAns = (new GenerateGame()).secondGameAns();
    private final ArrayList<String> thirdFloorAns = (new GenerateGame()).thirdGameAns();

    {
        bossAns.put(1, firstFloorAns);
        bossAns.put(2, secondFloorAns);
        bossAns.put(3, thirdFloorAns);
    }
}