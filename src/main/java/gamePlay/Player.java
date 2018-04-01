package gamePlay;

import java.util.*;

public class Player {
    private String name;
    private int hp = 100;

    private int BAG_SIZE = 6;

    private final Potion[] potionsBags = new Potion[BAG_SIZE];

    private Tower playerMap = new Tower();

    public boolean isBusy = false;

    private int row = 1;
    private int col = 1;
    private int floor = 1;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.hp;
    }

    public void setRow(int x){
        this.row = x;
    }

    public void setCol(int y){
        this.col = y;
    }

    public void setFloor(int f){
        this.floor = f;
    }

    public Room getCurrentRoom(){
        System.out.println("IN getCurrentRoom in Player");
        System.out.println("floor: "+floor+" row: "+row+" col: "+col);
        return this.playerMap.tower.get(floor)[row][col];
    }

    private int hasHealPotion(){
        for (int i = 0; i < BAG_SIZE;i++){
            if(potionsBags[i]!=null && potionsBags[i].getName().equals("healing potion")){
                return i;
            }
        }
        return -1;
    }
    public int useHealPotion(){
        int itemSlot = hasHealPotion();
        if(itemSlot==-1){
            return -2;
        }
        else {
            if (this.hp == 100) {
                return 0;
            } else if (this.hp > 90) {
                potionsBags[itemSlot] = null;
                this.hp = 100;
                return 1;
            } else {
                potionsBags[itemSlot] = null;
                this.hp += 10;
                return 1;
            }
        }
    }

    private boolean isRoomValidMove(String dir){
        Room currentRoom = this.playerMap.tower.get(floor)[row][col];
        return currentRoom.canGo(dir);
    }

    public int move(String dir){
        System.out.println("HI move" + dir);
        if(!isBusy){
            System.out.println("in if isBusy in Player");
            if(!getCurrentRoom().canProceed())
                return -2;
            dir = dir.toLowerCase();
            if(isRoomValidMove(dir)){
                System.out.println("HI in isRoomValidMove in player");

                if(dir.equals("w"))
                    this.row -= 1;
                else if(dir.equals("d"))
                    this.col+=1;
                else if(dir.equals("a"))
                    this.col-=1;
                else if(dir.equals("s"))
                    this.row+=1;

                return 1;
            }
            System.out.println("HI in out isRoomValidMove in player");
            return -1;
        }
        return 0;

    }
}
