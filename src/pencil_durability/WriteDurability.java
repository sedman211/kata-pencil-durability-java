package pencil_durability;
import java.util.*;

public class WriteDurability {
	
	public static void main(String[] args) {
		int length, dur, eraserDur;
		
		System.out.print("Welcome to the pencil durability test!\n\n");
		
		System.out.print("Enter the pencil length: ");
		Scanner lengthInput = new Scanner(System.in);
		length = lengthInput.nextInt();
		
		System.out.print("Enter the point durability: ");
		Scanner durInput = new Scanner(System.in);
		dur = durInput.nextInt();
		
		System.out.print("Enter the eraser durability: ");
		Scanner eraserDurInput = new Scanner(System.in);
		eraserDur = eraserDurInput.nextInt();
		
		Pencil myPencil = new Pencil(dur, length, eraserDur);
		Paper myPaper = new Paper("");
		
		pencilTest(myPencil, myPaper);
		System.out.println("End of pencil durability test.");
		lengthInput.close();
		durInput.close();
		eraserDurInput.close();
		return;
	}
	
	public static void pencilTest(Pencil pencil, Paper paper) {
		String userInput = "", writeText, eraseText, editText;
		
		Scanner userIn = new Scanner(System.in);
		Scanner writeIn = new Scanner(System.in);
		Scanner eraseIn = new Scanner(System.in);
		Scanner editIn = new Scanner(System.in);		
		
		while(!userInput.equals("exit")) {
			System.out.print("Enter 'write', 'erase', 'edit', 'sharpen', or 'exit': ");
			userInput = userIn.nextLine();
			
			if(userInput.equals("write")) {
				System.out.print("Enter what you want to write: ");
				writeText = writeIn.nextLine();
				pencil.write(writeText, paper);
				System.out.println("Your paper contains: " + paper.getText() + "\n");
				System.out.println("You now have a pencil of length " + pencil.getLength() 
				+ ", durability " + pencil.getDurability() + ", eraser " 
				+ pencil.getEraserDurability() + "\n");
			}
			if(userInput.equals("erase")) {
				System.out.print("Enter what you want to erase: ");
				eraseText = eraseIn.nextLine();
				pencil.erase(eraseText, paper);
				System.out.println("Your paper contains: " + paper.getText() + "\n");
				System.out.println("You now have a pencil of length " + pencil.getLength() 
				+ ", durability " + pencil.getDurability() + ", eraser " 
				+ pencil.getEraserDurability() + "\n");
			}
			if(userInput.equals("edit")) {
				if(pencil.getEraseIndex() == 0) {
					System.out.println("You can only edit once something has been erased.");
				}
				else {
					System.out.print("Enter what you want to edit: ");
					editText = editIn.nextLine();
					pencil.edit(paper, editText, pencil.getEraseIndex());
					System.out.println("Your paper contains: " + paper.getText() + "\n");
					System.out.println("You now have a pencil of length " + pencil.getLength() 
					+ ", durability " + pencil.getDurability() + ", eraser " 
					+ pencil.getEraserDurability() + "\n");
				}
			}
			if(userInput.equals("sharpen")) {
				System.out.println("Attempting to sharpen...");
				pencil.sharpen();
				System.out.println("Your paper contains: " + paper.getText() + "\n");
				System.out.println("You now have a pencil of length " + pencil.getLength() 
				+ ", durability " + pencil.getDurability() + ", eraser " 
				+ pencil.getEraserDurability() + "\n");
			}
		}
		editIn.close();
		writeIn.close();
		eraseIn.close();
		userIn.close();
		return;
	}
	
}
