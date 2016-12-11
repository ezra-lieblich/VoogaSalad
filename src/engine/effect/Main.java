package engine.effect;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

public class Main {

    public static void main (String[] args) {
        // TODO Auto-generated method stub
        Reflections test = new Reflections("org.reflections.adapters", new MethodAnnotationsScanner());
        Object blah = test.getMethodsAnnotatedWith(Override.class);
        System.out.println("here");
    }

}
