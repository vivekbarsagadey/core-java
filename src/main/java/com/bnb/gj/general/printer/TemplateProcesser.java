package com.bnb.gj.general.printer;

import lombok.Data;

@Data
public class TemplateProcesser {
	private PrintCommandsProcesser processer = new PrintCommandsProcesser();

	private PrintCommands printCommands = new PrintCommands();
	private String templateString = "";
	
	public TemplateProcesser(String templateString) {
		templateString = processer.initialize(templateString);
		this.templateString = templateString;
	}
	
	public TemplateProcesser build(String command) {
		if(PrintCommands.FONT.equalsIgnoreCase(command) ) {
			buildFont(PrintCommands.FONT);
		}
		return this;
	}
	
	
	private void buildFont(String command) {
		for(int i=0 ; i<=50 ; i++) {
			var comd  =command +i+"|";
			System.out.println(comd);
			this.templateString = this.templateString.replaceAll(comd, processer.font(Byte.parseByte(i+"")));
			System.out.println(comd+">>"+this.templateString);
		}
	}
	
	
	

}
