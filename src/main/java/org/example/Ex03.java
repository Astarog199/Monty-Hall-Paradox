package org.example;
import java.util.*;

public class Ex03 {
    public static void main(String[] args)  {
        List<String> list = new ArrayList<>();
        list.add("один");
        list.add("два");
        list.add("два");
        list.add("три");
        boolean res = contains(list, "nhb");
        System.out.println(res);



        Collection<String> col = new ArrayList<>();
        col.add("a");
        col.add("a");

        boolean res2 = hasExactly(col, "a");
        System.out.println(res2);


        System.out.println(unique(list));

    }



    /**
     * Возвращает true, если в values присутствует значение value
     */
    public static boolean contains(List<String> values, String value) {
        for (String v : values) {
            if (Objects.equals(value, v)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает true, если в values РОВНО 1 элемент и он равен value
     * // ["a", "b"], "a" -> false
     * // ["a"], "a" -> true
     */
    public static boolean hasExactly(Collection<String> values, String value) {
        Iterator<String> iterator = values.iterator();
        return iterator.hasNext() && Objects.equals(iterator.next(), value) && !iterator.hasNext();
    }

    /**
     * Возвращает только уникальные элементы из values.
     */
    public static List<String> unique(List<String> values) {
        return List.copyOf(Set.copyOf(values));
    }

}