package idstv;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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

public class Paint implements MouseListener, MouseMotionListener{

	private JFrame frame;
	private DrawingPanel drawingPanel; 
	
	private Point lastPoint; // Para almacenar la última posición del mouse
     // Para almacenar los puntos dibujados
	private List<Point> points = new ArrayList<>();
	
    List<List<Point>> listaDePuntos = new ArrayList<>();
    
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
		panel_1.add(btnNewButton, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		panel_3.add(btnNewButton_1);
		
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
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub 
		lastPoint = e.getPoint();
        points.add(lastPoint); // Añadir el primer punto
         
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub 
		
		
		ArrayList<Point> listaCopiada = (ArrayList<Point>) (((ArrayList<Point>) points).clone());
		
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
		 
		 points.add(newPoint);  
	        
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
	        for (List<Point> trazo : listaDePuntos) {
	            if (trazo.size() > 1) {
	                for (int i = 1; i < trazo.size(); i++) {
	                    Point p1 = trazo.get(i - 1);
	                    Point p2 = trazo.get(i);
	                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
	                }
	            }
	        }
	        
	        // Dibujar el trazo actual (points) mientras se arrastra el mouse
	        if (points.size() > 1) {
	            for (int i = 1; i < points.size(); i++) {
	                Point p1 = points.get(i - 1);
	                Point p2 = points.get(i);
	                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
	            }
	        }
	    }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}










