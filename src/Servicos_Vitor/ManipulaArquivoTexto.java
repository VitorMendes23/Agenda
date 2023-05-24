package Servicos_Vitor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import Negocio_Vitor.Contato;

public class ManipulaArquivoTexto {

	private static String arquivo;
	private static Formatter gravador;
	private static Scanner leitor;
	
    public static void setArquivo(String arquivo) {
        ManipulaArquivoTexto.arquivo = arquivo;
    }
	
	public static void abrirArquivoParaGravacao() {
        try {
            gravador = new Formatter(arquivo);
        } catch (FileNotFoundException | SecurityException e) {
            System.err.println("Erro ao criar arquivo.");
            //System.exit(1);
        }		
	}
	public static void gravarContato(HashMap<String, Contato> contatos, String nomeArquivo) {
	    try {
	        gravador = new Formatter(nomeArquivo);
	        for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
	            //String chave = entry.getKey();
	            Contato contato = entry.getValue();
	            gravador.format("%s %s %s %s%n", contato.getNome(), contato.getTelefone(), contato.getEndereco(), contato.getEmail());
	        }
	    } catch (FileNotFoundException e) {
	        System.err.print("O arquivo não foi encontrado!");	
	        //System.exit(1);
	    }
	    
	    fecharArquivoGravacao();
	}

	public static void fecharArquivoGravacao() {
		//if
		if (gravador != null) 
			gravador.close();

	}
	public static void abrirArquivoParaLeitura() {
		try {
            //File arquivo1 = new File(arquivo);
			leitor = new Scanner(Paths.get("agendaPessoal.txt"));
			
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }
            
            //leitor.close();
            
		}
	     catch (FileNotFoundException e) {
		        System.err.println("Arquivo não encontrado.");
		    //    System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        System.err.println("Erro ao ler o arquivo.");
	       // System.exit(1);
		}

			
	}

	public static ArrayList<Contato> lerArquivo(){
		
		ArrayList<Contato> contatos = new ArrayList<>();
		
		try {
			leitor = new Scanner(Paths.get(arquivo));
			while (!leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] infomacao = linha.split(":");
                Contato contato = new Contato(infomacao[0], infomacao[1], infomacao[2], infomacao[3]);
                contatos.add(contato);

			} 
		}catch (IOException e) {
				// TODO Auto-generated catch block
	            System.err.println("Erro ao ler o arquivo.");
	            System.exit(1);
				e.printStackTrace();
			}

		return contatos;
	}
	public static void fecharArquivoLeitura() {
        if (leitor != null) 
            leitor.close();
        
	}
}
