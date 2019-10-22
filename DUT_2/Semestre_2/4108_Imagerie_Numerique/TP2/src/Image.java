import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Image {

	/**
	 * 
	 */
	protected int[] pixels;
	protected int height;
	protected int width;
	protected static int display=0;

	/** 
	 * constructeur par defaut
	 * @param width
	 * @param height
	 */
	public Image(int width, int height) {
		this.width=width;
		this.height=height;
		pixels=new int[width*height];
		Arrays.fill(pixels,0);
	}

	/** 
	 * constructeur par recopie
	 * @param i
	 */
	public Image(Image i) {
		width=i.width;
		height=i.height;
		pixels=Arrays.copyOf(i.pixels,i.pixels.length);
	}

	/** 
	 * constructeur par chargement d'image
	 * @param filename
	 */
	public Image(String filename) {
		try{
			BufferedImage bimg = ImageIO.read(new File(filename));
			Raster raster=bimg.getData();
			this.width=bimg.getWidth();
			this.height=bimg.getHeight();
			pixels=raster.getSamples(0,0,width,height,0,pixels);
		}
		catch(IOException ex) {
			System.out.println("Probl�me lecture du fichier : "+filename);
			ex.printStackTrace();
		}
	}

	/** 
	 * retourne la hauteur de l'image
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/** 
	 * retourne la largeur de l'image
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/** 
	 * accesseur en lecture
	 * @param x
	 * @param y
	 * @return
	 */
	public int getValue(int x, int y) {
		return pixels[x+y*width];
	}

	/** 
	 * accesseur en �criture
	 * @param x
	 * @param y
	 * @param v
	 */
	public void setValue(int x, int y, int v) {
		pixels[x+y*width]=v;
	}

	/** 
	 * affichage de l'image  
	 */
	public void display() {
		// conversion en BufferedImage
		BufferedImage bimg=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
		byte [] buffer = ((DataBufferByte) bimg.getRaster().getDataBuffer()).getData();
		for (int p=0;p<buffer.length;p++)
			buffer[p] = (byte)(pixels[p]);

		// Cr�ation de la fen�tre d'affichage et affichage
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
	 * Affichage de l'image  en couleurs al�atoires
	 */
	public void displayColor() {
		// g�n�ration de la table de pseudo-couleurs
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

		// Cr�ation de la fen�tre d'affichage et affichage
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

	/** TP1_5
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
	 * TP1_5
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
	 * Exercice 1
	 * @param t
	 * @return
	 */
	public Image seuillage(int t){
		for(int i=0; i<this.pixels.length; i++){
			if(this.pixels[i] < t){
				this.pixels[i] = 0;
			}else{
				this.pixels[i] = 255;
			}
		}
		return this;
	}

	/**
	 * Exercice 2
	 * @return
	 */
	public Image otsu(){
		int[] histo = this.histogram();
		double somme = 0;
		for (int t=0 ; t<256 ; t++){
			somme += t * histo[t];
		}
		double sommeA = 0;
		int wA = 0;
		int wB = 0;
		double varMax = 0;
		int threshold = 0;
		for (int i=0 ; i<256 ; i++) {
			wA += histo[i];
			if (wA == 0) continue;
			wB = this.pixels.length - wA;
			if (wB == 0) break;
			sommeA += (double) (i * histo[i]);
			double moyA = sommeA / wA;
			double moyB = (somme - sommeA) / wB;
			double var = (double)wA * (double)wB * (moyA - moyB) * (moyA - moyB);
			if (var > varMax) {
				varMax = var;
				threshold = i;
			}
		}
		this.seuillage(threshold);
		return this;
	}

	/**
	 * Exercice 2
	 * @return
	 */
	public Image iterativeSelectionThresholding(){
		double [] histo = this.normalizedHistogram();
		int t = 128;
		int[] ancienT = new int[256];
		while (ancienT[t] != 1){
			ancienT[t] = 1;
			int indexA=0;
			double moyA = 0.0;
			for(int i=0; i<t; i++){
				moyA += i * histo[i];
			}
			moyA = moyA/255;
			for(int j=0; j<t && moyA>=0;j++){
				moyA -= histo[j];
				indexA=j;
			}
			int indexB=0;
			double moyB = 0.0;
			for(int i=t; i<256; i++){
				moyB += i * histo[i];
			}
			moyB = moyB/255;
			for(int j=t; j<256 && moyB>=0;j++){
				moyB -= histo[j];
				indexB=j;
			}

			t = (indexA+indexB)/2;
		}
		this.seuillage(t);
		return this;
	}

	/** Exercice 2
	 * @return
	 */
	public Image otsuNormalized(){
		double[] histo = this.normalizedHistogram();
		double variance = 0.0;
		double varianceMax = 0.0;
		int seuil = 0;
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
			variance = probaA * probaB * ((moyA - moyB) * (moyA - moyB));
			if(variance > varianceMax){
				varianceMax = variance;
				seuil = k;
			}
		}
		this.seuillage(seuil);
		return this;
	}

	/**
	 * Exercice3
	 * @param s
	 * @return
	 */
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

	/**
	 * Exercice 3
	 * @param s
	 * @param x
	 * @param y
	 * @return
	 */
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

	/**
	 * Exercice 3
	 * @param s
	 * @param x
	 * @param y
	 * @return
	 */
	public double[] normalizedHistogramSeuillage(int s, int x, int y) {
		int[] histo = new int[256];
		double[] ret = new double[256];
		int pixels = 0;
		for(int xs = x - s ; xs < x + s ; xs ++) {
			for(int ys = y - s ; ys < y + s ; ys ++) {
				if(xs >= 0 && xs < this.width && ys >= 0 && ys < this.height) {
					histo[this.getValue(xs, ys)] ++;
					pixels ++;
				}
			}
		}
		for(int i = 0 ; i < 256 ; i ++) {
			ret[i] = histo[i] / (double)(pixels);
		}
		return ret;
	}

	/**
	 * Exercice 4
	 * @return
	 */
	public Image erosion3x3(){
		Image ret = new Image(this.getWidth(),this.getHeight());
		int x,y;
		int max;
		for(int i=0; i<this.pixels.length; i++){
			max = 0;
			x = i/ret.getWidth();
			y = i-(x*ret.getWidth());
			for(int k=y-1; k<=y+1; k++){
				if(k>=0 && k<ret.getWidth()){
					for(int j=x-1; j<=x+1; j++){
						if(j>=0 && j<ret.getHeight()){
							if(this.getValue(k, j) > max){
								max = this.getValue(k, j);
							}
						}
					}
				}
			}
			ret.pixels[i] =  max;
		}
		return ret;
	}

	/**
	 * Exercice 4
	 * @return
	 */
	public Image dilatation3x3(){
		Image ret = new Image(this.getWidth(),this.getHeight());
		int x,y;
		int min;
		for(int i=0; i<this.pixels.length; i++){
			min = 255;
			x = i/ret.getWidth();
			y = i-(x*ret.getWidth());
			for(int k=y-1; k<=y+1; k++){
				if(k>=0 && k<ret.getWidth()){
					for(int j=x-1; j<=x+1; j++){
						if(j>=0 && j<ret.getHeight()){
							if(this.getValue(k, j) < min){
								min = this.getValue(k, j);
							}
						}
					}
				}
			}
			ret.pixels[i] =  min;
		}
		return ret;
	}

	/**
	 * Exercice 5
	 * @param n
	 * @return
	 */
	public Image erosion(int n){
		Image ret = new Image(this.getWidth(),this.getHeight());
		int x,y;
		int max;
		for(int i=0; i<this.pixels.length; i++){
			max = 0;
			x = i/ret.getWidth();
			y = i-(x*ret.getWidth());
			for(int k=y-n; k<=y+n; k++){
				if(k>=0 && k<ret.getWidth()){
					for(int j=x-n; j<=x+n; j++){
						if(j>=0 && j<ret.getHeight()){
							if(this.getValue(k, j) > max){
								max = this.getValue(k, j);
							}
						}
					}
				}
			}
			ret.pixels[i] =  max;
		}
		return ret;
	}

	/**
	 * Exercice 5
	 * @return
	 */
	public Image dilatation(int n){
		Image ret = new Image(this.getWidth(),this.getHeight());
		int x,y;
		int min;
		for(int i=0; i<this.pixels.length; i++){
			min = 255;
			x = i/ret.getWidth();
			y = i-(x*ret.getWidth());
			for(int k=y-n; k<=y+n; k++){
				if(k>=0 && k<ret.getWidth()){
					for(int j=x-n; j<=x+n; j++){
						if(j>=0 && j<ret.getHeight()){
							if(this.getValue(k, j) < min){
								min = this.getValue(k, j);
							}
						}
					}
				}
			}
			ret.pixels[i] =  min;
		}
		return ret;
	}

	/**
	 * Exercice 7
	 * @param s
	 * @return
	 */
	public Image ouverture(int s){
		Image ret = new Image(this);
		return ret.erosion(s).dilatation(s);
	}

	/**
	 * Exercice 7
	 */
	public Image fermeture(int s){
		Image ret = new Image(this);
		return ret.dilatation(s).erosion(s);
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public Image topHatOuv(int n) {
		Image ret = new Image(this);
		Image ouv = ret.ouverture(n);
		for(int i=0; i<ret.pixels.length; i++) ret.pixels[i]= ret.pixels[i] - ouv.pixels[i]; 
		return ret;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public Image topHatFer(int n) {
		Image ret = new Image(this);
		Image fer = ret.dilatation(n);
		for(int i=0; i<ret.pixels.length; i++) ret.pixels[i]= ret.pixels[i] - fer.pixels[i]; 
		return ret;
	}

	/**
	 * 
	 */
	public Image gradMorpho(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.dilatation(n).getValue(x, y) - ret.erosion(n).getValue(x, y)));
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public Image lapMorpho(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.dilatation(n).getValue(x, y) + ret.erosion(n).getValue(x, y) - 2 * ret.getValue(x, y)));
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public Image toutEnRien(int n) {
		Image ret = new Image(this);
		for(int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++){
				ret.setValue(x, y, (ret.erosion(n).getValue(x, y) - ret.dilatation(n).getValue(x, y)));
			}
		}
		return ret;
	}

	/**
	 * 
	 */
	private int nbLabel;
	
	/**
	 * 
	 * @return
	 */
	public int[] etiquetageINIT(){
		int[] etiq = new int[this.pixels.length];
		nbLabel = 0;
		for(int x = 0; x < this.width ; x ++) {
			for(int y = 0; y < this.height ; y ++) {
				etiq = this.etiquetage(etiq,nbLabel,x,y);
			}
		}
		return etiq;
	}

	/**
	 * 
	 */
	public int[] etiquetage(int[] etiq, int nbLabel, int xInit,int yInit){

		if(this.getValue(xInit, yInit)==255 && etiq[xInit+yInit*this.width]==0){

			for(int x=xInit-1; x<=xInit+1; x++) {

				for(int y=yInit-1; y<=yInit+1; y++) {

					if(x>=0 && y>=0 && y<this.height && x<this.width){

						if(xInit!=x && yInit!=y){

							if(this.getValue(x, y)==255){

								if(etiq[x+y*this.width]!=0){

									etiq[xInit+yInit*this.width] = etiq[x+y*this.width];

									etiq = this.etiquetage(etiq, nbLabel,x,y);

								}else if(etiq[x+y*this.width]==0){

									nbLabel++;

									etiq[xInit+yInit*this.width]= nbLabel;

									etiq = this.etiquetage(etiq, nbLabel, x, y);
								}
							}
						}
					}
				}
			}
		}	
		return etiq;
	}
	
	/**
	 * Exercice8
	 * @return
	 */
	public Image etiquetage() {
		Image ret = this.otsu();
		int etiquette = 0;
		for(int x = 0 ; x < ret.getWidth(); x ++) {
			for(int y = 0 ; y <ret.getHeight() ; y ++) {
				if(ret.getValue(x, y) == 255) {
					etiquette ++;
					ret = diffusion(x, y, etiquette, ret);
				}
			}
		}
		return ret;
	}

	/**
	 * Exercie 8
	 * @param x
	 * @param y
	 * @param etiquette
	 * @param ret
	 * @return
	 */
	public Image diffusion(int x, int y, int etiquette, Image ret) {
		System.out.println(etiquette);
		if(etiquette != 255) {
			if(ret.getValue(x - 1, y - 1) == 255) {
				ret.setValue(x - 1, y - 1, etiquette);
				diffusion(x - 1, y - 1, etiquette, ret);
			}

			if(ret.getValue(x + 1, y - 1) == 255) {
				ret.setValue(x + 1, y - 1, etiquette);
				diffusion(x + 1, y - 1, etiquette, ret);
			}

			if(ret.getValue(x - 1, y + 1) == 255) {
				ret.setValue(x - 1, y + 1, etiquette);
				diffusion(x - 1, y + 1, etiquette, ret);
			}

			if(ret.getValue(x + 1, y + 1) == 255) {
				ret.setValue(x + 1, y + 1, etiquette);
				diffusion(x + 1, y + 1, etiquette, ret);
			}
		}
		return ret;
	}

	//Exercice9
	public ArrayList<Integer> tableEtiq() {
		ArrayList<Integer> table = new ArrayList<Integer>();
		Image ret = this;
		int etiquette = 0;
		int etiqMin = 0;
		int boucle1 = 0, boucle2 = 0, boucle3 = 0, boucle4 = 0;

		for(int x = 0 ; x < ret.getWidth() ; x ++) {
			for(int y = 0 ; y < ret.getHeight() ; y ++) {
				if(ret.getValue(x, y) != 0) {
					//System.out.println("Valeur : " +x+" : "+y+ " ! "+ret.getValue(x, y));
					etiquette ++;
					//System.out.println(etiquette);
					table.add(etiquette);
					//System.out.println("A : " +table.get(table.size()-1));
					etiqMin = etiquette;

					if(x - 1 > 0 && y - 1 > 0) {
						if(ret.getValue(x - 1, y - 1) != 0 && ret.getValue(x - 1, y - 1) < etiqMin) {
							etiqMin = ret.getValue(x - 1, y - 1);
							table.set(etiquette - 1, etiqMin);
							boucle1 ++;
						}
					}

					if(y - 1 > 0) {
						if(ret.getValue(x, y - 1) != 0 && ret.getValue(x, y - 1) < etiqMin) {
							etiqMin = ret.getValue(x, y - 1);
							table.set(etiquette - 1, etiqMin);
							boucle2 ++;
						}
					}

					if(x + 1 < ret.getWidth() && y - 1 > 0) {
						if(ret.getValue(x + 1, y - 1) != 0 && ret.getValue(x + 1, y - 1) < etiqMin) {
							etiqMin = ret.getValue(x + 1, y - 1);
							table.set(etiquette - 1, etiqMin);
							boucle3 ++;
						}
					}

					if(x - 1 > 0) {
						if(ret.getValue(x - 1, y) != 0 && ret.getValue(x - 1, y) < etiqMin) {
							etiqMin = ret.getValue(x - 1, y);
							table.set(etiquette - 1, etiqMin);
							boucle4 ++;
						}
					}
				}
				//System.out.println("x : " + x + " ; y : " + y);
			}
		}
		System.out.println("boucle 1 : " + boucle1 + "\nboucle 2 : " + boucle2 + "\n boucle 3 : " + boucle3 + "\n boucle 4 : " + boucle4);
		return table;
	}
	
	/** 
	 * tests basiques de la classe
	 * @param args
	 */
	public static void main(String[] args) {
		Image image2=new Image("coins.png");
		Image image3=new Image("damier.jpg");
		Image image4=new Image("question.png");
		Image image5=new Image("question2.png");
		Image image6=new Image("circuit.jpg");
		Image image7=new Image("golfe2ndg.jpg");
		Image image1=new Image(image3.height,image3.width);

		for(int i=0;i<image1.getWidth();i++){
			for(int j=0;j<image1.getHeight();j++){
				image1.setValue(i,j,Math.abs(i-j));    	  
			}
		}
		//    image1.display();    
		//    image2.display();
		//    image1.displayColor();

		/*
		 * Exercice 1
		 */
		//		try {
		//			image6.seuillage(100).display();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		/*
		 * Exercice 2
		 */
		//		try {
		//			image7.otsuNormalized().display();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		//		try {
		//			image6.iterativeSelectionThresholding().display();;
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		/*
		 * Exercice 3
		 */
		//		try {
		//			image7.display();
		//			image7.otsu2(4).display();
		//
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		/**
		 * Exercice 4
		 */
		//		try {
		//			image6.display();
		//			image6.otsu().display();
		//			image6.erosion3x3().display();
		//			image6.dilatation3x3().display();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		/**
		 * Exercice 5
		 */
		//		try {
		//			image6.display();
		//			image6.otsu().display();
		//			image6.erosion(2).display();
		//			image6.dilatation(2).display();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		/**
		 * Exercice 7
		 */
		//		try {
		//			image6.ouverture(1).display();
		//			image6.fermeture(1).display();
		//			image6.topHatOuv(1).display();
		//			image6.topHatFer(1).display();
		//			image6.gradMorpho(1).display();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		/*
		 * Exwercie 8
		 */
		try {

			Image ret = image2.etiquetage();
			ret.displayColor();

			//			Image ret = new Image(image2);
			//			ret.pixels = eti;
			//			ret.displayColor();
			//			int max=0;
			//			for(int i=0; i<eti.length; i++){
			//				if(eti[i] > max){
			//					max = eti[i];
			//				}
			//			}
//			System.out.println(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}