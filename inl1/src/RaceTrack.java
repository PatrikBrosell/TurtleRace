import se.lth.cs.ptdc.window.SimpleWindow;

/**
 * Klassen RaceTrack beskriver själva löpspåret.
 */
public class RaceTrack {
	private int yFinish;
	private int yStart;
	private SimpleWindow w;

	/**
	 * Skapar ett RaceTrack som har sin start vid yStart och mål vid yFinish
	 */
	public RaceTrack(SimpleWindow w, int yStart, int yFinish) {
		this.yStart = yStart;
		this.yFinish = yFinish;
		this.w = w;
	}

	/** Ritar upp ett löpspår */
	public void draw(SimpleWindow w) {
		w.moveTo(50, yStart);
		w.lineTo(w.getWidth() - 50, yStart);
		w.moveTo(50, yFinish);
		w.lineTo(w.getWidth() - 50, yFinish);
		w.moveTo((w.getWidth() - 50) / 2 + 5, yStart + 15);
		w.writeText("Start");
		w.moveTo((w.getWidth() - 50) / 2 + 10, yFinish - 5);
		w.writeText("Mål");

	}

	/** Tar reda på y-koordinaten för löpspårets start */
	public int getStart() {
		return yStart;
	}

	/** Tar reda på y-koordinaten för målet */
	public int getFinish() {
		return yFinish;
	}

	/** Tar reda på löpbanans bredd */
	public int getTrackWidth() {
		return w.getWidth() - 100;
	}

}
