import java.util.Scanner;

class Questao03 {
    private char[][] tabuleiro;
    private char jogadorAtual;

    public Questao03() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X';
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----");
            }
        }
    }

    public boolean fazerJogada(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != ' ') {
            System.out.println("Posição inválida. Tente novamente.");
            return false;
        }
        tabuleiro[linha][coluna] = jogadorAtual;
        if (verificarVitoria()) {
            System.out.println("Parabéns! O jogador " + jogadorAtual + " venceu!");
            return true;
        } else if (verificarEmpate()) {
            System.out.println("Empate! O jogo terminou sem vencedor.");
            return true;
        } else {
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            return false;
        }
    }

    private boolean verificarVitoria() {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
                return true; // Linha i
            }
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i] && tabuleiro[0][i] != ' ') {
                return true; // Coluna i
            }
        }
        // Verifica diagonais
        if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ')
                || (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' ')) {
            return true;
        }
        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();

        while (true) {
            jogo.imprimirTabuleiro();
            System.out.println("Jogador " + jogo.getJogadorAtual() + ", informe a linha (0 a 2): ");
            int linha = scanner.nextInt();
            System.out.println("Jogador " + jogo.getJogadorAtual() + ", informe a coluna (0 a 2): ");
            int coluna = scanner.nextInt();
            if (jogo.fazerJogada(linha, coluna)) {
                break;
            }
        }
        scanner.close();
    }
}
