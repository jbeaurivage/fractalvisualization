
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
 * Instruction String constants are externalized for easier and quicker reference and modification.
 * @author Justin Beaurivage
 *
 */
public final class Instructions {
	public static final String JML = "<html><h3>JML Fractal</h3>" +
			"This fractal is the the result of the collaborative <br>" +
			"work of Maxence Dauphinais, Laurence Faucher-Giguère and <br>" +
			"Justin Beaurivage, which displays a mosaic-like structure of circles." +
			"<h4>Instructions</h4>" +
			"<ol><li>Hold down space and move the image <br> around with the mouse to " +
			"center before zooming</li>" +
			"<li>A to zoom in, Z to zoom out</li><li>Arrow keys to navigate " +
			"around the fractal </li><li>R to reset. </li></ol></html>";


	public static final String KOCHTREE = "<html><h3>Koch Tree</h3>" +
			"This fractal displays an interesting Koch curve-like structure " +
			"<br>through a specific set of parameters inside a fractal tree. However, it has <br>" +
			"a high processor cost and will slow down after zooming in <br>" +
			"a few times." +
			"<h4>Instructions:</h4>" +
			"<ol><li>Hold down space and move the image <br> around with the mouse to " +
			"center before zooming</li>" +
			"<li>A to zoom in, Z to zoom out</li><li>Arrow keys to navigate " +
			"around the fractal </li><li>R to reset. </li></ol></html>";


	public static final String FRACTALTREE = "<html><h3>Fractal Tree</h3>" +
			"Simple rendering of the classic Fractal Tree. It has <br>" +
			"a high processor cost and will slow down after zooming in <br>" +
			"a few times." +
			"<h4>Instructions:</h4>" +
			"<ol><li>Hold down space and move the image <br> around with the mouse to " +
			"center before zooming</li>" +
			"<li>A to zoom in, Z to zoom out</li><li>Arrow keys to navigate " +
			"around the fractal </li><li>R to reset. </li></ol></html>";


	public static final String MANDELBROT = "<html><h3>Mandelbrot Fractal</h3>" +
			"Rendering of the well-known Mandelbrot Fractal. Due to performance <br>" +
			"limitations, initial loading time is somewhat long." +
			"<h4>Instructions:</h4>" +
			"Hold down the mouse and drag a rectangle over the desired zooming area. <br>" +
			"Drag the rectangle from upper left corner to lower right corner. R to reset.</html>";
	
	public static final String KOCHSNOWFLAKE = "<html><h3>Koch Snowflake</h3>" +
			"Rendering of the well-known Koch Snowflake. It has <br>" +
			"a high processor cost and will slow down after zooming in <br>" +
			"a few times." +
			"<h4>Instructions:</h4>" +
			"<ol><li>Hold down space and move the image <br> around with the mouse to " +
			"center before zooming</li>" +
			"<li>A to zoom in, Z to zoom out</li><li>Arrow keys to navigate " +
			"around the fractal </li><li>R to reset. </li></ol></html>";
	
	public static final String TEMPCURVE = "";
}
