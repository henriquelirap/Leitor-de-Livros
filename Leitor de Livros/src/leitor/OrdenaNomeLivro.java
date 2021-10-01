package leitor;

import java.util.Comparator;

public class OrdenaNomeLivro implements Comparator<Livro> {
	
	@Override
	public int compare(Livro o1, Livro o2) {
		return o1.getNome_livro().compareTo(o2.getNome_livro());
	}
}