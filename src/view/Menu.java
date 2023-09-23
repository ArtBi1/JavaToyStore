package view;

import view.cmd.AddToy;
import view.cmd.ChoosePrizeToy;
import view.cmd.Exit;
import view.cmd.GetToys;
import view.cmd.SavePrizeToy;
import view.cmd.UpdateWeight;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();

// Каждая команда выполняет определенное действие   // Команда:
        commands.add(new GetToys(console));         // для получения списка игрушек
        commands.add(new AddToy(console));          // для добавления игрушки
        commands.add(new UpdateWeight(console));    // для обновления веса игрушки
        commands.add(new ChoosePrizeToy(console));  // для организации розыгрыша призовых игрушек
        commands.add(new SavePrizeToy(console));    // для сохранения призовой игрушки
        commands.add(new Exit(console));            // для завершения программы
    }

    public void print() { // Вывод списка доступных команд
        System.out.println("Выберите команду:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i + 1 + ". " + commands.get(i).getDescription());
        }
    }

    public void execute(int choice) { // Для выполнения выбранной команды
        if (choice >= 1 && choice <= commands.size()) {
            commands.get(choice - 1).execute();
        } else {
            console.print("Неверный выбор команды. Пожалуйста, выберите другую команду.");
        }
    }
}

