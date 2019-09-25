package com.bnb.gj.general.printer.wiki;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PrintCommandsProcesser {
	String initdata = "";

	public String initialize(String initdata) {
        final byte[] Init = {27, 64};
        initdata += new String(Init);
        return new String(Init)+initdata;
    }
	
	public void resetAll() {
		initdata = "";
    }

	 
	public String font(Byte size) {
		final byte[] ChooseFontA = {27, 77, size.byteValue()};
	    return new String(ChooseFontA);
	}
	
	public String feed(byte lines) {
        final byte[] Feed = {27,100,lines};
        return new String(Feed);
    }
	
	public String alignLeft() {
        final byte[] AlignLeft = {27, 97,48};
        return new String(AlignLeft);
    }

    public String alignCenter() {
        final byte[] AlignCenter = {27, 97,49};
        return new String(AlignCenter);
    }

    public String alignRight() {
        final byte[] AlignRight = {27, 97,50};
        return new String(AlignRight);
    }
    
    public String finit() {
        final byte[] FeedAndCut = {29, 'V', 66, 0};
        String s = new String(FeedAndCut);
        final byte[] DrawerKick={27,70,0,60,120};   
        s += new String(DrawerKick);
        return s;
    }
    
    public String newLine() {
        final  byte[] LF = {10};
        return new String(LF);
    }
    
    public String justLine(Long len, String data) {
    	//System.out.println("data >>>> "+data);
    	//System.out.println("len >>>> "+len);
    	if(data.length() > len) {
    		AtomicInteger splitCounter = new AtomicInteger(0);
    		var newData = data
            .chars()
            .mapToObj(_char -> String.valueOf((char)_char))
            .collect(Collectors.groupingBy(stringChar -> splitCounter.getAndIncrement() / len
                                        ,Collectors.joining()))
            .values();
    		System.out.println("newData >>>>>>>>>>>>>>>>>>> ");
    		System.out.println(newData);
    		data = newData.stream()
    	            .map( Object::toString )
    	            .collect( Collectors.joining( newLine() ) );
    		
    	}
    	System.out.println("data :::::::::::: ");
    	System.out.println(data);
    	System.out.println("data END:::::::::::: ");
    	return data;
    }
    
    public String horizontalTab() {
        final  byte[] HT = {9};
        return new String(HT);
    }
    
    public String horizontalTabPosition() {
        final  byte[] HTP = {27, 68, 10};
        return new String(HTP);
    }
    
    public String emphasized(boolean enabled) {
        final byte[] EmphasizedOff={27 , 69, 0};
        final byte[] EmphasizedOn={27 ,69, 1};

        String s="";
        if(enabled)
            s = new String(EmphasizedOn);
        else
            s = new String(EmphasizedOff);

        return s;
    } 
    public String doubleHeight(boolean enabled) {
        final byte[] DoubleHeight = {27, 33, 17};
        final byte[] UnDoubleHeight={27, 33, 0};

        String s = "";
        if(enabled)
            s = new String(DoubleHeight);
        else
            s = new String(UnDoubleHeight);

        return s;
    }

}
