/**
 * Класс Toy представляет игрушку с уникальным идентификатором, названием,
 * количеством и частотой выпадения.
 */
public class Toy {
    private int id; // Идентификатор игрушки
    private String name; // Название игрушки
    private int quantity; // Количество игрушек
    private double frequency; // Частота выпадения игрушки (в % от 100)

    // Конструктор для создания новой игрушки
    public Toy(int id, String name, int quantity, double frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    // Геттер для идентификатора игрушки
    public int getId() {
        return id;
    }

    // Геттер для названия игрушки
    public String getName() {
        return name;
    }

    // Геттер для количества игрушек
    public int getQuantity() {
        return quantity;
    }

    // Сеттер для установки количества игрушек
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Геттер для частоты выпадения игрушки
    public double getFrequency() {
        return frequency;
    }

    // Сеттер для установки частоты выпадения игрушки
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    // Переопределение метода toString() для удобного вывода информации об игрушке
    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", frequency=" + frequency +
                '}';
    }
}
