package discoverylab.util.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LogUtils
 * @author Irvin Steve Cardenas
 *
 * Logging utility class allows developer to log information, warning and errors
 */
public class LogUtils {
	
//	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); Java Utils Logger = No Bueno
	private static Logger logger = LoggerFactory.getLogger(LogUtils.class);
	
	private static final String LOG_PREFIX = "discoverylab";
	private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
	private static final int MAX_LOG_TAG_LENGTH = 23;
	
	public static String makeLogTag(String str) {
		if(str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH){
			return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH);
		}
		return LOG_PREFIX + str;
	}
	
	public static String makeLogTag(Class cls) {
		return makeLogTag(cls.getSimpleName());
	}
	
	public static void LOGI(final String tag, String message) {
//		logger.info(tag, message);
		logger = LoggerFactory.getLogger(tag);
		logger.info(message);
	}
	
	public static void LOGI(final String tag, String message, Throwable cause) {
//		logger.info(tag, message, cause);
		logger = LoggerFactory.getLogger(tag);
		logger.info(message);
	}
	
	public static void LOGW(final String tag, String message) {
//		logger.warn(tag, message);
		logger = LoggerFactory.getLogger(tag);
		logger.info(message);
	}
	
	public static void LOGW(final String tag, String message, Throwable cause) {
//		logger.warn(tag, message, cause);
		logger = LoggerFactory.getLogger(tag);
		logger.info(message);
	}
	
	public static void LOGE(final String tag, String message){
//		logger.error(tag, message);
		logger = LoggerFactory.getLogger(tag);
		logger.info(message);
	}
	
	public static void LEGE(final String tag, String message, Throwable cause){
//		logger.error(tag, message, cause);
		logger = LoggerFactory.getLogger(tag);
		logger.info(message);
	}
	
	private LogUtils() {
		
	}
}
