package view.cmd;

import view.Console;

public class SavePrizeToy implements Command {
    private Console console;

    public SavePrizeToy(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Получить выигрыш"; // Описание команды для меню
    }

    @Override
    public void execute() {
        console.savePrizeToyToFile(); // Для сохранения призовой игрушки
    }

    @Override
    public void setConsole(Console console) {
        this.console = console;
    }
}
