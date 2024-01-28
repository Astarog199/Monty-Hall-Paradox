package org.example;

import java.util.Random;
import java.util.Scanner;

/*
    В качестве задачи предлагаю вам реализовать код для
демонстрации парадокса Монти Холла (Парадокс Монти Холла
— Википедия ) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
● Создать свой Java Maven или Gradle проект;
● Самостоятельно реализовать прикладную задачу;
● Сохранить результат в HashMap<шаг теста, результат>
● Вывести на экран статистику по победам и поражениям
*/

public class MontyHallParadox {

    private boolean flag = false;
    private final Random r;
    private final Scanner iScanner;
    protected int answer, index;
    private int length, attempt;
    private boolean[] doors;

    private final String TASK ="\nПредставьте, что вы стали участником игры, в которой вам нужно выбрать одну из трёх дверей.\n"
            +"За одной из дверей находится автомобиль, за двумя другими дверями — козы. \n" +
            "Вы выбираете одну из дверей, например, номер 1, после этого ведущий, который знает, где находится автомобиль, \n" +
            "а где — козы, открывает одну из оставшихся дверей, например, номер 3, за которой находится коза. \n" +
            "После этого он спрашивает вас — не желаете ли вы изменить свой выбор и выбрать дверь номер 2? \n" +
            "Увеличатся ли ваши шансы выиграть автомобиль, если вы примете предложение ведущего и измените свой выбор? \n";

    public MontyHallParadox(){
        attempt = 0;
        answer = 0;
        r = new Random();
        iScanner = new Scanner(System.in);

    }


    public static void  main(String[] args) {
        MontyHallParadox game = new MontyHallParadox();
        game.startGame();
    }

    public void startGame(){
        System.out.println(TASK);

        length = getLengthForArray();
        doors = createArrayForGame(length);
        System.out.println(doors.length);
        getAnswer();
        check(doors[answer]);
        if (flag){
            check(doors[answer]);
        }
    }

    protected int getLengthForArray(){
        System.out.println("Выберите уровень сложности для игры: введите \"простой\" или \"сложный\" ");
        String gameDifficulty = iScanner.nextLine();
        return switch (gameDifficulty) {
            case "простой" -> 3;
            case "сложный" -> 10;
            default -> throw new ArrayIndexOutOfBoundsException("Введено некорректное значение");
        };
    }

    protected boolean[] createArrayForGame(int length){
        boolean[] doors = new boolean[length];
        for (int i = 0; i<length; i++){
            doors[i] = false;
        }
        doors[getIndex(length)] = true;
        return doors;
    }

    private void getAnswer(){
        System.out.println("введите число от 1 до "+ length);
        answer = iScanner.nextInt();
        this.answer = answer-1;
    }

    private void check(boolean res){
        if (res && attempt != 0){
            System.out.println("Поздравляю вы победили");
        } else if (attempt<1) {
            flag = true;
            getHelp(doors, answer, length);
            attempt++;
            getAnswer();
        } else {
            System.out.println("Вы проиграли");
        }
    }

    protected void getHelp(boolean[] doors, int answer, int length) {
         index =  getIndex(length);
        if (index != answer && !doors[index]){
            int i = index+1;
            System.out.println("Подсказка: дверь под № " + i + doors[index]);
        }else {
            getHelp(doors, answer, length);
        }
    }

    protected int getIndex(int length){
        return r.nextInt(0, length);
    }
}
