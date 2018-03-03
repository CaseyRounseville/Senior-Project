package input;

import static input.Button.*;

public abstract class InputDevice {
	protected Button[] buttons;
	public static final int
		BUTTON_START = 0,
		BUTTON_UP = 1,
		BUTTON_DOWN = 2,
		BUTTON_LEFT = 3,
		BUTTON_RIGHT = 4,
		BUTTON_X = 5,
		BUTTON_1 = 6,
		BUTTON_3 = 7;
	public static final int NUM_BUTTONS = 8;
	
	//private boolean enabled;
	
	public InputDevice() {
		buttons = new Button[NUM_BUTTONS];
		
		// fill button array
		// initialize all buttons to state UP and 1 frames
		// (isUp and wasUp both return true)
		for (int i = 0; i < NUM_BUTTONS; i++) {
			Button b = new Button();
			b.setState(UP);
			b.setFrames(2);
			buttons[i] = b;
		}
	}
	
	public int framesUp(int btn) {
		if (buttons[btn].getState() != UP) {
			return 0;
		}
		
		return buttons[btn].getFrames();
	}
	
	public int framesDown(int btn) {
		if (buttons[btn].getState() != DOWN) {
			return 0;
		}
		
		return buttons[btn].getFrames();
	}
	
	public boolean isUp(int btn) {
		return buttons[btn].getState() == UP;
	}
	
	public boolean isDown(int btn) {
		return buttons[btn].getState() == DOWN;
	}
	
	public boolean wasUp(int btn) {
		int state = buttons[btn].getState();
		int frames = buttons[btn].getFrames();
		
		return (state == UP && frames > 1) || (state == DOWN && frames == 1);
	}
	
	public boolean wasDown(int btn) {
		int state = buttons[btn].getState();
		int frames = buttons[btn].getFrames();
		
		return (state == DOWN && frames > 1) || (state == UP && frames == 1);
	}
	
	public void releaseAll() {
		for (Button b : buttons) {
			b.setState(UP);
			b.setFrames(1);
		}
	}
	
	public abstract void poll();
}