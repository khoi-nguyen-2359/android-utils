package fantageek.com.util.helper;

import java.util.HashMap;
import java.util.Iterator;

public class DbUtil {
    
    public static boolean isInvalidId(long id) {
        return id <= 0;
    }
	
	/**
	 * Make string list of arguments for select sql
	 * @param criterias argument name-value pairs
	 * @return String array containing argument values
	 */
	public static String[] makeSelectArgList(HashMap<String, Object> criterias) {
		String[] argList = null;

		do {
			if (criterias == null || criterias.isEmpty())
				break;
			
			int nEntry = criterias.size();
			argList = new String[nEntry];
			Iterator<Object> entries = criterias.values().iterator();
			for (int i = 0; i < nEntry; ++i) {
				Object value = entries.next();
				argList[i] = value.toString();
			}
		} while (false);
		
		return argList;
	}
	
}
