package gamePlay;

import java.util.*;

public class Room {
    private final static int MAX_ITEMS = 1;
    private final Potion[] potionLst = new Potion[MAX_ITEMS];
    private final Map<Character,Room> neighbors = new HashMap<Character,Room>();

    public boolean canGo(String dir){
        return neighbors.containsKey(dir);
    }

    public boolean addObj(Potion potion) {
        for(int i = 0; i < MAX_ITEMS;i++){
            if(potionLst[i] == null){
                potionLst[i] = potion;
                return true;
            }
        }
        return false;
    }

    public String getInfo(){
        String info = "In this room, you can find ";
        for(Potion obj : potionLst){
            if(obj!=null)
                info += obj.getInfo() +"\n";
        }

        return info;
    }

    public void setPath(Character direction,Room neighborRoom){
        switch (direction) {
            case 'w':
            case 'a':
            case 's':
            case 'd':
                neighbors.put(direction,neighborRoom);
        }
    }

    public boolean canProceed(){
        return true;
    }
}