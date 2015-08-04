import java.util.Scanner;

import se.lth.cs.ptdc.window.SimpleWindow;

/** 
 * TurtleRace innehåller main-metoden för loppet.
 */
public class TurtleRace {
	/**
	 * Frågar om antal sköldpaddor som skall tävla och väntar sedan
     * på musklick innan simuleringen startar.
	 * Skapar alla de permanents objektet och placerar
     * ut samtliga sköldpaddor längs med startlinjen.
	 * Sedan anropas RacingEvent för att starta loppet.
	 */
	public static void main(String[] args) {
		System.out.println("TESTING TESTING");
		SimpleWindow w = new SimpleWindow(600, 600, "Turtle Race");
		RaceTrack track = new RaceTrack(w, 500, 100);
		System.out.println("Skriv in det antal sköldpaddor som skall tävla:");
		Scanner scan = new Scanner(System.in);
		int nbrTurtles = scan.nextInt();
		track.draw(w);
		Turtle[] turtles = new Turtle[nbrTurtles];
		int StartLns = Math.round((track.getTrackWidth() / turtles.length));		
		for (int i = 0; i < turtles.length; i++) {
			turtles[i] = new Turtle(w, (50 + StartLns / 2) + (StartLns * i),
					track.getStart());
		}
		RacingEvent turtleRace = new RacingEvent(track, turtles);
		w.waitForMouseClick();
		turtleRace.race(w);
	}
}
