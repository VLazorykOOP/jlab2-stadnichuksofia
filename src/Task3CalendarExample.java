import java.util.Calendar;
import java.util.Scanner;

public class Task3CalendarExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть день (число): ");
        int day = scanner.nextInt();

        System.out.print("Введіть рік: ");
        int year = scanner.nextInt();

        // Створення об'єкта Calendar та встановлення дати на задану дату
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, day);

        // Отримання дати та дня тижня
        int month = calendar.get(Calendar.MONTH); // Місяць (січень = 0, лютого = 1, ...)
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // День місяця
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // День тижня (неділя = 1, понеділок = 2, ...)

        // Масив для назв місяців та днів тижня
        String[] months = {"січень", "лютий", "березень", "квітень", "травень", "червень", "липень", "серпень", "вересень", "жовтень", "листопад", "грудень"};
        String[] daysOfWeek = {"неділя", "понеділок", "вівторок", "середа", "четвер", "п'ятниця", "субота"};

        // Виведення результатів
        System.out.println(dayOfMonth + " " + months[month] + ", " + daysOfWeek[dayOfWeek - 1]);

        scanner.close();
    }
}
