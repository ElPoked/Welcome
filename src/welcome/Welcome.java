package welcome;

public class Welcome {
	public static String welcome(String nom) {
		if (nom == null || (nom.trim()).equals("")) {
			return "Hello, my friend";
		} else if ((nom.toUpperCase()).equals(nom)) {
			return welcomeShoutBuilder(nom);
		} else if (Friends(nom)) {
			return welcomeFriendsBuilder(nom);
		}
		return welcomeBuilder(nom);
	}

	public static boolean Friends(String nom) {
		for (int i = 0; i < nom.length(); i++) {
			if (nom.charAt(i) == ',') {
				return true;
			}
		}
		return false;
	}

	public static int numberFriends(String nom) {
		int nbFriends = 1;
		for (int i = 0; i < nom.length(); i++) {
			if (nom.charAt(i) == ',') {
				nbFriends++;
			}
		}
		return nbFriends;
	}

	public static String[] friendsNames(String nom) {
		String[] names = new String[numberFriends(nom)];
		int endLastName = 0;
		int j = 0;
		for (int i = 0; i < nom.length(); i++) {
			if (nom.charAt(i) == ',') {
				if (nom.charAt(i + 1) == ' ') {
					names[j] = nom.substring(endLastName, i);
					j++;
					endLastName = i + 2;
				} else {
					names[j] = nom.substring(endLastName, i);
					j++;
					endLastName = i + 1;
				}

			}
		}
		names[j] = nom.substring(endLastName, nom.length());
		return names;
	}

	public static String welcomeFriendsBuilder(String nom) {
		String[] names = friendsNames(nom);
		StringBuilder chaine = new StringBuilder("Hello, ");
		for (int i = 0; i < names.length - 1; i++) {
			chaine.append(firstLetterUppercase(names[i]));
			chaine.append(", ");
		}
		chaine.append(firstLetterUppercase(names[names.length - 1]));
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
