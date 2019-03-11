package main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

	LinkedList<Object> object = new LinkedList<Object>();

	public LinkedList<Object> getObject() {
		return object;
	}

	public void tick() {
		for(int i  = 0; i < object.size(); i ++) {
			Object tempObject = object.get(i);

			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for(int i  = 0; i < object.size(); i ++) {
			Object tempObject = object.get(i);

			tempObject.render(g);
		}
	}

	public void addObject(Object object) {
		this.object.add(object);
	}

	public void removeObject(Object object) {
		this.object.remove(object);

	}


	public void removeAll() {
		for (int i = 0; i < this.object.size(); i++) {
			Object tempObject = this.object.get(i);
			this.removeObject(tempObject);
		}
	}
}