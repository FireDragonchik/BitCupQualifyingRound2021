package framework.utils;

import org.apache.log4j.Appender;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;

public class Logger {
	private static ThreadLocal<org.apache.log4j.Logger> log4J = ThreadLocal.withInitial(()
			-> org.apache.log4j.Logger.getLogger(String.valueOf(Thread.currentThread().getId())));
	private static ThreadLocal<Logger> instance = ThreadLocal.withInitial(Logger::new);

	private Logger() {
	}

	public static Logger getInstance() {
		return instance.get();
	}


	public void info(String message) {
		log4J.get().info(message);
	}

	public void error(String message) {
		log4J.get().error(message);
	}
}
