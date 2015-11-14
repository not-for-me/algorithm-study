import java.util.Scanner;

/**
 * Problem Ref.: https://algospot.com/judge/problem/read/ANAGRAM
 *
 **/
public class Anagram {
	private static final int ASCII_CNT = 128;
	private static final String NO_RETURN = "No.";
	private static final String YES_RETURN = "Yes";

	public static void main(final String... args) {
		new Anagram().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		final short caseCnt = Short.parseShort(sc.nextLine()); // 3만개까지
		String[] results = new String[caseCnt];
		for (int idx = 0; idx < caseCnt; idx++) {
			String[] inputStrings = sc.nextLine().split(" ");

			if (inputStrings[0].equals(inputStrings[1]) || inputStrings[0].length() !=
					inputStrings[1].length()) {
				results[idx] = NO_RETURN;
				continue;
			}
			char[] fChars = inputStrings[0].toCharArray();
			char[] sChars = inputStrings[1].toCharArray();

			short[] histogram = new short[ASCII_CNT];
			for(int i = 0; i < fChars.length; i++) {
				histogram[(int) fChars[i]]++;
				histogram[(int) sChars[i]]--;
			}

			boolean isAnagram = true;
			for (int i = 0; i < ASCII_CNT; i++) {
				if(histogram[i] != 0) {
					isAnagram = false;
					break;
				}
			}
			results[idx] = isAnagram ? YES_RETURN : NO_RETURN;
		}

		for(String result : results) {
			System.out.println(result);
		}
	}
}