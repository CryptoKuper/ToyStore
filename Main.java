/**
 * Главный класс для запуска программы розыгрыша игрушек.
 */
public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавляем игрушки в магазин
        toyStore.addToy(new Toy(1, "Teddy Bear", 10, 30.0));
        toyStore.addToy(new Toy(2, "Toy Car", 15, 50.0));
        toyStore.addToy(new Toy(3, "Doll", 5, 20.0));

        // Отображаем все игрушки в магазине
        toyStore.displayToys();

        // Проводим розыгрыш призовой игрушки
        System.out.println("Проведение розыгрыша...");
        toyStore.drawPrizeToy();

        // Получаем призовую игрушку
        Toy prizeToy = toyStore.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Призовая игрушка: " + prizeToy);
        } else {
            System.out.println("Призовых игрушек нет.");
        }

        // Отображаем все игрушки в магазине после розыгрыша
        toyStore.displayToys();
    }
}
