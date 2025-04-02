package idstv;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class Paint implements MouseListener, MouseMotionListener{

	private JFrame frame;
	private DrawingPanel drawingPanel; 
	
	private Point lastPoint; // Para almacenar la última posición del mouse
     // Para almacenar los puntos dibujados
	private List<MyPoint> points = new ArrayList<>();
	
	private List<Rectangle> figuras = new ArrayList<>();
	
    List<List<MyPoint>> listaDePuntos = new ArrayList<>();
    
    //1 = pincel, 2 = cuadrado
    private int method = 1, grosor = 2;
    private Color color = Color.black;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
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
	public Paint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Pincel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				method = 1;
				
			}
		});
		panel_1.add(btnNewButton, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(10, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				points.clear();
				figuras.clear();
				listaDePuntos.clear();
				drawingPanel.repaint();
			}
		});
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rectangulo");
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				method = 2;
			}
			
		});
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("-");
		panel_3.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_3.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				grosor+=1;
				
				lblNewLabel.setText(grosor+"");
			}
		});
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Rojo");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.red;
			}
		});
		btnNewButton_5.setBackground(new Color(255, 11, 0));
		btnNewButton_5.setOpaque(true);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Verde");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				color = Color.green;
			}
		});
		btnNewButton_6.setBackground(new Color(2, 234, 0));
		btnNewButton_6.setOpaque(true);
		panel_3.add(btnNewButton_6);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
			
		
		drawingPanel = new DrawingPanel();
        panel.add(drawingPanel, BorderLayout.CENTER);

        drawingPanel.addMouseListener(this);
        drawingPanel.addMouseMotionListener(this);
	        
		/*JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		panel_2.addMouseListener(this);
		panel_2.addMouseMotionListener(this);*/
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(method==2) {
			Rectangle tmp = new Rectangle(e.getX(),e.getY(),100,100);
			figuras.add(tmp);
		}
		
		
		drawingPanel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub 
		lastPoint = e.getPoint();
		
		MyPoint p = new MyPoint(lastPoint,color,grosor);
		
        points.add(p); // Añadir el primer punto
         
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub 
		
		
		ArrayList<MyPoint> listaCopiada = (ArrayList<MyPoint>) (((ArrayList<MyPoint>) points).clone());
		
		listaDePuntos.add(listaCopiada); 
		points.clear();
		
		System.out.println(listaDePuntos);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub 
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		 Point newPoint = e.getPoint(); 
		 
		 if(method==1)
			 points.add(new MyPoint(newPoint,color,grosor));  
	        
	     drawingPanel.repaint();
	        
	     lastPoint = newPoint;
	        
	        
	}

	class DrawingPanel extends JPanel {
	    public DrawingPanel() {
	        setBackground(Color.WHITE);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        
	        // Configuración del dibujo
	        g2d.setColor(Color.BLACK);
	        g2d.setStroke(new BasicStroke(3));
	        
	        // Dibujar todos los trazos guardados (listaDePuntos)
	        for (List<MyPoint> trazo : listaDePuntos) {
	            if (trazo.size() > 1) {
	                for (int i = 1; i < trazo.size(); i++) { 
	                	
	                	MyPoint p1 = trazo.get(i - 1);
	                	MyPoint p2 = trazo.get(i);
	                	
	                	g2d.setColor(p1.c);
	                	g2d.setStroke(new BasicStroke(p1.g));
	                	
	                    g2d.drawLine(p1.p.x, p1.p.y, p2.p.x, p2.p.y);
	                }
	            }
	        }
	        
	        // Dibujar el trazo actual (points) mientras se arrastra el mouse
	        if (points.size() > 1) {
	            for (int i = 1; i < points.size(); i++) {
	            	
	            	g2d.setColor(points.get(i).c ); 
	            	
	                MyPoint p1 = points.get(i - 1);
	                MyPoint p2 = points.get(i);
	                
	                g2d.setStroke(new BasicStroke(p1.g));
	                
	                g2d.drawLine(p1.p.x, p1.p.y, p2.p.x, p2.p.y);
	            }
	        }
	        
	        for (Iterator iterator = figuras.iterator(); iterator.hasNext();) {
				Rectangle rectangle = (Rectangle) iterator.next();
				
				g2d.drawRect(rectangle.x, rectangle.y, rectangle.w, rectangle.h);
				
			}
	    }
	}
	
	class MyPoint extends Point{
		
		private Point p;
		private Color c;
		private int g;
		
		public MyPoint(Point p,Color c, int g)
		{
			this.p = p;
			this.c = c;
			this.g = g;
		}
	}
	
	class Rectangle{
		
		private int x,y,w,h;
		
		public Rectangle(int x, int y,int w, int h)
		{
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}










