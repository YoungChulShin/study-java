import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WriteLog {

  private static final Logger logger = LogManager.getLogger(WriteLog.class);

  public void writeLog(String message) {
    logger.error("Log: {}", message);
  }
}
