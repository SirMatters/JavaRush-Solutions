package com.javarush.test.level15.lesson12.home05;

import java.math.BigInteger;

/**
 * Created by K.Perov on 08.06.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(int s)
    {
        super(s);
    }

    public SubSolution(short s)
    {
        super(s);
    }

    protected SubSolution(Integer s)
    {
        super(s);
    }

    protected SubSolution(Double s)
    {
        super(s);
    }

    protected SubSolution(double s)
    {
        super(s);
    }

    private SubSolution (byte s) {}
    private SubSolution (long s) {}
    private SubSolution (float s) {}

    SubSolution(BigInteger s)
    {
        super(s);
    }

    SubSolution(Float s)
    {
        super(s);
    }

    SubSolution(Object s)
    {
        super(s);
    }
}