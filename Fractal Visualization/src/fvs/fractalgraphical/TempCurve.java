package fvs.fractalgraphical;

import fvs.fractalapi.FractalControl;

@SuppressWarnings("serial")
public class TempCurve extends FractalControl {
	@Override
	protected void fractalSetup() {
		background(255);
		renderFractal(new Turtle(10,400, -45), 400);
		
		

	}

	private void renderFractal(Turtle t, float length){
		//t.right(90);
		if(length > 10){
			//t.forward(length);
			renderFractal(t, length/3);
			t.left(60);
			//t.forward(length);
			renderFractal(t, length/3);
			t.right(120);
			//t.forward(length);
			renderFractal(t, length/3);
			t.left(60);
			//t.forward(length);
			renderFractal(t, length/3);
		}
		if(length < 10){
			t.right(90);
			t.forward(length);
			//renderFractal(t, length/3);
			t.left(60);
			t.forward(length);
			//renderFractal(t, length/3);
			t.right(120);
			t.forward(length);
			//renderFractal(t, length/3);
			t.left(60);
			t.forward(length);
			//renderFractal(t, length/3);
		}

	}

	@Override
	protected void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed() {
		// TODO Auto-generated method stub

	}

	public void draw(){
	}

	class Turtle {

		float x, y, angle; // Current position of the turtle
		boolean penDown = true; // Is pen down?

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
		}

		/**
		 *  Move forward by the specified distance
		 * @param distance
		 */
		public void forward (float distance) {

			stroke(0);
			fill(0);
			strokeWeight(2);

			//  Calculate the new position
			float xtarget = x+cos(radians(angle)) * distance;
			float ytarget = y+sin(radians(angle)) * distance;

			// If the pen is down, draw a line to the new position
			if (penDown) line(x, y, xtarget, ytarget);

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

}
