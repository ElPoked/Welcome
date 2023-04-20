package welcome;

public class Welcome {
	public static String welcome(String nom) {
		String nomMaj = firstLetterUppercase(nom);
		StringBuilder chaine = new StringBuilder("Hello, ");
		chaine.append(nomMaj);
		return chaine.toString();
	}

	public static String firstLetterUppercase(String nom) {
		String premiereLettre = nom.substring(0, 1);
		String resteNom = nom.substring(1);
		String premiereLettreMaj = premiereLettre.toUpperCase();
		return premiereLettreMaj.concat(resteNom);
	}
}
