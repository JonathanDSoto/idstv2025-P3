package idstv;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pacman implements KeyListener{

	private JFrame frame;
	private DrawingPanel tablero;
	private int x = 200, y = 100;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacman window = new Pacman();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pacman() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(109, 89, 213));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(109, 89, 213));
		frame.getContentPane().add(footer, BorderLayout.SOUTH);
		
		tablero = new DrawingPanel();
		tablero.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(tablero, BorderLayout.CENTER);
		
		tablero.addKeyListener(this);
		tablero.setFocusable(true);
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x = 200;
				y = 100;
				
				tablero.repaint();
				
				tablero.requestFocus();
			}
			
		});
		footer.add(reiniciar);
		
		//score jlabel
		//botón para reiniciar
	}
	
	class DrawingPanel extends JPanel {
	    public DrawingPanel() {
	        setBackground(Color.WHITE);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        
	        g2d.setColor(Color.yellow);
	        g2d.fillOval(x, y, 30, 30);
	        
	         
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub 
		System.out.println(x);
		if(e.getKeyCode()==87) {
			y-=5;
		}
		if(e.getKeyCode()==83) {
			y+=5;
		}
		if(e.getKeyCode()==65) {
			x-=5;
		}
		if(e.getKeyCode()==68) {
			x+=5;
			if(x>=445) {
				x=-25;
			}
		} 
		
		tablero.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
