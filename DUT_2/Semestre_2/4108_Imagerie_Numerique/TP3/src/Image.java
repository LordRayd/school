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
		return pixels[x + y * width];
	}

	/** 
	 * accesseur en �criture
	 * @param x
	 * @param y
	 * @param v
	 */
	public void setValue(int x, int y, int v) {
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

	/**
	 * TP2_1
	 * @param t
	 * @return
	 */
	public Image seuillage(int t) {
		for (int i = 0; i < this.pixels.length; i++) {
			if (this.pixels[i] < t) {
				this.pixels[i] = 0;
			} else {
				this.pixels[i] = 255;
			}
		}
		return this;
	}

	/** TP2_2
	 * @return
	 */
	public Image otsu() {
		int[] histo = this.histogram();
		double somme = 0;
		for (int t = 0; t < 256; t++) {
			somme += t * histo[t];
		}
		double sommeA = 0;
		int wA = 0;
		int wB = 0;
		double varMax = 0;
		int threshold = 0;
		for (int i = 0; i < 256; i++) {
			wA += histo[i];
			if (wA == 0)
				continue;
			wB = this.pixels.length - wA;
			if (wB == 0)
				break;
			sommeA += (double) (i * histo[i]);
			double moyA = sommeA / wA;
			double moyB = (somme - sommeA) / wB;
			double var = (double) wA * (double) wB * (moyA - moyB) * (moyA - moyB);
			if (var > varMax) {
				varMax = var;
				threshold = i;
			}
		}
		this.seuillage(threshold);
		return this;
	}

	/** TP2_8
	 * @return
	 */
	public Image etiquetage() {
		Image ret = new Image(this);
		int etiquette = 0;
		for (int x = 0; x < ret.getWidth(); x++) {
			for (int y = 0; y < ret.getHeight(); y++) {
				if (ret.getValue(x, y) == 255) {
					etiquette++;
					ret = diffusion(x, y, etiquette, ret);
				}
			}
		}
		return ret;
	}

	/**
	 * TP2_8
	 * @param x
	 * @param y
	 * @param etiquette
	 * @param ret
	 * @return
	 */
	public Image diffusion(int x, int y, int etiquette, Image ret) {
		System.out.println(etiquette);
		if (etiquette != 255) {
			if (ret.getValue(x - 1, y - 1) == 255) {
				ret.setValue(x - 1, y - 1, etiquette);
				diffusion(x - 1, y - 1, etiquette, ret);
			}

			if (ret.getValue(x + 1, y - 1) == 255) {
				ret.setValue(x + 1, y - 1, etiquette);
				diffusion(x + 1, y - 1, etiquette, ret);
			}

			if (ret.getValue(x - 1, y + 1) == 255) {
				ret.setValue(x - 1, y + 1, etiquette);
				diffusion(x - 1, y + 1, etiquette, ret);
			}

			if (ret.getValue(x + 1, y + 1) == 255) {
				ret.setValue(x + 1, y + 1, etiquette);
				diffusion(x + 1, y + 1, etiquette, ret);
			}
		}
		return ret;
	}

	/**
	 * TP3_1
	 * @return
	 */
	public Image segmentation() {
		Image ret = new Image(this);
		ret = ret.otsu();
		ret = ret.etiquetage();
		return ret;
	}

	/**
	 * TP3_2
	 * @return
	 */
	/* public Image segmentationLPE() {
		Image ret = new Image(this);
		ArrayList<Integer> fifo = new ArrayList<Integer>();
		int curLab = 0;
		int[] lab, dist;
		int hMin = this.minGrey();
		int hMax = this.maxGrey();
		lab = new int[this.pixels.length];
		dist = new int[this.pixels.length];
		for (int i = 0; i < this.pixels.length; i++) {
			lab[i] = -1;
			dist[i] = 0;
		}
		for (int h = hMin; h <= hMax; h++) {
			for (int i = 0; i < this.pixels.length; i++) {
				if (this.pixels[i] == h) {
					lab[i] = -2;
	
				}
			}
		}
	
		return ret;
	}
	
	public int maxGrey() {
		int ret = 0;
		for (int i = 0; i < this.pixels.length; i++) {
			if (ret < this.pixels[i]) {
				ret = this.pixels[i];
			}
		}
		return ret;
	}
	
	public int minGrey() {
		int ret = 255;
		for (int i = 0; i < this.pixels.length; i++) {
			if (ret > this.pixels[i]) {
				ret = this.pixels[i];
			}
		}
		return ret;
	} */

	/**
	 * TP3_4
	 * @return
	 */
	public Image transformeeDistance1() {
		Image ret = new Image(this.width, this.height);
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				ret.setValue(x, y, this.calculDist(x, y, ret));
			}
		}
		return ret;
	}

	public int calculDist(int x, int y, Image img) {
		int ret = 0;
		return ret;
	}

	/**
	 * TP4_1
	 * @param masque
	 * @return
	 */
	public Image convolution(int[][] masque) {
		Image ret = new Image(this.width, this.height);
		int lengthMas = masque.length;
		System.out.println("length : " + lengthMas);
		int val = (lengthMas - 1) / 2;
		System.out.println("val : " + val);
		int parcoursX, parcoursY, sum;
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				sum = 0;
				parcoursX = 0;
				for (int i = x - val; i < x + val; i++) {
					if (i >= 0 && i < this.width && parcoursX <= lengthMas) {
						parcoursY = 0;
						for (int j = y - val; j < y + val; j++) {
							if (j >= 0 && j < this.height && parcoursY <= lengthMas) {
								sum += this.getValue(i, j) * masque[parcoursX][parcoursY];
							}
							parcoursY++;
						}
					}
					parcoursX++;
				}
				ret.setValue(x, y, sum);
			}
		}
		return ret;
	}

	/**
	 * TP4_2
	 * @param masque1
	 * @param masque2
	 * @return
	 */
	public Image convolution(int[] masque1, int[] masque2) {
		Image ret = this;
		if (masque1.length == masque2.length) {
			int lengthMas = masque1.length;
			System.out.println("length : " + lengthMas);
			int val = (lengthMas - 1) / 2;
			System.out.println("val : " + val);
			int parcoursX, parcoursY, sum;
			for (int x = 0; x < this.width; x++) {
				for (int y = 0; y < this.height; y++) {
					sum = 0;
					parcoursX = 0;
					for (int i = x - val; i < x + val; i++) {
						if (i >= 0 && i < this.width && parcoursX <= lengthMas) {
							parcoursY = 0;
							for (int j = y - val; j < y + val; j++) {
								if (j >= 0 && j < this.height && parcoursY <= lengthMas) {
									sum += this.getValue(i, j) * masque1[parcoursX] * masque2[parcoursY];
								}
								parcoursY++;
							}
						}
						parcoursX++;
					}
					ret.setValue(x, y, sum);
				}
			}
		}
		return ret;
	}

	/**
	 * TP4_2
	 * @param masque
	 * @return
	 */
	public Image convolution(int[] masque) {
		Image ret = new Image(this.width, this.height);
		int lengthMas = (int) Math.sqrt(masque.length);
		System.out.println("length : " + lengthMas);
		int val = (lengthMas - 1) / 2;
		System.out.println("val : " + val);
		int parcours, sum;
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				sum = 0;
				parcours = 0;
				for (int i = x - val; i < x + val; i++) {
					if (i >= 0 && i < this.width && parcours <= masque.length) {
						for (int j = y - val; j < y + val; j++) {
							if (j >= 0 && j < this.height && parcours <= masque.length) {
								sum += this.getValue(i, j) * masque[parcours];
							}
							parcours++;
						}
					}
					parcours++;
				}
				ret.setValue(x, y, sum);
			}
		}
		return ret;
	}

	/** 
	 * tests basiques de la classe
	 * @param args
	 */
	public static void main(String[] args) {
		Image image2 = new Image("../coins.png");
		Image image3 = new Image("../damier.jpg");
		Image image4 = new Image("../question.png");
		Image image5 = new Image("../question2.png");
		Image image6 = new Image("../circuit.jpg");
		Image image7 = new Image("../golfe2ndg.jpg");
		Image image1 = new Image(image3.height, image3.width);

		for (int i = 0; i < image1.getWidth(); i++) {
			for (int j = 0; j < image1.getHeight(); j++) {
				image1.setValue(i, j, Math.abs(i - j));
			}
		}
		/* image1.display();
		image2.display();
		image1.displayColor();
		image3.display();
		
		int[][] masque = new int[5][5];
		
		masque[0][0] = 0;
		masque[0][1] = 0;
		masque[0][2] = 0;
		masque[0][3] = 0;
		masque[0][4] = 0;
		
		masque[1][0] = 0;
		masque[1][1] = 0;
		masque[1][2] = 0;
		masque[1][3] = -1;
		masque[1][4] = 0;
		
		masque[2][0] = 0;
		masque[2][1] = -1;
		masque[2][2] = 5;
		masque[2][3] = -1;
		masque[2][4] = 0;
		
		masque[3][0] = 0;
		masque[3][1] = 0;
		masque[3][2] = -1;
		masque[3][3] = 0;
		masque[3][4] = 0;
		
		masque[4][0] = 0;
		masque[4][1] = 0;
		masque[4][2] = 0;
		masque[4][3] = 0;
		masque[4][4] = 0;
		
		masque[0][0] = 0;
		masque[0][1] = 0;
		masque[0][2] = 0;
		
		masque[1][0] = 0;
		masque[1][1] = 1;
		masque[1][2] = 0;
		
		masque[2][0] = 0;
		masque[2][1] = 0;
		masque[2][2] = 0;
		
		image7.convolution(masque).display();
		
		int[] leMasque = { 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 5, -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 };
		image7.convolution(leMasque).display(); */

		int[] masque1 = { 0, 1, 0 };
		int[] masque2 = { 0, -1, 0 };
		image7.convolution(masque1, masque2).display();
	}
}