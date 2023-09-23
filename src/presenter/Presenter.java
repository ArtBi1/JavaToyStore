package presenter;

import model.Service;
import model.save.FileIo;
import model.toy.Toy;
import model.toy.ToyStore;
import model.toy.Toys;
import view.View;

public class Presenter {
    private View view;          // Интерфейс для взаимодействия с юзером
    private Service service;    // Обработка бизнес-логики

    public Presenter(Toys<Toy> toys, ToyStore<Toy> prizeToys, View view) { // Принимает коллекцию игрушек,
        service = new Service(toys, prizeToys);                            // хранилище призовых игрушек и интерфейс View
        this.view = view;
    }

    public void setToys(Toys<Toy> toys) { // Для установки коллекции игрушек
        service.setToys(toys);
    }

    public void setPrizeToys(ToyStore<Toy> prizeToys) { // Для установки хранилища призовых игрушек
        service.setPrizeToys(prizeToys);
    }

    public void setFileIo(FileIo fileIo) { // Метод для установки объекта для работы с файлами
        service.setFileIo(fileIo);
    }

    public void addToy(String name, int amount, double weight) { // Доб. новой игрушки с параметрами
        String answer = service.addToy(name, amount, weight);
        view.print(answer);
    }

    public void updateWeight(int id, double weight) { // Метод для обновы веса игрушки по ид
        String answer = service.updateWeight(id, weight);
        view.print(answer);
    }

    public void getToys() { // Метод для получения инфы о всех игрушках
        String answer = service.getToys();
        view.print(answer);
    }

    public void chooseAndAddPrizeToy() { // Для выбора и добавления игрушки
        service.chooseAndAddPrizeToy();
    }

    public void savePrizeToyToFile() { // Сохр игрушки в файл сохранения
        service.savePrizeToyToFile();
    }
}

