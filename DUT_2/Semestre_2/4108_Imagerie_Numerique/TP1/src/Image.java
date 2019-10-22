import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Image {

  protected int[] pixels;
  protected int height;
  protected int width;
  protected static int display=0;

  // constructeur par défaut
  public Image(int width, int height) {
    this.width=width;
    this.height=height;
    pixels=new int[width*height];
    Arrays.fill(pixels,0);
  }

  // constructeur par recopie
  public Image(Image i) {
    width=i.width;
    height=i.height;
    pixels=Arrays.copyOf(i.pixels,i.pixels.length);
  }

  // constructeur par chargement d'image
  public Image(String filename) {
    try{
      BufferedImage bimg = ImageIO.read(new File(filename));
      Raster raster=bimg.getData();
      this.width=bimg.getWidth();
      this.height=bimg.getHeight();
      pixels=raster.getSamples(0,0,width,height,0,pixels);
    }
    catch(IOException ex) {
      System.out.println("Problème lecture du fichier : "+filename);
      ex.printStackTrace();
    }
  }

  // retourne la hauteur de l'image
  public int getHeight() {
    return height;
  }

  // retourne la largeur de l'image
  public int getWidth() {
    return width;
  }

  // accesseur en lecture
  public int getValue(int x, int y) {
    return pixels[x+y*width];
  }

  // accesseur en écriture
  public void setValue(int x, int y, int v) {
    pixels[x+y*width]=v;
  }

  // affichage de l'image  
  public void display() {
    // conversion en BufferedImage
    BufferedImage bimg=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
    byte [] buffer = ((DataBufferByte) bimg.getRaster().getDataBuffer()).getData();
    for (int p=0;p<buffer.length;p++)
      buffer[p] = (byte)(pixels[p]);

    // Création de la fenêtre d'affichage et affichage
    display++;
    JFrame f = new JFrame("Display: "+display);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    ImageIcon imageIcon = new ImageIcon(bimg);
    JLabel jLabel = new JLabel();
    jLabel.setIcon(imageIcon);
    f.getContentPane().add(jLabel, BorderLayout.CENTER);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }

  // affichage de l'image  en couleurs aléatoires
  public void displayColor() {
    // génération de la table de pseudo-couleurs
    int max=0;
    for (int p=0;p<pixels.length;p++)
      if(pixels[p]>max)
        max=pixels[p];
    int[] tab=new int[max+1];
    Random r=new Random();
    int l=256*256*256;
    for (int t=0;t<tab.length;t++)
      tab[t]=r.nextInt(l);
    // conversion en BufferedImage
    BufferedImage bimg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);    
    int [] buffer = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
    for (int p=0;p<buffer.length;p++)
      buffer[p] = tab[pixels[p]];

    // Création de la fenêtre d'affichage et affichage
    display++;
    JFrame f = new JFrame("Display: "+display);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    ImageIcon imageIcon = new ImageIcon(bimg);
    JLabel jLabel = new JLabel();
    jLabel.setIcon(imageIcon);
    f.getContentPane().add(jLabel, BorderLayout.CENTER);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }

  /**
   * Exercice 1
   * @param a
   * @param b
   * @return
   * @throws Exception
   */
  public Image globalMultiplyAdd(double a, double b) throws Exception {
    Image ret = new Image(this);
    //    if(a<0) throw new Exception("valeur a < 0");
    //    if(b>255) throw new Exception("valeur b > 255");
    //    if(b<-255) throw new Exception("valeur b < -255");
    int tmp;
    for(int i=0; i<ret.pixels.length; i++) {
      tmp = (int) (a*ret.pixels[i]+b);
      if(tmp > 255) tmp=255;
      if(tmp < 0) tmp=0;
      ret.pixels[i]= tmp;
    }
    return ret;
  }

  /**
   * Exercice 2
   * @param a
   * @param b
   * @param c
   * @param d
   * @return
   * @throws Exception
   */
  public Image spatialMultiplyAdd(Image a, Image b, double c) throws Exception {
    Image ret = new Image(this);
    //    if(a == null) throw new Exception("Image a null");
    //    if(b == null) throw new Exception("Image b null");
    //    if(c<0) throw new Exception("valeur c < 0");

    int tmp;
    b = b.globalMultiplyAdd(c,0);
    for(int i=0; i<ret.pixels.length; i++) {
      tmp = (a.pixels[i]*ret.pixels[i]+b.pixels[i]);
      if(tmp > 255) tmp=255;
      if(tmp < 0) tmp=0;
      ret.pixels[i]= tmp;
    }
    return ret;
  }

  /**
   * Exercice 3
   * @param alpha
   * @param image1
   * @param image2
   * @return
   * @throws Exception
   */
  public Image alphaBlending(double alpha, Image image1, Image image2) throws Exception {
    Image ret = new Image(this);
    if(image1 == null) throw new Exception("image1 null");
    if(image2 == null) throw new Exception("image2 null");
    int tmp;
    for(int i=0; i<ret.pixels.length; i++) {
      tmp = (int) (alpha*image1.pixels[i]+(1-alpha)*image2.pixels[i]);
      if(tmp > 255) tmp=255;
      if(tmp < 0) tmp=0;
      ret.pixels[i]= tmp;
    }
    return ret;
  }

  /**
   * Exercice 3
   * @param alpha
   * @param image1
   * @param image2
   * @return
   * @throws Exception
   */
  public Image spatialAlphaBlending(Image alpha, Image image1, Image image2) throws Exception {
    if(image1 == null) throw new Exception("image1 null");
    if(image2 == null) throw new Exception("image2 null");  
    int tmp;
    int minWidth, minHeight;
    minWidth = image1.width;
    if(minWidth > image2.width)minWidth = image2.width;
    if(minWidth > alpha.width)minWidth = alpha.width;
    minHeight = image1.height;
    if(minHeight > image2.height)minHeight = image2.height;
    if(minHeight > alpha.height)minHeight = alpha.height;

    Image ret = new Image(minWidth, minHeight);
    for(int i=0; i<ret.pixels.length; i++) {
      tmp = (int) ((alpha.pixels[i]/255.0)*image1.pixels[i]+(1-(alpha.pixels[i]/255.0))*image2.pixels[i]);
      if(tmp > 255) tmp=255;
      if(tmp < 0) tmp=0;
      ret.pixels[i]= tmp;
    }
    return ret;
  }

  /**
   * Exercice 4
   */
  public Image dynamicExpansion() {
    double val;
    int min = 255;
    int max = 0;
    for(int i=0; i<this.pixels.length; i++) {
      if(this.pixels[i] < min) min = this.pixels[i];
      if(this.pixels[i] > max) max = this.pixels[i];
    }
    int[] value = new int[256];
    for(int k=0; k<256; k++) {
      val = k-min;
      val = (val/(max-min))*255;
      value[k] = (int) val;
    }
    for(int j=0; j<this.pixels.length; j++) {
      this.pixels[j] = value[this.pixels[j]];
    }
    return this;
  }

  /**
   * Exercice 5
   * @return
   */
  public int[] histogram() {
    int[] ret = new int[256];
    for(int i=0; i<this.pixels.length; i++) {
      int index = this.pixels[i];
      ret[index]++;
    }
    return ret;
  }

  /**
   * Exercice 5
   * @return
   */
  public double[] normalizedHistogram() {
    double[] ret = new double[256];
    int[] histo = this.histogram();
    double val=0.0;
    for (int i=0; i<256;i++){
      val = histo[i];
      ret[i] = val / this.pixels.length;
    }
    return ret;
  }

  /**
   * Exercice 5
   * @param image
   * @param histogramme
   * @return
   */
  public Image dynamicExpansion(Image image, int[] histogramme) {
    double val;
    int min = 255;
    int max = 0;
    for(int i=0; i<256; i++) {
      if(i < min && histogramme[i] != 0) min = i;
      if(i > max && histogramme[i] != 0) max = i;
    }
    int[] value = new int[256];
    for(int k=0; k<256; k++) {
      val = k-min;
      val = (val/(max-min))*255;
      value[k] = (int) val;
    }
    for(int j=0; j<this.pixels.length; j++) {
      this.pixels[j] = value[this.pixels[j]];
    }
    return this;
  }

  /**
   * Exercice 6
   * @param histogramme
   * @return
   */
  public double[] cumule(double[] histogramme) {
    double[] ret = new double[256];
    double cumule =0.0;
    for(int i=0; i<256; i++) {
      cumule = cumule + histogramme[i];
      ret[i] = cumule;
    }
    return ret;
  }

  /**
   * Exercice 6
   * @param histogramme
   * @return
   */
  public Image dynamicEgalization(double[] histogramme) {
    histogramme = cumule(histogramme);
    for(int i=0; i<histogramme.length; i++) {
      histogramme[i] = histogramme[i]*255.0;
    }
    for(int j=0; j<this.pixels.length; j++) {
      this.pixels[j] = (int) histogramme[this.pixels[j]];
    }
    return this;
  }
  
  // tests basiques de la classe
  public static void main(String[] args) {

    Image image2=new Image("coins.png");
    Image image3=new Image("damier.jpg");
    Image image4=new Image("question.png");
    Image image5=new Image("question2.png");
    Image image6=new Image("golfe2ndg.jpg");
    Image image1=new Image(image3.height,image3.width);

    for(int i=0;i<image1.getWidth();i++)
      for(int j=0;j<image1.getHeight();j++)
        image1.setValue(i,j,Math.abs(i-j));
    //    image1.display();    
    //    image2.display();
    //    image1.displayColor();

    /*
     * Exercice 1
     */
//    try {
//    	image2.globalMultiplyAdd(0.1,30).display();
//    } catch (Exception e) {
//    	e.printStackTrace();
//    }

    /*
     * Exercice 2
     */
//    try {
//    	image2.spatialMultiplyAdd(image3, image2, 0.3).display();
//    } catch (Exception e) {
//    	e.printStackTrace();
//    }

    /*
     * Exercice 3
     */
//    try {
//    	image2.alphaBlending(0.5,image2, image3).display();
//    	image2.spatialAlphaBlending(image1,image2, image3).display();
//    } catch (Exception e) {
//    	e.printStackTrace();
//    }

    /*
     * Exercice 4
     */
    //    try {
    //      image5.display();
    //      image5.dynamicExpansion().display();
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //    }

    /*
     * Exercice 5
     */
    //    try {
    //      image5.display();
    //      image5.dynamicExpansion(image5, image5.histogram());
    //      image5.display();
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //    }

    /*
     * Exercice 6
     */
//    try {
//      image5.dynamicEgalization(image5.normalizedHistogram()).display();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
  }
}