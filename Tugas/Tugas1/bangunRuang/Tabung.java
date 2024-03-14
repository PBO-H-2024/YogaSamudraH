package bangunRuang;

import bangunDatar.Lingkaran;

public class Tabung extends Lingkaran implements HitungRuang{
    double tinggi;
    public Tabung(double t, double r){
        super(r);
        this.tinggi = t;
        System.out.println("\nOUTPUT");
        System.out.printf("Luas Lingkaran : " + "%.2f",hitungLuas());
        System.out.printf("\nKeliling Lingkaran : " + "%.2f",hitungKeliling());
    }
    public double volume(){
        return hitungLuas() * tinggi;
    }
    public double luasPermukaan(){
        return hitungKeliling() * (jari + tinggi);
    }
    
}