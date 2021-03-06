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

package fvs.fractalapi;

/**
 * This class provides an API for fractals of the Fractal Tree Family, which have common specific
 * implementations. 
 * @author Justin Beaurivage
 *
 */
@SuppressWarnings("serial")
public abstract class TreeFamily extends FractalControl {
	
	/*
	 * Tree family specific variables
	 */
	protected float init_len = 0; //tree initial branch length
	protected float frac = 0;     //old branch/frac = new branch
	protected float offset = 0;   //angle offset between branches
	protected float stroke;   //stroke weight
	
	/**
	 * Keyboard controls.
	 */
	@Override
	public void keyPressed(){
		  switch(key){
		  //mouse move
		    case ' ':
		    if(iterations == 0 || iterations == -1){
		      translateX = (mouseX-width/2)/scaleFactor;
		      translateY = (mouseY-width/2)/scaleFactor+200;}
		    break;
		    
		    //reset
		    case 'r':
		      reset();
		    break;
		    
		    //zoom in
		    case 'a':
		      scaleFactor *= 2;
		      stroke /= 2;
		      iterations += 1;
		      println(scaleFactor+"x zoom");
		    break;
		    
		    //zoom out
		    case 'z':
		      scaleFactor /= 2;
		      stroke *=2;
		      iterations -= 1;
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
		      offset = radians(mouseX/10);
		    break;
		  }
		}
	
}
