package fvs.fractalgraphical;
import java.util.ArrayList;

import processing.core.PVector;

import fvs.fractalapi.*;

@SuppressWarnings("serial")
public class KochSnowflake extends FractalControl {

	private float stroke;
	
	@Override
	protected void fractalSetup() {
		translateX = -300; 
		translateY = 175; 
		scaleFactor = 1;
		iterations = 10;
		stroke = 1;

	}

	private void renderCurve(Turtle t, float length){

		t.points.add(new PVector(t.x,t.y));

		if(length > iterations){
			renderCurve(t, length/3);
			t.left(60);
			renderCurve(t, length/3);
			t.right(120);
			renderCurve(t, length/3);
			t.left(60);
			renderCurve(t, length/3);
		}
		if(length < iterations){
			t.forward(length);
			t.left(60);
			t.forward(length);
			t.right(120);
			t.forward(length);
			t.left(60);
			t.forward(length);
		}

		fill(255,0,0);
		beginShape(CLOSE);
		for(PVector p : t.points){
			vertex(p.x,p.y);
		}
		endShape();

	}

	private void renderFractal(Turtle t, float length){

		renderCurve(t, length);
		t.right(120);
		renderCurve(t, length);
		t.right(120);
		renderCurve(t, length);

	}

	@Override
	protected void reset() {
		
		translateX = -300; 
		translateY = 175; 
		scaleFactor = 1;
		iterations = 10;
		stroke = 1;

	}


	public void draw(){
		background(0);

		pushMatrix();
		translate(width/2+translateX*scaleFactor,
				height/2+translateY*scaleFactor);
		scale(scaleFactor);
		renderFractal(new Turtle(0, 0, -60), 200);
		popMatrix();
	}

	class Turtle {

		float x, y, angle; // Current position of the turtle
		boolean penDown = true; // Is pen down?
		ArrayList<PVector> points;

		/**
		 *  Set up initial position (Turtle constructor)
		 * @param xin initial x
		 * @param yin initial y
		 */

		/**
		 * Constructor (initial position)
		 * @param xin
		 * @param yin
		 */
		public Turtle (float xin, float yin, float ain) {
			x = xin;
			y = yin;
			angle = ain;
			penDown = true;
			points = new ArrayList<PVector>();
		}

		/**
		 *  Move forward by the specified distance
		 * @param distance
		 */
		public void forward (float distance) {

			stroke(255);
			fill(255);
			strokeWeight(stroke);

			//  Calculate the new position
			float xtarget = x+cos(radians(angle)) * distance;
			float ytarget = y+sin(radians(angle)) * distance;

			// If the pen is down, draw a line to the new position
			if (penDown) line(x, y, xtarget, ytarget);
			points.add(new PVector(xtarget, ytarget));

			// Update position
			x = xtarget;
			y = ytarget;

		}

		// Move back by specified distance
		public void back (float distance) {
			forward(-distance);
		}

		// Turn left by given angle
		public  void left (float turnangle) {
			angle -= turnangle;
		}

		// Turn right by given angle
		public void right (float turnangle) {
			angle += turnangle;
		}

		// Set the pen to be up
		public void penUp() {
			penDown = false;
		}

		// Set the pen to be down
		public void penDown() {
			penDown = true;
		}

	}

	@Override
	public void keyPressed(){
		switch(key){
		//mouse move holding down spacebar
		case ' ':
				translateX = (mouseX-width/2 - 300)/scaleFactor;
				translateY = (mouseY-width/2 + 175)/scaleFactor;
			break;

			//reset
		case 'r':
			reset();
			break;

			//zoom in
		case 'a':
			scaleFactor *= 2;
			iterations /= log(iterations);
			println(scaleFactor+"x zoom");
			stroke /= 2;
			break;

			//zoom out
		case 'z':
			scaleFactor /= 2;
			iterations *= log(iterations);
			println(scaleFactor+"x zoom");
			stroke*= 2;
			break;

		}
		switch(keyCode){

		case UP:
			translateY += (speed/scaleFactor);
			break;

		case DOWN:
			translateY -= (speed/scaleFactor);
			break;

		case LEFT:
			translateX += (speed/scaleFactor);
			break;

		case RIGHT:
			translateX -= (speed/scaleFactor);
			break;

		case ENTER:
			break;
		}
	}

}
