package pencil_durability;

public class Pencil {
	public static final int lowerCaseRate = 1, upperCaseRate = 2, blankSpaceRate = 0;
	public static final char collideValue = '@';	

	private static int durability, maxDurability, length, eraserDurability, eraseIndex = 0;

	public Pencil(int initialPencilDurability, int initialLength, int initialEraserDurability) {
		durability = initialPencilDurability;
		maxDurability = initialPencilDurability;
		length = initialLength;
		eraserDurability = initialEraserDurability;
	}
	
	public void write(String text, Paper sheet) {		
		char[] characters = text.toCharArray();
		int caseRate = blankSpaceRate;
		
		for(int i = 0; i < characters.length; i++) {
			if (Character.isLowerCase(characters[i]))
				caseRate = lowerCaseRate;
			if (Character.isUpperCase(characters[i])) 
				caseRate = upperCaseRate;
			if (durability < caseRate)
				characters[i] = ' ';
			else
				durability -= caseRate;
			sheet.Add(characters[i]);
		}
	}

	public void erase(String text, Paper sheet) {
		int eraseRate = blankSpaceRate;	
		eraseIndex = sheet.getText().lastIndexOf(text);
		int eraseLimit = eraseIndex + text.length() - 1;
		
		if(eraseIndex == -1) 
			return;

		for(int j = eraseLimit; j >= eraseIndex; j--) {
			if(Character.isLowerCase(sheet.getText().charAt(j)) || Character.isUpperCase(sheet.getText().charAt(j)))
				eraseRate = lowerCaseRate;
			else
				eraseRate = blankSpaceRate;
			if(eraserDurability < eraseRate)
				return;
			eraserDurability -= eraseRate;
			sheet.Delete(j);
		}
	}
	
	public void sharpen() {
		if (length != 0)
		{
			length--;
			durability = maxDurability;
			System.out.println("Sharpened.");
		}
		else
		{
			System.out.println("Cannot sharpen. Pencil has run out of length.");
			return;
		}
	}
	
	public void edit(Paper sheet, String text, int index) {
		for(int k = 0; k < text.length(); k++) {
			if(Character.isLowerCase(text.charAt(k)) || Character.isUpperCase(text.charAt(k)))
			{
				
			}
			try {
				if(Character.isAlphabetic(sheet.getText().charAt(index)))
					sheet.Edit(index, '@');
				else
					sheet.Edit(index, text.charAt(k));
				index++;
			}
			catch(java.lang.StringIndexOutOfBoundsException exception) {
				System.out.println("The text you tried to edit was larger than the text on paper.");
				return;
			}
		}
	}
	
	public int getLength() {
		return length;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public int getEraserDurability() {
		return eraserDurability;
	}
	
	public int getEraseIndex() {
		return eraseIndex;
	}
}
