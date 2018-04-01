package gamePlay;


import java.util.HashMap;
import java.util.Map;

public class Tower {
    public final Map<Integer,Room[][]> tower = new HashMap<Integer, Room[][]>();
    private final Room[][] firstFloor = (new GenerateMap()).generateFirstFloor();

//    private final Room[][] secondFloor = (new GenerateMap()).secondFloorGenerator();
//
//    private final Room[][] thirdFloor = (new GenerateMap()).thirdFloorGenerator();

    {
        tower.put(1,firstFloor);
//        tower.put(2,secondFloor);
//        tower.put(3,thirdFloor);
    }
}