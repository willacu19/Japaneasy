package match;

/*
Color myWhite = new Color(255, 0, 0); // Color white
int rgb = myWhite.getRGB();
canvasImage.setRGB(50, 50, rgb);
System.out.println("DIAY");
*/

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JF_Board {

    /** Reference to the original image. */
	private BufferedImage originalImage;
    /** Image used to make changes. */
    private BufferedImage canvasImage;
    /** The main GUI that might be added to a frame or applet. */
    private JPanel gui;
    /** The color to use when calling clear, text or other 
     * drawing functionality. */
    private Color colorWhite = Color.WHITE;
    private Color colorBlack = Color.BLACK;
    
    private BufferedImage colorSample = new BufferedImage(
            16,16,BufferedImage.TYPE_INT_RGB);
    private JLabel imageLabel;

    private Rectangle selection;
    private boolean dirty = false;
    private Stroke stroke = new BasicStroke(15,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,1.7f);
    private RenderingHints renderingHints;
    private boolean start = true;

    /**
     * @wbp.parser.entryPoint
     */
    public JComponent getGui() {
    	System.out.println("getGUI");
        if (gui==null) {
            Map<Key, Object> hintsMap = new HashMap<RenderingHints.Key,Object>();
            hintsMap.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            hintsMap.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            hintsMap.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            renderingHints = new RenderingHints(hintsMap); 

            setImage(new BufferedImage(320,240,BufferedImage.TYPE_INT_RGB));
            gui = new JPanel(new BorderLayout(4,4));
            gui.setBorder(new EmptyBorder(5,3,5,3));

            JPanel imageView = new JPanel(new GridBagLayout());
            imageView.setPreferredSize(new Dimension(480,320));
            
            
//////////////
            
      		BufferedImage MycanvasImage;
      		BufferedImage img = null;
      		try {
      			img = ImageIO.read(new File("C:/Users/acunaarl/Documents/GitHub/Japaneasy/src/img/year.jpg"));
      		} catch (IOException ex) {
      			ex.printStackTrace();
      		}
      		MycanvasImage = img;
      		
//////////////
            
            
            
      		
      		imageLabel = new JLabel(new ImageIcon(canvasImage));
            JScrollPane imageScroll = new JScrollPane(imageView);
            imageView.add(imageLabel);
            imageLabel.addMouseMotionListener(new ImageMouseMotionListener());
            imageLabel.addMouseListener(new ImageMouseListener());
            gui.add(imageScroll,BorderLayout.CENTER);

            JToolBar tb = new JToolBar();
            tb.setFloatable(false);

            ActionListener clearListener = new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int result = JOptionPane.OK_OPTION;
                    if (dirty) {
                        result = JOptionPane.showConfirmDialog(
                                gui, "Erase the current painting?");
                    }
                    if (result==JOptionPane.OK_OPTION) {
                        clear(canvasImage);
                    }
                }
            };
            JButton clearButton = new JButton("Clear");
            tb.add(clearButton);
            clearButton.addActionListener(clearListener);

            gui.add(tb, BorderLayout.PAGE_START);
            
            JButton btnMedir = new JButton("Medir");
            btnMedir.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent arg0) {
            		medir();
            	}
            });
            tb.add(btnMedir);

            JToolBar tools = new JToolBar(JToolBar.VERTICAL);
            tools.setFloatable(false);
            final JRadioButton draw = new JRadioButton("Draw");
            draw.setSelected(true);       
            tools.add(draw); 




            gui.add(tools, BorderLayout.LINE_END);
            clear(colorSample);
            clear(canvasImage);
            
        }

        return gui;
    }

    /** Clears the entire image area by painting it with the current color. */
    public void clear(BufferedImage bi) {
    	System.out.println("clear");
        Graphics2D g = bi.createGraphics();
        g.setRenderingHints(renderingHints);
        g.setColor(colorWhite);                                         // COLOR DEL FONDO
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());

        g.dispose();
        imageLabel.repaint();
    }
   
    
    public void medir(){
    	System.out.println("medir");
    ////WILSON START
    	
  	  BufferedImage img;
        int imgW, imgH;
        System.out.println(imageLabel.getHeight());
        System.out.println(imageLabel.getWidth());
  	  Icon icon = imageLabel.getIcon();
        imgW = icon.getIconWidth();
        imgH = icon.getIconHeight();
        //this.setPreferredSize(new Dimension(imgW * 10, imgH * 10));
        img = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
  	  
  	      	      	      	  
  	  //BufferedImage image = imageLabel.getIcon().paintIcon(null, g2d, 0, 0);
        int blanco = 0;
    	int gris = 0;
    	int negro = 0;
    	  
        for(int x=1; x<160; x++){
      	  for(int y=1; y<120; y++){
      		  // Getting pixel color by position x and y 
          	  int clr=  img.getRGB(x,y); 
          	  int  red   = (clr & 0x00ff0000) >> 16;
          	  int  green = (clr & 0x0000ff00) >> 8;
          	  int  blue  =  clr & 0x000000ff;
          	  
          	  if (red==0 && red==0 && red==0)
          		  negro = negro + 1;
          	  if (red==150 && red==150 && red==150)
        		  gris = gris + 1;
          	  if (red==255 && red==255 && red==255)
        		  blanco = blanco + 1;
           }
        }
        System.out.println("Blanco " + blanco);
        System.out.println("Gris " + gris);
        System.out.println("Negro " + negro);
  	  
  	////WILSON END
    }
    
    

    public void setImage(BufferedImage image) {
    	System.out.println("setImage");
        this.originalImage = image;
        int w = image.getWidth();
        int h = image.getHeight();
        canvasImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = this.canvasImage.createGraphics();
        g.setRenderingHints(renderingHints);
        g.drawImage(image, 0, 0, gui);
        g.dispose();

        selection = new Rectangle(0,0,w,h); 
        if (this.imageLabel!=null) {
            imageLabel.setIcon(new ImageIcon(canvasImage));
            this.imageLabel.repaint();
        }
        if (gui!=null) {
            gui.invalidate();
        }
        
        
    }


    public boolean canExit() {
    	System.out.println("canExit");
        boolean canExit = false;
        SecurityManager sm = System.getSecurityManager();
        if (sm==null) {
            canExit = true;
        } else {
            try {
                sm.checkExit(0);
                canExit = true; 
            } catch(Exception stayFalse) {
            }
        }
        return canExit;
    }


    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {
    	System.out.println("main");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    // use default
                }
                JF_Board bp = new JF_Board();

                JFrame f = new JFrame("DooDoodle!");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(bp.getGui());

                f.pack();
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
    
    
   
    public void draw(Point point) {
    	System.out.println("draw");
        Graphics2D g = this.canvasImage.createGraphics();
        g.setRenderingHints(renderingHints);
        g.setColor(this.colorBlack);
        g.setStroke(stroke);
        System.out.println("point X = " + point.x);
        System.out.println("point Y = " + point.y);
        int n = 0; //Thick of the point
        g.drawLine(point.x, point.y, point.x+n, point.y+n);
        g.dispose();
        
        
        mierda();
        
        this.imageLabel.repaint();
        
    }
    
    
    public void mierda(){
    	Color myWhite = new Color(150, 0, 0); // Color white
        int rgb = myWhite.getRGB();
        if(((canvasImage.getRGB(50, 50) & 0x00ff0000) >> 16 )== 0 ){
        	
        } else {
        	canvasImage.setRGB(50, 50, rgb);
        }
        System.out.println("DIAY");
    }
    

    class ImageMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            draw(arg0.getPoint());
        }
    }

    class ImageMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent arg0) {
            reportPositionAndColor(arg0);
            draw(arg0.getPoint());
        }

        @Override
        public void mouseMoved(MouseEvent arg0) {
            reportPositionAndColor(arg0);
        }

    }

    private void reportPositionAndColor(MouseEvent me) {
    }
}

