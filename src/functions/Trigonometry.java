package src.functions;

import src.graphic.Model;

import java.util.Scanner;

public class Trigonometry extends Function{
    public Trigonometry(){
        super();
    }

    public Trigonometry(Model m){
        super(m);
    }

    @Override
    public Object fetchArg(Model m) {
        return m.getTrigoInfo();
    }

    @Override
    public Object requestArg() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which function you wish to use from C(cos), S(sin) and T(tan) :");
        String arg = sc.nextLine();
        if(!arg.equals("C")&&!arg.equals("S")&&!arg.equals("T")){
            System.out.println("C, S or T expected, you wrote "+arg);
            System.exit(-1);
        }
        return arg;
    }

    @Override
    public Complexe calculate(Complexe z) {
        switch ((String) getArgument()){
            case "C":
                double real = Math.cos(z.getReel())*Math.cosh(z.getImaginaire());
                double img = -(Math.sin(z.getReel())*Math.sinh(z.getImaginaire()));
                return new Complexe(real,img);
            case "S":
                real = Math.sin(z.getReel())*Math.cosh(z.getImaginaire());
                img = Math.cos(z.getReel())*Math.sinh(z.getImaginaire());
                return new Complexe(real,img);
            case "T":
                Complexe up = new Complexe(Math.sin(z.getReel())*Math.cosh(z.getImaginaire()),
                        Math.cos(z.getReel())*Math.sinh(z.getImaginaire()));
                Complexe bot = new Complexe(Math.cos(z.getReel())*Math.cosh(z.getImaginaire()),
                        -(Math.sin(z.getReel())*Math.sinh(z.getImaginaire())));
                return up.division(bot);
        }
        return z;
    }

    public String toString(){
        String argument = "";
        if(getArgument().equals("C")){
            argument = "cos";
        }
        if(getArgument().equals("S")){
            argument = "sin";
        }
        if(getArgument().equals("T")){
            argument = "tan";
        }
        return argument+"(z)";
    }
}
