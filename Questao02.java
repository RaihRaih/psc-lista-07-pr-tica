public class Questao02 {
        public static void main(String[] args) {
            int[][] matriz = {
                {8, 1, 6},
                {3, 5, 7},
                {4, 9, 2}
            };
    
            if (verificarQuadradoMagico(matriz)) {
                System.out.println("A matriz é um quadrado mágico.");
            } else {
                System.out.println("A matriz não é um quadrado mágico.");
            }
        }
    
        public static boolean verificarQuadradoMagico(int[][] matriz) {
            int tamanho = matriz.length;
            int somaPadrao = tamanho * (tamanho * tamanho + 1) / 2; // Soma padrão de um quadrado mágico
    
            // Verificar linhas, colunas e diagonais
            for (int i = 0; i < tamanho; i++) {
                int somaLinha = 0;
                int somaColuna = 0;
    
                for (int j = 0; j < tamanho; j++) {
                    somaLinha += matriz[i][j];
                    somaColuna += matriz[j][i];
                }
    
                if (somaLinha != somaPadrao || somaColuna != somaPadrao) {
                    return false;
                }
            }
    
            int somaDiagonalPrincipal = 0;
            int somaDiagonalSecundaria = 0;
    
            for (int i = 0; i < tamanho; i++) {
                somaDiagonalPrincipal += matriz[i][i];
                somaDiagonalSecundaria += matriz[i][tamanho - i - 1];
            }
    
            return somaDiagonalPrincipal == somaPadrao && somaDiagonalSecundaria == somaPadrao;
        }
    }
    
