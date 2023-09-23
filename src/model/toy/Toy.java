package model.toy;

public class Toy implements ToysItem<Toy> {
    private long id;          // айди
    private String name;      // название
    private int amount;       // колво игрушек
    private double weight;    // вес

    public Toy(String name, int amount, double weight) {
        id = -1;              // начальное id
        this.name = name;     // установка имени
        this.amount = amount; // установка кол-ва игрушек
        this.weight = weight; // И вес игрушки
    }

    public long getId() {
        return id; // Получаем айди
    }

    public void setId(long id) {
        this.id = id; // Установка айди
    }

    public String getName() {
        return name; // Получение названия игрушки
    }

    public int getAmount() {
        return amount; // Получаем их кол-во
    }

    public double getWeight() {
        return weight; // Получаем вес
    }

    public void setWeight(double weight) {
        this.weight = weight; // Установка нового веса
    }

    public void decreaseAmount() {
        this.amount--; // Уменьшение колва на 1
    }

    @Override
    public String toString() {
        return getInfo(); // Для вывода инфы
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);            // Добавление id в строку
        sb.append(", название: ");
        sb.append(name);          // Добавление названия в строку
        sb.append(", количество: ");
        sb.append(getAmount());   // Добавление колва в строку
        sb.append(", вес: ");
        sb.append(getWeight());   // Добавление веса
        return sb.toString();      // Возвращение строки с инфой 
    }
}

