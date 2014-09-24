package org.fvs.fractalapi;
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

import processing.core.PApplet;

/**
 * This class provides an API for all fractal classes of this package, with all common variables and 
 * methods. It extends PApplet to provide a Processing environment to draw the graphics.
 * @author Justin Beaurivage 
 */
public abstract class FractalControl extends PApplet {

	/**
	 * ID for possible class serialization
	 */
	private static final long serialVersionUID = -2472489619697747836L;

	/*
	 * General fractal variables
	 */
	protected float scaleFactor;   
	protected float translateX;    
	protected float translateY;   
	protected static final float speed = 20;    //arrow key scroll speed, fixed
	protected int iterations;      

	/**
	 * Processing setup, executed at runtime by PApplet, and calls specific fractalSetup() method
	 * for each fractal class
	 */
	public void setup(){
		size(800,800);
		scaleFactor = 1;
		fractalSetup();
	}

	/*
	 * Common fractal methods; must be implemented
	 */
	public abstract void visor(); //zooming visor
	public abstract void fractalSetup(); //specific setup for each fractal
	public abstract void reset(); //reset screen
	public abstract void keyPressed(); //keyboard controls

}
