package machine;

import java.util.Scanner;

class Machine {
    enum State {WAIT, BUY, FILL}

    enum Fill {WATER, MILK, COFFEE, CUP}

    private int money = 550;
    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int cups = 9;
    private State state = State.WAIT;
    private Fill fill = Fill.WATER;

    String printStatus() {
        return "The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffee + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money";
    }

    private int checkResources(int needWater, int needMilk, int needCoffee) {
        if (needWater > 0 && needWater > water) {
            return 1;
        }
        if (needMilk > 0 && needMilk > milk) {
            return 2;
        }
        if (needCoffee > 0 && needCoffee > coffee) {
            return 3;
        }
        if (cups < 1) {
            return 4;
        } else {
            return 0;
        }
    }

    private int checkCoffee(String type) {
        switch (type) {
            case "1":
                return checkResources(250, 0, 16);
            case "2":
                return checkResources(350, 75, 20);
            case "3":
                return checkResources(200, 100, 12);
        }
        return 0;
    }

    private void makeCoffee(String type) {
        switch (type) {
            case "1":
                water -= 250;
                coffee -= 16;
                money += 4;
                break;
            case "2":
                water -= 350;
                milk -= 75;
                coffee -= 20;
                money += 7;
                break;
            case "3":
                water -= 200;
                milk -= 100;
                coffee -= 12;
                money += 6;
                break;
        }
        cups--;
    }

    String action(String input) {
        switch (state) {
            case WAIT:
                switch (input) {
                    case "buy":
                        state = State.BUY;
                        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                        action(new Scanner(System.in).nextLine());
                        break;
                    case "fill":
                        state = State.FILL;
                        fill = Fill.WATER;
                        System.out.print("Write how many ml of water do you want to add: ");
                        action(new Scanner(System.in).nextLine());
                        break;
                    case "take":
                        int wasMoney = money;
                        money = 0;
                        System.out.println("I gave you " + wasMoney);
                        break;
                }
                break;
            case BUY:
                state = State.WAIT;
                switch (checkCoffee(input)) {
                    case 0:
                        makeCoffee(input);
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        break;
                }
                break;
            case FILL:
                switch (fill) {
                    case WATER:
                        water += Integer.parseInt(input);
                        fill = Fill.MILK;
                        System.out.print("Write how many ml of milk do you want to add: ");
                        action(new Scanner(System.in).nextLine());
                        break;
                    case MILK:
                        milk += Integer.parseInt(input);
                        fill = Fill.COFFEE;
                        System.out.print("Write how many grams of coffee beans do you want to add: ");
                        action(new Scanner(System.in).nextLine());
                        break;
                    case COFFEE:
                        coffee += Integer.parseInt(input);
                        fill = Fill.CUP;
                        System.out.print("Write how many disposable cups of coffee do you want to add: ");
                        action(new Scanner(System.in).nextLine());
                        break;
                    case CUP:
                        cups += Integer.parseInt(input);
                        state = State.WAIT;
                        fill = Fill.WATER;
                        break;
                }
                break;
        }
        return "";
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();
        System.out.println(machine.printStatus());

        System.out.print("\nWrite action (buy, fill, take): ");
        String input = scanner.nextLine();
        System.out.println(machine.action(input));
        System.out.println(machine.printStatus());
    }
}
