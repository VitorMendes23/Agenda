package Negocio_Vitor;

import java.util.HashMap;

import Servicos_Vitor.ManipulaArquivoTexto;

public class Agenda {
	
	private HashMap<String, Contato> contatos;
	
	public HashMap<String, Contato> getContatos() {
		return contatos;
	}
	public void setContatos(HashMap<String, Contato> contatos) {
		this.contatos = contatos;	
	}
	
	public Agenda(HashMap<String, Contato> contatos) {
		this.contatos = contatos;
	}
	public Agenda() {
		this.contatos = new HashMap<>();
	}
	
	public boolean incluirContato(Contato contato) {
		
		int tamanhoAntigo = contatos.size();
		
		contatos.put(contato.getNome(), contato);
		
		int tamanhoNovo = contatos.size();
		
		if(tamanhoAntigo == tamanhoNovo) {
			return false;
		}else
			return true;	
		
		
	}
	public boolean existeContato (Contato contato) {
		if(contatos.containsKey(contato.getNome())) {
			return true;
		}else
			return false;

	}
	public Contato consultarContato (String nome) throws ContatoInexistenteException {
		
		Contato contato = null;
		try {
			 contato = contatos.get(nome);
			
		} catch (NullPointerException e) {
	        // Caso a variável contatos seja null
	        e.printStackTrace();
	        throw new ContatoInexistenteException(nome);
	    }

	    if (!contatos.containsKey(nome)) {
	        throw new ContatoInexistenteException(nome);
	    }
		
		return contato;

	}
	
	public void removerContato(String nome) {
	    try {
	        if (contatos.containsKey(nome)) {
	            contatos.remove(nome);
	        } else {
	            throw new ContatoInexistenteException(nome);
	        }
	    } catch (ContatoInexistenteException e) {
	        e.printStackTrace(); 
	        System.out.println(e.getMessage());
	    }
	}

	
		

	public void persistirAgenda() {
		ManipulaArquivoTexto.setArquivo("agendaPessoal.txt");
		ManipulaArquivoTexto.abrirArquivoParaGravacao();
		ManipulaArquivoTexto.gravarContato(contatos, "agendaPessoal.txt");
		ManipulaArquivoTexto.fecharArquivoGravacao();
		
	}
	public void lerAgenda() {
		ManipulaArquivoTexto.setArquivo("agendaPessoal.txt");
		ManipulaArquivoTexto.abrirArquivoParaLeitura();
		
		for(Contato contato : ManipulaArquivoTexto.lerArquivo()) {
			if(!existeContato(contato))
				incluirContato(contato);
		}
		
		ManipulaArquivoTexto.fecharArquivoLeitura();
	}
}
