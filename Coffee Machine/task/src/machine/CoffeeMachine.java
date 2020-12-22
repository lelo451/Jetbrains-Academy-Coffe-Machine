package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water * cups + " ml of water");
        System.out.println(milk * cups + " ml of milk");
        System.out.println(coffeeBeans * cups + " g of coffee beans");
    }
}
