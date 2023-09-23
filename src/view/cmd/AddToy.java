package view.cmd;

import view.Console;

import java.util.Scanner;

public class AddToy {
    private Console console;

    public AddToy(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return "Добавить игрушку"; // Описание команды для меню
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название игрушки: ");
        String name = scanner.nextLine();
        System.out.print("Введите кол-во: ");
        int amount = scanner.nextInt();
        System.out.print("Введите вес: ");
        double weight = scanner.nextDouble();

        console.addToy(name, amount, weight); // Вызов метода для добавления игрушки через консоль
    }
}

