package model.toy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ToyCollection<E extends ToysItem<E>> implements Iterable<E> {
    private long toysId;     // ИД для игрушек
    private List<E> toys;    // Список игрушек

    public ToyCollection() {
        this(new ArrayList<>()); // Объект ToyCollection с пустым списком игрушек
    }

    public ToyCollection(List<E> toys) {
        this.toys = toys; // Объект ToyCollection с заданным списком
    }

    public boolean add(E toy) {
        if (toy == null) {
            return false;
        }
        if (!toys.contains(toy)) { // Проверяем, чтоб не была добавлена раньше
            toys.add(toy); // Добавляем игрушку в список
            toy.setId(toysId++); // Присваиваем игрушке id
            return true;
        }
        return false;
    }

    public int size() {
        return toys.size(); // Возвращает размер
    }

    public Stream<E> stream() {
        return toys.stream(); // Преобразует список в поток
    }

    @Override
    public Iterator<E> iterator() {
        return toys.iterator(); // Итератор для списка игрушек
    }

    @Override
    public String toString() {
        return getInfo(); // Возвращает инфу о списке игрушек в виде строки
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В списке ");
        sb.append(toys.size());
        sb.append(" игрушек/ки: \n");
        for (E toy : toys) {
            sb.append(toy);
            sb.append("\n");
        }
        return sb.toString(); // Возвращает инфу о каждой игрушке в списке
    }

    public List<E> getToysList() {
        return toys; // Возвращает список с игрушками
    }
}
