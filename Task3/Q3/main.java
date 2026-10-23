package Q3;

public class main {
    public static void main(String[] args) {
        TestSession s1 =
                new TestSession(TestSession.Browser.CHROME);

        TestSession s2 =
                new TestSession(TestSession.Browser.FIREFOX);

        TestSession s3 =
                new TestSession(TestSession.Browser.EDGE);

        System.out.println(s1.getInfo());
        System.out.println(s2.getInfo());
        System.out.println(s3.getInfo());

        System.out.println("Total Sessions: "
                + TestSession.getSessionCount());
    }
}