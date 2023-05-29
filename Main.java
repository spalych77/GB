import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создание магазина и добавление ноутбуков
        Shop shop = new Shop();
        shop.addNotebook(new Notebook("Lenovo ThinkPad", 8, 256, "Windows 10", "Черный"));
        shop.addNotebook(new Notebook("HP Pavilion", 4, 1000, "Windows 8", "Серый"));
        shop.addNotebook(new Notebook("Acer Aspire", 16, 500, "Windows 10", "Красный"));
        shop.addNotebook(new Notebook("Dell XPS", 8, 512, "Windows 10", "Серебристый"));
        shop.addNotebook(new Notebook("Apple MacBook Air", 8, 256, "Mac OS", "Золотистый"));

        // Запрос критериев фильтрации
        Map<String, Object> filters = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criteriaNumber = sc.nextInt();
        sc.nextLine(); // Считать оставшийся символ переноса строки

        switch (criteriaNumber) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ: ");
                int minRam = sc.nextInt();
                filters.put("ram", minRam);
                break;

            case 2:
                System.out.print("Введите минимальный объем ЖД: ");
                int minHddSize = sc.nextInt();
                filters.put("hddSize", minHddSize);
                break;

            case 3:
                System.out.print("Введите требуемую операционную систему: ");
                String os = sc.nextLine();
                filters.put("os", os);
                break;

            case 4:
                System.out.print("Введите требуемый цвет: ");
                String color = sc.nextLine();
                filters.put("color", color);
                break;
        }

        // Фильтрация ноутбуков и вывод результатов
        List<Notebook> filteredList = shop.filterNotebooks(filters);

        if (filteredList.isEmpty()) {
            System.out.println("К сожалению, ноутбуки, отвечающие критериям, в магазине отсутствуют.");
        } else {
            System.out.println("В магазине имеются следующие ноутбуки, отвечающие критериям:");
            for (Notebook notebook : filteredList) {
                System.out.println(notebook);
            }
        }
    }
}