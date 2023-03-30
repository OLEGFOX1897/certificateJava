import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Viewer {

    public int getChoice() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Показать игрушки, которые я выграл");
            System.out.println("2. Добавить игрушку в автомат");
            System.out.println("3. Попробывать выграть игрушку у автомата");
            System.out.println("4. Выход\n");
            int input = in.nextInt();
            if (input < 1 | input > 4) {
                System.out.println("Введите вариант вариант 1...4.");
                return getChoice();
            }
            return input;
        } catch (Exception ex) {
            System.out.println("Вводить можно только числа.\nПовторите ввод ");
            return getChoice();
        }
    }

    public String getString(String msg) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.print("Введите " + msg + " > ");
        return in.nextLine();
    }

    public int getValue(String msg) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите " + msg + " > ");
            return in.nextInt();
        } catch (Exception ex) {
            System.out.println("Вводить можно только числа.\nПовторите ввод ");
            return getValue(msg);
        }
    }
}





