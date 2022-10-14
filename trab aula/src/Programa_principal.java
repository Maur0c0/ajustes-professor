import java.util.Scanner;

public class Programa_principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		int menu = -1, numProcessos;
		System.out.println("Digite o numero de processos");
		numProcessos = teclado.nextInt();
			
		menu = -1;
		while(menu != 0){
			System.out.println();
			System.out.println("=== MENU ===");
			System.out.println("(1) - FCFS");
			System.out.println("(0) - Sair");
			menu = teclado.nextInt();
			
			if(menu < 0) {
				System.out.println("***Opcao invalida***");
			}
			else if(menu == 1) {
				FCFS fcfs = new FCFS(numProcessos);
				fcfs.popularProcessos();
				fcfs.executar();
			}
			
			
			
			
		}
		

	}

}
