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
	protected static int display = 0;

	/** 
	 * constructeur par d�faut
	 * @param width
	 * @param height
	 */
	public Image(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		Arrays.fill(pixels, 0);
	}

	/** 
	 * constructeur par recopie
	 * @param i
	 */
	public Image(Image i) {
		width = i.width;
		height = i.height;
		pixels = Arrays.copyOf(i.pixels, i.pixels.length);
	}

	/** 
	 * constructeur par chargement d'image
	 * @param filename
	 */
	public Image(String filename) {
		try {
			BufferedImage bimg = ImageIO.read(new File(filename));
			Raster raster = bimg.getData();
			this.width = bimg.getWidth();
			this.height = bimg.getHeight();
			this.pixels = raster.getSamples(0, 0, width, height, 0, pixels);
		} catch (IOException ex) {
			System.out.println("Probleme lecture du fichier : " + filename);
			ex.printStackTrace();
		}
	}

	/** 
	 * retourne la hauteur de l'image
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}

	/** 
	 * retourne la largeur de l'image
	 * @return
	 */
	public int getWidth() {
		return this.width;
	}

	/** 
	 * accesseur en lecture
	 * @param x
	 * @param y
	 * @return
	 */
	public int getValue(int x, int y) {

		try{
			return pixels[x + y * width];
		}catch (Exception e){
			return -1;
		}
	}

	/** 
	 * accesseur en ecriture
	 * @param x
	 * @param y
	 * @param v
	 */
	public void setValue(int x, int y, int v) {
		/* if (v > 255) {
			v = 255;
		} else if (v < 0) {
			v = 0;
		} */
		pixels[x + y * width] = v;
	}

	/** 
	 * affichage de l'image  
	 */
	public void display() {
		// conversion en BufferedImage
		BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		byte[] buffer = ((DataBufferByte) bimg.getRaster().getDataBuffer()).getData();
		for (int p = 0; p < buffer.length; p++)
			buffer[p] = (byte) (pixels[p]);

		// Cr�ation de la fen�tre d'affichage et affichage
		display++;
		JFrame f = new JFrame("Display: " + display);
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
	 * Affichage de l'image  en couleurs aleatoires
	 */
	public void displayColor() {
		// generation de la table de pseudo-couleurs
		int max = 0;
		for (int p = 0; p < pixels.length; p++)
			if (pixels[p] > max)
				max = pixels[p];
		int[] tab = new int[max + 1];
		Random r = new Random();
		int l = 256 * 256 * 256;
		for (int t = 0; t < tab.length; t++)
			tab[t] = r.nextInt(l);
		// conversion en BufferedImage
		BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int[] buffer = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
		for (int p = 0; p < buffer.length; p++)
			buffer[p] = tab[pixels[p]];

		// Cr�ation de la fen�tre d'affichage et affichage
		display++;
		JFrame f = new JFrame("Display: " + display);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ImageIcon imageIcon = new ImageIcon(bimg);
		JLabel jLabel = new JLabel();
		jLabel.setIcon(imageIcon);
		f.getContentPane().add(jLabel, BorderLayout.CENTER);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	/** TP1_5
	 * @return Un tableau
	 */
	public int[] histogram() {
		int[] ret = new int[256];
		for (int i = 0; i < this.pixels.length; i++) {
			int index = this.pixels[i];
			ret[index]++;
		}
		return ret;
	}

	/** TP1_5
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
	 * 
	 * @return
	 */
	public double[] textureDescriptor1st(){
		double[] hist = this.normalizedHistogram();
		double[] ret = new double[4];
		double val;
		for(int i=0; i<255;i++){
			ret[0] += i*hist[i];
		}
		for(int i=0; i<255;i++){
			ret[1] += Math.pow(i-ret[0], 2)*hist[i];
			ret[2] += Math.pow(hist[i], 2);
			val = hist[i];
			if(val == 0)val=0.000001;
			ret[3] = val;
		}
		ret[1] = Math.sqrt(ret[1]);
		ret[3] = -ret[3];
		return ret;
	}
	
	/**
	 * 
	 */
	private Image imRescale(int p){
		Image ret = new Image(this.getWidth(), this.getHeight());
		for ( int y=0; y<this.getHeight(); y++){
			for (int x=0; x<this.getWidth(); x++){
				ret.setValue(x,y, (int)Math.round((this.getValue(x,y)*(p-1))/(double)255 ) );
			}
		}
		return ret;
	}

	/**
	 * 
	 */
	public int[][] glcm(int p, int[] dxdy){
		Image img = this.imRescale(p);
		int[][] ret = new int[p][p];
		int dx = dxdy[0];
		int dy = dxdy[1];
		for (int x=0; x<this.getWidth(); x++){
			for (int y=0; y<this.getHeight(); y++){
				ret[img.getValue(x,y)][img.getValue(x+dxdy[0],y+dxdy[1])]++;
			}
		}
		return ret;
	}

	/**
	 * 
	 */
	public double[][] normalizedGlcm(int p,int[] dxdy){
		Image img = this.imRescale(p);
		double[][] ret = new double[p][p];
		double divide = this.getWidth() * this.getHeight();
		for (int x=0; x<this.getWidth(); x++){
			for (int y=0; y<this.getHeight(); y++){
				ret[img.getValue(x,y)][img.getValue(x+dxdy[0],y+dxdy[1])]++;
			}
		}

		for (int x=0; x<this.getWidth(); x++){
			for (int y=0; y<this.getHeight(); y++){
				ret[img.getValue(x,y)][img.getValue(x+dxdy[0],y+dxdy[1])] /= divide;
			}
		}

		return ret;
	}

	public static void main(String[] args){
		Image image = new Image("../bois.jpg");
		double[] test = image.textureDescriptor1st();
		for(int i=0;i<4;i++){
			System.out.println(test[i]);
		}
	}
}