package src.graphic;

import src.functions.Function;
import src.sets.Julia;
import src.sets.Mandelbrot;
import src.sets.fractalSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Model extends JPanel {
    private JLabel title,f1,f2,f3,fct,hueDesc,sizeDesc;
    private JButton julia,mandelbrot,quit,polynom,trigonometry,back,next,download,view;
    private JTextField degre,type,cRe,cIm,hueVal,sizeVal;
    private Function typeF;
    private int polyInfo,id,size=-1;
    private String trigoInfo;
    private float hue = -1;
    private double[] constInfo = {0,0};
    private fractalSet set;
    private View v;
    private JPanel container;
    private BufferedImage img;

    public Model(View v){
        this.v = v;
        setBackground(Color.black);
        mainMenu();
    }

    public fractalSet getSet() {
        return set;
    }

    public JButton getDownload() {
        return download;
    }

    public JButton getView() {
        return view;
    }

    public JTextField getHueVal() {
        return hueVal;
    }

    public void setHueVal(JTextField hueVal) {
        this.hueVal = hueVal;
    }

    public JTextField getSizeVal() {
        return sizeVal;
    }

    public void setSizeVal(JTextField sizeVal) {
        this.sizeVal = sizeVal;
    }

    public int getSizeFrac() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getHue() {
        return hue;
    }

    public void setHue(float hue) {
        this.hue = hue;
    }

    public int getPolyInfo() {
        return polyInfo;
    }

    public String getTrigoInfo() {
        return trigoInfo;
    }

    public JButton getPolynom() {
        return polynom;
    }

    public JButton getTrigonometry() {
        return trigonometry;
    }

    public JButton getJulia() {
        return julia;
    }

    public JButton getMandelbrot() {
        return mandelbrot;
    }

    public JButton getQuit() {
        return quit;
    }

    public JButton getBack() {
        return back;
    }

    public int getId() {
        return id;
    }

    public JButton getNext() {
        return next;
    }

    public JTextField getDegre() {
        return degre;
    }

    public JTextField getcRe() {
        return cRe;
    }

    public JTextField getcIm() {
        return cIm;
    }

    public void setPolyInfo(int polyInfo) {
        this.polyInfo = polyInfo;
    }

    public void setTrigoInfo(String trigoInfo) {
        this.trigoInfo = trigoInfo;
    }

    public double[] getConstInfo() {
        return constInfo;
    }

    public void setConstRE(double re) {
        this.constInfo[0] = re;
    }

    public void setConstIM(double im){
        this.constInfo[1] = im;
    }

    public JTextField getType() {
        return type;
    }

    public void setTypeF(Function typeF) {
        this.typeF = typeF;
    }

    //affiche le menu principal
    public void mainMenu(){
        id = 0;
        setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
        //Titre
        title = new JLabel("Fractal Displayer");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setBorder(new EmptyBorder(60,0,0,0));
        add(title);
        //Bouton des Sets
        julia = new JButton("Julia");
        mandelbrot = new JButton("Mandelbrot");
        julia.setBorder(new EmptyBorder(10,40,10,40));
        mandelbrot.setBorder(new EmptyBorder(10,40,10,40));
        add(julia);
        add(mandelbrot);
        //Bouton quitter
        quit = new JButton("Quit");
        quit.setBorder(new EmptyBorder(10,40,10,40));
        add(quit);
    }

    //affiche les options de sélection du type de fonction
    public void typeSelect(Controller c){
        id = 1;
        setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
        //titre
        title.setText("Function Type");
        title.setBorder(new EmptyBorder(60,0,0,0));
        add(title);
        //Boutons des Types
        polynom = new JButton("Polynom");
        trigonometry = new JButton("Trigonometry");
        polynom.setBorder(new EmptyBorder(10,40,10,40));
        trigonometry.setBorder(new EmptyBorder(10,40,10,40));
        add(polynom);
        add(trigonometry);
        //Bouton retour
        back = new JButton("Back");
        back.setBorder(new EmptyBorder(10,40,10,40));
        add(back);
        c.activateTypeButtons();
    }

    //affiche les options dans le cas d'une fonction polynomiale
    public void polynomSettings(Controller c){
        degre = new JTextField("Press Enter when done");
        degre.setBorder(new EmptyBorder(5,120,5,120));
        f1 = new JLabel("Enter Degre of polynom as Integer");
        f1.setFont(new Font("SansSerif", Font.BOLD, 15));
        f1.setForeground(Color.WHITE);
        add(f1);
        add(degre);
        if(!mandelbrot.isEnabled()) {
            cRe = new JTextField("Press Enter when done");
            cRe.setBorder(new EmptyBorder(5, 120, 5, 120));
            f2 = new JLabel("Enter Real part of Constant as Double");
            f2.setFont(new Font("SansSerif", Font.BOLD, 15));
            f2.setForeground(Color.WHITE);
            add(f2);
            add(cRe);
            cIm = new JTextField("Press Enter when done");
            cIm.setBorder(new EmptyBorder(5, 120, 5, 120));
            f3 = new JLabel("Enter Imaginary part of Constant as Double");
            f3.setFont(new Font("SansSerif", Font.BOLD, 15));
            f3.setForeground(Color.WHITE);
            add(f3);
            add(cIm);
        }
        add(back);
        next = new JButton("Next");
        next.setBorder(new EmptyBorder(10,40,10,40));
        add(next);
        c.activateSetSettings();
    }

    //affiche les options dans le cas d'une fonction trigonométrique
    public void trigonometrySettings(Controller c){
        type = new JTextField("Press Enter when done");
        type.setBorder(new EmptyBorder(5,120,5,120));
        f1 = new JLabel("Enter Function as C(cos), S(sin) or T(tan)");
        f1.setFont(new Font("SansSerif", Font.BOLD, 15));
        f1.setForeground(Color.WHITE);
        add(f1);
        add(type);
        if(!mandelbrot.isEnabled()) {
            cRe = new JTextField("Press Enter when done");
            cRe.setBorder(new EmptyBorder(5, 120, 5, 120));
            f2 = new JLabel("Enter Real part of Constant as Double");
            f2.setFont(new Font("SansSerif", Font.BOLD, 15));
            f2.setForeground(Color.WHITE);
            add(f2);
            add(cRe);
            cIm = new JTextField("Press Enter when done");
            cIm.setBorder(new EmptyBorder(5, 120, 5, 120));
            f3 = new JLabel("Enter Imaginary part of Constant as Double");
            f3.setFont(new Font("SansSerif", Font.BOLD, 15));
            f3.setForeground(Color.WHITE);
            add(f3);
            add(cIm);
        }
        add(back);
        next = new JButton("Next");
        next.setBorder(new EmptyBorder(10,40,10,40));
        add(next);
        c.activateSetSettings();
    }

    //affiche les options pour le set julia
    public void juliaSettings(Controller c){
        id = 2;
        setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        //titre
        title.setText("Julia Set");
        title.setBorder(new EmptyBorder(40,0,0,0));
        add(title);
        //options selon le type de la fonction
        if(!trigonometry.isEnabled()){
            polynomSettings(c);
        }
        if(!polynom.isEnabled()){
            trigonometrySettings(c);
        }
    }

    //affiche les options pour le set mandelbrot
    public void mandelbrotSettings(Controller c){
        id = 2;
        setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        //titre
        title.setText("Mandelbrot Set");
        title.setBorder(new EmptyBorder(40,0,0,0));
        add(title);
        //options selon le type de la fonction
        if(!trigonometry.isEnabled()){
            polynomSettings(c);
        }
        if(!polynom.isEnabled()){
            trigonometrySettings(c);
        }
    }

    //affiche les choix finaux soit la taille de base et la teinte de base
    public void finalChoices(Controller c){
        id = 3;
        //titre
        title.setText("Color and Size");
        title.setBorder(new EmptyBorder(40,0,0,0));
        add(title);
        //fonction générée
        if(!mandelbrot.isEnabled()){
            set = new Julia(c);
        }else if(!julia.isEnabled()){
            set = new Mandelbrot(c);
        }
        fct = new JLabel(set.toString());
        fct.setFont(new Font("SansSerif", Font.BOLD, 20));
        fct.setForeground(Color.WHITE);
        fct.setBorder(new EmptyBorder(0,0,10,0));
        add(fct);
        //boutons et champs
        hueVal = new JTextField("Press Enter when done");
        hueVal.setBorder(new EmptyBorder(5,120,5,120));
        hueDesc = new JLabel("Enter Hue value as float from 0.0 to 1.0");
        hueDesc.setFont(new Font("SansSerif", Font.BOLD, 15));
        hueDesc.setForeground(Color.WHITE);
        add(hueDesc);
        add(hueVal);
        sizeVal = new JTextField("Press Enter when done");
        sizeVal.setBorder(new EmptyBorder(5,120,5,120));
        sizeDesc = new JLabel("Enter size value as Integer");
        sizeDesc.setFont(new Font("SansSerif", Font.BOLD, 15));
        sizeDesc.setForeground(Color.WHITE);
        add(sizeDesc);
        add(sizeVal);
        download = new JButton("Download");
        download.setBorder(new EmptyBorder(10,20,10,20));
        download.setEnabled(false);
        add(download);
        back.setBorder(new EmptyBorder(10,20,10,20));
        add(back);
        view = new JButton("View");
        view.setBorder(new EmptyBorder(10,20,10,20));
        view.setEnabled(false);
        add(view);
        c.activateFinalSettings();
    }

    //Génère une nouvelle fenetre pour visualiser le fractale et changer sa taille/couleur en live
    public void fractalViewer(Controller c){
        Controller.keyMaps k = c.new keyMaps(c);
        id = 4;
        v.setSize(600,600);
        v.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JLabel keys = new JLabel("Hold Z to zoom out, S to zoom in. Hold A to decrease hue, E to increase.");
        keys.setFont(new Font("SansSerif", Font.BOLD, 20));
        keys.setForeground(Color.WHITE);
        add(keys, BorderLayout.NORTH);
        img = c.getF().buildPicture();
        ImageIcon ic = new ImageIcon(img);
        JLabel fract = new JLabel(ic);
        container = new JPanel();
        container.setBackground(Color.black);
        container.setLayout(new BorderLayout());
        container.add(fract,BorderLayout.CENTER);
        add(container, BorderLayout.CENTER);
        container.removeKeyListener(k);
        container.addKeyListener(k);
        container.setFocusable(true);
        container.requestFocusInWindow();
    }
}
