/*
 * FRACTAL VISUALIZATION SOFTWARE
 * Copyright (C) 2014 Justin Beaurivage
 * justbeaurivage@gmail.com
 * 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fvs.fractalgraphical;

import fvs.fractalapi.FractalControl;

/**
 * 
 * @author Justin Beaurivage
 *
 */
@SuppressWarnings("serial")
public class TempCurve extends FractalControl {

	private float stroke;

	/**
	 * 
	 */
	@Override
	protected void fractalSetup() {
		iterations = 10;
		translateX = 10;
		translateY = 0;
		stroke = 1;
		scaleFactor = 1;

		background(255);
		pushMatrix();
		translate(translateX*scaleFactor,
				height/2+translateY*scaleFactor);
		scale(scaleFactor);
		renderFractal(new Turtle(0, 0, -45), 400);
		popMatrix();



	}

	/**
	 * 
	 * @param t
	 * @param length
	 */
	private void renderFractal(Turtle t, float length){
		//t.right(90);
		if(length > iterations){
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
		if(length < iterations){
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

	/**
	 * 
	 */
	@Override
	protected void reset() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
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
			if(iterations > 1){
				iterations /= 2;

			}
			scaleFactor *= 2;
			println(scaleFactor+"x zoom");
			stroke /= 2;
			break;

			//zoom out
		case 'z':
			if(iterations > 1){
				iterations *= 2;
			}
			scaleFactor /= 2;
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

		/*
		 * redraw the fractal
		 */
		background(255);
		pushMatrix();
		translate(translateX*scaleFactor,
				height/2+translateY*scaleFactor);
		scale(scaleFactor);
		renderFractal(new Turtle(0, 0, -45), 400);
		popMatrix();

	}

	/**
	 * 
	 */
	public void draw(){
		visor();
	}

	/**
	 * 
	 * @author **author**  //TODO
	 *
	 */
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
			strokeWeight(stroke);
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
