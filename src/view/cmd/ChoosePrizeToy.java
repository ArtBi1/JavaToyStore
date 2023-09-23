package view.cmd;

import view.Console;

public class ChoosePrizeToy {
    private Console console;

    public ChoosePrizeToy(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return "Сделать розыгрыш случайно выбранной игрушки"; // Описание команды для меню
    }

    public void execute() {
        console.chooseAndAddPrizeToy(); // Вызов метода для розыгрыша призовых игрушек через консоль
    }
}

