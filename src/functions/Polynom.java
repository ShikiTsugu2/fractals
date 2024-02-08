package src.functions;

import src.graphic.Model;

import java.util.Locale;
import java.util.Scanner;

public class Polynom extends Function{
    public Polynom(){
        super();
    }

    public Polynom(Model m){
        super(m);
    }

    @Override
    public Object fetchArg(Model m) {
        return m.getPolyInfo();
    }

    @Override
    public Object requestArg() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Enter degre of polynom (format : x) :");
        int degre = sc.nextInt();
        return degre;
    }

    @Override
    public Complexe calculate(Complexe z) {
        Complexe base = z;
        int i = 0;
        int exponent = (int)getArgument();
        Complexe res = z;
        if(exponent==0){
            res = new Complexe(1,1);
            return res;
        }
        while (i != exponent-1) {
            res = res.multiplication(base);
            i++;
        }
        return res;
    }

    public String toString(){
        return "z^"+getArgument();
    }
}
