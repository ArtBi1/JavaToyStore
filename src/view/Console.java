package view;

import model.save.FileIo;
import model.toy.Toy;
import model.toy.ToyStore;
import model.toy.Toys;
import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private boolean work;
    private Scanner scanner;
    private Menu menu;
    private Toys<Toy> toys;
    private ToyStore<Toy> prizeToys;
    private FileIo fileIo;

    public Console(Toys<Toy> toys, ToyStore<Toy> prizeToys, FileIo fileIo) {

        this.presenter = new Presenter(toys, prizeToys, this); // компоненты, консоль, презентер, сканер
        this.scanner = new Scanner(System.in);
        this.menu = new Menu(this);
        this.work = true;
        this.toys = toys;
        this.prizeToys = prizeToys;
        this.fileIo = fileIo;
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print()); // Вывод меню на экран
            String choice = scanner.nextLine(); // Считывание выбора пользователя
            menu.execute(choice); // Выполнение выбранной команды
        }
    }

    @Override
    public void exit() {
        work = false; // Метод для завершения работы программы
        System.out.println("Программа завершена.");
    }

    @Override
    public void print(String text) {
        System.out.println(text); // Для вывода текста на экран
    }

    public void addToy(String name, int amount, double weight) {
        presenter.addToy(name, amount, weight); // Для добавления игрушки через презентер(далее Ч.П.)
    }

    public void updateWeight(int id, double weight) {
        presenter.updateWeight(id, weight); // Для обновления веса игрушки Ч.П.
    }

    public void getToys() {
        presenter.getToys(); // Получение списка игрушек Ч.П.
    }

    public void chooseAndAddPrizeToy() {
        presenter.chooseAndAddPrizeToy(); // Организация розыгрыша Ч.П.
    }

    public void savePrizeToyToFile() {
        presenter.savePrizeToyToFile(); // Сохранение призовой игрушки в файл Ч.П.
    }
}
