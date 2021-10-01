package leitor;

import java.util.Comparator;

public class OrdenaAutor implements Comparator<Livro> {
	
	@Override
	public int compare(Livro o1, Livro o2) {
		return o1.getAutor().compareTo(o2.getAutor());
	}
}