package com.bnb.gj.general.func;

/**
 * Created by vivek_000 on 29/04/2014.
 */
@FunctionalInterface
public interface Integrable {
    double eval(double d);
    /*default double sqrt(int a) {
        return Math.sqrt(a);
    }*/
}
