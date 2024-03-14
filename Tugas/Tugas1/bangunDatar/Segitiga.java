package bangunDatar;

public class Segitiga implements perhitungan{
    public double alas;
    public double x,y;
    public Segitiga(double a, double b, double c){ 
        this.a = a;
        this.b = b;
        this.c = c;
        
    }
    public double getTinggi() {
        return Math.sqrt( (a*a) - (c/2)*(c/2) );
    }
    public double hitungLuas(){
        return(c * getTinggi()) / 2;
    };
    public double hitungKeliling(){
        return c + a + b;
    }

    public double luasSegitigaSembarang(){
        semiParameter = hitungKeliling() / 2;
        return Math.sqrt(semiParameter * (semiParameter - a) * (semiParameter - b) * (semiParameter - c));
    }
}