package text;

import java.awt.Graphics2D;

public class DialogBox extends TextBox {

    // lines
    private static final int LINE_LENGTH = 29; // in 8x8 tiles
    private static final int NUM_LINES = 3;

    // layout
    private int[][] layout = getLayout();

    // make text appear smoothly
    private static final int DELAY = 5;
    private int delayCounter;
    private int currentRow_textBox;
    private int currentRow_message;
    private int currentCol;
    private int startRow;
    private boolean waiting;
    private boolean done;

    private int blinkCounter;

    public DialogBox(String text, int x, int y) {
	super(text, LINE_LENGTH, x, y);
	delayCounter = 0;
	currentRow_textBox = 0;
	currentRow_message = 0;
	currentCol = 0;
	startRow = 0;
	waiting = false;
	done = false;
	blinkCounter = 0;
    }

    public void tick() {
	delayCounter++;
	if (delayCounter == DELAY) {
	    delayCounter = 0;
	    if (!done && !waiting) {
		currentCol++;
		if (currentCol == message.getTextMap()[currentRow_message].length) {

		    currentRow_textBox++;
		    currentRow_message++;
		    currentCol = 0;

		    if (currentRow_message == message.getTextMap().length) {
			currentRow_message--;
			currentRow_textBox--;
			currentCol = message.getTextMap()[currentRow_message].length - 1;
			done = true;
		    } else if (currentRow_textBox == NUM_LINES) {
			currentRow_message--;
			currentRow_textBox--;
			currentCol = message.getTextMap()[currentRow_message].length - 1;
			waiting = true;
		    }
		}
	    }

	    // arrow on box
	    if (done) {
		layout[layout.length - 1][layout[0].length - 2] = 73;
	    } else if (waiting) {
		if (delayCounter % DELAY == 0) {
		    blinkCounter++;
		    if (blinkCounter == 5) {
			blinkCounter = 0;
			if (layout[layout.length - 1][layout[0].length - 2] == 72) {
			    layout[layout.length - 1][layout[0].length - 2] = 71;
			} else {
			    layout[layout.length - 1][layout[0].length - 2] = 72;
			}
		    }
		}
	    } else {
		layout[layout.length - 1][layout[0].length - 2] = 71;
	    }
	}
    }

    public boolean isWaiting() {
	return waiting;
    }

    public boolean isDone() {
	return done;
    }

    public void advanceText() {
	currentRow_textBox = 0;
	currentRow_message++;
	currentCol = 0;
	startRow += NUM_LINES;
	waiting = false;
    }

    public void draw(Graphics2D g) {
	// draw frame & background
	for (int row = 0; row < layout.length; row++) {
	    for (int col = 0; col < layout[row].length; col++) {
		g.drawImage(sprites.getSprite(layout[row][col]), x + col * 8, y + row * 8, null);
	    }
	}

	// draw message
	for (int row = startRow; row < currentRow_message; row++) {
	    for (int col = 0; col < message.getTextMap()[row].length; col++) {
		g.drawImage(sprites.getSprite(message.getTextMap()[row][col]), x + 8 * col + 8, y + 8 * (row - startRow) + 8, null);
	    }
	}

	for (int col = 0; col <= currentCol; col++) {
	    g.drawImage(sprites.getSprite(message.getTextMap()[currentRow_message][col]), x + 8 * col + 8, y + 8 * currentRow_textBox + 8, null);
	}
    }
 
    private static int[][] getLayout() {
	int[][] layout = new int[NUM_LINES + 2][LINE_LENGTH + 2];
	
	// corners
	layout[0][0] = 64;
	layout[0][layout[0].length - 1] = 66;
	layout[layout.length - 1][0] = 70;
	layout[layout.length - 1][layout[0].length - 1] = 69;
	
	// borders
	for (int col = 1; col <= LINE_LENGTH; col++) {
	    layout[0][col] = 65;
	    layout[layout.length - 1][col] = 71;
	}
	
	for (int row = 1; row <= NUM_LINES; row++) {
	    layout[row][0] = 67;
	    layout[row][layout[0].length - 1] = 68;
	}
	
	// background: already zeros
	
	return layout;
    }

}
