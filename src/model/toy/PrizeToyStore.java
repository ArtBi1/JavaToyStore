package model.toy;

import java.util.ArrayList;
import java.util.List;

public class PrizeToyStore<E extends ToysItem<E>> {
    private long toysId;       // Уникальный id
    private List<E> prizeToys; // Список призовых игрушек

    public PrizeToyStore() {
        this(new ArrayList<>());
    }

    public PrizeToyStore(List<E> prizeToys) {
        this.prizeToys = prizeToys;
    }

    public boolean add(E toy) {
        if (toy == null) {
            return false; // Если переданная игрушка - null, не добавляем
        }
        if (!prizeToys.contains(toy)) {
            prizeToys.add(toy);    // Добавляем игрушку в список призовых
            toy.setId(toysId++);   // Устанавливаем айди игрушке
            return true;
        }
        return false;
    }

    public int size() {
        return prizeToys.size(); // Возврат кол-ва игрушек в списке
    }

    public E get(int index) {
        return prizeToys.get(index); // Получение игрушки по индексу
    }

    public void remove(int index) {
        prizeToys.remove(index); // Удаление игрушки тоже по индексу
    }

    @Override
    public String toString() {
        return getInfo(); // Для ввода инфы
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В призовом списке ");
        sb.append(prizeToys.size()); // Вывод колва игрушек в списке
        sb.append(" игрушек/ки: \n");
        for (E toy : prizeToys) {
            sb.append(toy); // Каждую игрушку призовую добавит ьв строку
            sb.append("\n");
        }
        return sb.toString(); // Возвращаем строку с инфой
    }
}

