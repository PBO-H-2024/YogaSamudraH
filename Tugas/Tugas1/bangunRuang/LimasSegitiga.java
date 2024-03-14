package bangunRuang;
import bangunDatar.Segitiga;

public class LimasSegitiga extends Segitiga implements HitungRuang{
    double tinggi_limas;
    public LimasSegitiga(double a, double b, double c, double t) { 
        super(a, b, c);
        this.tinggi_limas = t;
        System.out.println("\nOUTPUT");
    }
    public double volume(){
        return (hitungLuas() * tinggi_limas) / 3;
    }
    public double luasPermukaan(){
        return hitungLuas() + (tinggi_limas/2) + (a+b+c); 
    }
    public double volumeLimasSembarang(){
        return (luasSegitigaSembarang() * tinggi_limas) / 3;
    }
    public double luasPermukaanLimasSembarang(){
        return luasSegitigaSembarang() + ( (tinggi_limas/2) * (a+b+c) );
    }
}