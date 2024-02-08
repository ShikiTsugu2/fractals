package src.sets;

import src.functions.Complexe;
import src.functions.Function;
import src.functions.Polynom;
import src.functions.Trigonometry;

import java.util.Scanner;

public abstract class fractalSet {

    public Function requestType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which function do you wish to use ? Polynom(P) or Trigonometry(T) ?");
        String type = sc.nextLine();
        if(type.equals("P")){
            return new Polynom();
        }else if(type.equals("T")){
            return new Trigonometry();
        }
        System.out.println("P or T expected, you wrote "+type);
        System.exit(-1);
        return null;
    }

    public abstract String toString();

    public abstract Function getType();

    public abstract Complexe getC();
}
