import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;

public class Calendar {
    private int day;
    private int year;
    public Calendar(int day, int year) {
        this.day = day;
        this.year = year;
    }
    public void DateAndDayOfWeek() {
        LocalDate date = LocalDate.ofYearDay(year, day);
        Month month = date.getMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String[] months = {"січень", "лютий", "березень", "квітень", "травень", "червень", "липень", "серпень", "вересень", "жовтень", "листопад", "грудень"};
        String[] daysOfWeek = {"неділя", "понеділок", "вівторок", "середа", "четвер", "п'ятниця", "субота"};

        System.out.println(day + " " + months[month.getValue() - 1] + ", " + daysOfWeek[dayOfWeek.getValue() - 1]);
    }
}

