package main;

import util.Constants;

import java.awt.*;
import java.util.Random;

public class Point extends Object{

	private Random r = new Random();
	private Handler handler;

	private float lastX;
	private float lastY;

	public Point(float x, float y, Handler handler) {
		super(x, y);
		this.handler = handler;

		lastX = x;
		lastY = y;

	}

	private float equationX(float a) {
		return (float) Math.pow(a, 2) - (a * Main.time) + a + Main.time;
	}
	private float equationY(float a) {
		return (float) (Math.pow(a, 2) + Math.pow(a, 2)+  Math.pow(Main.time, 2) - (a * Main.time) - a + a);
	}

	@Override
	public void tick() {
		x = (float) Math.pow(lastX, 2) - (lastX * Main.time) + lastY + Main.time;
		y = (float)(Math.pow(lastX, 2) + Math.pow(lastY, 2) + Math.pow(Main.time, 2) - (lastX * Main.time) - lastX + lastY);


		Main.time += .0001f;
		y *= -1;

		System.out.println(x);
		System.out.println(y);

		handler.addObject(new Trail(x, y, Color.green, 3, 3, Constants.DECAY, handler));

		float lastX = x;
		float lastY = y;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect((int)x, (int)y, 3, 3);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
}
