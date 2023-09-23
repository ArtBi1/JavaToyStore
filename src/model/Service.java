package model;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import model.save.FileIo;
import model.toy.Toy;
import model.toy.PrizeToyStore;
import model.toy.ToyCollection;

public class Service {
    private ToyCollection<Toy> toys;        // Коллекция игрушек
    private PrizeToyStore<Toy> prizeToys;   // Хранилище призовых
    private FileIo fileIo;

    public Service(ToyCollection<Toy> toys, PrizeToyStore<Toy> prizeToys) { // Конструктор для инициализации сервиса с коллекцией игрушек и хранилищем призовых игрушек
        this.toys = toys;
        this.prizeToys = prizeToys;
    }

    public Service(FileIo fileIo) { // Конструктор для инициализации сервиса с объектом для работы с файлами
        this.fileIo = fileIo;
    }

    public String getToys() { // Для получения инфы о всех игрушках
        return toys.getInfo();
    }

    public void setToys(ToyCollection<Toy> toys) { // Для установки коллекции игрушек
        this.toys = toys;
    }

    public void setPrizeToys(PrizeToyStore<Toy> prizeToys) { // Для установки хранилища призов
        this.prizeToys = prizeToys;
    }

    public void setFileIo(FileIo fileIo) {// Для объекта работы с файлами
        this.fileIo = fileIo;
    }

    public String addToy(String name, int amount, double weight) { // Добавление новой игрушки
        Toy toy = new Toy(name, amount, weight);
        toys.add(toy);
        return "Игрушка добавлена";
    }

    public void chooseAndAddPrizeToy() { // Выбор и добавление призовой игрушки
        if (toys.size() == 0) {
            System.out.println("Увы, игрушек нет.");
            return;
        }

        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();

        Random random = new Random();
        double randomWeight = random.nextDouble() * totalWeight;

        double currentWeight = 0;
        Toy selectedToy = null;

        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= randomWeight) {
                selectedToy = toy;
                System.out.println("Призовая игрушка: " + selectedToy);
                System.out.println();
                break;
            }
        }

        if (selectedToy != null) {
            prizeToys.add(selectedToy);
        } else {
            System.out.println("Не удалось выбрать игрушку!");
        }
    }

    public void savePrizeToyToFile() { // Сохранение приза в файл
        if (prizeToys.size() == 0) {
            System.out.println("Игрушек к сохранению нет!");
            return;
        }
        Toy selectedToy = prizeToys.get(0);
        prizeToys.remove(0);

        try {
            fileIo.saveToFile(selectedToy, FileIo.filename);
            System.out.println("Держите игрушку");
        } catch (IOException e) {
            System.err.println("Ошибка при выдаче: " + e.getMessage());
        }

        selectedToy.decreaseAmount();
    }

    public String updateWeight(int id, double weight) { // Для обновления веса игрушки по ид
        List<Toy> toyList = toys.getToysList();
        for (Toy toy : toyList) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
        return "Вес изменен";
    }
}

