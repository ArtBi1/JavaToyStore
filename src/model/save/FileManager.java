package model.save;

import java.io.FileWriter;
import java.io.IOException;

import model.toy.Toy;

public class FileManager implements FileIo {
    @Override
    public void saveToFile(Toy toy, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Призовая игрушка: " + toy.getName() + "\n"); // Запись инфы о призовой игрушке в файл.
            System.out.println("Призовая игрушка сохранена.");
        } catch (IOException e) {
            System.err.println("Ошибка сохранения игрушки: " + e.getMessage()); // Если ошибка сохр, вывод сообщения.
        }
    }
}

