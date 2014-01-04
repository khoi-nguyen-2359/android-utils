package fantageek.com.util.android;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextUtil {

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
