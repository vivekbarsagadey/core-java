package com.bnb.gj.general.lambda;

import java.util.*;

/**
 * Created by vivek_000 on 27/04/2014.
 */
public class Ch1 {

    public static void main(String arg[]){

        /*List<Person> persons = new ArrayList<Person>();*/
        List<String> names = Arrays.asList("First","Second");
        names.forEach(name -> name.toUpperCase());


        String [] namesArray = {"First","Second","Third","Fo"};

        //Old programming
        /*Arrays.sort(namesArray,new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return (s1.charAt(0) - s2.charAt(0));
                    }
                }
        );*/

        // First way
        /*Arrays.sort(namesArray,
                (String s1,String s2) ->{ return  (s1.charAt(0) - s2.charAt(0));}

        );*/

        //second way remove type
        /*Arrays.sort(namesArray,
                (s1, s2) ->{ return  (s1.charAt(0) - s2.charAt(0));}

        );*/

        //third way remove return ; void means return result
        Arrays.sort(namesArray,
                (s1,s2) -> (s1.charAt(0) - s2.charAt(0))

        );

        System.out.println(namesArray[0]);
        System.out.println(namesArray[1]);

       // List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
       // list.stream().map((x) -> x*x).forEach(System.out::println);




    }
}
