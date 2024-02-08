package src.run;

import src.builders.buildFractals;
import src.graphic.View;
import src.sets.Julia;
import src.sets.Mandelbrot;
import src.sets.fractalSet;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public void initiateTerminal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What set do you want to use Julia (J) ? or Mandelbrot (M) ?");
        String rep = sc.nextLine();
        fractalSet set = null;
        if (rep.equals("J")) {
            set = new Julia();
        }else if (rep.equals("M")) {
            set = new Mandelbrot();
        }else {
            System.out.println("J or M expected");
            System.exit(-1);
        }
        System.out.println(set);
        buildFractals f = new buildFractals(set);
        f.generateFile();
    }

    public void initiateGraphic(){
        SwingUtilities.invokeLater(() -> new View());
    }

    public void chooseVersion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which version do you wish to use ? Terminal(T) or Graphic(G) ?");
        String rep = sc.nextLine();
        if(rep.equals("T")){
            initiateTerminal();
        }else if(rep.equals("G")){
            initiateGraphic();
        }else{
            System.out.println("T or G expected, you wrote :"+rep);
            System.exit(-1);
        }
    }

    public static void main(String[]args){
        Main launcher = new Main();
        launcher.chooseVersion();
    }
}
