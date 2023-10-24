import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listName = new ArrayList<>();
        listName.add("Анна Каренина");
        listName.add("Война и Мир");
        listName.add("Капитанская дочь");
        listName.add("Мцыри");
        listName.add("Родинка");
        listName.add("Тихий Дон");
        listName.add("Евгений Онегин");
        listName.add("Ревизор");
        listName.add("Идиот");
        listName.add("Обломов");
        listName.add("Темные аллеи");

        getSortedBooksOnShelf(listName);

    }

    public static void getSortedBooksOnShelf(List<String> list) {
        List<String> listSorted = list.stream()
                .sorted()
                .toList();

        final int shelf = 5;
        int totalBooks = list.size() / shelf;
        int booksLost = list.size() % shelf;

        List<ArrayList<String>> shelfTotal = new ArrayList<>();

        for (int i = 0; i < shelf; i++) {
            ArrayList<String> shelfItem = new ArrayList<>();
            shelfTotal.add(shelfItem);
        }

        int count = 0;
        for (int i = 0; i < shelf; i++) {
            for (int k = 0; k < totalBooks; k++) {
                shelfTotal.get(i).add(listSorted.get(count));
                count++;
            }
            if (i == 4) {
                for (int j = 0; j < booksLost; j++) {
                    shelfTotal.get(i).add(listSorted.get(count + j));
                }
            }
        }
        shelfTotal.stream()
                .forEach(System.out::println);
    }
}