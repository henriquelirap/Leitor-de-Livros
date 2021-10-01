package leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class LeitorLivros {
	public static void main(String[] args) throws IOException {	
		HashSet<String> totalDistintas = new HashSet<String>();
		HashMap<String, Integer> contadorHash = new HashMap<String, Integer>();
		ArrayList<Livro> biblioteca = new ArrayList<Livro>();
		Scanner scn = new Scanner(System.in);
		String endereco = "";
    	String st;
    	boolean work = true;
    	int vezesAnyoneBiblioteca = 0;

        while(work) {     	
        	System.out.println("Ex: C:\\Users\\henri\\Desktop\\texto.txt \nInsira o endereço do livro ou X para encerrar: ");
        	endereco = scn.next();
            if(endereco.equalsIgnoreCase("X")) {
                work = false;
                System.out.println("Programa encerrado!\n");   
            } else {
            	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(endereco), "UTF-8"));
            	HashSet<String> filtroDistintas = new HashSet<String>();
            	StringBuilder conteudo = new StringBuilder();
            	String preencher[];
            	String contador[];
            	String nome_livro = "";
            	String autor = "";
            	String ano_publicacao = "";           	
            	int qte_palavras = 0;
            	int qte_distintas = 0;
            	int i = 0;
            	int vezesAnyoneLivro = 0;
            	int maiorFrequenciaLivro = 0;
            	String maiorPalavraFrequenciaLivro = "";
            	int menorFrequenciaLivro = 0;
            	String menorPalavraFrequenciaLivro = "";
            	String[] cincoPalavrasMais = null;
            	    	
            	//Popular nome_livro, autor, ano_publicacao;
				while ((st = br.readLine()) != null) {	
					if(i == 0) {
						preencher = st.split("/");
						nome_livro = preencher[0];
						autor = preencher[1].trim();
						ano_publicacao = preencher[2].trim();
						i++;
					}
					
					//Popular conteudo, remover caracteres não-alfanuméricos e espaços duplicados;
					st = st.replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s+", " ");
					conteudo.append(st.toLowerCase()).append("\n");
					
					//Contador de palavras;
					contador = st.split(" ");
					qte_palavras = qte_palavras + contador.length;

					for(int j = 0; j < contador.length; j++) {
						if(contador[j].isEmpty() || contador[j].isBlank()) {
							qte_palavras--;
						}
					}
					
					//3b. Contador de palavras distintas em cada livro;
					//3c. Contador de palavras distintas em toda a biblioteca;
					for(int j = 0; j < contador.length; j++) {
						if(!(contador[j].isBlank()) || !(contador[j].isBlank())) {
							filtroDistintas.add(contador[j]);
							totalDistintas.add(contador[j]);
							qte_distintas = filtroDistintas.size();
						}
					}
					
					//3d. Contador de vezes da palavra escolhida;
					//3e. Contador de vezes da palavra escolhida em toda a bilioteca;
					for(int j = 0; j < contador.length; j++) {
						if(contador[j].equals("anyone")) {
							vezesAnyoneLivro++;
						}
					}
					
					// Mapeando contagem de ocorrências de palavras;
					for(String c : contador) {
						if(contadorHash.containsKey(c)) {
							contadorHash.put(c, contadorHash.get(c) + 1);
						} else if(!(c.isEmpty()) || !(c.isBlank())) {
							contadorHash.put(c, 1);
						}
					}
				
					//3f. Contando palavra mais frequente em cada livro; 
					HashMap.Entry<String, Integer> maxEntry = null;
					Integer max = Collections.max(contadorHash.values());
				    for(HashMap.Entry<String, Integer> entry : contadorHash.entrySet()) {
				        Integer valor = entry.getValue();
				        if(max == valor) {
				            maxEntry = entry;
				            maiorPalavraFrequenciaLivro = maxEntry.getKey();
				            maiorFrequenciaLivro = maxEntry.getValue();
				            
				        }
				    }
				    
				  //3g. Contando palavra menos frequente em cada livro; 
					HashMap.Entry<String, Integer> minEntry = null;
					Integer min = Collections.min(contadorHash.values());
				    for(HashMap.Entry<String, Integer> entry : contadorHash.entrySet()) {
				        Integer valor = entry.getValue();
				        if(min == valor) {
				        	minEntry = entry;
				            menorPalavraFrequenciaLivro = minEntry.getKey();
				            menorFrequenciaLivro = minEntry.getValue();
				            
				        }
				    }
				}
				
				// 2. Adicionando os dados a variável biblioteca e ordenando
				biblioteca.add(new Livro(nome_livro, autor, ano_publicacao, 
				qte_palavras, conteudo, qte_distintas, vezesAnyoneLivro, maiorPalavraFrequenciaLivro, 
				maiorFrequenciaLivro, menorPalavraFrequenciaLivro, menorFrequenciaLivro));
				
				vezesAnyoneBiblioteca = vezesAnyoneBiblioteca + vezesAnyoneLivro;
			
            }  
        }
        
        System.out.println("[APRESENTANDO SUA BIBLIOTECA DE LIVROS]:");
        
        System.out.println("\n[Ordenação por Nome do Livro]");
        Collections.sort(biblioteca, new OrdenaNomeLivro());
        System.out.println(biblioteca);
        
        System.out.println("\n[Ordenação por Autor]");
        Collections.sort(biblioteca, new OrdenaAutor());
        System.out.println(biblioteca);
        
        System.out.println("\n[Ordenação por Ano]");
        Collections.sort(biblioteca, new OrdenaAnoPublicacao());
        System.out.println(biblioteca);
        
        System.out.println("\n[Ordenação por Quantidade de Palavras]");
        Collections.sort(biblioteca, new OrdenaQtePalavras());
        System.out.println(biblioteca);
        
        //3a. Apresentando os dados em um método toString;
        /*for(Livro b : biblioteca) {
    	  System.out.println(b.toString()+"\n");
        }*/
        
        // Total de palavras distintas em toda a biblioteca;
        System.out.println("\n[Palavras Distintas na Biblioteca]: "+totalDistintas.size());
        
        //Total de vezes da palavra escolhida em toda a biblioteca;
        System.out.println("[Palavra Escolhida na Biblioteca]: "+vezesAnyoneBiblioteca);
	}	
}
	