package org.iiitb.DevOps.logs;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.iiitb.DevOps.Test.Test_class;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import java.net.URL;


/**
 * TODO Put here a description of what this class does.
 *
 * @author sankeerth.
 *         Created 26-Apr-2019.
 */
public class logs {
	
	
	public Logger getlogger() throws IOException  {
	//	Logger logger = Logger.getLogger(logs.class);
		URL url = getClass().getResource("./");
	//	File file = new File(url.getPath());
		RollingFileAppender appender =   new RollingFileAppender(new PatternLayout("%d{dd MMM yyyy HH:mm:ss,SSS} %-4r [%t] %-5p %c %x - %m%n"), "/Users/sankeerth/Documents/spe/s3/DevOps/src/main/java/org/iiitb/DevOps/logs/logs.out", true);
		   File directory = new File("./");
		   System.out.println("------------------------------>"+directory.getAbsolutePath());
		   System.out.println("------------------------------>"+url.getPath());
		//RollingFileAppender appender =   new RollingFileAppender(new PatternLayout("%d{dd MMM yyyy HH:mm:ss,SSS} %-4r [%t] %-5p %c %x - %m%n"), getClass().getResourceAsStream("ListStopWords.txt").getPath(), true);

		   appender.setMaxBackupIndex(5);
		     appender.setMaxFileSize("1MB");
		     Logger logger = Logger.getRootLogger();
		     logger.setLevel(Level.DEBUG);
		     logger.addAppender(appender);
		     return logger;
		     
		
		
		
		
	}
	
//	public st//atic final RollingFileAppender appender =   new RollingFileAppender(new PatternLayout("%-4r [%t] %-5p %c %x - %m%n"), "/Users/sankeerth/Documents/spe/s3/DevOps/src/logs.out", true);
	

}
