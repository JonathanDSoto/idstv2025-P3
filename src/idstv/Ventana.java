package idstv;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
		
		this.setTitle("Programa");
		this.setVisible(true);
		this.setSize(500, 500);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(true);
		this.setMaximumSize(new Dimension(800,800));
		this.setMinimumSize(new Dimension(400,400));
	}

}
