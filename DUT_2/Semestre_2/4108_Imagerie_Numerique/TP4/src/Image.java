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
	 * accesseur en �criture
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

	/**
	 * 
	 */
	public void dft(Image image, Image module, Image phase) {
		int N = image.width;
		int M = image.height;
		double fRe = 0;
		double fIm = 0;
		double valPha = 0.0;
		for (int u = 0; u < N; u++) {
			for (int v = 0; v < M; v++) {
				fRe = 0;
				fIm = 0;
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < M; y++) {
						fRe += (double) (image.getValue(x, y)) * Math.cos(
								2.0 * Math.PI * ((double) (x * u) / (double) (N) + (double) (y * v) / (double) (M)));
						fIm += (double) (image.getValue(x, y)) * Math.sin(
								2.0 * Math.PI * ((double) (x * u) / (double) (N) + (double) (y * v) / (double) (M)));
					}
				}
				fIm = 0 - fIm;
				valPha = Math.atan((double) (fRe / fIm));
				module.setValue(u, v, (int) Math.sqrt((Math.pow(fRe, 2) + Math.pow(fIm, 2))));
				phase.setValue(u, v, (int) valPha);
			}
		}
	}

	public Image getReImage() {
		int N = this.width;
		int M = this.height;
		Image ret = new Image(N,M);
		double fRe = 0;
		for (int u = 0; u < N; u++) {
			for (int v = 0; v < M; v++) {
				fRe = 0;
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < M; y++) {
						fRe += (double) (this.getValue(x, y)) * Math.cos(
								2.0 * Math.PI * ((double) (x * u) / (double) (N) + (double) (y * v) / (double) (M)));
					}
				}
				ret.setValue(u, v, (int)fRe);
			}
		}
		return ret;
	}

	public Image getImImage() {
		int N = this.width;
		int M = this.height;
		Image ret = new Image(N,M);
		double fIm = 0;
		double valPha = 0.0;
		for (int u = 0; u < N; u++) {
			for (int v = 0; v < M; v++) {
				fIm = 0;
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < M; y++) {
						fIm += (double) (this.getValue(x, y)) * Math.sin(
							2.0 * Math.PI * ((double) (x * u) / (double) (N) + (double) (y * v) / (double) (M)));
					}
				}
				ret.setValue(u, v, (int)-fIm);
			}
		}
		return ret;
	}


	public Image dwtHaar(int n){
		Image ret = new Image(this);
		for(int i=0; i<n; i++){
			Image ilines = new Image(this.getWidth(), this.getHeight());
			
			for(int y=0; y<this.height/(i+1); y++){
				for (int k=0; k<(int)(this.width/2)/(i+1)-1; k++){
					int s = (int)((ret.getValue(2*k, y) + ret.getValue(2*k+1, y))/2);
					int d = (int)((ret.getValue(2*k, y) - ret.getValue(2*k+1, y))/2);
					ilines.setValue(k, y, s);
					ilines.setValue((int)(this.width/2)/(i+1)+k, y, d);
				}
			}
			
			for(int k=0; k<(int)(this.height/2)/(i+1)-1; k++){
				for (int x=0; x<this.width/(i+1); x++){
					int s = (int)((ilines.getValue(x,2*k) + ilines.getValue(x, 2*k+1))/2);
					int d = (int)((ilines.getValue(x, 2*k) - ilines.getValue(x, 2*k+1))/2);
					ret.setValue(x, k, s);
					ret.setValue(x, (int)(this.height/2)/(i+1)+k, d);
				}
			}
			
		}

		return ret;
	}

	public static void main(String[] args){
		Image image = new Image("lenaTest3.jpg");
		Image mod = new Image(image.width, image.height);
		Image phase = new Image(image.width, image.height);
		image.dft(image, mod, phase);
		mod.displayColor();
		image.dwtHaar(3).display();
    }
}