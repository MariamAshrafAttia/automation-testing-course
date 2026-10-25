package Q1;

public abstract class BasePage {
    public abstract boolean isLoaded();

    protected void Click(String element)
    {
        System.out.println("Clicking on: " + element);
    }

    protected void type(String element, String text)
    {
        System.out.println("Typing " + text + " in " + element);
    }

    protected String getText(String element) {
        return ("Text from: " + element);
    }
}
