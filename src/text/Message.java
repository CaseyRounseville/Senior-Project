package text;

import java.util.ArrayList;
import java.util.List;

public class Message {
    
    private String text;
    private List<String> lines;
    private int lineLength;
    private static final int ASCII_OFFSET = 32;
    
    public Message(String text, int lineLength) {
	this.text = text;
	lines = new ArrayList<String>();
	this.lineLength = lineLength;
	setLines();
    }
    
    private void setLines() {
	String[] tokens = text.split("\\s");
	lines.add("");
	for (int l = 0, t = 0; t < tokens.length; t++) {
	    if (lines.get(l).length() + tokens[t].length() + 1 <= lineLength) {
		lines.set(l, lines.get(l) + tokens[t] + " ");
	    } else if (lines.get(l).length() + tokens[t].length() <= lineLength) {
		lines.set(l, lines.get(l) + tokens[t]);
		if (t != tokens.length - 1) {
		    lines.add("");
		    l++;
		}
	    } else {
		lines.add("");
		l++;
		if (tokens[t].length() > lineLength) {
		    tokens[t] = "<...>";
		}
		t--;
	    }
	}
	//padLines();
    }
    
    private void padLines() {
	for (int i = 0; i < lines.size(); i++) {
	    while (lines.get(i).length() < lineLength) {
		lines.set(i, lines.get(i) + " ");
	    }
	}
    }
    
    public int[][] getTextMap() {
	int[][] textMap = new int[lines.size()][];
	for (int row = 0; row < lines.size(); row++) {
	    textMap[row] = new int[lines.get(row).length()];
	    for (int col = 0; col < lines.get(row).length(); col++) {
		textMap[row][col] = (int) lines.get(row).charAt(col) - ASCII_OFFSET;
	    }
	}
	return textMap;
    }
    
    public int getNumLines() {
	return lines.size();
    }

}
