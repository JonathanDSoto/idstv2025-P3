package idstv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Ventana extends JFrame{

	public Ventana() {
		
		this.setVisible(true);
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		
		this.setTitle("Login");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(true); 
		
		this.setMaximumSize(new Dimension(800,800));
		this.setMinimumSize(new Dimension(400,400));
		
		//this.add(this.login());
		this.add(this.calculadora());
		
		Image image;
		try {
			
			image = ImageIO.read(this.getClass().getResource("/folder.png"));
			setIconImage(image);
			
			ImageIcon img = new ImageIcon("/folder.png");
			setIconImage(img.getImage());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//barra
		JMenuBar barra = new JMenuBar();
		
		JMenu file = new JMenu("Archivo");
		barra.add(file);
		
		JMenuItem open = new JMenuItem("Abrir");
		file.add(open);
		
		JMenuItem close = new JMenuItem("Cerrar");
		file.add(close);
		
		JMenuItem op_2 = new JMenuItem("Guardar");
		file.add(op_2);
		
		JMenuItem op_3 = new JMenuItem("Guardar como");
		file.add(op_3);
		
		JMenu menu_2 = new JMenu("Ayuda");
		barra.add(menu_2);
		
		JMenuItem op_4 = new JMenuItem("Manual de usuario");
		menu_2.add(op_4);
		
		JCheckBoxMenuItem op_5 = new JCheckBoxMenuItem("Hola");
		menu_2.add(op_5);
		
		this.setJMenuBar(barra);
		
		this.repaint();
		this.revalidate();
	}
	
	
	public JPanel login()
	{
		
		Font fuente = new Font("American Typewriter",Font.BOLD,20);
		
		JPanel mipanel = new JPanel();

		mipanel.setBackground(Color.decode("#48cae4"));
		mipanel.setOpaque(true);
		mipanel.setSize(400, 400);
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
	
	public JPanel calculadora()
	{
		
		Font fuente = new Font("American Typewriter",Font.BOLD,35);
		JPanel mipanel = new JPanel();

		mipanel.setBackground(Color.decode("#48cae4"));
		mipanel.setOpaque(true); 
		mipanel.setLayout(new BorderLayout()); 
		
		JLabel results = new JLabel("20.00");
		results.setBackground(Color.white);
		results.setOpaque(true);
		results.setFont(fuente);
		results.setHorizontalAlignment(JLabel.RIGHT);
		mipanel.add(results,BorderLayout.NORTH);
		
		JPanel centro = new JPanel();
		centro.setBackground(Color.decode("#CF93F0"));
		centro.setOpaque(true); 
		centro.setLayout(new BorderLayout());
		mipanel.add(centro,BorderLayout.CENTER);
		
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(4,3));
		centro.add(botones,BorderLayout.CENTER);
		
		String[] textos = {"9","8","7","6","5","4","3","2","1","0","."}; 
		
		for (String texto_boton : textos) {
			
			JButton boton = new JButton(texto_boton);
			botones.add(boton);
		}
		
		JPanel grilla = new JPanel();
		grilla.setLayout(new GridLayout(6,1));
		centro.add(grilla,BorderLayout.LINE_END);
		
		String[] textos_2 = {"+","-","*","/","=","CE"}; 
		
		for (String texto_boton : textos_2) {
			
			JButton boton = new JButton(texto_boton);
			grilla.add(boton);
		}
		
		return mipanel;
	}

}
















