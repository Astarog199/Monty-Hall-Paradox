package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.Random;

public class Ex02 {


    public static void main(String[] args) {
        task1(createArray(1, 100, 10));


       Number resFactorial = ArithmeticUtils.factorial(5);
       System.out.println("Факториал = " + resFactorial );


       Number resLCM = ArithmeticUtils.lcm(10, 33);
       System.out.println("Наименьшее общее кратное двух чисел " + resLCM);

        Number resGCD = ArithmeticUtils.gcd(10, 33);
        System.out.println("Наибольший общий делитель двух чисел " + resGCD);
    }




static int[] createArray(int min, int max, int size){
    Random r = new Random();
    int [] arr = new int[size];

    for (int i = 1; i < size; i++) {
        int num = r.nextInt(min, max);
        arr[i] = num;
    }
    return arr;
}



    static void task1(int[] arr){
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

        int size = arr.length;

        for (int i = 1; i < size; i++) {
            descriptiveStatistics.addValue(arr[i]);
        }

        System.out.println(descriptiveStatistics.getMin());
        System.out.println(descriptiveStatistics.getMax());
        System.out.println(descriptiveStatistics.getSum());
        System.out.println(descriptiveStatistics.getMean());
    }
}
