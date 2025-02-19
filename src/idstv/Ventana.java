package idstv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		
		this.setTitle("Login");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setMaximumSize(new Dimension(800,800));
		this.setMinimumSize(new Dimension(400,400));
		
		//this.setResizable(true);
		this.add(this.login());
		this.repaint();
	}
	
	public JPanel login()
	{
		JPanel mipanel = new JPanel();

		mipanel.setBackground(Color.decode("#48cae4"));
		mipanel.setOpaque(true);
		mipanel.setSize(500, 500);
		mipanel.setLocation(0, 0);
		mipanel.setLayout(null); //quita el molde
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(200, 30);
		etiqueta1.setLocation(150, 30);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(new Font("American Typewriter",Font.BOLD,24));
		mipanel.add(etiqueta1);
		
		
		JLabel etiqueta2 = new JLabel("Ingrese su email: ");
		etiqueta2.setSize(200, 30);
		etiqueta2.setLocation(40, 130);
		etiqueta2.setFont(new Font("American Typewriter",Font.BOLD,18));
		mipanel.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setSize(300, 30);
		email.setLocation(40, 190);
		email.setFont(new Font("American Typewriter",Font.BOLD,18));
		mipanel.add(email);
		
		return mipanel;
	}

}
