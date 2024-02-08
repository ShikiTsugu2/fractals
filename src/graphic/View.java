package src.graphic;

import javax.swing.*;

public class View extends JFrame {
    private Model model;
    private Controller control;

    public View(){
        model = new Model(this);
        control = new Controller(model);
        control.activateMainButtons();
        setContentPane(model);
        setTitle("Fractal Displayer");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
