import java.util.Arrays;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;

public class Image {

	protected int[] pixels;
	protected int height;
	protected int width;
	protected static int display=0;

	// constructeur par défaut} 
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
	
	// affichage de l'image	en couleurs aléatoires
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
	
	
	//Exercice1
	public Image seuillage(int t) {
		for(int x = 0 ; x < this.width ; x++) {
			for(int y = 0 ; y < this.height ; y++) {
				if(this.getValue(x, y) < t) {
					this.setValue(x, y, 0);
				} else {
					this.setValue(x,  y,  255);
				}
			}
		}
		return this;
	}
	
	
	//Histogramme
	public int[] histogram() {
		int[] ret = new int[256];
		for(int x = 0 ; x < this.getWidth() ; x ++) {
			for(int y = 0 ; y < this.getHeight() ; y ++) {
				ret[this.getValue(x, y)] ++;
			}
		}
		return ret;
	}

	//HistogrammeNormalisé
	public double[] normalizedHistogram() {
		double[] ret = new double[256];
		int[] histo = this.histogram();
		for(int i = 0 ; i < 256 ; i ++) {
			ret[i] = histo[i] / (double)(this.pixels.length);
		}
		return ret;
	}
	
	//Exercice2 _ Algo1
	public Image otsu() {		
		double[] histo = this.normalizedHistogram();
		double[] variance = new double[histo.length];

		for(int k = 0 ; k < histo.length ; k ++) {
			double moyA = 0.0;
			double moyB = 0.0;
			double probaA = 0.0;
			double probaB = 0.0;
			
			for(int i = 0 ; i < k ; i++) {
				probaA = probaA + histo[i];
				moyA = moyA + i * histo[i];
			}
			for(int j = k ; j < histo.length ; j ++) {
				probaB = probaB + histo[j];
				moyB = moyB + j * histo[j];
			}
			moyA = moyA / probaA;
			moyB = moyB / probaB;
			variance[k] = probaA * probaB * ((moyA - moyB) * (moyA - moyB));
		}

		
		double varianceMax = 0.0;
		int seuilMax = 0;
		for(int l = 0 ; l < variance.length ; l ++) {
			if(variance[l] > varianceMax) {
				varianceMax = variance[l];
				seuilMax = l;
			}
		}

		this.seuillage((int)seuilMax);
		return this;
	}
	
	//Exercice2 _ Algo2
	public Image iterativeSelectionThresholding() {
		int t = 128;
		int s = -1;
		double moyA = 0.0;
		double moyB = 0.0;
		double probaA = 0.0;
		double probaB = 0.0;

		double[] histo = this.normalizedHistogram();
		while(t < s - 1 || t > s + 1) {
			s = t;
			for(int i = 0 ; i < t ; i++) {
				moyA = moyA + i * histo[i];
				probaA = probaA + i * histo[i];
			}
			
			for(int j = t ; j < 256 ; j ++) {
				moyB = moyB + j * histo[j];
				probaB = probaB + j * histo[j];
			}
			
			moyA = moyA / probaA;
			moyB = moyB / probaB;
			
			t = (int)(moyA + moyB)/2;
		}
		
		this.seuillage(t);
		
		return this;
	}
	
	
	//Exercice3
	public Image otsu2(int s) {
		for(int x = 0 ; x < this.width ; x ++) {
			for(int y = 0 ; y < this.height ; y ++) {
				if(this.getValue(x, y) < this.intOtsu(s, x, y)) {
					this.setValue(x, y, 0);
				} else {
					this.setValue(x, y, 255);
				}
			}
		}
		return this;
	}
	
	
	public int intOtsu(int s, int x, int y) {		
		double[] histo = this.normalizedHistogramSeuillage(s, x, y);
		double[] variance = new double[histo.length];

		for(int k = 0 ; k < histo.length ; k ++) {
			double moyA = 0.0;
			double moyB = 0.0;
			double probaA = 0.0;
			double probaB = 0.0;
			
			for(int i = 0 ; i < k ; i++) {
				probaA = probaA + histo[i];
				moyA = moyA + i * histo[i];
			}
			for(int j = k ; j < histo.length ; j ++) {
				probaB = probaB + histo[j];
				moyB = moyB + j * histo[j];
			}
			moyA = moyA / probaA;
			moyB = moyB / probaB;
			variance[k] = probaA * probaB * ((moyA - moyB) * (moyA - moyB));
		}

		
		double varianceMax = 0.0;
		int seuilMax = 0;
		for(int l = 0 ; l < variance.length ; l ++) {
			if(variance[l] > varianceMax) {
				varianceMax = variance[l];
				seuilMax = l;
			}
		}

		return (int)seuilMax;
	}
	
	
	
