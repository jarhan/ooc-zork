package gamePlay;

import java.util.*;

public class Room {
    private final static int MAX_ITEMS = 1;
    private final Potion[] potionLst = new Potion[MAX_ITEMS];
    private final Map<String,Room> neighbors = new HashMap<String, Room>();

    public boolean canGo(String  dir){
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
        String info = "In this room, you can find... ";
        for(Potion obj : potionLst){
            if(obj!=null) {
                System.out.println("HI in getInfo in room");
                System.out.println("obj:" + obj);
                info += obj.getInfo() + "\n";
            }
        }

        info += "\nYou can go the other room in following direction(s): \n";
        for (String s: neighbors.keySet()){
            info += s + " \n";
        }

        return info;
    }

    public void setPath(String direction,Room neighborRoom){
        switch (direction.charAt(0)) {
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