package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import util.Constants;
import util.KeyInput;

public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = -7071532049979466544L;

	private boolean running = false;
	private Thread thread;
	private Handler handler;

	public static float time = -.1f;

	public Main() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));

		handler.addObject(new Point(1, 1, handler));

		new Window(Constants.GAME_WIDTH, Constants.GAME_HEIGHT, "Chaos Equations", this);
	}

	public void tick() {
		handler.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);


		handler.render(g);

		g.dispose();
		bs.show();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now  = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
				frames++;
			}

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	public static void main(String[] args) {
		new Main();
	}
}