package welcome;

public class Welcome {
	public static String welcome(String nom) {
		if (nom == null || (nom.trim()).equals("")) {
			return "Hello, my friend";
		}
		if ((nom.toUpperCase()).equals(nom)) {
			return welcomeShoutBuilder(nom);
		}
		return welcomeBuilder(nom);
	}

	public static String welcomeBuilder(String nom) {
		String nomMaj = firstLetterUppercase(nom);
		StringBuilder chaine = new StringBuilder("Hello, ");
		chaine.append(nomMaj);
		return chaine.toString();
	}

	public static String welcomeShoutBuilder(String nom) {
		String nomFullCaps = nom.toUpperCase();
		StringBuilder chaine = new StringBuilder("HELLO, ");
		chaine.append(nomFullCaps);
		chaine.append(" !");
		return chaine.toString();
	}

	public static String firstLetterUppercase(String nom) {
		String premiereLettre = nom.substring(0, 1);
		String resteNom = nom.substring(1);
		String premiereLettreMaj = premiereLettre.toUpperCase();
		return premiereLettreMaj.concat(resteNom);
	}
}
