package src.sets;

import src.functions.Complexe;
import src.functions.Function;
import src.functions.Polynom;
import src.functions.Trigonometry;
import src.graphic.Controller;

public class Mandelbrot extends fractalSet{
    private final Function type;
    private Complexe c;

    public Mandelbrot(){
        super();
        type = requestType();
    }

    public Mandelbrot(Controller c){
        super();
        type = c.generateFunction();
    }

    @Override
    public Function getType() {
        return type;
    }

    public Complexe getC() {
        return c;
    }

    public void setC(Complexe c) {
        this.c = c;
    }

    public String toString(){
        String res = "";
        if (type instanceof Polynom){
            res = type + " + c" + "  with  z0 = 0";
        }
        if (type instanceof Trigonometry){
            res = "c * " + type + "  with  z0 = 0";
        }
        return "f(z) = "+res;
    }
}
