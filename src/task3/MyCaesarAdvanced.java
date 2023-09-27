package task3;



public class MyCaesarAdvanced {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesarAdvanced(int shiftSteps) {
		this.n = shiftSteps;
	}
	
	// method 1
	 public char encryptChar(char c) {
	        // Check if the character is an ASCII printable character
	        if (c >= 32 && c <= 126) {
	            // Encrypt the character using the shift steps (n)
	            int encryptedChar = (c + n - 32) % 95 + 32;
	            return (char) encryptedChar;
	        } else {
	            // If it's not a printable character, return the character unchanged
	            return c;
	        }
	    }

	    public char decryptChar(char c) {
	        // Check if the character is an ASCII printable character
	        if (c >= 32 && c <= 126) {
	            // Decrypt the character using the shift steps (n)
	            int decryptedChar = (c - n - 32 + 95) % 95 + 32;
	            return (char) decryptedChar;
	        } else {
	            // If it's not a printable character, return the character unchanged
	            return c;
	        }
	    }

	    public String encrypt(String input) {
	        StringBuilder encryptedText = new StringBuilder();

	        for (char c : input.toCharArray()) {
	            char encryptedChar = encryptChar(c);
	            encryptedText.append(encryptedChar);
	        }

	        return encryptedText.toString();
	    }

	    public String decrypt(String input) {
	        StringBuilder decryptedText = new StringBuilder();

	        for (char c : input.toCharArray()) {
	            char decryptedChar = decryptChar(c);
	            decryptedText.append(decryptedChar);
	        }

	        return decryptedText.toString();
	    }

	    public static void main(String[] args) {
	        
	        MyCaesarAdvanced myCaesar1 = new MyCaesarAdvanced(3);
			char newIndex1 = myCaesar1.encryptChar('Z');
			System.out.println(newIndex1);

			System.out.println("");
			MyCaesarAdvanced myCaesar2 = new MyCaesarAdvanced(3);
			String newIndex2 = myCaesar2.encrypt("TUAN");
			System.out.println(newIndex2);

			System.out.println("");
			MyCaesarAdvanced myCaesar3 = new MyCaesarAdvanced(3);
			char newIndex3 = myCaesar3.decryptChar('Z');
			System.out.println(newIndex3);

			System.out.println("");
			MyCaesarAdvanced myCaesar4 = new MyCaesarAdvanced(3);
			String newIndex4 = myCaesar4.decrypt("TUAN");
			System.out.println(newIndex4);
	    }
	}
	

