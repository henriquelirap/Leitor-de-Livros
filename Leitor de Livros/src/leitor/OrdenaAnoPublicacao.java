package leitor;

import java.util.Comparator;

public class OrdenaAnoPublicacao implements Comparator<Livro> {
	
	@Override
	public int compare(Livro o1, Livro o2) {
		return o1.getAno_publicacao().compareTo(o2.getAno_publicacao());
	}
}