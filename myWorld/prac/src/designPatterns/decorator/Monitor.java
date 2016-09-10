package designPatterns.decorator;

/**
 * Created by keshav.gupta on 06/03/16.
 */
public class Monitor extends ComponentDecorator{

    Computer c;
    public Monitor(Computer c) {
        this.c=c;
    }

    @Override
    public String description() {
        return c.description()+" monitor";
    }
}