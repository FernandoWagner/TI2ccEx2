package app;

import java.util.*;

import dao.JogoDAO;
import model.Jogo;

public class Aplicacao {

	
	public static void main(String args[]) {
		
		JogoDAO jogoDAO = new JogoDAO();
		CRUD menu = new CRUD();
		Scanner scan = new Scanner(System.in);
		
		int comando = 0;
		
		
		while(comando != 5) {
			menu.mostraMenu();
			comando = scan.nextInt();
			if(menu.isComandoValido(comando) == false) System.out.println("\nComando invalido.");
			else {
				switch(comando) {
					case 1: {
						comando = 0;
						Jogo jogo = new Jogo();
						menu.mostraInserir();
						System.out.println("id:");
						jogo.setId(scan.nextInt());
						System.out.println("nome:");
						scan.nextLine();
						jogo.setNome(scan.nextLine());
						System.out.println("downloads:");
						jogo.setDownloads(scan.nextInt());
						System.out.println("estudio:");
						scan.nextLine();
						jogo.setEstudio(scan.nextLine());
						if(jogoDAO.insert(jogo) == true) {
							System.out.println("\nInserção com sucesso -> " + jogo.toString());
						}
						break;
					}
					case 2: {
						comando = 0;
						System.out.println("\n====EXIBINDO JOGOS EM ORDEM DE NOME====\n");
						List<Jogo> jogos = jogoDAO.getOrderByNome();
						for (Jogo j: jogos) {
							System.out.println(j.toString());
						}
						System.out.println("\n====EXIBIÇÃO CONCLUIDA====");
						break;
					}
					case 3: {
						comando = 0;
						Jogo jogo = new Jogo();
						menu.mostraAtualizar1();
						int id;
						id = scan.nextInt();
						jogo = jogoDAO.get(id);
						menu.mostraAtualizar2();
						int subcomando;
						subcomando = scan.nextInt();
						switch(subcomando) {
							case 1: {
								scan.nextLine();
								subcomando = 0;
								System.out.println("\nDigite o nome: ");
								jogo.setNome(scan.nextLine());
								break;
							}
							case 2: {
								subcomando = 0;
								System.out.println("\nDigite a quantidade de downloads: ");
								jogo.setDownloads(scan.nextInt());
								break;
							}
							case 3: {
								scan.nextLine();
								subcomando = 0;
								System.out.println("\nDigite o estudio: ");
								jogo.setEstudio(scan.nextLine());
								break;
							}
						}
						if(jogoDAO.update(jogo) == true) System.out.println("\n====ATUALIZAÇÃO CONCLUIDA====");
						break;
					}
					case 4: {
						comando = 0;
						menu.mostraExcluir();
						if(jogoDAO.delete(scan.nextInt()) == true) System.out.println("\n====DELEÇÃO CONCLUIDA====");
						break;
					}
				}
			}
			
		}
		scan.close();
		System.out.println("\n====ENCERRANDO EXECUÇÃO====");
		
		
	}
	
	
	
}
