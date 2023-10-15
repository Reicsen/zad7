package com.zad7;

class PrzekroczonoZakres extends Exception{};

public class PostacTrygonometryczna
{
    public double modul;
    public double argument;

    public PostacTrygonometryczna()
    {
        this.modul = 0.0;
        this.argument = 0.0;
    }

    public PostacTrygonometryczna(PostacZwykla z)
    {
        this.modul = Math.sqrt(z.czrzeczywista*z.czrzeczywista + z.czurojona*z.czurojona);
        
        if (z.czurojona >= 0.0)
        {
            this.argument = Math.acos(z.czrzeczywista/this.modul);
        }
        else
        {
            this.argument = 2*Math.PI - Math.acos(z.czrzeczywista/this.modul);
        }
    }

    public static PostacTrygonometryczna potega(PostacTrygonometryczna z, int wykladnik) throws PrzekroczonoZakres
    {
        if (Double.MAX_VALUE/wykladnik<z.argument || Math.log(Double.MAX_VALUE)/Math.log(z.modul)<wykladnik)
        {
            throw new PrzekroczonoZakres();
        }

        PostacTrygonometryczna wynik = new PostacTrygonometryczna();

        wynik.modul = Math.pow(z.modul,wykladnik);
        wynik.argument = z.argument*wykladnik;
        
        while (wynik.argument>=2*Math.PI)
        {
            wynik.argument=wynik.argument-2*Math.PI;
        }

        return wynik;
    }
}
