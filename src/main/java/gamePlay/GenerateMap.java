package gamePlay;

public class GenerateMap {

    public Room[][] generateFirstFloor(){

        Room[][] floor = new Room[3][3];

        Room room00 = new Room();
        room00.addObj(new Potion("heal"));

        Room room01 = new Room();

        Room room02 = new Room();

        Room room10 = new Room();

        Room room11 = new Room();

        Room room12 = new Room();

        Room room20 = new Room();

        Room room21 = new Room();
        room21.addObj(new Potion("heal"));

        Room room22 = new Room();

        room00.setPath("d", room01);
        room00.setPath("s", room10);

        room01.setPath("a", room00);
        room01.setPath("s", room11);
        room01.setPath("d", room02);

        room02.setPath("a", room01);
        room02.setPath("s", room12);

        room10.setPath("w", room00);
        room10.setPath("d", room11);
        room10.setPath("s", room20);

        room11.setPath("w", room01);
        room11.setPath("a", room10);
        room11.setPath("s", room21);
        room11.setPath("d", room12);

        room12.setPath("w", room02);
        room12.setPath("a", room11);
        room12.setPath("s", room22);

        room20.setPath("w", room10);
        room20.setPath("d", room21);

        room21.setPath("w", room11);
        room21.setPath("a", room20);
        room21.setPath("d", room22);

        room22.setPath("w", room12);
        room22.setPath("a", room21);


        floor[0][0] = room00;
        floor[0][1] = room01;
        floor[0][2] = room02;
        floor[1][0] = room10;
        floor[1][1] = room11;
        floor[1][2] = room12;
        floor[2][0] = room20;
        floor[2][1] = room21;
        floor[2][2] = room22;

        return floor;
    }
}