import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс ToyStore управляет коллекцией игрушек и розыгрышем призов.
 */
public class ToyStore {
    private List<Toy> toys; // Коллекция всех игрушек в магазине
    private List<Toy> prizeToys; // Коллекция призовых игрушек

    // Конструктор для создания нового магазина игрушек
    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    // Метод для добавления новой игрушки в магазин
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    // Метод для обновления частоты выпадения игрушки по её идентификатору
    public void updateToyFrequency(int id, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(newFrequency);
                break;
            }
        }
    }

    // Метод для проведения розыгрыша призовой игрушки
    public void drawPrizeToy() {
        Random random = new Random();
        double totalFrequency = 0.0;
        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }
        double randValue = random.nextDouble() * totalFrequency;
        double cumulativeFrequency = 0.0;
        for (Toy toy : toys) {
            cumulativeFrequency += toy.getFrequency();
            if (randValue <= cumulativeFrequency && toy.getQuantity() > 0) {
                prizeToys.add(toy);
                toy.setQuantity(toy.getQuantity() - 1);
                break;
            }
        }
    }

    // Метод для получения призовой игрушки из списка
    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            savePrizeToyToFile(prizeToy);
            return prizeToy;
        }
        return null;
    }

    // Метод для сохранения призовой игрушки в текстовый файл
    private void savePrizeToyToFile(Toy prizeToy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write(prizeToy.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    // Метод для отображения всех игрушек в магазине
    public void displayToys() {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
}
