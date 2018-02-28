package managers;

import input.InputDevice;
import input.AWTKeyboard;

/*public final class GamePad implements KeyListener {
	
	public static boolean[] buttons_currentFrame = new boolean[8];
	public static boolean[] buttons_lastFrame = new boolean[8];
	
	public static final int BUTTON_START = 0;
	
	public static boolean enabled = true;
	
	public static final int BUTTON_UP = 1;
	public static final int BUTTON_DOWN = 2;
	public static final int BUTTON_LEFT = 3;
	public static final int BUTTON_RIGHT = 4;
	
	public static final int BUTTON_X = 5;
	public static final int BUTTON_1 = 6;
	public static final int BUTTON_3 = 7;
	
	public static boolean wasJustPressed(int key) {
		if (key == BUTTON_X) {
			//System.out.println(buttons_currentFrame[key] + "\t" + buttons_lastFrame[key]);
		}
		return buttons_currentFrame[key] && (!buttons_lastFrame[key]);
	}
	
	public static boolean wasDownLastFrame(int key) {
		return buttons_lastFrame[key];
	}
	
	public static boolean isDownNow(int key) {
		return buttons_currentFrame[key];
	}
	
	public static void press(int key) {
		buttons_currentFrame[key] = true;
	}
	
	public static void release(int key) {
		buttons_currentFrame[key] = false;
	}
	
	public static void disable() {
		enabled = false;
	}
	
	public static void enable() {
		enabled = true;
	}

	public static void tick() {
		for (int i = 0; i < buttons_currentFrame.length; i++) {
			buttons_lastFrame[i] = buttons_currentFrame[i];
		}
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		
		if (keyCode == KeyEvent.VK_ENTER) buttons_currentFrame[BUTTON_START] = true;
		
		if (keyCode == KeyEvent.VK_UP) buttons_currentFrame[BUTTON_UP] = true;
		if (keyCode == KeyEvent.VK_DOWN) buttons_currentFrame[BUTTON_DOWN] = true;
		if (keyCode == KeyEvent.VK_LEFT) buttons_currentFrame[BUTTON_LEFT] = true;
		if (keyCode == KeyEvent.VK_RIGHT) buttons_currentFrame[BUTTON_RIGHT] = true;
		
		if (keyCode == KeyEvent.VK_X) buttons_currentFrame[BUTTON_X] = true;
		if (keyCode == KeyEvent.VK_1) buttons_currentFrame[BUTTON_1] = true;
		if (keyCode == KeyEvent.VK_3) buttons_currentFrame[BUTTON_3] = true;
		
		//System.out.println(buttons_currentFrame[BUTTON_RIGHT]);
	}

	@Override
	public void keyReleased(KeyEvent key) {
		int keyCode = key.getKeyCode();
		
		if (keyCode == KeyEvent.VK_ENTER) buttons_currentFrame[BUTTON_START] = false;
		
		if (keyCode == KeyEvent.VK_UP) buttons_currentFrame[BUTTON_UP] = false;
		if (keyCode == KeyEvent.VK_DOWN) buttons_currentFrame[BUTTON_DOWN] = false;
		if (keyCode == KeyEvent.VK_LEFT) buttons_currentFrame[BUTTON_LEFT] = false;
		if (keyCode == KeyEvent.VK_RIGHT) buttons_currentFrame[BUTTON_RIGHT] = false;
		
		if (keyCode == KeyEvent.VK_X) buttons_currentFrame[BUTTON_X] = false;
		if (keyCode == KeyEvent.VK_1) buttons_currentFrame[BUTTON_1] = false;
		if (keyCode == KeyEvent.VK_3) buttons_currentFrame[BUTTON_3] = false;
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
	
	public static void releaseAll() {
		for (int i = 0; i < buttons_currentFrame.length; i++) {
			buttons_currentFrame[i] = false;
		}
	}
	
}*/

public final class GamePad {
	public static final int BUTTON_START = 0;
	
	//public static boolean enabled = true;
	
	public static final int BUTTON_UP = 1;
	public static final int BUTTON_DOWN = 2;
	public static final int BUTTON_LEFT = 3;
	public static final int BUTTON_RIGHT = 4;
	
	public static final int BUTTON_X = 5;
	public static final int BUTTON_1 = 6;
	public static final int BUTTON_3 = 7;
	
	private static final InputDevice inputDevice = new AWTKeyboard();
	
	public static boolean wasJustPressed(int btn) {
		return inputDevice.isDown(btn) && !inputDevice.wasDown(btn);
	}
	
	public static boolean wasDownLastFrame(int btn) {
		return inputDevice.wasDown(btn);
	}
	
	public static boolean isDownNow(int btn) {
		return inputDevice.isDown(btn);
	}
	
	public InputDevice getInputDevice() {
		return inputDevice;
	}
	
	public static void tick() {
		inputDevice.poll();
	}
	
	public static void releaseAll() {
		inputDevice.releaseAll();
	}
	
	/*public static void press(int key) {
		buttons_currentFrame[key] = true;
	}
	
	public static void release(int key) {
		buttons_currentFrame[key] = false;
	}
	
	public static void disable() {
		enabled = false;
	}
	
	public static void enable() {
		enabled = true;
	}*/
}