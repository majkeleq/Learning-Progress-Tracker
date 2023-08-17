package tracker.statisticsHandler;

import java.util.TreeMap;

public class Statistics {
    private static int javaActivity = 0;

    private static int dsaActivity = 0;
    private static int dbActivity = 0;
    private static int springActivity = 0;
    private static int javaPopularity = 0;
    private static int dsaPopularity = 0;
    private static int dbPopularity = 0;
    private static int springPopularity = 0;
    private static int javaPoints = 0;
    private static int dsaPoints = 0;
    private static int dbPoints = 0;
    private static int springPoints = 0;

    public Statistics() {
    }

    public static void incrementJavaActivity() {
        javaActivity++;
    }

    public static void incrementDsaActivity() {
        dsaActivity++;
    }

    public static void incrementDbActivity() {
        dbActivity++;
    }

    public static void incrementSpringActivity() {
        springActivity++;
    }

    public static void incrementJavaPopularity() {
        javaPopularity++;
    }

    public static void incrementDsaPopularity() {
        dsaPopularity++;
    }

    public static void incrementDbPopularity() {
        dbPopularity++;
    }

    public static void incrementSpringPopularity() {
        springPopularity++;
    }

    public static void addJavaPoints(int points) {
        javaPoints += points;
    }

    public static void addDsaPoints(int points) {
        dsaPoints += points;
    }

    public static void addDbPoints(int points) {
        dbPoints += points;
    }

    public static void addSpringPoints(int points) {
        springPoints += points;
    }

    public static String getMostPopularCourse() {
        return getMost(javaPopularity, dsaPopularity, dbPopularity, springPopularity);
    }

    public static String getLeastPopularCourse() {
        return getLeast(javaPopularity, dsaPopularity, dbPopularity, springPopularity);
    }

    public static String getMostActiveCourse() {
        return getMost(javaActivity, dsaActivity, dbActivity, springActivity);
    }

    public static String getLeastActiveCourse() {
        return getLeast(javaActivity, dsaActivity, dbActivity, springActivity);
    }

    public static String getEasiestCourse() {
        return getMost(javaPopularity > 0 ? javaPoints / javaPopularity : 0,
                dsaPopularity > 0 ? dsaPoints / dsaPopularity : 0,
                dbPopularity > 0 ? dbPoints / dbPopularity : 0,
                springPopularity > 0 ? springPoints / springPopularity : 0);
    }

    public static String getHardestCourse() {
        return getLeast(javaPopularity > 0 ? javaPoints / javaPopularity : 0,
                dsaPopularity > 0 ? dsaPoints / dsaPopularity : 0,
                dbPopularity > 0 ? dbPoints / dbPopularity : 0,
                springPopularity > 0 ? springPoints / springPopularity : 0);
    }

    private static String getMost(int java, int dsa, int db, int spring) {
        int max = Math.max(Math.max(java, dsa), Math.max(db, spring));
        if (max == 0) return "n/a";
        if (max == java) return "Java";
        if (max == dsa) return "DSA";
        if (max == db) return "Databases";
        return "Spring";

    }

    private static String getLeast(int java, int dsa, int db, int spring) {
        int min = Math.min(Math.min(java, dsa), Math.min(db, spring));
        if (min == 0) return "n/a";
        if (min == spring) return "Spring";
        if (min == db) return "Databases";
        if (min == dsa) return "DSA";
        return "Java";
    }
}