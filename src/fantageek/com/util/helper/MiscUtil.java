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
}
