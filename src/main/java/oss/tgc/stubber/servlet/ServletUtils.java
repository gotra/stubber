package oss.tgc.stubber.servlet;

/**
 * Created by rajeevguru on 14/07/15.
 */
public class ServletUtils {

    public static <T> T coalesce(T...ts) {
        for(T t: ts)
            if(t != null)
                return t;
        return null;
    }
}
