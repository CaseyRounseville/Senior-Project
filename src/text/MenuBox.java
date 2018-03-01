package text;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuBox extends TextBox {

	private Message question;
	private Message[] options;
	private int currentChoice;
	private static final int LINE_LENGTH = 20;
	private int[][] layout;

	public MenuBox(String text, String[] options, int x, int y) {
		super(text, LINE_LENGTH, x, y);
		question = new Message(text, LINE_LENGTH);
		initOptions(options);
		currentChoice = 0;
		initLayout();
	}

	public void draw(Graphics2D g) {
		
		// draw frame & background
		for (int row = 0; row < layout.length; row++) {
			for (int col = 0; col < layout[row].length; col++) {
				g.drawImage(sprites.getSprite(layout[row][col]), x + col * 8, y + row * 8, null);
			}
		}
		
		// draw question
		int rowOffset = 0;
		int colOffset = 0;
		int[][] questionMap = question.getTextMap();
		for (int row = 0; row < questionMap.length; row++) {
			for (int col = 0; col < questionMap[row].length; col++) {
				g.drawImage(sprites.getSprite(questionMap[row][col]), 8 + x + col * 8, 8 + y + row * 8, null);
			}
			rowOffset++;
		}
		rowOffset++;// blank line after question
		colOffset += 3;// indent for arrow
		
		// draw options
		for (int opt = 0; opt < options.length; opt++) {
			int[][] optionMap = options[opt].getTextMap();
			for (int row = 0; row < optionMap.length; row++) {
				for (int col = 0; col < optionMap[row].length; col++) {
					g.drawImage(
					sprites.getSprite(optionMap[row][col]), 
					8 + 8 * colOffset + x + col * 8,
					8 + 8 * rowOffset + y + row * 8,
					null
					);
				}
				//rowOffset++;
			}
			rowOffset += options[opt].getNumLines() + 1;// blank line
		}
		
		// draw arrow
		int row = 0;
		for (int i = 0; i < currentChoice; i++) {
			row += options[i].getNumLines();
			row++;
		}
		g.drawImage(sprites.getSprite(74), 16 + x, 8 + (question.getNumLines() * 8) + 8 + 8 * row + y, null);
	}

	public void tick() {

	}

	public int getCurrentChoice() {
		return currentChoice;
	}
	
	public void setCurrentChoice(int currentChoice) {
		this.currentChoice = currentChoice;
	}

	public void increaseCurrentChoice() {
		currentChoice++;
		if (currentChoice > options.length - 1) {
			currentChoice = 0;
		}
	}

	public void decreaseCurrentChoice() {
		currentChoice--;
		if (currentChoice < 0) {
			currentChoice = options.length - 1;
		}
	}

	private void initLayout() {
		int numLines = 0;
		for (int i = 0; i < options.length; i++) {
			numLines += options[i].getNumLines();
		}
		numLines += numLines - 1; // add spaces between choices
		numLines += question.getNumLines() + 1;// add question and space
		layout = new int[numLines + 2][LINE_LENGTH + 5];

		// corners
		layout[0][0] = 64;
		layout[0][layout[0].length - 1] = 66;
		layout[layout.length - 1][0] = 70;
		layout[layout.length - 1][layout[0].length - 1] = 69;

		// borders
		for (int col = 1; col <= LINE_LENGTH + 3; col++) {
			layout[0][col] = 65;
			layout[layout.length - 1][col] = 71;
		}

		for (int row = 1; row <= numLines; row++) {
			layout[row][0] = 67;
			layout[row][layout[0].length - 1] = 68;
		}
	}

	private void initOptions(String[] opt) {
		options = new Message[opt.length];
		for (int i = 0; i < options.length; i++) {
			options[i] = new Message(opt[i], LINE_LENGTH);
		}
	}

}
