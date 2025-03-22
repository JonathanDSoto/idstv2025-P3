package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Memorama {

	private JFrame frame;
	public int cartas[] = {1,1,2,2,3,3,4,4,5,5,6,6};
	public int c1 = -1,c2 = -1;
	public ArrayList<JButton> cartas2 = new ArrayList<JButton>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memorama window = new Memorama();
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
	public Memorama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 754, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(109, 89, 213));
		frame.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Juego de Memorama");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_1.add(lblNewLabel,BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[0]+".png")));
				
				
				cartas2.add(btnNewButton);
				
				if(c1 == -1) {
					c1 = cartas[0];
				}else
					if(c2 == -1) {
						c2 = cartas[0];
					}
				
				if(c1 == c2 && c1 != -1) {
					
					JOptionPane.showMessageDialog(null, "ok", "ok", JOptionPane.ERROR_MESSAGE);
					 
					
					for (Iterator iterator = cartas2.iterator(); iterator.hasNext();) {
						JButton jButton = (JButton) iterator.next();
						
						jButton.setEnabled(false); 
						
					} 
					
					cartas2.removeAll(cartas2);
					
					c1 = -1;
					c2 = -1;
					
				}else 
				if( c1!= -1 && c2!= -1 )
				{
					
					JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
					
					for (Iterator iterator = cartas2.iterator(); iterator.hasNext();) {
						JButton jButton = (JButton) iterator.next();
						jButton.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/hidden.png")));
						
					} 
					
					cartas2.removeAll(cartas2);
					
					c1 = -1;
					c2 = -1;
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/hidden.png")));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton_4.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[0]+".png")));
				cartas2.add(btnNewButton_4);
				
				if(c1 == -1) {
					c1 = cartas[1];
				}else
					if(c2 == -1) {
						c2 = cartas[1];
					}
				
				if(c1 == c2 && c1 != -1) {
					//joption
				}else 
				if( c1!= -1 && c2!= -1 )
				{
					
					JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
					
					for (Iterator iterator = cartas2.iterator(); iterator.hasNext();) {
						JButton jButton = (JButton) iterator.next();
						jButton.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/hidden.png")));
						
					} 
					
					c1 = -1;
					c2 = -1;
				}
			
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/hidden.png")));
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton_1.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[4]+".png")));
				
				if(c1 == -1) {
					c1 = cartas[4];
				}else
					if(c2 == -1) {
						c2 = cartas[4];
					}
				
				cartas2.add(btnNewButton_1);
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_4_1 = new JButton("New button");
		panel_2.add(btnNewButton_4_1);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_4_1_1 = new JButton("New button");
		panel_2.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		panel_2.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		panel_2.add(btnNewButton_13);
	}

}
