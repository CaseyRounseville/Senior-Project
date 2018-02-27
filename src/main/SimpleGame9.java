package main;

import java.awt.event.KeyEvent;

import managers.GamePad;
import managers.GameStateManager;

public class SimpleGame9 implements Runnable{

    private Screen screen;
    private boolean isRunning;
    private int ticks;
    private static final int FPS = 60;
    private long targetTime = 1000 / FPS;

    public SimpleGame9() {
	ticks = 0;
	screen = new Screen();
	isRunning = true;
	//gameLoop();
	Thread t = new Thread(this);
	t.start();
    }

    public void draw() {
	screen.draw();
    }

    public void run() {
	long startTime;
	long elapsedTime;
	long waitTime;
	while (isRunning) {
	    startTime = System.nanoTime();
	    processInput();
	    tick();
	    draw();
	    //tick();
	    elapsedTime = System.nanoTime() - startTime;
	    waitTime = targetTime - elapsedTime / 1000000;// divide by 1000000
							  // to convert from
							  // nanosec to milisec
	    limitFPS(waitTime);
	}
    }
    
    public void processInput() {
	GameStateManager.processInput();
    }

    public void tick() {
	GameStateManager.tick();
	GamePad.tick();
	ticks++;
    }

    public void limitFPS(long waitTime) {
	if (waitTime < 0) {
	    waitTime = 0;
	}
	try {
	    Thread.sleep(waitTime);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
