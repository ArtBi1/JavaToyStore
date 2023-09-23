package view.cmd;

import view.Console;

public class Exit implements Command {
    private Console console;

    public Exit(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Завершить программу"; // Описание команды для меню
    }

    @Override
    public void execute() {
        console.exit(); // Вызов метода для завершения программы через консоль
    }

    @Override
    public void setConsole(Console console) {
        this.console = console;
    }
}
