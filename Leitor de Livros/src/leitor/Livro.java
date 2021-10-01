package leitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Livro {

	private String nome_livro;
	private String autor;
	private String ano_publicacao;
	private int qte_palavras;
	private StringBuilder conteudo = new StringBuilder();
	private int qte_distintas;
	private int vezesAnyoneLivro;
	private String maiorPalavraFrequenciaLivro;
	private int maiorFrequenciaLivro;
	private String menorPalavraFrequenciaLivro;
	private int menorFrequenciaLivro;
	
	public String getMenorPalavraFrequenciaLivro() {
		return menorPalavraFrequenciaLivro;
	}

	public void setMenorPalavraFrequenciaLivro(String menorPalavraFrequenciaLivro) {
		this.menorPalavraFrequenciaLivro = menorPalavraFrequenciaLivro;
	}

	public int getMenorFrequenciaLivro() {
		return menorFrequenciaLivro;
	}

	public void setMenorFrequenciaLivro(int menorFrequenciaLivro) {
		this.menorFrequenciaLivro = menorFrequenciaLivro;
	}

	public Livro(String nome_livro, String autor, String ano_publicacao, int qte_palavras,
			StringBuilder conteudo, int qte_distintas, int vezesAnyoneLivro, String maiorPalavraFrequenciaLivro, int maiorFrequenciaLivro, String menorPalavraFrequenciaLivro, int menorFrequenciaLivro) {
		this.setNome_livro(nome_livro);
		this.setAutor(autor);
		this.setAno_publicacao(ano_publicacao);
		this.setQte_palavras(qte_palavras);
		this.setConteudo(conteudo);
		this.setQte_distintas(qte_distintas);
		this.setVezesAnyoneLivro(vezesAnyoneLivro);
		this.setMaiorPalavraFrequenciaLivro(maiorPalavraFrequenciaLivro);
		this.setMaiorFrequenciaLivro(maiorFrequenciaLivro);
		this.setMenorPalavraFrequenciaLivro(menorPalavraFrequenciaLivro);
		this.setMenorFrequenciaLivro(menorFrequenciaLivro);
	}

	@Override
	public String toString() {
		return "\n\n[Livro]: " + nome_livro + "\n[Autor]: " + autor + "\n[Publicado]: " + ano_publicacao
				+ "\n[Palavras]: " + qte_palavras +"\n[Palavras Distintas]: " +qte_distintas+ "\n[Palavra Escolhida]: " +vezesAnyoneLivro+ "\n[Maior Frequência]: " +maiorPalavraFrequenciaLivro+ ", " +maiorFrequenciaLivro+ "\n[Menor Frequência]: " +menorPalavraFrequenciaLivro+ ", " +menorFrequenciaLivro;
	}

	public String getNome_livro() {
		return nome_livro;
	}

	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(String ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}

	public int getQte_palavras() {
		return qte_palavras;
	}

	public void setQte_palavras(int qte_palavras) {
		this.qte_palavras = qte_palavras;
	}

	public StringBuilder getConteudo() {
		return conteudo;
	}

	public void setConteudo(StringBuilder conteudo) {
		this.conteudo = conteudo;
	}

	public int getQte_distintas() {
		return qte_distintas;
	}

	public void setQte_distintas(int qte_distintas) {
		this.qte_distintas = qte_distintas;
	}

	public int getVezesAnyoneLivro() {
		return vezesAnyoneLivro;
	}

	public void setVezesAnyoneLivro(int vezesAnyoneLivro) {
		this.vezesAnyoneLivro = vezesAnyoneLivro;
	}

	public String getMaiorPalavraFrequenciaLivro() {
		return maiorPalavraFrequenciaLivro;
	}

	public void setMaiorPalavraFrequenciaLivro(String maiorPalavraFrequenciaLivro) {
		this.maiorPalavraFrequenciaLivro = maiorPalavraFrequenciaLivro;
	}

	public int getMaiorFrequenciaLivro() {
		return maiorFrequenciaLivro;
	}

	public void setMaiorFrequenciaLivro(int maiorFrequenciaLivro) {
		this.maiorFrequenciaLivro = maiorFrequenciaLivro;
	}
	

}
	

