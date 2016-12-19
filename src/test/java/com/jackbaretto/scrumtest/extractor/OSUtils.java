package com.jackbaretto.scrumtest.extractor;

/**
 * Toolbox to get OS information
 * Created by florentsailly on 15/12/2016.
 */
public class OSUtils {

    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isMac() {
        return OS.contains("mac");
    }

    public static boolean isUnix() {
        return OS.contains("nix") || OS.contains("nux") || OS.contains("aix");
    }

}
