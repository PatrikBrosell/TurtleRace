import java.util.Random;
import se.lth.cs.ptdc.window.SimpleWindow;

/**
 * Klassen RacingEvent beskriver själva loppet.
 */
public class RacingEvent {
	private RaceTrack track;
	private int nbrTurtles;
	private Turtle[] turtles;
	
	/**
	 * Skapar ett RacingEvent med RaceTrack track och med Turtle[] turtles.
	 */
	public RacingEvent(RaceTrack track, Turtle[] turtles) {
		this.track = track;
		this.turtles = turtles;

	}
	/**
	 * Initierar själva loppet för alla sköldpaddor i turtles.
     * Ser till att alla sköldpaddor har penDown == true
	 * och låter dem i tur och ordning ta ett slumpmässigt
     *steg i intervallet [0, 2] frammåt. Jämnför sedan deras
	 * position till startlinjen.
	 */
	public void race(SimpleWindow w) {
		Random rand = new Random();
		nbrTurtles = turtles.length;
		for (int i = 0; i < nbrTurtles; i++) {
			turtles[i].penDown();
		}
		int i = 0;
		while (turtles[i].getY() > track.getFinish()) {
			turtles[i].forward(rand.nextInt(3));
			i++;
			if (i == nbrTurtles) {
				SimpleWindow.delay(10);
				i = 0;
			}

		}
		w.moveTo(w.getWidth() / 2 - 95, track.getFinish() - 50);
		w.writeText("Sköldpadda #" + (i + 1) + " vann loppet!");
		System.out.println("Sköldpadda #" + (i + 1) + " vann loppet!");
	}
}
