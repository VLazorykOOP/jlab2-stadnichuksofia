import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть завдання:");
        System.out.println("1 - Робота з датами");
        System.out.println("2 - Розрахунок об'єму та площі призми");
        System.out.println("3 - Виведення дати за номером дня та роком");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> Date();
            case 2 -> Prism();
            case 3 -> Calendar();
            default -> System.out.println("Невірний вибір!");
        }
        scanner.close();
    }
    private static void Date() throws ParseException {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Оберіть дію:");
                System.out.println("1 - Додавання днів");
                System.out.println("2 - Віднімання днів");
                System.out.println("3 - Перевірка високосності року");
                System.out.println("4 - Отримання та присвоєння окремих частин");
                System.out.println("5 - Порівняння дат");
                System.out.println("6 - Обчислити кількість днів між датами");

                int choice = scanner.nextInt();

                Date date1 = null;
                Date date2 = null;

                switch (choice) {
                    case 1:
                        date1 = getDateFromUserInput("Введіть початкову дату: ");
                        int daysToAdd = getNumberOfDays("Введіть кількість днів для додавання: ");
                        System.out.println("Дата після додавання " + daysToAdd + " днів: " + date1.addDays(daysToAdd));
                        break;
                    case 2:
                        date1 = getDateFromUserInput("Введіть початкову дату: ");
                        int daysToSubtract = getNumberOfDays("Введіть кількість днів для віднімання: ");
                        date1.subtractDays(daysToSubtract);
                        System.out.println("Дата після віднімання " + daysToSubtract + " днів: " + date1);
                        break;
                    case 3:
                        int yearToCheck = getUserInputData("Введіть рік для перевірки високосності: ");
                        date1 = new Date(yearToCheck + ".01.01");
                        System.out.println("Рік " + yearToCheck + (date1.isLeapYear() ? " - високосний." : " - не високосний."));
                        break;
                    case 4:
                        int year = getUserInputData("Введіть рік: ");
                        int month = getUserInputData("Введіть місяць: ");
                        int day = getUserInputData("Введіть день: ");
                        date1 = new Date(year + "." + month + "." + day);
                        System.out.println("Результат присвоєння: " + date1);
                        break;
                    case 5:
                        date1 = getDateFromUserInput("Введіть першу дату: ");
                        date2 = getDateFromUserInput("Введіть другу дату: ");
                        long difference = date1.calculateDifference(date2);
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
                        long differenceInDays = date1.calculateDifferenceInDays(date2);
                        System.out.println("Кількість днів між датами: " + differenceInDays + " днів");
                        break;
                    default:
                        System.out.println("Невірний вибір!");
                }
                scanner.close();
            }
            private static Date getDateFromUserInput(String prompt) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.print(prompt);
                String userInputDate = scanner.next();
                return new Date(userInputDate);
            }
            private static int getNumberOfDays(String prompt) {
                Scanner scanner = new Scanner(System.in);
                System.out.print(prompt);
                return scanner.nextInt();
            }
            private static int getUserInputData(String prompt) {
                Scanner scanner = new Scanner(System.in);
                System.out.print(prompt);
                return scanner.nextInt();
            }
    private static void Prism() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту призми: ");
        double height = scanner.nextDouble();

        System.out.print("Введіть довжину сторони основи призми: ");
        double sideLength = scanner.nextDouble();

        Prism prism = new Prism(height, sideLength);
        double lateralBaseArea = prism.lateralBaseArea();
        double volume = prism.volume();

        System.out.println("Площа бічної основи призми: " + lateralBaseArea);
        System.out.println("Об'єм призми: " + volume);

        scanner.close();
    }
    private static void Calendar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть день (число): ");
        int day = scanner.nextInt();

        System.out.print("Введіть рік: ");
        int year = scanner.nextInt();

        Calendar calendar = new Calendar(day, year);
        calendar.DateAndDayOfWeek();

        scanner.close();
    }
}