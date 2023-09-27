package task2;

public class MyCaesar {

	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

// method 1
	public char encryptChar(char c) {
		// Calculate the index of the character in the ALPHABET array
		int x = c - 'A';

		// Encrypt the character using the shift steps (n)
		int encryptedIndex = (x + n) % 26;
		// Return the encrypted character
		return ALPHABET[encryptedIndex];
	}
// method 2
	public String encrypt(String input) {

		StringBuilder decryptedText = new StringBuilder();

		for (char c : input.toCharArray()) {
			// Giải mã từng ký tự và thêm vào chuỗi giải mã
			char decryptedChar = encryptChar(c);
			decryptedText.append(decryptedChar);
		}

		return decryptedText.toString();

	}
// method3
	public char decryptChar(char c) {
		int x = c - 'A';

		int indexChar = (x - n) % 26;
		if(indexChar <0) {
			indexChar += 26;
			}

		return ALPHABET[indexChar];
	}
// method4
	public String decrypt(String input) {

		StringBuilder stringIndex = new StringBuilder();

		for (char c : input.toCharArray()) {
			char index = decryptChar(c);
			stringIndex.append(index);
		}
		return stringIndex.toString();
	}

	public static void main(String[] args) {
		MyCaesar myCaesar1 = new MyCaesar(3);
		char newIndex1 = myCaesar1.encryptChar('Z');
		System.out.println(newIndex1);

		System.out.println("");
		MyCaesar myCaesar2 = new MyCaesar(3);
		String newIndex2 = myCaesar2.encrypt("TUAN");
		System.out.println(newIndex2);

		System.out.println("");
		MyCaesar myCaesar3 = new MyCaesar(3);
		char newIndex3 = myCaesar3.decryptChar('Z');
		System.out.println(newIndex3);

		System.out.println("");
		MyCaesar myCaesar4 = new MyCaesar(3);
		String newIndex4 = myCaesar4.decrypt("TUAN");
		System.out.println(newIndex4);
	}

}
