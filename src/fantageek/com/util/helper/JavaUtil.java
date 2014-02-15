package fantageek.com.util.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JavaUtil {
	
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
	
    /**
     * Check an array is null or having zero length
     * 
     * @param array
     * @return
     */
    public static boolean isArrayEmpty(Object... array) {
        return array == null || array.length == 0;
    }
    
    public static String[] match(String text, Pattern pattern) {
        String[] list = null;
        
        List<String> tempResult = new ArrayList<String>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            tempResult.add(matcher.group());

        list = new String[tempResult.size()];
        tempResult.toArray(list);
        
        return list;
    }

    public static String[] match(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return match(text, pattern);
    }
}
