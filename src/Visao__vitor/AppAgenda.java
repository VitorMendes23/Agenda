package Visao__vitor;


import java.util.Scanner;

import Negocio_Vitor.Agenda;
import Negocio_Vitor.Contato;
import Negocio_Vitor.ContatoInexistenteException;


public class AppAgenda {
	
	public static void main(String[] args) throws ContatoInexistenteException {
		
		Scanner scanner = new Scanner(System.in);

		boolean continuarPrograma = true;


		
		Contato contato1 = new Contato("Vitor","1111-5555","Rua tryCatch 45","vitor@cefet.com"); 
		Contato contato2 = new Contato("Cebolinha","2222-5555","Rua foreach 45","cebolinha@cefet.com"); 
		Contato contato3 = new Contato("Mordecayr","3333-5555","Rua ifElse 45","apenasUmShow@cefet.com"); 
		Contato contato4 = new Contato("Davi","1111-4444","Rua switchCase 45","nenem@cefet.com"); 
		
		Agenda agenda = new Agenda();
		
		
		boolean incluiu1 = agenda.incluirContato(contato1);
		boolean incluiu2 = agenda.incluirContato(contato2);
		boolean incluiu3 = agenda.incluirContato(contato3);
		boolean incluiu4 = agenda.incluirContato(contato4);
		
        System.out.print("Bem vindo(a) agenda ! \n\n");
        
        if(incluiu1 && incluiu2 && incluiu3 && incluiu4) {
            System.out.print("O contato com nome: "+ contato1.getNome() +" telefone: "+ contato1.getTelefone() +" endereço: "+ contato1.getEndereco() +"  email: "+ contato1.getEmail() +" já foi adicionado previamente! \\r\n");
            System.out.print("O contato com nome: "+ contato2.getNome() +" telefone: "+ contato2.getTelefone() +" endereço: "+ contato2.getEndereco() +"  email: "+ contato2.getEmail() +" já foi adicionado previamente! \\r\n");
            System.out.print("O contato com nome: "+ contato3.getNome() +" telefone: "+ contato3.getTelefone() +" endereço: "+ contato3.getEndereco() +"  email: "+ contato3.getEmail() +" já foi adicionado previamente! \\r\n");
            System.out.print("O contato com nome: "+ contato4.getNome() +" telefone: "+ contato4.getTelefone() +" endereço: "+ contato4.getEndereco() +"  email: "+ contato4.getEmail() +" já foi adicionado previamente! \r\n\n");

        }
        
        System.out.print("Caso queira fazer outra ação, aperte <enter>, se não digite \"sair\"\n");
        
	    String resosta = scanner.nextLine();
	    
	    if(resosta.equals("sair")) {
	    	agenda.persistirAgenda();
        	scanner.close();
        	System.out.println("Programa encerrando...");
        	System.exit(0); 
	    }
	    while (continuarPrograma) {

			System.out.printf("Digite a opção desejada:\n\n");
		    System.out.printf("Incluir contato [1]\n");
		    System.out.printf("Remover contato [2]\n");
		    System.out.printf("Ler agenda[3]\n");

		  //  System.out.printf("Mostrar tipos de triangulos do programa [4]\n");

		    int numero = scanner.nextInt();

		    if (numero < 1 || numero > 3) {
		        while (numero < 1 || numero > 4) {
		            System.out.printf("Digite uma opção válida:\n\n");
		            numero = scanner.nextInt();
		        }
		    }

		    switch (numero) {
		        case 1: {
					System.out.printf("Digite o nome :\n");
			        scanner.nextLine(); // Limpa o buffer

					String nome = scanner.nextLine();

					
					System.out.printf("Digite o telefone :\n");
					String telefone = scanner.nextLine();
					
					System.out.printf("Digite o endereco :\n");
					String endereco = scanner.nextLine();
					
					System.out.printf("Digite o email :\n");
					String email = scanner.nextLine();
					
					Contato contato = new Contato(nome,telefone,endereco,email); 
					
					//if(!agenda.existeContato(contato))
					agenda.incluirContato(contato);

					agenda.persistirAgenda();


		            break;
		        }
		        case 2: {
		        	
					System.out.printf("Digite o nome :\n");
			        scanner.nextLine(); // Limpa o buffer

					String nome = scanner.nextLine();

					
					agenda.removerContato(nome);
		        	
					agenda.persistirAgenda();
					
					System.out.println("Contato removido da agenda! \n");
		            break;
		         }
		        case 3: {
		        	
					agenda.persistirAgenda();

					agenda.lerAgenda();
		        	
		            break;
		         }

		        
		        default:
		        	
					agenda.persistirAgenda();

		            break;
		    }

		    System.out.printf("\n Deseja continuar o programa? Sim[1] Não[0]\n");

		    
		    int opcao = scanner.nextInt();

		    
		    while (opcao != 0 && opcao != 1) {
		        System.out.printf("Digite uma opção válida: 1 para Sim ou 0 para Não\n");
		        opcao = scanner.nextInt();
		        scanner.nextLine(); // Consumir o caractere '\n'

		    }

		    if (opcao == 0) {
				continuarPrograma = false;
		    	agenda.persistirAgenda();
				scanner.close();
				System.out.println("Programa encerrando...");
				System.out.println("Obrigada por utilizar o sistema!");
				System.exit(0); 

		    }
	    }
	}
}

        


		
	
	


	


