import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
public class Date {
    private int year;
    private byte month;
    private byte day;

    public Date(int year, byte month, byte day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        java.util.Date date = dateFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.year = calendar.get(Calendar.YEAR);
        this.month = (byte) (calendar.get(Calendar.MONTH) + 1);
        this.day = (byte) calendar.get(Calendar.DAY_OF_MONTH);
    }
    public Date addDays(int daysToAdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        return new Date(
                calendar.get(Calendar.YEAR),
                (byte) (calendar.get(Calendar.MONTH) + 1),
                (byte) calendar.get(Calendar.DAY_OF_MONTH)
        );
    }
    public Date subtractDays(int daysToSubtract) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract);
        return new Date(
                calendar.get(Calendar.YEAR),
                (byte) (calendar.get(Calendar.MONTH) + 1),
                (byte) calendar.get(Calendar.DAY_OF_MONTH)
        );

    }
    public boolean isLeapYear() {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
    public java.util.Date toDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String dateStr = String.format("%04d.%02d.%02d", year, month, day);
        return dateFormat.parse(dateStr);
    }
    @Override
    public String toString() {
        return String.format("%04d.%02d.%02d", year, month, day);
    }
    public long calculateDifference(Date date2) throws ParseException {
        return this.toDate().getTime() - date2.toDate().getTime();
    }
    public long calculateDifferenceInDays(Date date2) throws ParseException {
        long differenceInMilliseconds = Math.abs(this.toDate().getTime() - date2.toDate().getTime());
        return TimeUnit.DAYS.convert(differenceInMilliseconds, TimeUnit.MILLISECONDS);
    }
}
