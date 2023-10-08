import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Task1DateExample {
    private int year;
    private byte month;
    private byte day;

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть дію:");
        System.out.println("1 - Додавання днів");
        System.out.println("2 - Віднімання днів");
        System.out.println("3 - Перевірка високосності року");
        System.out.println("4 - Отримання та присвоєння окремих частин");
        System.out.println("5 - Порівняння дат");
        System.out.println("6 - Обчислити кількість днів між датами");

        int choice = scanner.nextInt();

        Task1DateExample date1 = null;
        Task1DateExample date2 = null;

        switch (choice) {
            case 1:
                date1 = getDateFromUserInput("Введіть початкову дату: ");
                int daysToAdd = getNumberOfDays("Введіть кількість днів для додавання: ");
                date1.addDays(daysToAdd);
                System.out.println("Дата після додавання " + daysToAdd + " днів: " + date1);
                break;
            case 2:
                date1 = getDateFromUserInput("Введіть початкову дату: ");
                int daysToSubtract = getNumberOfDays("Введіть кількість днів для віднімання: ");
                date1.subtractDays(daysToSubtract);
                System.out.println("Дата після віднімання " + daysToSubtract + " днів: " + date1);
                break;
            case 3:
                int yearToCheck = getUserInputData("Введіть рік для перевірки високосності: ");
                Task1DateExample leapYearDate = new Task1DateExample(yearToCheck, (byte) 1, (byte) 1);
                System.out.println("Рік " + yearToCheck + (leapYearDate.isLeapYear() ? " - високосний." : " - не високосний."));
                break;
            case 4:
                int year = getUserInputData("Введіть рік: ");
                int month = getUserInputData("Введіть місяць: ");
                int day = getUserInputData("Введіть день: ");
                System.out.println("Результат присвоєння: " + year + "." + month + "." + day);
                break;
            case 5:
                date1 = getDateFromUserInput("Введіть першу дату: ");
                date2 = getDateFromUserInput("Введіть другу дату: ");
                long difference = calculateDifference(date1, date2);
                String message = (difference > 0)
                        ? (date1 + " пізніше " + date2)
                        : (difference < 0)
                            ? (date1 + " раніше " + date2)
                            : "Ці дати рівні";
                System.out.println(message);
                break;
            case 6:
                date1 = getDateFromUserInput("Введіть першу дату: ");
                date2 = getDateFromUserInput("Введіть другу дату: ");
                long differenceInDays = calculateDifferenceInDays(date1, date2);
                System.out.println("Кількість днів між датами: " + differenceInDays + " днів");
                break;
            default:
                System.out.println("Невірний вибір!");
        }

        scanner.close();
    }
    private static Task1DateExample getDateFromUserInput(String prompt) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String userInputDate = scanner.next();
        return new Task1DateExample(userInputDate);
    }
    private static int getNumberOfDays(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public void addDays(int daysToAdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        this.year = calendar.get(Calendar.YEAR);
        this.month = (byte) (calendar.get(Calendar.MONTH) + 1);
        this.day = (byte) calendar.get(Calendar.DAY_OF_MONTH);
    }
    public void subtractDays(int daysToSubtract) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract);
        this.year = calendar.get(Calendar.YEAR);
        this.month = (byte) (calendar.get(Calendar.MONTH) + 1);
        this.day = (byte) calendar.get(Calendar.DAY_OF_MONTH);
    }
    private static int getUserInputData(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public boolean isLeapYear() {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
    public Task1DateExample(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = dateFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.year = calendar.get(Calendar.YEAR);
        this.month = (byte) (calendar.get(Calendar.MONTH) + 1);
        this.day = (byte) calendar.get(Calendar.DAY_OF_MONTH);
    }
    public Task1DateExample(int year, byte month, byte day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    private static long calculateDifference(Task1DateExample date1, Task1DateExample date2) throws ParseException {
        return date1.toDate().getTime() - date2.toDate().getTime();
    }
    private static long calculateDifferenceInDays(Task1DateExample date1, Task1DateExample date2) throws ParseException {
        long differenceInMilliseconds = Math.abs(date1.toDate().getTime() - date2.toDate().getTime());
        return TimeUnit.DAYS.convert(differenceInMilliseconds, TimeUnit.MILLISECONDS);
    }
    public Date toDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String dateStr = String.format("%04d.%02d.%02d", year, month, day);
        return dateFormat.parse(dateStr);
    }
}
