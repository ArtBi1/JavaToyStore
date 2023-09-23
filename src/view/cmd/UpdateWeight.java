package view.cmd;

import view.Console;

import java.util.Scanner;

public class UpdateWeight implements Command {
    private Console console;

    public UpdateWeight(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Обновить вес игрушки"; // Описание команды для меню
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id игрушки: ");
        int id = scanner.nextInt(); // Считывание ид с клавиатуры
        System.out.print("Введите измененный вес: ");
        double weight = scanner.nextDouble(); // Считывание нового веса с клавиатуры

        console.updateWeight(id, weight); // Вызов метода для обновления веса
    }

    @Override
    public void setConsole(Console console) {
        this.console = console;
    }
}