	public double[] normalizedHistogramSeuillage(int s, int x, int y) {
		int[] histo = new int[256];
		double[] ret = new double[256];
		int pixels = 0;
		for(int xs = x - s ; xs < x + s ; xs ++) {
			for(int ys = y - s ; ys < y + s ; ys ++) {
				if(xs >= 0 && xs <= this.width && ys >= 0 && ys <= this.height) {
					histo[this.getValue(xs, ys)] ++;
					pixels ++;
				}
			}
		}
		
		for(int i = 0 ; i < histo.length ; i ++) {
			ret[i] = histo[i] / (double)(pixels);
		}
		
		return ret;
	}

	
	//Exercice4
	public Image erosion3x3(){
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				if(this.min(x, y, 3))
					ret.setValue(x, y, 0);
			}
		}
		return ret;
	}
	
	public Image dilatation3x3() {
		Image ret = new Image(this);
		for(int x = 0 ; x < this.getWidth(); x ++) {
			for(int y = 0 ; y < this.getHeight() ; y ++) {
				if(this.max(x, y, 3)) {
					ret.setValue(x, y, 255);
				}
			}
		}
		return ret;
	}
	
	public boolean min(int x, int y, int s) {
		boolean trouve = false;
		s = (int)( s / 2);
		int xs = x - s;
		while(xs <= x + s && trouve != true) {
			//System.out.println("xs : "+xs);
			int ys = y -s;
			while(ys <= y + s && trouve != true) {
				//System.out.println("ys : "+ys);
				if(xs > 0 && xs < this.width && ys > 0 && ys < this.height && xs != x && ys != y) {
					if(this.getValue(xs, ys) == 0) {
						trouve = true;
					}
				}
				ys ++;
			}
			xs ++;
		}
		return trouve;
	}
	
	public boolean max(int x, int y, int s) {
		boolean trouve = false;
		s = (int)( s / 2);
		int xs = x - s;
		while(xs <= x + s && trouve != true) {
			//System.out.println("xs : "+xs);
			int ys = y -s;
			while(ys <= y + s && trouve != true) {
				//System.out.println("ys : "+ys);
				if(xs > 0 && xs < this.width && ys > 0 && ys < this.height && xs != x && ys != y) {
					if(this.getValue(xs, ys) == 255) {
						trouve = true;
					}
				}
				ys ++;
			}
			xs ++;
		}
		return trouve;
	}
	
	
	//Exercice5_1
	public Image erosionNxN(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				if(this.min(x, y, n))
					ret.setValue(x, y, 0);
			}
		}
		return ret;
	}
	
	//Exercice5_2
	public Image dilatationNxN(int n) {
		Image ret = new Image(this);
		for(int x = 0 ; x < this.getWidth(); x ++) {
			for(int y = 0 ; y < this.getHeight() ; y ++) {
				if(this.max(x, y, n)) {
					ret.setValue(x, y, 255);
				}
			}
		}
		return ret;
	}

	
	//Exercice7_1
	public Image ouverture(int n) {
		Image ret = new Image(this);
		return ret.erosionNxN(n).dilatationNxN(n);
	}
	
	public Image fermeture(int n) {
		Image ret = new Image(this);
		return ret.dilatationNxN(n).erosionNxN(n);
	}

	public Image topHatOuv(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.getValue(x, y) - ret.ouverture(n).getValue(x, y)));
				System.out.println("pixel : " + x + " ; " + y);
			}
		}
		return ret;
	}
	
	public Image topHatFer(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.fermeture(n).getValue(x, y) - ret.getValue(x, y)));
				System.out.println("pixel : " + x + " ; " + y);
			}
		}
		return ret;
	}
	
	public Image gradMorpho(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.dilatationNxN(n).getValue(x, y) - ret.erosionNxN(n).getValue(x, y)));
				System.out.println("pixel : " + x + " ; " + y);
			}
		}
		return ret;
	}
	
	public Image lapMorpho(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.dilatationNxN(n).getValue(x, y) + ret.erosionNxN(n).getValue(x, y) - 2 * ret.getValue(x, y)));
				System.out.println("pixel : " + x + " ; " + y);
			}
		}
		return ret;
	}
	
	public Image toutEnRien(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.erosionNxN(n).getValue(x, y) - ret.dilatationNxN(n).getValue(x, y)));
				System.out.println("pixel : " + x + " ; " + y);
			}
		}
		return ret;
	}
	
	// tests basiques de la classe
	public static void main(String[] args) {
		//Image image1=new Image(256,256);
		
		//for(int i=0;i<image1.getWidth();i++)
			//for(int j=0;j<image1.getHeight();j++)
			//	image1.setValue(i,j,Math.abs(i-j));
		//image1.display();
	
		//Image image2=new Image("damier.jpg");
		//image2.display();
		
		//image1.displayColor();
		
		
		//Image image1 = new Image("question2.png");
		//image1.display();
		//image1.seuillage(128).display();
		
		//Image image1 = new Image("golfe.jpg");
		//image1.otsu2(5).display();
		//image1.display();
		
		Image image = new Image("coins.png");
		
		//Exercice4
		//image.seuillage(128).display();
		//image.seuillage(128).erosion3x3().display();
		//image.seuillage(128).dilatation3x3().display();
		
		//Exercice5
		//image.seuillage(128).display();
		//image.seuillage(128).erosionNxN(5).display();
		//image.seuillage(128).dilatationNxN(5).display();
		
		//Exercice7
		image.display();
		//image.seuillage(128).erosionNxN(5).display();
		//image.seuillage(128).dilatationNxN(5).display();
		//image.seuillage(128).ouverture(5).display();
		//image.seuillage(128).fermeture(5).display();
		image.topHatOuv(5).display();
	}
		
}