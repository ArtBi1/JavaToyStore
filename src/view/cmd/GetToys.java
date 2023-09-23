package view.cmd;

import view.Console;

public class GetToys implements Command {
    private Console console;

    public GetToys(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Получить список игрушек"; // Описание команды для меню
    }

    @Override
    public void execute() {
        console.getToys(); // Вызов метода для получения списка игрушек через консоль
    }

    @Override
    public void setConsole(Console console) {
        this.console = console;
    }
}
