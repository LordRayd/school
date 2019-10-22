public class ComplexImage {

    private Image reImage;
    private Image imImage;
    private int width;
    private int height;

    public ComplexImage(int N, int M) {
        this.reImage = new Image(N, M);
        this.imImage = new Image(N, M);
        this.width = N;
        this.height = M;
    }

    public ComplexImage(Image re, Image im) {
        this.reImage = re;
        this.imImage = im;
        this.width = re.width;
        this.height = im.height;
    }

    public Image getReImage() {
        return this.reImage;
    }

    public Image getImImage() {
        return this.imImage;
    }

    public Image getPhase() {
        Image phase = new Image(this.width, this.height);
        double fRe = 0;
        double fIm = 0;
        double valPha = 0.0;
        for (int u = 0; u < this.width; u++) {
            for (int v = 0; v < this.height; v++) {
                fRe = 0;
                fIm = 0;
                for (int x = 0; x < this.width; x++) {
                    for (int y = 0; y < this.height; y++) {
                        fRe += (double) (reImage.getValue(x, y))
                                * Math.cos(2.0 * Math.PI * ((double) (x * u) / (double) (this.width)
                                        + (double) (y * v) / (double) (this.height)));
                        fIm += (double) (imImage.getValue(x, y))
                                * Math.sin(2.0 * Math.PI * ((double) (x * u) / (double) (this.width)
                                        + (double) (y * v) / (double) (this.height)));
                    }
                }
                fIm = 0 - fIm;
                valPha = Math.atan((double) (fRe / fIm));
                phase.setValue(u, v, (int) valPha);
            }
        }
        return phase;
    }

    public Image getModule() {
        Image module = new Image(this.width, this.height);
        double fRe = 0;
        double fIm = 0;
        for (int u = 0; u < this.width; u++) {
            for (int v = 0; v < this.height; v++) {
                fRe = 0;
                fIm = 0;
                for (int x = 0; x < this.width; x++) {
                    for (int y = 0; y < this.height; y++) {
                        fRe += (double) (reImage.getValue(x, y))
                                * Math.cos(2.0 * Math.PI * ((double) (x * u) / (double) (this.width)
                                        + (double) (y * v) / (double) (this.height)));
                        fIm += (double) (imImage.getValue(x, y))
                                * Math.sin(2.0 * Math.PI * ((double) (x * u) / (double) (this.width)
                                        + (double) (y * v) / (double) (this.height)));
                    }
                }
                fIm = 0 - fIm;
				module.setValue(u, v, (int) Math.sqrt((Math.pow(fRe, 2) + Math.pow(fIm, 2))));
            }
        }
        return module;
    }

   /*  public ComplexImage dft(ComplexImage img) {
        int N = img.image.width;
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
        return this;
    } */

    /** 
	 * tests basiques de la classe
	 * @param args
	 */
	/* public static void main(String[] args) {
		Image image = new Image("../lena-64x64.jpg");
		Image mod = new Image(image.width, image.height);
		Image phase = new Image(image.width, image.height);

		image.dft(image, mod, phase);
        ComplexImage img = new ComplexImage(image.getReImage(), image.getReImage());

		mod.displayColor();
        img.getModule().displayColor();

        phase.displayColor();
        img.getPhase().displayColor();
    } */
    
}