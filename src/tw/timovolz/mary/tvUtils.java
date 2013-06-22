package tw.timovolz.mary;

import java.util.concurrent.TimeUnit;

public class tvUtils {
	public static String milisecondsToMinuteString(long miliseconds ){
		return String.format("%d:%02d", 
    		    TimeUnit.MILLISECONDS.toMinutes(miliseconds),
    		    TimeUnit.MILLISECONDS.toSeconds(miliseconds) - 
    		    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(miliseconds)));   		
	}
	public static long randomNumber( long min, long max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
}
