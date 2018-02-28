package input;

public class Button {
	public static final int UP = 0;
	public static final int DOWN = 1;
	
	private int state;
	private int frames;
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getFrames() {
		return frames;
	}
	
	public void setFrames(int frames) {
		this.frames = frames;
	}
}