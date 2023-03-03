package app;

public class CRUD {
	
	public void mostraMenu() {
		System.out.println("\n====MENU====");
		//System.out.println("\nComandos:");
		System.out.println("\n1)Inserir\n2)Listar\n3)Atualizar\n4)Excluir\n5)Sair\n");
	}
	
	public boolean isComandoValido(int entrada) {
		boolean status = false;
		if(entrada >= 1 && entrada <= 5) status = true;
		return status;
	}
	
	public void mostraInserir() {
		System.out.println("\n====INSERIR SELECIONADO====");
		System.out.println("\nMetodo de uso:");
		//System.out.println("\nid \nnome \ndownloads \nestudio\n");
	}
	
	public void mostraAtualizar1() {
		System.out.println("\n====ATUALIZAR SELECIONADO====");
		System.out.println("\nMetodo de uso:");
		System.out.println("\nid\n");
	}
	public void mostraAtualizar2() {
		System.out.println("\nO que voce quer atualizar?");
		System.out.println("\n1)Nome\n2)Downloads\n3)Estudio\n");
	}
	
	public void mostraExcluir() {
		System.out.println("\n====EXCLUIR SELECIONADO====");
		System.out.println("\nDigite ID do jogo a ser deletado: ");
	}

}
