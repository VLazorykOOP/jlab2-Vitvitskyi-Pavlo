import java.util.Scanner;
public class Point {
    private double x;
    private double y;

    // Конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттер для x
    public double getX() {
        return x;
    }

    // Геттер для y
    public double getY() {
        return y;
    }

    // Переміщення вздовж осі x
    public void moveX(double deltaX) {
        this.x += deltaX;
    }

    // Переміщення вздовж осі y
    public void moveY(double deltaY) {
        this.y += deltaY;
    }

    // Визначення відстані до початку координат
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Визначення відстані між двома точками
    public double distanceTo(Point other) {
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Перетворення до полярних координат (повертає радіус і кут у вигляді масиву)
    public double[] toPolar() {
        double r = Math.sqrt(x * x + y * y); // Радіус
        double theta = Math.atan2(y, x); // Кут у радіанах
        return new double[]{r, theta};
    }

    // Порівняння на співпадання
    public boolean equals(Point other) {
        return this.x == other.x && this.y == other.y;
    }

    // Порівняння на неспівпадання
    public boolean notEquals(Point other) {
        return !equals(other);
    }

    // Перетворення об'єкту на рядок
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }



public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Введення координат для першої точки
        System.out.print("Введіть координату x для точки 1: ");
        double x1 = sc.nextDouble();
        System.out.print("Введіть координату y для точки 1: ");
        double y1 = sc.nextDouble();
        Point p1 = new Point(x1, y1);

        // Введення координат для другої точки
        System.out.print("Введіть координату x для точки 2: ");
        double x2 = sc.nextDouble();
        System.out.print("Введіть координату y для точки 2: ");
        double y2 = sc.nextDouble();
        Point p2 = new Point(x2, y2);

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);

        // Визначення відстані від p1 до початку координат
        System.out.println("Відстань точки 1 до початку координат: " + p1.distanceFromOrigin());

        // Визначення відстані між p1 і p2
        System.out.println("Відстань між точкою 1 і точкою 2: " + p1.distanceTo(p2));

        // Перетворення до полярних координат для p1
        double[] polar = p1.toPolar();
        System.out.println("Полярні координати точки 1: Радіус = " + polar[0] + ", Кут = " + polar[1]);

        // Порівняння точок
        if (p1.equals(p2)) {
            System.out.println("Точки 1 і 2 співпадають.");
        } else {
            System.out.println("Точки 1 і 2 не співпадають.");
        }

        // Переміщення точок за введеними зсувами
        System.out.print("Введіть зсув для точки 1 по осі x: ");
        double deltaX1 = sc.nextDouble();
        System.out.print("Введіть зсув для точки 1 по осі y: ");
        double deltaY1 = sc.nextDouble();
        p1.moveX(deltaX1);
        p1.moveY(deltaY1);

        System.out.println("Точка 1 після переміщення: " + p1);
    }
}

}




	

    

