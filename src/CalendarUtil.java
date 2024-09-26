import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalendarUtil {

    // Метод для пошуку дня місяця і тижня для введеного числа і року
    public static void findDate(int dayOfYear, int year) {
        // Створюємо початкову дату на 1 січня введеного року
        LocalDate date = LocalDate.of(year, 1, 1);

        // Перевіряємо, чи введений день не перевищує кількість днів у році
        if (dayOfYear > date.lengthOfYear() || dayOfYear < 1) {
            System.out.println("Неправильний день року!");
            return;
        }

        // Додаємо кількість днів до 1 січня для отримання дати
        LocalDate resultDate = date.plus(dayOfYear - 1, ChronoUnit.DAYS);

        // Форматування дати для виведення
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMMM");
        String formattedDate = resultDate.format(dateFormatter);

        // Виведення дати і дня тижня
        System.out.println("Дата: " + formattedDate);
        System.out.println("День тижня: " + resultDate.getDayOfWeek());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення дня і року
        System.out.print("Введіть день року (1-365/366): ");
        int dayOfYear = scanner.nextInt();

        System.out.print("Введіть рік: ");
        int year = scanner.nextInt();

        // Пошук і виведення результату
        findDate(dayOfYear, year);
    }
}
