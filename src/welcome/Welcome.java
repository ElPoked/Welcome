package welcome;

public class Welcome {
	public static String welcome(String nom) {
		if (nom == null || (nom.trim().equals(""))) {
			return "Hello, my friend";
		}
		String name = byeByeSpaces(nom);
		if ((name.toUpperCase()).equals(name)) {
			return welcomeShoutBuilder(name);
		} else if (friends(name)) {
			return welcomeFriendsBuilder(name);
		}
		return welcomeBuilder(name);
	}

	public static String byeByeSpaces(String nom) {
		return nom.replace(" ", "");
	}

	public static boolean friends(String nom) {
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
				names[j] = nom.substring(endLastName, i);
				j++;
				endLastName = i + 1;
			}
		}
		names[j] = nom.substring(endLastName, nom.length());
		return names;
	}

	public static int nbFriendsFullCapsNames(String nom) {
		String[] names = friendsNames(nom);
		int nbFullCapsNames = 0;
		for (int i = 0; i < names.length; i++) {
			if ((names[i].toUpperCase()).equals(names[i])) {
				nbFullCapsNames++;
			}
		}
		return nbFullCapsNames;
	}

	public static String[] friendsFullCapsNames(String nom) {
		String[] names = friendsNames(nom);
		String[] fullCapsNames = new String[nbFriendsFullCapsNames(nom)];
		int j = 0;
		for (int i = 0; i < names.length; i++) {
			if ((names[i].toUpperCase()).equals(names[i])) {
				fullCapsNames[j] = names[i];
				j++;
			}
		}
		return fullCapsNames;
	}

	public static String[] friendsNoFullCapsNames(String nom) {
		String[] names = friendsNames(nom);
		String[] noFullCapsNames = new String[numberFriends(nom) - nbFriendsFullCapsNames(nom)];
		int j = 0;
		for (int i = 0; i < names.length; i++) {
			if (!(names[i].toUpperCase()).equals(names[i])) {
				noFullCapsNames[j] = names[i];
				j++;
			}
		}
		return noFullCapsNames;
	}

	private static String[] distinctNames(String[] names) {
		String[] sort_names = new String[names.length];
		int size_sort_names = 0;

		for (int i = 0; i < names.length; i++) {
			if (!in_list(sort_names, size_sort_names, names[i])) {
				sort_names[size_sort_names] = firstLetterUppercase(names[i]);
				size_sort_names++;
			}
		}

		String[] final_list = new String[size_sort_names];
		for (int i = 0; i < size_sort_names; i++) {
			final_list[i] = sort_names[i];
		}

		return final_list;

	}

	private static boolean in_list(String[] list, int size, String name) {
		for (int i = 0; i < size; i++) {
			if (name.equals(name.toUpperCase())) {
				if (name.equals(list[i])) {
					return true;
				}
			} else {
				if (firstLetterUppercase(name).equals(firstLetterUppercase(list[i]))) {
					return true;
				}
			}
		}
		return false;
	}

	public static int[] numFriendsNames(String[] names, String[] distinctNames) {
		int[] numNames = new int[distinctNames.length];
		for (int i = 0; i < numNames.length; i++) {
			numNames[i] = 0;
		}
		for (int i = 0; i < distinctNames.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (firstLetterUppercase(names[j]).equals(distinctNames[i])) {
					numNames[i]++;
				}
			}
		}
		return numNames;
	}

	public static String welcomeFriendsBuilder(String nom) {
		String[] noFullCapsNames = distinctNames(friendsNoFullCapsNames(nom));
		int[] numNoFullCapsNames = numFriendsNames(friendsNoFullCapsNames(nom), noFullCapsNames);
		String[] fullCapsNames = distinctNames(friendsFullCapsNames(nom));
		int[] numFullCapsNames = numFriendsNames(friendsFullCapsNames(nom), fullCapsNames);
		StringBuilder chaine = new StringBuilder(welcomeNoFullCapsFriends(noFullCapsNames, numNoFullCapsNames));
		if (fullCapsNames.length > 0) {
			chaine.append(welcomeShoutFriendsBuilder(fullCapsNames, numFullCapsNames));
		}
		return chaine.toString();
	}

	public static String welcomeNoFullCapsFriends(String[] names, int[] numNames) {
		StringBuilder chaine = new StringBuilder("Hello, ");
		for (int i = 0; i < names.length - 1; i++) {
			chaine.append(names[i]);

			if (numNames[i] > 1) {
				chaine.append("(x");
				chaine.append(numNames[i]);
				chaine.append(")");
			}
			if (i < names.length - 2) {
				chaine.append(", ");
			}
		}
		if (names.length > 1) {
			chaine.append(" and ");
		}
		chaine.append(names[names.length - 1]);
		if (numNames[numNames.length - 1] > 1) {
			chaine.append("(x");
			chaine.append(numNames[numNames.length - 1]);
			chaine.append(")");
		}
		return chaine.toString();
	}

	public static String welcomeShoutFriendsBuilder(String[] names, int[] numNames) {
		StringBuilder chaine = new StringBuilder(". AND HELLO, ");
		for (int i = 0; i < names.length - 1; i++) {
			chaine.append(names[i]);
			if (numNames[i] > 1) {
				chaine.append("(x");
				chaine.append(numNames[i]);
				chaine.append(")");
			}
			if (i < names.length - 2) {
				chaine.append(", ");
			}
		}
		if (names.length > 1) {
			chaine.append(" AND ");
		}
		chaine.append(names[names.length - 1]);
		if (numNames[numNames.length - 1] > 1) {
			chaine.append("(x");
			chaine.append(numNames[numNames.length - 1]);
			chaine.append(")");
		}
		chaine.append(" !");

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
