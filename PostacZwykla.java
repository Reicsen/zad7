package com.zad7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PostacZwykla
{
    public double czrzeczywista;
    public double czurojona;

    public static double zaokraglanie(double liczba)
    {
        BigDecimal pomocniczy = BigDecimal.valueOf(liczba);
        pomocniczy = pomocniczy.setScale(3, RoundingMode.HALF_UP);
        return pomocniczy.doubleValue();
    }

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
                    return (Double.toString(z.czrzeczywista))+"+"+Double.toString(z.czurojona)+"i";
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
        this.czrzeczywista = zaokraglanie(z.modul * Math.cos(z.argument));
        this.czurojona = zaokraglanie(z.modul * Math.sin(z.argument));
    }
}
