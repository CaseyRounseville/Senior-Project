package input;

import java.util.Map;
import java.util.HashMap;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;

import static input.Button.*;

public class AWTKeyboard extends InputDevice implements KeyListener {
	private static final Map<Integer, Integer> keyToBtn = new HashMap<Integer, Integer>();
	static {
		keyToBtn.put(VK_ENTER, BUTTON_START);
		keyToBtn.put(VK_UP, BUTTON_UP);
		keyToBtn.put(VK_DOWN, BUTTON_DOWN);
		keyToBtn.put(VK_LEFT, BUTTON_LEFT);
		keyToBtn.put(VK_RIGHT, BUTTON_RIGHT);
		keyToBtn.put(VK_X, BUTTON_X);
		keyToBtn.put(VK_1, BUTTON_1);
		keyToBtn.put(VK_3, BUTTON_3);
	}
	
	private int stateBuffer;
	private int stateBuffer_copy;
	private final Object stateBufferLock = new Object();
	
	public AWTKeyboard() {
		stateBuffer = 0;
		stateBuffer_copy = 0;
	}
	
	@Override
	public void poll() {
		synchronized (stateBufferLock) {
			stateBuffer_copy = stateBuffer;
		}
		
		for (int i = 0; i < NUM_BUTTONS; i++) {
			Button b = buttons[i];
			int state = (stateBuffer_copy >> i) & 1;
			
			if (b.getState() == UP) {
				if (state == UP) {
					b.setFrames(b.getFrames() + 1);
				} else {
					b.setState(DOWN);
					b.setFrames(1);
				}
			} else {
				if (state == DOWN) {
					b.setFrames(b.getFrames() + 1);
				} else {
					b.setState(UP);
					b.setFrames(1);
				}
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (!keyToBtn.containsKey(e.getKeyCode())) {
			return;
		}
		
		synchronized (stateBufferLock) {
			stateBuffer |= 1 << keyToBtn.get(e.getKeyCode());
		}		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (!keyToBtn.containsKey(e.getKeyCode())) {
			return;
		}
		
		synchronized (stateBufferLock) {
			stateBuffer &= ~(1 << keyToBtn.get(e.getKeyCode()));
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// nothing
	}
}