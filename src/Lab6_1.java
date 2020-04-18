//Ввести строки из файла, записать в список ArrayList.
// Выполнить сортировку строк, используя метод sort() из класса Collections
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab6_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/Users/Рита/IdeaProjects/Lab6/src/test.txt"));
        ArrayList<String> arr = new ArrayList<>();

        while (scanner.hasNext()) {
            arr.add(scanner.nextLine());
        }
        scanner.close();
        Collections.sort(arr);

        for (String i : arr) {
            System.out.println(i);
        }
    }
}
