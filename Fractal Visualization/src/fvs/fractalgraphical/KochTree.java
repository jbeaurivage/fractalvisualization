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

import fvs.fractalapi.TreeFamily;

import processing.core.PVector;

/**
 * This class renders an interactive Koch Tree fractal with the use of the Processing library.
 * @author Justin Beaurivage
 *
 */
@SuppressWarnings("serial")
public class KochTree extends TreeFamily {

	protected void fractalSetup(){
		
		/*
		 * Tree variables initialization
		 */
		offset = (float)radians(145); 
		init_len = (float) 392.51376;
		frac = (float)1.6384;

		stroke = 1;
		translateY = 400;
		iterations = -1;
	}

	protected void reset(){
		translateX = 0;
		translateY = 400;
		scaleFactor = 1;
		stroke = 1;
		iterations = -1;
	}

	public void draw(){
		background(255);

		visor();
		smooth();
		strokeWeight(stroke);
		stroke(0);

		translate(width/2+translateX*scaleFactor,height/2+translateY*scaleFactor);
		scale(scaleFactor);
		rotate(PI+HALF_PI);

		branch(new PVector(0,0),init_len,0);


	}


	/**
	 * Fractal generation engine
	 * @param pos (Vector) Initial position of line (branch point)
	 * @param len Length of the new branch
	 * @param theta Absolute angle of new line
	 */
	private void branch(PVector pos, float len, float theta){

		line(pos.x, pos.y, pos.x+len*cos(theta), pos.y+len*sin(theta));

		float lim = 3*pow((float) 0.5,iterations);

		if(len > lim){
			branch(new PVector(pos.x+len*cos(theta), pos.y+len*sin(theta)),len/frac,theta-offset);
			branch(new PVector(pos.x+len*cos(theta), pos.y+len*sin(theta)),len/frac,theta+offset);
		}

	}


}

