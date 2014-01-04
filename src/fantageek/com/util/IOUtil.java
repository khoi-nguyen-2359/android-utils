package fantageek.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class IOUtil {
	
	/**
	 * Convert input stream to string. UTF-8 is used as default encoding.<br/>
	 * The stream won't be closed after converted.
	 * @param is
	 * @return the content string or null.
	 */
	public static String toString(InputStream is) {
		String result = null;
		
		try {
			InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
			
			StringBuilder stringBuilder = new StringBuilder();
			final int buffSize = 1024;
			char[] charBuff = new char[buffSize];
			int readCount = 0;
			while ((readCount = isReader.read(charBuff, 0, charBuff.length)) > 0)
				stringBuilder.append(charBuff, 0, readCount);
			
			result = stringBuilder.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static boolean copy(InputStream from, OutputStream to) {
		boolean result = false;
		
		do {
			final int blockSize = 1024;
			byte[] block = new byte[blockSize];
			int readCount = 0;
			try {
				while ((readCount = from.read(block, 0, blockSize)) != -1) {
					to.write(block, 0, readCount);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			result = true;
		} while (false);
		
		return result;
	}
}
