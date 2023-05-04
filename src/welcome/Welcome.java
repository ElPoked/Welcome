package welcome;

public class Welcome {
	public static String welcome(String nom) {
		if (nom == null || (nom.trim().equals(""))) {
			return "Hello, my friend";
		}
		String name = byeByeSpaces(nom);
		return welcomeFriends(name);
	}

	private static String byeByeSpaces(String nom) {
		return nom.replace(" ", "");
	}

	private static int numberFriends(String nom) {
		int nbFriends = 1;
		for (int i = 0; i < nom.length(); i++) {
			if (nom.charAt(i) == ',') {
				nbFriends++;
			}
		}
		return nbFriends;
	}

	private static String[] friendsNames(String nom) {
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

	private static int nbFriendsFullCapsNames(String nom) {
		String[] names = friendsNames(nom);
		int nbFullCapsNames = 0;
		for (int i = 0; i < names.length; i++) {
			if ((names[i].toUpperCase()).equals(names[i])) {
				nbFullCapsNames++;
			}
		}
		return nbFullCapsNames;
	}

	private static String[] friendsFullCapsNames(String nom) {
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

	private static String[] friendsNoFullCapsNames(String nom) {
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

	private static int[] numFriendsNames(String[] names, String[] distinctNames) {
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

	private static String welcomeFriends(String nom) {
		String[] noFullCapsNames = distinctNames(friendsNoFullCapsNames(nom));
		int[] numNoFullCapsNames = numFriendsNames(friendsNoFullCapsNames(nom), noFullCapsNames);
		String[] fullCapsNames = distinctNames(friendsFullCapsNames(nom));
		int[] numFullCapsNames = numFriendsNames(friendsFullCapsNames(nom), fullCapsNames);
		StringBuilder chaine = new StringBuilder();
		if (noFullCapsNames.length > 0) {
			chaine.append(welcomeFriendsBuilder(noFullCapsNames, numNoFullCapsNames, false,
					in_list(noFullCapsNames, noFullCapsNames.length, "Yoda")));
		}

		if (fullCapsNames.length > 0) {
			if (nbFriendsFullCapsNames(nom) != numberFriends(nom)) {
				chaine.append(". AND ");
			}
			chaine.append(welcomeFriendsBuilder(fullCapsNames, numFullCapsNames, true,
					in_list(fullCapsNames, fullCapsNames.length, "YODA")));
		}
		return chaine.toString();
	}

	private static String welcomeFriendsBuilder(String[] names, int[] numNames, boolean upp, boolean yoda) {
		StringBuilder chaine = new StringBuilder();
		chaine.append(stringNames(names, numNames));
		if (names.length > 1 && upp) {
			chaine.append(" AND ");
		} else if (names.length > 1) {
			chaine.append(" and ");
		}
		chaine.append(names[names.length - 1]);
		if (numNames[numNames.length - 1] > 1) {
			chaine.append(numFriendsInParentesis(numNames[numNames.length - 1]));
		}
		if (yoda && upp) {
			chaine.append(", HELLO !");
		} else if (yoda) {
			chaine.append(", Hello");
		} else if (upp) {
			chaine.insert(0, "HELLO, ");
			chaine.append(" !");
		} else {
			chaine.insert(0, "Hello, ");
		}
		return chaine.toString();
	}

	private static String numFriendsInParentesis(int n) {
		StringBuilder chaine = new StringBuilder("(x");
		chaine.append(n);
		chaine.append(")");
		return chaine.toString();
	}

	private static String stringNames(String[] names, int[] numNames) {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0; i < names.length - 1; i++) {
			chaine.append(names[i]);
			if (numNames[i] > 1) {
				chaine.append(numFriendsInParentesis(numNames[i]));
			}
			if (i < names.length - 2) {
				chaine.append(", ");
			}
		}
		return chaine.toString();
	}

	private static String firstLetterUppercase(String nom) {
		String premiereLettre = nom.substring(0, 1);
		String resteNom = nom.substring(1);
		String premiereLettreMaj = premiereLettre.toUpperCase();
		return premiereLettreMaj.concat(resteNom);
	}
}