package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.example.Ex03.*;

    public class Ex03Test {
        @Test
        void testContains(){
            List<String> list = new ArrayList<>();
            list.add("один");
            list.add("два");
            Assertions.assertTrue(contains(list, "два"));
        }

        @Test
        void hasExactlyTest(){
            Collection<String> col = new ArrayList<>();
            col.add("a");
            col.add("a");

            Assertions.assertFalse(hasExactly(col, "a"));
        }

        @Test
        void uniqueTest(){
            List<String> list = new ArrayList<>();
            list.add("один");
            list.add("два");
            list.add("два");
            list.add("три");

            List<String> list2 = new ArrayList<>();
            list2.add("один");
            list2.add("два");
            list2.add("три");

            Assertions.assertEquals(3, unique(list).size());
            Assertions.assertEquals(3, unique(list2).size());
        }
    }


