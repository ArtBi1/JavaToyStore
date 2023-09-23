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
        // Создаем экземпляр ToyCollection с типом элементов Toy и присваиваем его переменной toyCollection.
        ToyCollection<Toy> toyCollection = new ToyCollection<>();
        
        // Создаем экземпляр PrizeToyStore с типом элементов Toy и присваиваем его переменной prizeToyInventory.
        PrizeToyStore<Toy> prizeToyInventory = new PrizeToyStore<>();

        // Создаем экземпляры Toy с указанными параметрами и присваиваем их переменным toy1, toy2, toy3 и toy4.
        Toy toy1 = new Toy("Тигр", 15, 10.4);
        Toy toy2 = new Toy("Лев", 15, 7);
        Toy toy3 = new Toy("Зебра", 15, 20);
        Toy toy4 = new Toy("Слон", 15, 4);

        // Добавляем созданные экземпляры Toy в toyCollection.
        toyCollection.add(toy1);
        toyCollection.add(toy2);
        toyCollection.add(toy3);
        toyCollection.add(toy4);

        // Создаем экземпляр FileManager и присваиваем его переменной fileHandler.
        FileManager fileHandler = new FileManager();

        // Создаем экземпляр Service с переданным fileHandler и присваиваем его переменной service.
        Service service = new Service(fileHandler);

        // Устанавливаем fileHandler в service с помощью метода setFileIo.
        service.setFileIo(fileHandler);

        // Создаем экземпляр Console и присваиваем его переменной console.
        Console console = new Console();

        // Создаем экземпляр View и присваиваем его переменной view.
        View view = new View();

        // Устанавливаем toyCollection, prizeToyInventory и fileHandler в console и view с помощью соответствующих методов.
        console.setToyCollection(toyCollection);
        console.setPrizeToyStore(prizeToyInventory);
        console.setFileHandler(fileHandler);

        view.setToyCollection(toyCollection);
        view.setPrizeToyStore(prizeToyInventory);

        // Запускаем метод start() у console для начала работы терминального интерфейса.
        console.start();
    }
}

