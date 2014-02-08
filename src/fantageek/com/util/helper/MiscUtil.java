package fantageek.com.util.helper;

public final class MiscUtil {
	
	/**
	 * Check an array is null or having zero length
	 * @param array
	 * @return
	 */
	public static boolean isArrayEmpty(Object... array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * Simple check lat/lng is positive or not
	 * @param lat
	 * @param lng
	 * @return
	 */
	public static boolean isLocationValid(double lat, double lng) {
	    return lat > 0 && lng > 0;
	}
}
