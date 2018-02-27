package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import managers.GamePad;

import javax.swing.JFrame;
import javax.swing.JPanel;

import managers.ActorManager;
import managers.GameStateManager;

public class Screen extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private static BufferedImage image;
    public static final int HEIGHT = 240;
    public static final int WIDTH = HEIGHT * 4 / 3;
    public static final int SCALE = 2;
    private Graphics2D g;

    public Screen() {
	super();
	setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
	// g.scale(SCALE, SCALE);
	setFocusable(true);
	requestFocus();
	addKeyListener(new GamePad());
	image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	g = (Graphics2D) image.getGraphics();
	//g.setBackground(new Color(20, 50, 130));
	JFrame window = new JFrame("simple java game 9");
	window.setContentPane(this);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//window.setResizable(false);
	window.pack();
	window.setVisible(true);
	window.setLocationRelativeTo(null);
    }

    public void draw() {
	g.clearRect(0, 0, WIDTH, HEIGHT);
	GameStateManager.draw(g);
	drawToScreen();
    }
    
    public void drawToScreen() {
	//RescaleOp op = new RescaleOp(0.5f, 0, null);
	//image = op.filter(image, null);
	Graphics2D g2 = (Graphics2D) getGraphics();
	//g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
	g2.drawImage(image, 0, 0, (int) getSize().getWidth(), (int) getSize().getHeight(), null);
	g2.dispose();
    }
    
    public static void darken() {
//	RescaleOp op = new RescaleOp(0.984f, 0, null);
//	image = op.filter(image, null);
//	int rgb = image.getRGB(3, 3);
//	System.out.println(rgb);
    }
    
    public static void brighten() {
	
    }
    
    public static BufferedImage getImage() {
	return image;
    }

}
