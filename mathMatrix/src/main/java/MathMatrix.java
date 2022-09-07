import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathMatrix {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void sayHello() {
        System.out.println("Hello! You are using matrix calc!");
    }


    private static void chooseItem() throws Exception {
        System.out.println("Choose item which you want to calculate"
                + ": multiplication of 2 matrix or calculate deter'minant"
                + ". Write matrix or determinant.\nTo exit write \"exit\"");
        String read = reader.readLine();
        if (read.equals("matrix")) {
            calcMatrix();
        } else if (read.equals("determinant")) {
            calcDeterm();
        } else if (read.equals("exit")) {
            exit();
        } else {
            throw new Exception("Wrong input!!!");
        }
    }

    private static void calcMatrix() throws IOException {
        System.out.println("Insert amount of lines and columns of first matrix:");
        int heighta = Integer.parseInt(reader.readLine());
        int widtha = Integer.parseInt(reader.readLine());
        System.out.println("Insert amount of lines and columns of second matrix:");
        int heightb = Integer.parseInt(reader.readLine());
        int widthb = Integer.parseInt(reader.readLine());
        int[][] matrixa = new int[heighta][widtha];
        int[][] matrixb = new int[heightb][widthb];
        int[][] matrixResult = new int[heighta][widthb];
        System.out.println("Insert first matrix:");
        for (int i = 0; i < heighta; i ++) {
            for (int j = 0; j < widtha; j++) {
                matrixa[i][j] = Integer.parseInt(reader.readLine());
            }
        }
        System.out.println("Insert second matrix:");
        for (int i = 0; i < heightb; i ++) {
            for (int j = 0; j < widthb; j++) {
                matrixb[i][j] = Integer.parseInt(reader.readLine());
            }
        }
        for (int i = 0; i < heighta; i++) {
            for (int d = 0; d < widthb; d++) {
                for (int j = 0; j < widtha; j++) {
                        matrixResult[i][d] +=matrixa[i][j] * matrixb[j][d];
                }
            }
        }
        for (int i = 0; i < heighta; i++) {
            for (int j = 0; j < widthb; j++) {
                System.out.printf("%6d", matrixResult[i][j]);
            }
            System.out.print("\n");
        }
    }

    private static void calcDeterm() throws Exception {
        System.out.println("Insert degree of determinant (3 or 2):");
        int degree = Integer.parseInt(reader.readLine());
        int[][] determinant = new int[degree][degree];
        System.out.println("Insert elements of determinant:");
        for (int i = 0; i < degree; i ++) {
            for (int j = 0; j < degree; j++) {
                determinant[i][j] = Integer.parseInt(reader.readLine());
            }
        }
        int result = 0;
        if (degree == 3) {
            int diagonal = 1;
            for (int i = 0; i < degree; i++) {
                diagonal *= determinant[i][i];
            }
            result += diagonal;
            int firstTriangle = determinant[0][1] * determinant[1][2] * determinant[2][0];
            int secondTriangle = determinant[0][2] * determinant[1][0] * determinant[2][1];
            result = result + firstTriangle + secondTriangle;
            int secDiagonal = 1;
            secDiagonal = determinant[0][2] * determinant[1][1] * determinant[2][0];
            result -= secDiagonal;
            firstTriangle = determinant[0][1] * determinant[1][0] * determinant[2][2];
            secondTriangle = determinant[0][0] * determinant[1][2] * determinant[2][1];
            result = result - firstTriangle - secondTriangle;
            System.out.println(result);
        } else if (degree == 2) {
            System.out.println(determinant[0][0]*determinant[1][1] - determinant[0][1]*determinant[1][0]);
        } else {
            throw new Exception("Sorry we can count only 3 and 2 degree determinants!");
        }
    }

    private static void exit() {
        System.exit(111);
    }

    public static void main(String[] args) {
        sayHello();
        while (true) {
            try {
                chooseItem();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
