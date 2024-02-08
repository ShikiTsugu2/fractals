package src.functions;

public class Complexe {
    private final double reel,imaginaire;

    public Complexe(double pr, double pi){
        reel = pr;
        imaginaire = pi;
    }

    public double getReel() {
        return reel;
    }

    public double getImaginaire() {
        return imaginaire;
    }

    public Complexe somme(Complexe c){
        return new Complexe(this.reel+c.reel, this.imaginaire+c.imaginaire);
    }

    public Complexe soustraction(Complexe c){
        return new Complexe(this.reel-c.reel, this.imaginaire-c.imaginaire);
    }

    public Complexe multiplication(Complexe c){
        double reel = (this.reel * c.reel) - (this.imaginaire * c.imaginaire);
        double img = (this.reel * c.imaginaire) + (this.imaginaire * c.reel);
        return new Complexe(reel,img);
    }

    public Complexe division(Complexe c){
        Complexe inverse = new Complexe(c.reel,-c.imaginaire);
        Complexe num = this.multiplication(inverse);
        Complexe denom = c.multiplication(inverse);
        double resR = num.reel/denom.reel;
        double resI = num.imaginaire/denom.reel;
        return new Complexe(resR,resI);
    }

    public boolean equals(Complexe c){
        return reel==c.reel && imaginaire==c.imaginaire;
    }

    public double partieReel(){
        return reel;
    }

    public double partieImaginaire(){
        return imaginaire;
    }

    public Complexe conjugue(){
        double newIm = -imaginaire;
        return new Complexe(reel, -imaginaire);
    }

    public double module(){
        return Math.sqrt((reel*reel)+(imaginaire*imaginaire));
    }

    public String toString(){
        return reel+" + i*"+imaginaire;
    }
}
