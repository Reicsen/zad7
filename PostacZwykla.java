package com.zad7;

public class PostacZwykla
{
    public double czrzeczywista;
    public double czurojona;

    public PostacZwykla()
    {
        this.czrzeczywista=0.0;
        this.czurojona=0.0;
    }

    public PostacZwykla(double re, double im)
    {
        this.czrzeczywista = re;
        this.czurojona = im;
    }

    public static String wypisz(PostacZwykla z)
    {
        if (z.czurojona == 0.0)
        {
            return Double.toString(z.czrzeczywista);
        }

        else
        {
            if (z.czrzeczywista==0.0)
            {
                return Double.toString(z.czurojona)+"i";
            }
            else
            {
                if (z.czurojona>0.0)
                {
                    return Double.toString(z.czrzeczywista)+"+"+Double.toString(z.czurojona)+"i";
                }
                else
                {
                    return Double.toString(z.czrzeczywista)+Double.toString(z.czurojona)+"i";
                }
            }
        }
    }

    public PostacZwykla(PostacTrygonometryczna z)
    {
        this.czrzeczywista = z.modul * Math.cos(z.argument);
        this.czurojona = z.modul * Math.sin(z.argument);
    }
}
