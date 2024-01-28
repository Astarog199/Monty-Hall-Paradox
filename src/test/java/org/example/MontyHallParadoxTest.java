package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MontyHallParadoxTest {

    @Test
    void testCreateArrayForGame(){
       MontyHallParadox game = new MontyHallParadox();
       boolean[] arr = game.createArrayForGame(3);
       boolean[] arr2 = game.createArrayForGame(10);
       Assertions.assertEquals(3, arr.length);
       Assertions.assertEquals(10, arr2.length);
    }

    @Test
    void testCreateArrayForGame2() {
        MontyHallParadox game = new MontyHallParadox();
        boolean[] arr = game.createArrayForGame(3);
        boolean res = false;

        for (int i = 0; i<3; i++){
            if (arr[i]) {
                res = true;
                break;
            }
        }
        Assertions.assertTrue(res);
    }

    @Test
    void testGetHelp(){
        MontyHallParadox game = new MontyHallParadox();
        boolean[] doors = {true, false, false};
        game.getHelp(doors, 2, 3);

        int i = game.index;
        System.out.println("index = " + i);
        Assertions.assertEquals(1, i);
    }

    @Test
    void testGetHelp2(){
        MontyHallParadox game = new MontyHallParadox();
        boolean[] doors = {false, true, false};
        game.getHelp(doors, 2, 3);

        int i = game.index;
        System.out.println("index = " + i);
        Assertions.assertEquals(0, i);
    }
}
