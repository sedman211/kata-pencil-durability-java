package pencil_durability;

public class Paper {
	
	private String text;
	
	public Paper(String initialText) {
		text = initialText;
	}
	
	public String getText() {
		return text;
	}
	
	public void Add(char character) {
		text += character;
	}
	
	public void Delete(int index) {
		char[] eraseText = text.toCharArray();
		eraseText[index] = ' ';
		text = new String(eraseText);
	}
	
	public void Edit(int index, char character) {
		char[] editText = text.toCharArray();
		editText[index] = character;
		text = new String(editText);
	}

}
