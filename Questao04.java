import java.util.Scanner;

class Questao04 {
    private double[][] matriz;

    public Questao04() {
        matriz = new double[4][4];
    }

    public void preencherMatriz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Preencha a matriz 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Insira o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();
    }

    public void exibirDiagonais() {
        System.out.println("Diagonal principal:");
        for (int i = 0; i < 4; i++) {
            System.out.println(matriz[i][i]);
        }
        System.out.println("Diagonal secundária:");
        for (int i = 0; i < 4; i++) {
            System.out.println(matriz[i][3 - i]);
        }
    }

    public void exibirTransposta() {
        System.out.println("Matriz transposta:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz();
        matriz.preencherMatriz();
        matriz.exibirDiagonais();
        matriz.exibirTransposta();
    }
}
