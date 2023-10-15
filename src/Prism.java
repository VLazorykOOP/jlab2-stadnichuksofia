public class Prism {
    private double height;
    private double sideLength;
    
    // Конструктор класу
    public Prism(double height, double sideLength) {
        this.height = height;
        this.sideLength = sideLength;
    }
    // Метод для площі бічної призми
    public double lateralBaseArea() {
        double perimeter = 3 * sideLength;
        return (perimeter * height);
    }
    // Метод для знаходження об'єму призми
    public double volume() {
        double baseArea = (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
        return baseArea * height;
    }
}
