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


public class JF_Board {


    // The main GUI that might be added to a frame.
    private JPanel gui;
    
    // Image boundaries [width x height]
    private int width = 320;
    private int height = 240;
    
    // Image used to make changes.
    private BufferedImage canvasImage;
    
    // Label to assign the image. 
    private JLabel imageLabel;
    
    // The color used to make strokes
    private Color colorBlack = Color.BLACK;
    // The color used to make a carbon copy of the images
    private Color colorWhite = new Color(255, 255, 255); //WHITE COLOR
    private Color colorGray = new Color(150, 150, 150); //GRAY COLOR
    
    // Strokes to hand drawing and carbon copies
    private Stroke stroke = new BasicStroke(15,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10.0F);
    private Stroke pixelStroke = new BasicStroke(1,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND,10.0F);
    
    // RenderingHints options
    private RenderingHints renderingHints;

    JLabel lbScore = new JLabel("..........");
    
    // Initiates all the GUI components
    /**
     * @wbp.parser.entryPoint
     */
    public JComponent getGui() {
            Map<Key, Object> hintsMap = new HashMap<RenderingHints.Key,Object>();
            hintsMap.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            hintsMap.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            hintsMap.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            renderingHints = new RenderingHints(hintsMap); 

            // Set the image boundaries [width x height]
            setImage(new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB));
            
            // Initialize the gui Panel.
            gui = new JPanel();
            gui.setBorder(null);
      		gui.setLayout(null);

            // Set the canvasImage as Label icon
      		imageLabel = new JLabel(new ImageIcon(canvasImage));
      		imageLabel.setBounds(1, 1, width+1, height+1);
      		
      		// Initialize the imageView Panel boundaries [width x height].
            JPanel imageView = new JPanel();
            imageView.setBorder(null);
            imageView.setLayout(null);
            imageView.add(imageLabel);
            
      		// Creates the ScrollPane and adds the imageView to it.
      		JScrollPane imageScroll = new JScrollPane(imageView);
      		imageScroll.setBounds(1, 1, width+5, height+5);
      		
