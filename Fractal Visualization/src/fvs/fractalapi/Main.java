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

import javax.swing.UIManager;

import fvs.fractalgraphical.Launcher;

/**
 * This class provides the entry point for the software, with {@link void main(String[])}
 * @author justinbeaurivage
 *
 */
public class Main {

	/**
	 * Program entry point, creates a new Launcher frame
	 * @param String[] args: default Java signature for main method
	 */
	public static void main(String[] args) {

		/*
		 * Mac OSX integration; set application name in menu bar, with exception handler
		 */
		try {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name",
					"Fractal Visualization Software");
		} catch (Exception e){
			System.out.println("Couldn't set Apple properties");
		}

		/*
		 * Try to get system look and feel; if impossible, default LaF will be used
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 


		/*
		 * Start Launcher GUI
		 */
		new Launcher();

	}

}
