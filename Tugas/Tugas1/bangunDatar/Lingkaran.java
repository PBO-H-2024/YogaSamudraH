package bangunDatar;

public class Lingkaran implements HitungBidang{
    public double jari;
    static double phi = 3.14;
    public Lingkaran(double r){
        this.jari = r;
    }
    public double hitungLuas(){
        return phi * jari * jari;
    }
    public double hitungKeliling(){
        return (2 * phi * jari);
    }
}