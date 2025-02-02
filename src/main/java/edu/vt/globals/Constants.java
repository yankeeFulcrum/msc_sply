package edu.vt.globals;

public final class Constants {
    //---------------
    // To run locally
    //---------------
     public static final String FILES_ABSOLUTE_PATH  = "C:/Users/Roscoe/DocRoot/CloudStorage/FileStorage/";
     public static final String PHOTOS_ABSOLUTE_PATH = "C:/Users/Roscoe/DocRoot/CloudStorage/PhotoStorage/";

    //-------------------------------------------------------------------
    // To run on your AWS EC2 instance, on VENUS or JUPITER course server
    //-------------------------------------------------------------------
    //public static final String FILES_ABSOLUTE_PATH  = "/opt/wildfly/DocRoot/CloudStorage/FileStorage/";
    //public static final String PHOTOS_ABSOLUTE_PATH = "/opt/wildfly/DocRoot/CloudStorage/PhotoStorage/";

    //---------------
    // To run locally
    //---------------
    public static final String FILES_URI  = "http://localhost:8080/files/";
    public static final String PHOTOS_URI = "http://localhost:8080/photos/";

    //-----------------------------------------------------
    // To run on your AWS EC2 instance with your IP address
    //-----------------------------------------------------
    //public static final String FILES_URI  = "http://3.14.146.234:8080/files/";
    //public static final String PHOTOS_URI = "http://3.14.146.234:8080/photos/";
}
