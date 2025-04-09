package idstv;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Ventana extends JFrame implements MouseListener{

	public Ventana() {
		
		this.setVisible(true);
		this.setSize(930, 600);
		this.setLocationRelativeTo(null);
		
		this.setTitle("Login");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(true); 
		
		//this.setMaximumSize(new Dimension(800,800));
		//this.setMinimumSize(new Dimension(400,400));
		
		//
		this.add(this.login());
		//this.add(this.registro());
		//this.add(this.calculadora());
		
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
		
		
		JMenu menu_3 = new JMenu("Cuenta");
		barra.add(menu_3);
		
		JMenuItem op_6 = new JMenuItem("Acceder");
		op_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}});
		menu_3.add(op_6);
		
		JMenuItem op_7 = new JMenuItem("Registar");
		op_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("register");
				
			}});
		menu_3.add(op_7);
		
		this.setJMenuBar(barra);
		
		this.repaint();
		this.revalidate();
	}
	
	
public JPanel login() {
		
		JTextField textField;
		JPasswordField passwordField;
		 
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		//this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		/*
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(228, 192, 250));
		lblNewLabel_1.setBounds(124, 25, 183, 47); 
		panel.add(lblNewLabel_1);
		*/
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(36, 186, 353, 81);
		lblNewLabel_8.setBorder(BorderFactory.createTitledBorder("Correo electrónico"));
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBackground(new Color(218, 230, 225));
		textField.setBounds(49, 211, 328, 42);
		panel.add(textField);
		textField.setBorder(new LineBorder(new Color(91, 253, 255), 1, true));
		textField.setBorder(null);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(218, 230, 225));
		passwordField.setBounds(49, 300, 295, 42);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setOpaque(true);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String passText = new String(passwordField.getPassword());
				Boolean flag1 = false, flag2 = false;
				
				
				if( passText.equals("") ) {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
					
				}else {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag1 = true;
				}
				
				
				if(textField.getText().equals("")) {
					textField.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}else {
					
					textField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag2 = true;
				}
				
				if(flag1 && flag2) {
					
					if(textField.getText().equals("fake@mail.com") ) {
						if(passText.equals("12345")) {
							
							JOptionPane.showMessageDialog(null, "Bienvenido.");
							
						}else {
							JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
					}
					
					
				}
				
			}
		});
		btnNewButton.setBounds(36, 413, 341, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Sabiduría como meta, patria como destino ");
		lblNewLabel_1.setBounds(69, 73, 308, 16);
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		
		lblNewLabel_6.setIcon(new ImageIcon(this.getClass().getResource("/redd-francisco-9o8YdYGTT64-unsplash.jpg")));
		lblNewLabel_6.setBounds(531, 6, 383, 494);
		lblNewLabel_6.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ingresa al panel administrador");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_2_1.setBounds(49, 109, 340, 39);
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setBorder(BorderFactory.createTitledBorder("Contraseña"));
		lblNewLabel_8_1.setBounds(36, 279, 353, 81);
		panel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/hidden.png")));
		lblNewLabel_2.setBounds(351, 315, 24, 16);
		panel.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar contraseña");
		chckbxNewCheckBox.setBounds(36, 372, 180, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("¿Aún no tienes cuenta?");
		lblNewLabel_3.setBounds(225, 462, 152, 16);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton2 = new JButton("Crea una aquí");
		btnNewButton2.setBackground(new Color(0, 0, 0));
		btnNewButton2.setOpaque(true);
		btnNewButton2.setForeground(new Color(0, 0, 0));
		btnNewButton2.setBounds(205, 490, 200, 20);
		btnNewButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				router("register");
				
			}});
		panel.add(btnNewButton2);
		
		return panel;
	}
	
	
	
	
	public JPanel registro()
	{
		
		Font fuente = new Font("American Typewriter",Font.BOLD,20);
		
		JPanel mipanel = new JPanel();

		mipanel.setBackground(Color.decode("#F0A96D"));
		mipanel.setOpaque(true);
		mipanel.setSize(400, 400);
		mipanel.setLocation(0, 0);
		mipanel.setLayout(null); //quita el molde
		
		JLabel etiqueta1 = new JLabel("Registarse");
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
		
		access.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Boolean flag1 = false, flag2 = false;
				
				if( email.getText().equals("") ) {
					
					email.setBorder(BorderFactory.createLineBorder(Color.red,3));
					
				}else {
					email.setBorder(BorderFactory.createLineBorder(Color.green,3));
					flag1 = true;
				}
				
				String passw = new String(password.getPassword());
				
				if( passw.equals("") ) {
					
					password.setBorder(BorderFactory.createLineBorder(Color.red,3));
					
				}else {
					password.setBorder(BorderFactory.createLineBorder(Color.green,3));
					flag2 = true;
				}
				
				if (flag1 && flag2) {
					
					if(email.getText().equals("jsoto@uabcs.mx"))
						if(passw.equals("password123"))
							JOptionPane.showMessageDialog(null, "Bienvenido","Hello",JOptionPane.WARNING_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Hello",JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Hello",JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
			
			
		});
		
		mipanel.add(access);
		
		JButton ir_login = new JButton("Ir al login");
		ir_login.setBounds(100, 450, 200, 50);
		ir_login.setFont(fuente);
		ir_login.setOpaque(true);
		ir_login.setBackground(Color.red);
		ir_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		mipanel.add(ir_login);
		
		return mipanel;
	}
	
	
	public void router(String route) {
		
		this.getContentPane().removeAll();
		
		
		if(route.equals("register")) { 
			this.add(this.registro()); 
		}
		if(route.equals("login")) {
			this.add(this.login());
		}
		
		this.repaint();
		this.revalidate();
	}
	
	public JPanel calculadora()
	{
		
		Font fuente = new Font("American Typewriter",Font.BOLD,35);
		JPanel mipanel = new JPanel();

		mipanel.setBackground(Color.decode("#48cae4"));
		mipanel.setOpaque(true); 
		mipanel.setLayout(new BorderLayout()); 
		
		JLabel results = new JLabel("Interés");
		results.setBackground(Color.white);
		results.setOpaque(true);
		results.setFont(fuente);
		results.setHorizontalAlignment(JLabel.LEFT);
		mipanel.add(results,BorderLayout.NORTH);
		
		
		JPanel centro = new JPanel();
		centro.setBackground(Color.decode("#CF93F0"));
		centro.setOpaque(true); 
		centro.setLayout(new BorderLayout());
		mipanel.add(centro,BorderLayout.CENTER);
		
		JPanel footer = new JPanel();
		footer.setOpaque(true);
		footer.setBackground(Color.cyan);
		footer.setLayout(new GridLayout(2,2,0,40));
		mipanel.add(footer,BorderLayout.SOUTH);
		
		JLabel text1 = new JLabel("Interés");
		text1.setBorder(BorderFactory.createMatteBorder(30, 80, 1, 1, Color.cyan));
		footer.add(text1);
		
		JTextField textw1 = new JTextField("315.00000002");
		footer.add(textw1);
		
		JLabel text2 = new JLabel("Monto");
		text2.setBorder(BorderFactory.createMatteBorder(1, 80, 30, 1, Color.cyan));
		footer.add(text2);
		
		JTextField textw2 = new JTextField("1815.00000002");
		footer.add(textw2);
		
		/*
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(4,3));
		centro.add(botones,BorderLayout.CENTER);
		
		String[] textos = {"9","8","7","6","5","4","3","2","1","0","."}; 
		
		for (String texto_boton : textos) {
			
			JButton boton = new JButton(texto_boton);
			botones.add(boton);
		}
		
		
		
		
		*/
		
		return mipanel;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
	}
	
	/*
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(new BasicStroke(5));
		
		g2d.drawRect(100, 100, 80, 80);
		
		g2d.setColor(Color.orange);
		
		g2d.fillRect(120, 120, 80, 80);
		
		g2d.setColor(Color.green);
		
		g2d.setFont(new Font("American Typewriter",Font.BOLD,60));
		g2d.drawString("Hola", 150, 200);
		
		g2d.drawLine(0,0,400,400);
		
		
		g2d.drawArc(400, 100, 100, 100, 0, -180);
		
		g2d.setColor(Color.black);
		g2d.drawArc(400, 100, 100, 100, 0, 180);
		g2d.setColor(Color.orange);
		g2d.fillArc(400, 100, 100, 100, 0, 180);
		
		g2d.drawOval(100, 400, 90, 190);
		
		g2d.fillOval(150, 400, 190, 90);
		
		try {
			
			BufferedImage image = ImageIO.read(new File("maths.png"));
			g2d.drawImage(image, 500, 150, null);
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] xs = {400,350,450};
		int[] ys = {200,250,250};
		
		g2d.drawPolygon(xs, ys, 3);
		
		int[] xs2 = {420,370,470};
		int[] ys2 = {220,270,270};
		
		g2d.fillPolygon(xs2 , ys2, 3);
		
		
		g2d.drawRoundRect(500, 300, 100, 100, 30, 30);
		
		g2d.setColor(Color.black);
		g2d.fillRoundRect(550, 350, 100, 100, 30, 30);
		
	}
	*/
	
	
}
















