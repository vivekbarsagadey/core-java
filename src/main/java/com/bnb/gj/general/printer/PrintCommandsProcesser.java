package com.bnb.gj.general.printer;

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
        String s = new String(Feed);
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

}
