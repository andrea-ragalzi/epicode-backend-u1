package it.epicode.be;

public class Helloworld {

	public static void main(String[] args) {
		String[] strings = { "uno", "due", "tre", "quattro", "cinque" };

		System.out.println(moltiplica(3, 8));
		System.out.println(concatena("ciao", 8));
		printStrings(strings);
		printStrings(inserisciInArray(strings, "due e mezzo"));
	}

	private static String concatena(String str, int num) {
		System.out.println("ESERCIZIO 2");
		return str + num;
	}

	private static String[] inserisciInArray(String[] strings, String stringToInsert) {
		System.out.println("ESERCIZIO 3");
		String[] result = new String[strings.length + 1];
		result[2] = stringToInsert;
		int j = 0;
		for (int i = 0; i < strings.length; i++) {
			if (i == 2) {
				result[j] = stringToInsert;
				result[j + 1] = strings[i];
				j += 2;
			} else {
				result[j] = strings[i];
				j++;
			}
		}
		return result;
	}

	private static int moltiplica(int num1, int num2) {
		System.out.println("ESERCIZIO 1");
		return num1 * num2;
	}

	private static void printStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + ", ");
		}
		System.out.println();
	}
}
