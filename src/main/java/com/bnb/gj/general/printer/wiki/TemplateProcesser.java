package com.bnb.gj.general.printer.wiki;

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
		if(PrintCommands.CHAR.equalsIgnoreCase(command) ) {
			buildChar(PrintCommands.CHAR);
		}
		if(PrintCommands.TAB.equalsIgnoreCase(command) ) {
			buildHorizontalTab(PrintCommands.TAB);
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
		buildJustLine(command);
	}
	
	private void buildJustLine(String command) {
		var newCommand = getJustLineCommand(command+"just:");
		if(newCommand!=null) {
			var lineData = getLineData(newCommand);
			var newExtraCommand = newCommand.replace(":just:", ":exrta:");
			if(lineData.length ==5) {
				var str = lineData[4];
				var data = lineData[4].substring(0, str.length()-1);
				var listData  =processer.justLine(Integer.parseInt(lineData[3]),data);
				
				if(listData.length > 1) {
					//this.templateString = this.templateString.replaceAll(Pattern.quote(newExtraCommand),listData[1]);
					this.templateString = this.templateString.replaceAll(Pattern.quote(newCommand),listData[0] +"...");
				}else {
					this.templateString = this.templateString.replaceAll(Pattern.quote(newCommand),listData[0]);
					//this.templateString = this.templateString.replaceAll(Pattern.quote(newExtraCommand),"");
				}
				
			}else {
				//this.templateString = this.templateString.replaceAll(Pattern.quote(newExtraCommand),"");
			}
			
		}
		if(isNewLineFound(command+"just:")) {
			buildJustLine(command);
		}else {
			return;
		}
	}
	
	private Boolean isNewLineFound(String command) {
		return this.templateString.contains(command);
		
	}
	
	
	private String [] getLineData(String data) {
		return data.split(":");
	}
	
	private String getJustLineCommand(String command) {
		String findCommand  = null;
		var commandLen = command.length();
		if(this.templateString.contains(command)) {
			int index = this.templateString.indexOf(command);
			int lastindex = this.templateString.indexOf("|",index+commandLen);
			var data = this.templateString.substring(index+commandLen,lastindex);
			findCommand = command+data+"|";
		}
		return findCommand;
	}

	private void buildHorizontalTab(String command) {
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"horizontal|"), processer.horizontalTab());	
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"horizontalPosition|"), processer.horizontalTabPosition());	
		
	}
	
	private void buildChar(String command) {
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"emphasized:on|"), processer.emphasized(true)) ;
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"emphasized:off|"), processer.emphasized(false)) ;
		
		
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"doubleHeight:on|"), processer.doubleHeight(true)) ;
		this.templateString = this.templateString.replaceAll(Pattern.quote(command+"doubleHeight:off|"), processer.doubleHeight(false)) ;
			
	}
	
	
	
	
	

}
