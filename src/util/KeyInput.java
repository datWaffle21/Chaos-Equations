package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.Main;
import main.Object;
import main.Handler;

public class KeyInput extends KeyAdapter{

	private Main main;
	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_ESCAPE) System.exit(1);

		for(int i = 0; i < handler.getObject().size(); i++) {

			Object tempObject = handler.getObject().get(i);

			//Add more if-statements like above for more characters
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.getObject().size(); i++) {
			Object tempObject = handler.getObject().get(i);


			//Add more if-statements like above for more characters
		}
	}

}