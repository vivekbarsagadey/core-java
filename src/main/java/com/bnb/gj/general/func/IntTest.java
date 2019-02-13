package com.bnb.gj.general.func;

/**
 * Created by vivek_000 on 29/04/2014.
 */
public class IntTest {
    public static void intTest(Integrable integrable, double x) {
        System.out.println("Result is : "+integrable.eval(x));
    }

    public static void main(String[] args) {
        /*intTest(new Integrable() {
            @Override
            public double eval(double d) {
                System.out.println(">>> the d is "+d);
                return d*d;
            }
        },10);*/

        intTest((x) -> x+x,10);
        intTest((x) -> x-x,10);
        intTest((x) -> x*x,10);
        intTest((x) -> x/x,10);
        intTest((x) -> Math.pow(x,x),10);
        intTest((x) -> Math.sin(x),10);
        //Method reference
        intTest( Math::sin ,10);

        // Typed Interface
        Integrable integrable = (x) -> x+x;
        intTest(integrable,10);

        integrable = Math::sin;
        intTest(integrable,10);


    }
}
