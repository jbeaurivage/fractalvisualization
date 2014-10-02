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
 * This class renders an interactive JML fractal with the use of the Processing library.
 * @author Justin Beaurivage
 *
 */
@SuppressWarnings("serial")
public class JML extends FractalControl {

	protected void fractalSetup(){
		iterations = 8;
	}

	protected void reset(){
		translateX = 0;
		translateY = 0;
		scaleFactor = 1;
		iterations = 8;
	}

	public void draw() {
		background(0);
		textSize(18);

		pushMatrix();
		translate(width/2+translateX*scaleFactor,
				height/2+translateY*scaleFactor);
		scale(scaleFactor);

		drawCircle(0,0,200,"center",0); // change radius
		stroke(0);
		strokeWeight((float) 1.5);

		line(-25,0,25,0);
		line(0,-25,0,25);

		popMatrix();

		fractalInfo();
		visor();
	}

	/**
	 * JML fractal generation engine. Each new call recursively calls itself 3 or 4  times, depending 
	 * on the previous circle's position.
	 * @param x New circle x position
	 * @param y New circle y position
	 * @param radius New circle radius
	 * @param pos New circle's position relative to its parent circle
	 * @param c Enables color generation
	 */
	void drawCircle(
			float x,
			float y,  
			float radius,
			String pos, 
			int c)
	{
		smooth();
		noStroke();

		//color generation
		fill((float)(0.7*c),100,(float)(1.5*(255-c)));

		//draw circles
		ellipse(x, y, radius, radius);

		//radius limit
		float rad = 350*pow((float) 0.5,iterations-1);

		/*
		 * Call method recursion with radius limiter to avoid infinite loops
		 */
		if(radius >= rad) { 

			/*
			 * position limits
			 */


			if(pos == "center"){
				drawCircle(x + radius/2+radius/4, y, radius/2,"right",c+50); //right
				drawCircle(x - radius/2-radius/4, y, radius/2,"left",c+50); //left
				drawCircle(x, y - radius/2-radius/4, radius/2,"up",c+50); //up
				drawCircle(x, y+ radius/2+radius/4, radius/2,"down",c+50); //down
			}
			if(pos == "left"){
				drawCircle(x - radius/2-radius/4, y, radius/2,"left",c+50); //left
				drawCircle(x, y - radius/2-radius/4, radius/2,"up",c+50); //up
				drawCircle(x, y+ radius/2+radius/4, radius/2,"down",c+50); //down
			}
			if(pos == "right"){
				drawCircle(x + radius/2+radius/4, y, radius/2,"right",c+50); //right
				drawCircle(x, y - radius/2-radius/4, radius/2,"up",c+50); //up
				drawCircle(x, y+ radius/2+radius/4, radius/2,"down",c+50); //down
			}
			if(pos == "up"){
				drawCircle(x + radius/2+radius/4, y, radius/2,"right",c+50); //right
				drawCircle(x - radius/2-radius/4, y, radius/2,"left",c+50); //left
				drawCircle(x, y - radius/2-radius/4, radius/2,"up",c+50); //up
			}
			if(pos == "down"){
				drawCircle(x + radius/2+radius/4, y, radius/2,"right",c+50); //right
				drawCircle(x - radius/2-radius/4, y, radius/2,"left",c+50); //left 
				drawCircle(x, y+ radius/2+radius/4, radius/2,"down",c+50); //down

			}
		}
	}

	/**
	 * Fractal information panel
	 */
	void fractalInfo(){
		fill(255);
		int circles = round((2*(pow(3,iterations)-1)+1));
		if(iterations < 1){
			text(circles+" circle",650,780);
		}
		if(iterations <2){
			text(iterations+" Iteration", 650,720);
			text(circles+" circles",650,780);
		}
		if(iterations >= 2){
			text(iterations+" Iterations", 650,720);
			text(circles+" circles",650,780);
		}
		text(scaleFactor+"x zoom",650,750);
		text("("+translateX+", "+translateY+")",10,20);
	}

	/**
	 * keyboard controls
	 */
	@Override
	public void keyPressed(){
		switch(key){
		//mouse move holding down spacebar
		case ' ':
			if(iterations == 8 || iterations == 0){
				translateX = (mouseX-width/2)/scaleFactor;
				translateY = (mouseY-width/2)/scaleFactor;
			}
			break;

			//reset
		case 'r':
			reset();
			break;

			//zoom in
		case 'a':
			scaleFactor *= 2;

			if(iterations < 13){
				iterations ++;
			}

			println(scaleFactor+"x zoom");
			break;

			//zoom out
		case 'z':
			scaleFactor /= 2;

			if(iterations < 13){
				iterations --;
			}

			println(scaleFactor+"x zoom");
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
