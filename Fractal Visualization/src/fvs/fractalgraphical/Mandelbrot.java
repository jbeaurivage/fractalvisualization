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
import processing.core.PGraphics;

/**
 * This class renders an interactive Mandelbrot fractal with the use of the Processing library.
 * @author Justin Beaurivage
 */
@SuppressWarnings("serial")
public class Mandelbrot extends FractalControl {

	/**
	 * Called by the default Processing setup method at applet
	 *  initialization and initializes fractal rendering
	 */
	protected void fractalSetup(){

		pg = createGraphics(800,800);
		renderFractal();

	}

	/**
	 * Loops during the applet runtime and renders the fractal image as the background and calls the
	 * zooming rectangle 
	 */
	public void draw(){
		image(pg,0,0);
		visor();	
	}

	/**
	 * The main fractal engine. Loops through all the points on the plane and assigns them a coordinate
	 * in the complex plane. Then uses these coordinates to assign a color to each point using the
	 * {@link #mandel(float, float) mandel} method. Finally saves the frame to the {@link #pg} graphics
	 * object, which will be used to be drawn on the canvas.
	 */
	private void renderFractal(){
		pg.beginDraw();

		pg.background(255);

		for(int x = 0; x < w; x+=1){

			for(int y = 0; y < h; y+=1){

				float cx = x / scaleFactor + minX;
				float cy = y / scaleFactor + minY;

				float mandelvalue = mandel(cx,cy);

				if(mandelvalue < 2){
					pg.stroke(0);
				}

				else{
					float ratio = count/iterations;
					pg.stroke(10+count*2,ratio*ratio,count*8);
				}

				pg.point(x,y);

			}
		}
		visor();
		pg.endDraw();
	}

	/**
	 * Provides calculations to determine whether a given point on the complex plane is an element of the
	 * Mandelbrot set.
	 * @param cx The real axis on the complex plane
	 * @param cy The imaginary axis on the complex plane
	 * @return Mandelvalue, used by the main {@link #renderFractal()} engine to assign colors to points
	 */
	private float mandel(float cx, float cy){
		float xm = 0;
		float ym = 0;
		count = 0;
		fx = 0;
		fy = 0;
		while ( (count < iterations) && (fx*fx+fy*fy < 16))
		{
			func(xm,ym,cx,cy);
			xm = fx;
			ym = fy;
			count++;
		}
		return sqrt(fx*fx + fy*fy);
	}

	/**
	 * The method used to calculate the function of the mandelbrot set. Is externalized from the {@link
	 * #mandel(float, float) mandel} method to make it easily interchangeable with other functions of
	 * the Mandelbrot family.
	 * @param x
	 * @param y
	 * @param cx
	 * @param cy
	 */
	private void func(float x,float y, float cx, float cy){
		fx = x*x - y*y + cx;
		fy = 2*x*y + cy;
	}

	/**
	 * Renders the zooming rectangle on the canvas.
	 */
	@Override
	protected void visor() {
		int rectW = rect_x2-rect_x1;
		int rectH = rect_y2-rect_y1;

		stroke(255,0,0);
		noFill();
		if (mousePressed && mouseButton == LEFT && rectW > 0) {
			rect(rect_x1, rect_y1, rectW,rectH);
		}

	}

	/**
	 * Resets the canvas to its original state
	 */
	@Override
	protected void reset() {

		fx = 0;
		fy = 0;
		count = 0;
		minX = (float)-2.5;
		maxX = (float)1.5;
		minY = -2;
		maxY = 2;

		translateX = 0;
		translateY = 0;

		scaleFactor = 200;
		iterations = 40;

		w = (int)((maxX - minX) * scaleFactor);
		h = (int)((maxY - minY) * scaleFactor);

		renderFractal();
	}

	/**
	 * Checks whether a key is pressed during each call of {@link #draw()}
	 */
	@Override
	public void keyPressed(){

		switch(key){
		case 'r':
			reset();
			return;
		}

		renderFractal();
	}

	/**
	 * Check if mouse is pressed during each call of {@link #draw()} to draw the zooming rectangle
	 */
	public void mousePressed(){

		rect_x1 = mouseX;
		rect_y1 = mouseY;

		mouseDragged();

	}

	/**
	 * Check if mouse is dragged during each call of {@link #draw()} to draw the zooming rectangle
	 */
	public void mouseDragged(){

		rect_x2 = mouseX;
		rect_y2 = rect_y1 + (rect_x2 - rect_x1);

	}

	/**
	 * Check if mouse button is released during each call of {@link #draw()}
	 *  to draw the zooming rectangle, and sets the new plane/canvas boundaries and scale factor, and
	 *  then calls a new {@link #renderFractal()} to refresh the image.
	 */
	public void mouseReleased(){

		float tempMinX = 0;
		float tempMaxX = 0;
		rect_x2 = mouseX;
		rect_y2 = rect_y1 + (rect_x2 - rect_x1);

		tempMinX = minX;
		tempMaxX = maxX;


		minX = rect_x1 / scaleFactor + minX;
		maxX = rect_x2 / scaleFactor + minX;
		minY = rect_y1 / scaleFactor + minY;
		maxY = rect_y2 / scaleFactor + minY;

		scaleFactor *= (tempMaxX - tempMinX) / (maxX - minX);

		renderFractal();

	}

	/*
	 * Mandelbrot fractal variables
	 */
	private float fx = 0;
	private float fy = 0;
	private int count = 0;

	/*
	 * Plane boundaries
	 */
	private float minX = (float) -2.5;
	private float maxX = (float) 1.5;
	private float minY = -2;
	private float maxY = 2;

	/*
	 * Scale/zooming factor
	 */
	private float scaleFactor = 200;

	/*
	 * Fractal iterations (fixed, best performance/functionality ratio)
	 */
	private int iterations = 40;

	/*
	 * Plane size
	 */
	private int w = (int)((maxX - minX) * scaleFactor);
	private int h = (int)((maxY - minY) * scaleFactor);

	/*
	 * Zooming rectangle boundaries
	 */
	private int rect_x1, rect_y1, rect_x2, rect_y2;

	/*
	 * Fractal image frame
	 */
	private PGraphics pg;


}