      		// Add the mouse listeners to imageLabel 
      		imageLabel.addMouseMotionListener(new ImageMouseMotionListener());
            imageLabel.addMouseListener(new ImageMouseListener());
            
            
            // Clear button actionListener
            ActionListener clearListener = new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    clear(canvasImage);
                }
            };
            // Creates the Clear button
            JButton clearButton = new JButton("Clear");
            clearButton.setBounds(130, 250, 60, 30);
            clearButton.addActionListener(clearListener);
    
            // Adds the imageScroll and ClearButton to the gui panel.
            gui.add(imageScroll);
            gui.add(clearButton);
            
           
            lbScore.setHorizontalAlignment(SwingConstants.CENTER);
            lbScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lbScore.setBounds(200, 250, 104, 27);
            gui.add(lbScore);
            
            // Clear the canvasImage at the start.
            clear(canvasImage);
        return gui;
    }
    
    // Set the image to the canvas and pastes it to the GUI.
    public void setImage(BufferedImage image) {
        // Initialize the canvasImage with the image values.
        canvasImage = new BufferedImage(width+1,height+1,BufferedImage.TYPE_INT_RGB);  //ANTES TYPE_INT_ARGB
        // Creates a 2D graph from canvasImage.
        Graphics2D g = this.canvasImage.createGraphics();
        g.setRenderingHints(renderingHints);
        // Paste the image to gui on position [0,0]
        g.drawImage(image, 0, 0, gui);
        g.dispose(); 
    }
    
    
    // Clears the entire image area by painting it with the current color.
    public void clear(BufferedImage canvas){
    	BufferedImage img = null;
        try {
      		img = ImageIO.read(new File("C:/Users/acunaarl/Documents/GitHub/Japaneasy/src/img/year.png"));
      	} catch (IOException ex) {
      		ex.printStackTrace();
      	}
        Graphics2D imgG = img.createGraphics();
        
        Graphics2D canvasG = canvas.createGraphics();
        
        
        for(int x=1; x<320; x++){
        	for(int y=1; y<240; y++){
            	  // Getting pixel color by position x and y 
               	  int pixel=  img.getRGB(x,y); 
               	  int  red   = (pixel & 0x00ff0000) >> 16;
               	  int  green = (pixel & 0x0000ff00) >> 8;
               	  int  blue  =  pixel & 0x000000ff;
               	  
               	  if (red==255 && green==255 && blue==255){   // WHITE COLOR
               	  //if (red==150 && green==150 && blue==150){
               		  canvasG.setColor(colorWhite);
               	  } else {
               		  canvasG.setColor(colorGray);
               	  }
               	  
               	  canvasG.setStroke(pixelStroke);
           		  canvasG.drawLine(x, y, x, y);
                 }
        	}
        imgG.dispose();
        canvasG.dispose();
        imageLabel.repaint();
        black = 0;
        gray = 0;
        lbScore.setText("..........");
        }
  
    
    public double black = 0;
    public double gray = 0;
    	
    public void medir(){ 
    	
    	
  	    BufferedImage img;
        int imgW, imgH;
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
    	  
        for(int x=0; x<width; x++){
      	  for(int y=0; y<height; y++){
      		  // Getting pixel color by position x and y 
          	  int clr=  img.getRGB(x,y); 
          	  int  red   = (clr & 0x00ff0000) >> 16;
          	  int  green = (clr & 0x0000ff00) >> 8;
          	  int  blue  =  clr & 0x000000ff;
          	  
          	  if (red==0 && green==0 && blue==0)
          		  negro = negro + 1;
          	  if (red==150 && green==150 && blue==150)
        		  gris = gris + 1;
          	  if (red==255 && green==255 && blue==255)
        		  blanco = blanco + 1;
           }
        }
        //System.out.println("Blanco " + blanco);
        //System.out.println("Gris " + gris);
        //System.out.println("Negro " + negro);
  	  
        if (black==0 && gray == 0) {
        	black = gris * 1.40;
        	gray = gris;
    	}

        
        if (negro < black*0.10 && gris < gray){
        	lbScore.setText("l.........");
        }
        else if (negro < (black * 0.20) && gris < (gray * 0.92)){
        	lbScore.setText("ll........");
        }
        else if (negro < (black * 0.30) && gris < (gray * 0.82)){
        	lbScore.setText("lll.......");
        }
        else if (negro < (black * 0.40) && gris < (gray * 0.72)){
        	lbScore.setText("llll......");
        }
        else if (negro < (black * 0.50) && gris < (gray * 0.62)){
        	lbScore.setText("lllll.....");
        }
        else if (negro < (black * 0.60) && gris < (gray * 0.52)){
        	lbScore.setText("llllll....");
        }
        else if (negro < (black * 0.70) && gris < (gray * 0.42)){
        	lbScore.setText("lllllll...");
        }
        else if (negro < (black * 0.80) && gris < (gray * 0.32)){
        	lbScore.setText("llllllll..");
        }
        else if (negro < (black * 0.90) && gris < (gray * 0.22)){
        	lbScore.setText("lllllllll.");
        }
        else if (negro > (black * 1.10) && gris < (gray * 0.02)){
        	lbScore.setText("llllllllll");
        	JOptionPane.showMessageDialog(gui, "Well done!!!");
        } 
        else if (negro > (black * 1.15)){
        	JOptionPane.showMessageDialog(gui, "Hold your hourses!!!");
        	clear(canvasImage);
        }
        
        
  	////WILSON END
    }
    
    



    



    
    
   
    public void draw(Point point) {
        Graphics2D g = this.canvasImage.createGraphics();
        g.setRenderingHints(renderingHints);
        g.setColor(this.colorBlack);
        g.setStroke(stroke);
        int n = 0; //Thick of the point
        g.drawLine(point.x, point.y, point.x+n, point.y+n);
        g.dispose();
        
        this.imageLabel.repaint();
        medir();
    }
    
    
    public void mierda(){
    	Color myWhite = new Color(150, 0, 0); // Color white
        int rgb = myWhite.getRGB();
        if(((canvasImage.getRGB(50, 50) & 0x00ff0000) >> 16 )== 0 ){
        	
        } else {
        	for (int i=0; i < 50; i++){
        		for (int j=0; j < 50; j++){
        			canvasImage.setRGB(i+50 , j+50 , rgb);
        			canvasImage.setRGB(i+100, j+100, BufferedImage.TYPE_INT_RGB);
                }
        	}
        }
    }
    

    class ImageMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent arg0) {
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

    

    public static void main(String[] args) {
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

                JFrame f = new JFrame("Japaneasy");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(bp.getGui());
                
                f.pack();
                f.setSize(343, 325);
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

