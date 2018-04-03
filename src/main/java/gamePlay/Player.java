package gamePlay;

import java.util.*;

public class Player {
    private String name;
    private int MAX_HP = 100;
    private int hp = MAX_HP;
    private int ap = 10;

    private BigBoss target = null;
    private int game_n = 0;
    private String ans_n = "";
//    private String prv_ans = "";

    private int BAG_SIZE = 6;

    private final Potion[] potionsBags = new Potion[BAG_SIZE];

    private Tower playerMap = new Tower();
    private BossFight playerGame = new BossFight();

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

    public int getAp(){
        return this.ap;
    }

    public int getFloor(){
        return this.floor;
    }

    public void increaseMAX_HP() { this.MAX_HP += 5; }

    public void increaseHp() { this.hp += 5; }

    public void increaseAp() { this.ap += 5; }

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
//        System.out.println("IN getCurrentRoom in Player");
//        System.out.println("floor: "+floor+" row: "+row+" col: "+col);
        return this.playerMap
                .tower
                .get(floor)[row][col];
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
//            potionsBags[itemSlot] = null;
//            this.hp += 10;
//            return 1;
            if (this.hp == MAX_HP) {
                return 0;
            } else if (this.hp > (MAX_HP - 10)) {
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

    public String checkHP(){
        return ""+this.hp;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    public boolean validAttack(){
        Room currentRoom = this.playerMap.tower.get(floor)[row][col];

        BigBoss currentGuardian = currentRoom.getBoss();

        if(currentGuardian!=null){
            this.target = currentGuardian;
            this.isBusy = true;
            return true;
        }
        return false;
    }

    public int compareChoice(String player,String computer){
        if(player.equals(computer))
            return 1;
        else return -1;

//        if(player.equals("rock"))
//            return (computer.equals("scissors") ? 1 : -1);
//        if(player.equals("paper"))
//            return (computer.equals("rock") ? 1 : -1);
//        if(player.equals("scissors"))
//            return (computer.equals("paper") ? 1 : -1);
//
//        //should not reach here
//        return -2;

    }
    public void fight(){
//        System.out.println("In fight: " + floor);
//        System.out.println("In fight: " + this.floor);
        ArrayList<String[]> games = this.playerGame.bossFight.get(floor);
        ArrayList<String> ans = this.playerGame.bossAns.get(floor);
//        this.playerGame.getGame(this.floor);

        if (this.isBusy){
//            System.out.println("busy");
            if (this.floor == 1) {
                System.out.println("  ABCDE");
                for (int j = 0; j < games.get(this.game_n % 8).length; j++) {
                    System.out.println((j+1) + " " + games.get(this.game_n % 8)[j]);
                }
//                System.out.println("In fight " + ans_n);
//                prv_ans = ans_n;
                ans_n = ans.get(game_n%8);
            }
            else if (this.floor == 2) {
                System.out.println("  ABCDEFGH");
                for (int j = 0; j < games.get(this.game_n % 8).length; j++) {
                    System.out.println((j+1) + " " + games.get(this.game_n % 8)[j]);
                }
//                System.out.println("In fight " + ans_n);
//                prv_ans = ans_n;
                ans_n = ans.get(game_n%8);
            }
            else if (this.floor == 3) {
                System.out.println("   ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                for (int j = 0; j < games.get(this.game_n % 5).length; j++) {
                    if (j < 9) {
                        System.out.println(" " + (j + 1) + " " + games.get(this.game_n % 5)[j]);
                    }
                    else {
                        System.out.println((j + 1) + " " + games.get(this.game_n % 5)[j]);
                    }
                }
//                System.out.println("In fight " + ans_n);
//                prv_ans = ans_n;
                ans_n = ans.get(game_n%5);
            }
            game_n++;
        }
//        System.out.println(games.get(0));
//        for (int i = 0; i < games.size(); i++) {
//            System.out.println("  ABCDE");
//            for (int j = 0; j < games.get(i).length; j++) {
//                System.out.println((j+1) + " " + games.get(i)[j]);
//            }
//            System.out.println(ans.get(i));
//        }
    }

    public int attackWith(String choice){
        if(this.isBusy) {
            choice = choice.toUpperCase();
//            this.fight();
//            System.out.println("In attackWith:" + choice + ", " + prv_ans);
            int status = compareChoice(choice, ans_n);
            if(status==1){
                this.target.lose(ap);
                if(target.isDead()){
                    getCurrentRoom().setBoss(null);
                    this.isBusy = false;
                    this.ap += 10;
                    return 4;
                }
            }
            else if(status==-1){
                lose();
            }
            return status;
        }
        return -2;
    }

    private void lose() {
        int c = new Random().nextInt(this.hp/5);
        this.hp -= c;
    }

    private boolean isRoomValidMove(String dir){
        Room currentRoom = this.playerMap.tower.get(floor)[row][col];
        return currentRoom.canGo(dir);
    }

    public boolean canGoNextFloor(){
        Room finalRoom = this.playerMap.getBossRoom(this.floor);
        return finalRoom.getBoss()==null;
    }

    public void goNextFloor(int flr){
        if (flr == 1) {
            this.floor = 2;
            this.row = 1;
            this.col = 1;
        }
        else if (flr == 2) {
            this.floor = 3;
            this.row = 0;
            this.col = 0;
        }
    }

    public int move(String dir){
//        System.out.println("HI move" + dir);
        if(!isBusy){
//            System.out.println("in if isBusy in Player");
            if(!getCurrentRoom().canProceed())
                return -2;
            dir = dir.toLowerCase();
            if(isRoomValidMove(dir)){
//                System.out.println("HI in isRoomValidMove in player");

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
