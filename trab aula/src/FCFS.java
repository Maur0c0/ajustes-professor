import java.util.Random;
import java.util.Scanner;

public class FCFS {
	Random gerador = new Random();
	Scanner teclado = new Scanner(System.in);
	double num_processos;
	double temp_execucao[], temp_em_execucao,temp_restante[], temp_espera=0;
	int processo_em_execucao=0;
	double media;
	
	public FCFS(int num_processos) {
		this.num_processos = num_processos;
		temp_execucao = new double[num_processos];
		temp_restante = new double[num_processos];
	}
	
	public void popularProcessos() {
		int menu = -1;
		System.out.println();
		System.out.println("=== TEMPO DE EXECUCAO ===");
		System.out.println("(1) - Automatico");
		System.out.println("(2) - Manual");
		menu = teclado.nextInt();
		
		if(menu == 1) {
			for(int i=0; i < num_processos; i++) {
				temp_execucao[i] = gerador.nextInt(10);
				temp_restante[i] = temp_execucao[i];
			}
		}else {
			int entrada;
			for(int i=0; i < num_processos; i++) {
				System.out.println("Digite o tempo de execucao do processo (p" + (i+1) + ") : ");
				entrada = teclado.nextInt();
				temp_execucao[i] = entrada;
				temp_restante[i] = temp_execucao[i];
			}
		}
	}
	
	public void executar() {				
		for(int tempo=1; tempo < 1000; tempo++) {
			if(temp_restante[processo_em_execucao]!=0) {
				System.out.println(tempo + ": Processo " + processo_em_execucao);
				temp_restante[processo_em_execucao]--;
				if (temp_restante[processo_em_execucao] == temp_execucao[processo_em_execucao])
					temp_espera = tempo;
			}
			else
			{
				if (processo_em_execucao < num_processos) {
					processo_em_execucao++;
					System.out.println(tempo + ": Processo " + processo_em_execucao);
					temp_restante[processo_em_execucao]--;
					if (temp_restante[processo_em_execucao] == temp_execucao[processo_em_execucao]) {
						temp_espera = tempo;
					}
				}
				else
					break;
			}
			
			/*for(int i=0; i < num_processos; i++) {
				System.out.println(tempo + " Processo:" + i);
				if(temp_execucao[i] == tempo) {
					temp_em_execucao = temp_em_execucao + tempo;
					System.out.println("Processo " + (i+1) + " finalizado! Tempo necessario para ser executado: " + tempo);
					System.out.println("Tempo de espera: " + temp_espera);
					System.out.println();
					temp_espera += tempo;
				}
			}*/
		}
		/*double mediaArredondada = Math.ceil(temp_em_execucao/num_processos);
		System.out.println("Tempo TOTAL de execucao: " + temp_em_execucao);
		System.out.println("Tempo MEDIO de execução: " + mediaArredondada);*/
	}
}
