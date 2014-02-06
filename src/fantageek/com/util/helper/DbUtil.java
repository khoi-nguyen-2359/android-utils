package fantageek.com.util.helper;

import java.util.HashMap;
import java.util.Iterator;

public class DbUtil {
    
    public static boolean isInvalidId(Long id) {
        return id == null || id <= 0;
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
	
	/**
	 * Make projection string array
	 * @param objs
	 * @return
	 */
	public static String[] projs(String... objs) {
        int len;
        if (objs == null || (len = objs.length) == 0)
            return null;

        String[] projs = new String[len];
        for (int i = 0; i < len; ++i)
            projs[i] = objs[i];

        return projs;
    }

	/**
	 * Make arguments string array
	 * @param objs
	 * @return
	 */
    public static final String[] args(Object... objs) {
        int len;
        if (objs == null || (len = objs.length) == 0)
            return null;

        String[] args = new String[len];
        for (int i = 0; i < len; ++i)
            args[i] = String.valueOf(objs[i]);

        return args;
    }
}
