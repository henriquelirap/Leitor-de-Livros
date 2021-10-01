package leitor;

import java.util.Comparator;

public class OrdenaQtePalavras implements Comparator<Livro> {
	
	@Override
	public int compare(Livro o1, Livro o2) {
		return  Integer.compare(o1.getQte_palavras(),o2.getQte_palavras());
	}
}