/*(Loiane - Adaptado) Faça um programa para armazenar em uma matriz os compromissos de 
uma agenda pessoal, onde, cada dia do mês deve conter 24 horas, e, para cada uma destas 
24 horas podemos associar uma tarefa específica (compromisso agendado). O programa deve 
ter um menu onde o usuário indica o dia do mês que deseja alterar e a hora, entrando em 
seguida com o compromisso, ou então, o usuário pode também consultar a agenda, fornecendo 
o dia e a hora para obter o compromisso armazenado. */
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] compromisso = new String[30][24];
        int opcao;

        while(true){
            System.out.println("Adicionar compromisso[1]:\nConsultar compromisso[2]:\nSair[0] ");
            opcao = scanner.nextInt();
            if(opcao == 0){
                break;
            }
            else if(opcao == 1){
                adicionarCompromisso(compromisso);
            }
            else if(opcao == 2){
                consultarCompromisso(compromisso);
            }
            else{
                System.out.println("Opção inválida");
            }
        
        }

    }
    public static void adicionarCompromisso(String[][] compromisso) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Digite o dia do mês (1-30): ");
        int dia = scanner.nextInt() - 1; // Subtraímos 1 para ajustar ao índice da matriz
        System.out.println("Digite a hora do compromisso (0-23): ");
        int hora = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite o compromisso: ");
        String descricao = scanner.nextLine();
    
        compromisso[dia][hora] = descricao;
        System.out.println("Compromisso adicionado com sucesso!");
    }
    
    public static void consultarCompromisso(String[][] compromisso) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Digite o dia do mês (1-30): ");
        int dia = scanner.nextInt() - 1; // Subtraímos 1 para ajustar ao índice da matriz
        System.out.println("Digite a hora do compromisso (0-23): ");
        int hora = scanner.nextInt();
    
        String compromissoConsultado = compromisso[dia][hora];
        if (compromissoConsultado != null) {
            System.out.println("Compromisso encontrado: " + compromissoConsultado);
        } else {
            System.out.println("Nenhum compromisso agendado para este horário.");
        }
    }
    
}
