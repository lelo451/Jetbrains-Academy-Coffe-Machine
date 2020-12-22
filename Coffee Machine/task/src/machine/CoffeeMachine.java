package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has: ");
        int waterAmount = scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        int milkAmount = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeansAmount = scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();
        int waterTotal = waterAmount / water;
        int milkTotal = milkAmount / milk;
        int coffeBeansTotal = coffeeBeansAmount / coffeeBeans;
        int min = Math.min(Math.min(waterTotal, milkTotal), coffeBeansTotal);
        if (min < cups) {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        } else if (min == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (min > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (min - cups) + " more than that)");
        }

    }
}
