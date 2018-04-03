package gamePlay;


import java.util.HashMap;
import java.util.Map;

public class Tower {
    public final Map<Integer,Room[][]> tower = new HashMap<Integer, Room[][]>();
    private final Room[][] firstFloor = (new GenerateMap()).generateFirstFloor();

    private final Room[][] secondFloor = (new GenerateMap()).generateSecondFloor();

    private final Room[][] thirdFloor = (new GenerateMap()).generateThirdFloor();

    {
        tower.put(1,firstFloor);
        tower.put(2,secondFloor);
        tower.put(3,thirdFloor);
    }

    public Room getBossRoom(int floor){
        if (floor == 1) {
            return tower.get(floor)[1][0];
        }
        else if (floor == 2) {
            return tower.get(floor)[0][1];
        }
        else if (floor == 3) {
            return tower.get(floor)[0][0];
        }
        return null;
    }

}