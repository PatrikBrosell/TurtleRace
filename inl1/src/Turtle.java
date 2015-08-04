import se.lth.cs.ptdc.window.SimpleWindow;

/**
 * Klassen Turtle beskriver en sköldpadda som kan rita.
 */
public class Turtle {
	private double x;
	private double y;
	private int direction;
	private boolean penDown;
	protected SimpleWindow w;
	
	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x,y med pennan lyft och huvudet pekande rakt uppåt
	 * i fönstret (i negativ y-riktning)
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		direction = 90;
		penDown = false;
		this.w = w;
	}
	
	/** Sänker pennan */
	public void penDown() {
		penDown = true;
	}
	
	/** Lyfter pennan */
	public void penUp() {
		penDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning som huvudet pekar */
	public void forward(int n) {
		w.moveTo((int)Math.round(x), (int)Math.round(y));
		x += n * (Math.cos(Math.toRadians(direction)));
		y += n * - (Math.sin(Math.toRadians(direction)));
		if(penDown == true){
			w.lineTo((int)Math.round(x), (int)Math.round(y));
		}
	}
	
	/** Vrider beta grader åt vänster runt pennan */
	public void left(int beta) {
		direction += beta;
	}
	
	/** Går till punkten newX,newY utan att rita. Pennans läge (sänkt 
	    eller lyft) och huvudets riktning påverkas inte */
	public void jumpTo(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	/** Återställer huvudriktningen till den ursprungliga */
	public void turnNorth() {
		direction = 90;
	}
	
	/** Tar reda på x-koordinaten för sköldpaddans aktuella position */
	public int getX() {
		return (int) x;
	}
	
	/** Tar reda på y-koordinaten för sköldpaddans aktuella position */
	public int getY() {
		return (int) y;
	}
	
	/** Tar reda på sköldpaddans riktning, i grader från positiv x-led */
	public int getDirection() {
		return direction;
	}
}
