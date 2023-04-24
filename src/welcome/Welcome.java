package welcome;

public class Welcome {
	public static String welcome(String nom) {
		if (nom == null || (nom.trim()).equals("")) {
			return "Hello, my friend";
		} else if ((nom.toUpperCase()).equals(nom)) {
			return welcomeShoutBuilder(nom);
		} else if (twoFriends(nom)) {
			return welcomeTwoFriendsBuilder(nom);
		}
		return welcomeBuilder(nom);
	}

	public static boolean twoFriends(String nom) {
		for (int i = 0; i < nom.length(); i++) {
			if (nom.charAt(i) == ',') {
				return true;
			}
		}
		return false;
	}

	public static String welcomeTwoFriendsBuilder(String nom) {
		int i = 0;
		System.out.println(nom);
		while (nom.charAt(i) != ',') {
			i++;
		}
		String nom1 = nom.substring(0, i);
		String nom2 = nom.substring(i + 1);
		StringBuilder chaine = new StringBuilder("Hello, ");
		chaine.append(firstLetterUppercase(nom1));
		chaine.append(", ");
		chaine.append(firstLetterUppercase(nom2));
		System.out.println(chaine.toString());
		return chaine.toString();

	}

	public static String welcomeBuilder(String nom) {
		StringBuilder chaine = new StringBuilder("Hello, ");
		chaine.append(firstLetterUppercase(nom));
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
