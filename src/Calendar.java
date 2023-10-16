import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Calendar {
    private int day;
    private int year;
    public Calendar(int day, int year) {
        this.day = day;
        this.year = year;
    }
    public String DateAndDayOfWeek() {
        if (day < 1 || day > 366 || year < 1) {
            return "Некоректні дані. День повинен бути від 1 до 366, а рік більше 0.";
        }
        LocalDate date = LocalDate.of(year, 1, 1).plusDays(day - 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, EEEE, yyyy");
        return date.format(formatter);
    }
}
