package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {

    public static Logger logger(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());//[3] it contains pacage,class,method name
    }

    public static void info(String message){
        logger().info(message);
    }
    public static void error(String message){
        logger().error(message);
    }
    public static void warn(String message){
        logger().warn(message);
    }
    public static void fatal(String message){
        logger().fatal(message);
    }
    public static void debug(String message){
        logger().debug(message);
    }

}
