import java.util.Scanner;

public class Matrix {
    private double[][] matrix;

    // Конструктор для матриці 2х2
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    // Виведення матриці
    public void printMatrix() {
        for (int i = 0; i < 2; i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1]);
        }
    }

    // Детермінант
    public double determinant() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // Обернена матриця
    public Matrix inverse() {
        double det = determinant();
        if (det == 0) {
            throw new ArithmeticException("Матриця вироджена, оберненої не існує.");
        }
        return new Matrix(new double[][]{
            {matrix[1][1] / det, -matrix[0][1] / det},
            {-matrix[1][0] / det, matrix[0][0] / det}
        });
    }

    // Множення на іншу матрицю
    public Matrix multiply(Matrix other) {
        return new Matrix(new double[][]{
            {matrix[0][0] * other.matrix[0][0] + matrix[0][1] * other.matrix[1][0], 
             matrix[0][0] * other.matrix[0][1] + matrix[0][1] * other.matrix[1][1]},
            {matrix[1][0] * other.matrix[0][0] + matrix[1][1] * other.matrix[1][0], 
             matrix[1][0] * other.matrix[0][1] + matrix[1][1] * other.matrix[1][1]}
        });
    }

    // Додавання матриць
    public Matrix add(Matrix other) {
        return new Matrix(new double[][]{
            {matrix[0][0] + other.matrix[0][0], matrix[0][1] + other.matrix[0][1]},
            {matrix[1][0] + other.matrix[1][0], matrix[1][1] + other.matrix[1][1]}
        });
    }

    // Множення на скаляр
    public Matrix multiplyByScalar(double scalar) {
        return new Matrix(new double[][]{
            {matrix[0][0] * scalar, matrix[0][1] * scalar},
            {matrix[1][0] * scalar, matrix[1][1] * scalar}
        });
    }

    // Метод для введення матриці
    public static Matrix inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        double[][] mat = new double[2][2];
        System.out.println("Введіть елементи матриці 2x2:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mat[i][j] = scanner.nextDouble();
            }
        }
        return new Matrix(mat);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Matrix matrix1 = inputMatrix();
        Matrix matrix2 = inputMatrix();

        System.out.println("\nМатриця 1:");
        matrix1.printMatrix();

        System.out.println("\nМатриця 2:");
        matrix2.printMatrix();

        System.out.println("\nДетермінант матриці 1: " + matrix1.determinant());

        try {
            System.out.println("\nОбернена матриця до матриці 1:");
            matrix1.inverse().printMatrix();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nМноження матриці 1 на матрицю 2:");
        matrix1.multiply(matrix2).printMatrix();

        System.out.println("\nДодавання матриць:");
        matrix1.add(matrix2).printMatrix();

        // Введення числа для множення
        System.out.print("\nВведіть число, на яке буде множитись матриця 1: ");
        double scalar = scanner.nextDouble();

        System.out.println("\nМноження матриці 1 на число " + scalar + ":");
        matrix1.multiplyByScalar(scalar).printMatrix();
    }
}
