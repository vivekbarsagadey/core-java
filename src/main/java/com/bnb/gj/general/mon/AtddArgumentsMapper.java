package com.bnb.gj.general.mon;
import java.util.Optional;

public class AtddArgumentsMapper {

    public static AtddArguments map(String baseFilePath) {
        AtddArguments atddArguments = new AtddArguments();
        atddArguments.setJenkinsworkspace(Optional.ofNullable(System.getProperty("workspace.jenkins")).orElse(System.getProperty("user.home")));
        atddArguments.setLevelReleaseVersion(System.getProperty("level1release.version"));
        atddArguments.setSparkPath(Optional.ofNullable(System.getProperty("spark.path")).orElse(System.getProperty("user.home")+"/Documents/SparkLauncher/spark-2.4.6-bin-hadoop2.7"));
        atddArguments.setBaseFilePath(baseFilePath);

        if(isDevProfile()) {
            atddArguments.setInputFilePath(Optional.ofNullable(System.getProperty("path.input.file")).orElse("InputFiles/"));
            atddArguments.setOutFilePath(Optional.ofNullable(System.getProperty("path.output.file")).orElse("OutPutFiles/"));
        }
        return atddArguments;

    }

    public static boolean isDevProfile(){
        String type = Optional.ofNullable(System.getProperty("profile.name")).orElse("prod") ;
        return type.equalsIgnoreCase("DEV");

    }
    
    public static void main(String[] args) {
    	String inputFile="all_address_features_v1_6_md";
    	AtddArguments atddArguments =AtddArgumentsMapper.map("L1Atdd-Cases-Testdata-All/Address_Cases/");
    	atddArguments.setInputfile(inputFile);
        atddArguments.setOutputfile(inputFile);
    	System.out.println(atddArguments);
    	System.out.println(""+atddArguments.getAbsOutputFolder());
    	System.out.println(""+atddArguments.getAbsInputfile());
    	System.out.println(""+atddArguments.getOutputfileName());
	}

}