package com.bnb.gj.general.printer;

public class PrintCommandsProcesser {


	public String initialize(String initdata) {
        final byte[] Init = {27, 64};
        initdata += new String(Init);
        return new String(Init);
    }

	 
	public String font(Byte size) {
		final byte[] ChooseFontA = {27, 77, size.byteValue()};
	    return new String(ChooseFontA);
	}
}
