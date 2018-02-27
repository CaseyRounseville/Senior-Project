package text;

import java.awt.Graphics2D;

public class LabelBox extends TextBox {

    public LabelBox(String text, int x, int y) {
	super(text, text.length(), x, y);
    }
    
    public void tick() {
	// do nothing
    }
    
    public void draw(Graphics2D g) {
	int[][] textMap = message.getTextMap();
	for (int row = 0; row < textMap.length; row++) {
	    for (int col = 0; col < textMap[row].length; col++) {
		g.drawImage(sprites.getSprite(textMap[row][col]), x + col * FONT_SIZE, y + row * FONT_SIZE, null);
	    }
	}
    }

}
