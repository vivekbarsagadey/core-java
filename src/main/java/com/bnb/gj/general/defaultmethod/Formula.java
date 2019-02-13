package com.bnb.gj.general.defaultmethod;

/**
 * Created by vivek_000 on 29/04/2014.
 */

public interface Formula {
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
