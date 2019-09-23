package com.bnb.gj.general.printer;

import java.util.regex.Pattern;

import lombok.Data;

@Data
public class TemplateProcesser {
	private PrintCommandsProcesser processer = new PrintCommandsProcesser();

	private PrintCommands printCommands = new PrintCommands();
	private String templateString = "";
	
	public TemplateProcesser(String templateString) {
		this.templateString = templateString;
		this.init();
	}
	
	public void init() {
		this.templateString = processer.initialize(this.templateString);
	}
	
	public TemplateProcesser buildFeed() {
		this.templateString = this.templateString + processer.feed((byte)3);
		this.templateString = this.templateString+processer.finit();
		return this;
	}
	public TemplateProcesser build(String command) {
		if(PrintCommands.FONT.equalsIgnoreCase(command) ) {
			buildFont(PrintCommands.FONT);
		}
		if(PrintCommands.ALIGN.equalsIgnoreCase(command) ) {
			buildAlign(PrintCommands.ALIGN);
		}
		if(PrintCommands.LINE.equalsIgnoreCase(command) ) {
			buildLine(PrintCommands.LINE);
		}
		return this;
	}
	
	
	private void buildFont(String command) {
		System.out.println("this.templateString >>>>>>>>>"+this.templateString);
		for(int i=0 ; i<=50 ; i++) {
			var comd  =command +i+"|";
			this.templateString = this.templateString.replaceAll(Pattern.quote(comd), processer.font(Byte.parseByte(i+"")));
		}
	}
	
	private void buildAlign(String command) {
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"left|"), processer.alignLeft());
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"right|"), processer.alignRight());
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"center|"), processer.alignCenter());
	}
	
	private void buildLine(String command) {
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"new|"), processer.newLine());
		
		
	}
	
	
	
	
	

}
