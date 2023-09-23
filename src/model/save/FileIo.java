package model.save;

import java.io.IOException;

import model.toy.Toy;

public interface FileIo {
    public static final String FILENAME = "prize.txt"; // Имя файла, в который будут сохраняться призовые игрушки.

    void saveToFile(Toy toy) throws IOException; // Метод для сохранения игрушки в файл.
}
