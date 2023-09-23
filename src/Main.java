import model.Service;
import model.save.FileIo;
import model.save.FileManager;
import model.toy.Toy;
import model.toy.PrizeToyStore;
import model.toy.ToyCollection;
import view.Console;
import view.View;

public class Main {
    public static void main(String[] args) {
        ToyCollection<Toy> toyCollection = new ToyCollection<>();
        
        PrizeToyStore<Toy> prizeToyInventory = new PrizeToyStore<>();

        Toy toy1 = new Toy("Тигр", 15, 10.4); // Создаем экземпляры Toy
        Toy toy2 = new Toy("Лев", 15, 7);     // с указанными параметрами
        Toy toy3 = new Toy("Зебра", 15, 20);  // и присваиваем их переменным
        Toy toy4 = new Toy("Слон", 15, 4);

        toyCollection.add(toy1); // Добавляем созданные экземпляры Toy в toyCollection.
        toyCollection.add(toy2);
        toyCollection.add(toy3);
        toyCollection.add(toy4);

        FileManager fileHandler = new FileManager(); // Добавляем созданные экземпляры Toy в toyCollection.

        Service service = new Service(fileHandler);

        service.setFileIo(fileHandler); // fileHandler в service с помощью метода setFileIo.

        Console console = new Console();

        View view = new View(); // Экземпляр View и присваиваем его переменной view.

        console.setToyCollection(toyCollection);
        console.setPrizeToyStore(prizeToyInventory);
        console.setFileHandler(fileHandler);

        view.setToyCollection(toyCollection);
        view.setPrizeToyStore(prizeToyInventory);

        console.start(); // Запускаем метода start() для начала работы интерфейса
    }
}

