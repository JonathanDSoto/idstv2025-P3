package idstv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Ventana extends JFrame{

	public Ventana() {
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		
		this.setTitle("Login");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(true); 
		
		this.setMaximumSize(new Dimension(800,800));
		this.setMinimumSize(new Dimension(400,400));
		
		this.add(this.login());
		this.repaint();
	}
	
	public JPanel login()
	{
		
		Font fuente = new Font("American Typewriter",Font.BOLD,20);
		
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
		etiqueta2.setFont(fuente);
		mipanel.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setSize(300, 30);
		email.setLocation(38, 160);
		email.setFont(fuente);
		mipanel.add(email);
		
		JLabel password_tag = new JLabel("Ingrese su contraseña: ");
		password_tag.setSize(250, 30);
		password_tag.setLocation(40, 210);
		password_tag.setFont(fuente);
		mipanel.add(password_tag);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(38, 240, 300, 30);
		password.setFont(fuente);
		mipanel.add(password);
		
		JCheckBox terms = new JCheckBox("Acepto los términos",false);
		terms.setSize(250, 30);
		terms.setLocation(40, 280); 
		mipanel.add(terms);
		
		JLabel forgot_tag = new JLabel("¿Olvidó su contraseña?");
		forgot_tag.setSize(250, 30);
		forgot_tag.setLocation(200, 310); 
		mipanel.add(forgot_tag);
		
		JButton access = new JButton("ACCEDER");
		access.setBounds(100, 350, 200, 50);
		access.setFont(fuente);
		access.setOpaque(true);
		access.setBackground(Color.red);
		mipanel.add(access);
		
		return mipanel;
	}

}
















