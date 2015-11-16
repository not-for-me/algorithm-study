import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Ref.: https://algospot.com/judge/problem/read/ENDIANS
 **/
public class EndianConversion {
	public static void main(final String... args) {
		new EndianConversion().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		final int caseCnt = sc.nextInt();
		List<Long> outputNumbers = new ArrayList<>();

		for (int idx = 0; idx < caseCnt; idx++) {
			final long inputNumber = sc.nextLong();
			String bitString = "";
			String convertedBits = "";
			for (int binaryDecimalPos = 4 * 8; binaryDecimalPos > 0; binaryDecimalPos--) {
				bitString += (inputNumber & (1 << binaryDecimalPos - 1)) > 0 ? 1 : 0;
				if (binaryDecimalPos % 8 == 1) {
					convertedBits = bitString + convertedBits;
					bitString = "";
				}
			}

			long convertedIntSum = 0;
			long binaryDecimal = 1L << 31;
			for (char c : convertedBits.toCharArray()) {
				convertedIntSum += Long.parseLong(String.valueOf(c)) * binaryDecimal;
				binaryDecimal = binaryDecimal >> 1;
			}
			outputNumbers.add(convertedIntSum);
		}

		outputNumbers.forEach(System.out::println);
	}
}