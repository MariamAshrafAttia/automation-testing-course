package Q3;

public class TestSession {
    enum Browser {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }

    private static int sessionCount = 0;
    private int sessionId;
    private Browser browser;
    private long startTime;

    public TestSession(Browser browser)
    {
        sessionId=++sessionCount;
        this.browser=browser;
        this.startTime=System.currentTimeMillis();
    }

    public static int getSessionCount() {
        return sessionCount;
    }

    public String getInfo() {
        return "Session ID: " + sessionId
                + ", Browser: " + browser
                + ", Start Time: " + startTime;
    }
}
