package view;

import model.save.FileIo;
import model.toy.Toy;
import model.toy.PrizeToyStore;
import model.toy.ToyCollection;

public interface View {
    void start(); // Метод для запуска

    void print(String text); // Метод вывода текста

    void exit(); // Для завершения программы

    void setToys(Toys<Toy> toys); // Для установки коллекции игрушек

    void setPrizeToys(PrizeToyStore<Toy> prizeToys); // Установка хранилища призовых игрушек

    void setFileIo(FileIo fileIo); // Для установки объекта для работы с файлами
}


