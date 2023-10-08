import java.util.Scanner;

public class Task2Prism {
    private double height;
    private double sideLength;

    // Конструктор класу
    public Task2Prism(double height, double sideLength) {
        this.height = height;
        this.sideLength = sideLength;
    }

    // Метод для знаходження площі бічної основи призми
    public double lateralBaseArea() {
        double perimeter = 3 * sideLength;
        return (perimeter * height);
    }

    // Метод для знаходження об'єму призми
    public double volume() {
        double baseArea = (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
        return baseArea * height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту призми: ");
        double height = scanner.nextDouble();

        System.out.print("Введіть довжину сторони основи призми: ");
        double sideLength = scanner.nextDouble();

        Task2Prism prism = new Task2Prism(height, sideLength);
        double lateralBaseArea = prism.lateralBaseArea();
        double volume = prism.volume();

        System.out.println("Площа бічної основи призми: " + lateralBaseArea);
        System.out.println("Об'єм призми: " + volume);

        scanner.close();
    }
}
