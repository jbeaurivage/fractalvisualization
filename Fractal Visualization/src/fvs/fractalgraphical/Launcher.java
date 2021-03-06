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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fvs.fractalapi.Instructions;


/**
 * This class provides the first interface the user will see when the program is launched. It launches
 *  the different fractal classes according to user selection and provides instructions. Uses Swing
 *  as a GUI library
 * @author Justin Beaurivage
 *
 */
@SuppressWarnings("serial")
public class Launcher extends JFrame {

	/**
	 * Records user fractal selection (has a default value)
	 */
	String fractalSelection = "Fractal Tree";

	
	

	/**
	 * Not inside constructor to enable dynamically changing the text through event handlers
	 */
	JLabel textArea = new JLabel(Instructions.FRACTALTREE);

	/**
	 * Class constructor, creates a launcher frame
	 */
	public Launcher(){
		
		/*
		 * Launcher Frame setup
		 */
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setTitle("Fractal Visualization Engine");

		/*
		 * Layout setup
		 */
		Container c = getContentPane();
		c.setLayout(new BorderLayout(30,30));
		Box[] boxes = new Box[1];

		boxes[0] = Box.createVerticalBox();


		/*
		 * Title label
		 */
		JPanel introPanel = new JPanel();
		introPanel.setBackground(Color.WHITE);
		JLabel intro = new JLabel("<html>Interactive Fractal Visualization Software" +
				"<br>v1.2<html>");
		intro.setFont(new Font("Default",Font.PLAIN,24));
		introPanel.add(intro);

		/*
		 * Instructions and licensing text
		 */
		JPanel textPane = new JPanel();
		textPane.setBackground(Color.WHITE);
		textPane.add(this.textArea);


		/*
		 *  Fractal Selection box
		 */
		String[] selection = {
				"Fractal Tree",
				"JML",
				"Koch Tree",
				"Koch Snowflake",
				"Mandelbrot",
				};
		JComboBox selector = new JComboBox(selection);

		/*
		 *selector action listener
		 */
		selector.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				/*
				 * temporary combo box, because cannot reference non-final field in variable action
				 * listener
				 */
				JComboBox cb = (JComboBox)e.getSource();
				fractalSelection = (String)cb.getSelectedItem();

				/*
				 * change instructions area
				 */
				if(fractalSelection == "Fractal Tree"){
					textArea.setText(Instructions.FRACTALTREE);
				}

				else if(fractalSelection == "Koch Tree"){
					textArea.setText(Instructions.KOCHTREE);
				}

				else if(fractalSelection == "JML"){
					textArea.setText(Instructions.JML);
				}

				else if(fractalSelection == "Mandelbrot"){
					textArea.setText(Instructions.MANDELBROT);
				}
				
				else if(fractalSelection == "Koch Snowflake"){
					textArea.setText(Instructions.KOCHSNOWFLAKE);
				}

			}
		});

		/*
		 * selector panel
		 */
		JPanel selectorPane = new JPanel();
		selectorPane.setBackground(Color.WHITE);
		selectorPane.add(selector);

		/*
		 * Start Button
		 */
		JButton startButton = new JButton("Run");

		/*
		 * start button action listener
		 */
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				/*
				 *  initialize fractal engine
				 */
				processing.core.PApplet fractal;
				JFrame engine = new JFrame();

				/*
				 * fractal class (engine) selection
				 */
				if(fractalSelection == "Fractal Tree"){
					fractal = new FractalTree();
					engine.add(fractal);
					engine.setSize(800,800);
					engine.setTitle(fractalSelection);
					fractal.init();
					engine.setVisible(true);
				}
				else if(fractalSelection == "Koch Tree"){
					fractal = new KochTree();
					engine.add(fractal);
					engine.setSize(800,800);
					engine.setTitle(fractalSelection);
					fractal.init();
					engine.setVisible(true);
				}
				else if(fractalSelection == "JML"){
					fractal = new JML();
					engine.add(fractal);
					engine.setSize(800,800);
					engine.setTitle(fractalSelection);
					fractal.init();
					engine.setVisible(true);
				}

				else if(fractalSelection == "Mandelbrot"){
					fractal = new Mandelbrot();
					engine.add(fractal);
					engine.setSize(800,800);
					engine.setTitle(fractalSelection);
					fractal.init();
					engine.setVisible(true);
				}
				
				else if(fractalSelection == "Koch Snowflake"){
					fractal = new KochSnowflake();
					engine.add(fractal);
					engine.setSize(800,800);
					engine.setTitle(fractalSelection);
					fractal.init();
					engine.setVisible(true);
				}
				
			}
		});

		/*
		 * button panel
		 */
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		buttonPane.add(startButton);

		/*
		 * add UI elements to container
		 */
		boxes[0].add(Box.createVerticalStrut(25));

		boxes[0].add(introPanel,BorderLayout.CENTER);
		boxes[0].add(selectorPane,BorderLayout.CENTER);
		boxes[0].add(textPane,BorderLayout.CENTER);
		boxes[0].add(buttonPane,BorderLayout.CENTER);

		/*
		 * add container to frame
		 */
		c.add(boxes[0],BorderLayout.NORTH);

		/*
		 * Render frame Launcher
		 */
		setVisible(true);

	}

}
