package com.bnb.gj.general.mon;

public class AtddArguments {

    private final static  String INPUT_FILE_PATH_PRE="inputcsvfile_";
    private final static String OUT_FILE_PATH_PRE="outputcsvfile_";
    private final static String FILE_TYPE=".csv";

    private String inputfile = "";
    private String outputfile = "";
    private String Serialisedfolder = "";
    private String featurefile = "";
    private String jenkinsworkspace = "";
    private String jarversion = "";
    private String inputdata = "";
    private String levelReleaseVersion = "1";
    private String baseFilePath = "";
    private String inputFilePath = "InputFiles/";
    private String outFilePath = "OutPutFiles/";



    private String sparkPath="";

    public AtddArguments() {

    }

    public AtddArguments(String baseFilePath) {
        this.baseFilePath =baseFilePath;
    }


    public String getInputfile() {
        return inputfile;
    }

    public String getAbsInputfile() {
        return jenkinsworkspace+inputFilePath+baseFilePath+INPUT_FILE_PATH_PRE+inputfile+FILE_TYPE;
    }

    public String getAbsInputFolder() {
        return jenkinsworkspace+inputFilePath+baseFilePath;
    }

    public void setInputfile(String inputfile) {
        this.inputfile = inputfile;
    }
    public String getOutputfile() {
        return outputfile;
    }

    public String getOutputfileName() {
        return OUT_FILE_PATH_PRE+outputfile+FILE_TYPE;
    }

    public String getAbsOutputfile() {
        return jenkinsworkspace+outFilePath+baseFilePath+OUT_FILE_PATH_PRE+outputfile+FILE_TYPE;
    }
    public String getAbsOutputFolder() {
        return jenkinsworkspace+outFilePath+baseFilePath;
    }

    public void setOutputfile(String outputfile) {
        this.outputfile = outputfile;
    }
    public String getSerialisedfolder() {
        return Serialisedfolder;
    }
    public void setSerialisedfolder(String serialisedfolder) {
        Serialisedfolder = serialisedfolder;
    }
    public String getFeaturefile() {
        return featurefile;
    }
    public void setFeaturefile(String featurefile) {
        this.featurefile = featurefile;
    }
    public String getJenkinsworkspace() {
        return jenkinsworkspace;
    }
    public void setJenkinsworkspace(String jenkinsworkspace) {
        this.jenkinsworkspace = jenkinsworkspace;
    }
    public String getJarversion() {
        return jarversion;
    }
    public void setJarversion(String jarversion) {
        this.jarversion = jarversion;
    }
    public String getInputdata() {
        return inputdata;
    }
    public void setInputdata(String inputdata) {
        this.inputdata = inputdata;
    }

    public String getLevelReleaseVersion() {
        return levelReleaseVersion;
    }


    public void setLevelReleaseVersion(String levelReleaseVersion) {
        this.levelReleaseVersion = levelReleaseVersion;
    }

    public String getBaseFilePath() {
        return baseFilePath;
    }

    public void setBaseFilePath(String baseFilePath) {
        this.baseFilePath = baseFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public void setOutFilePath(String outFilePath) {
        this.outFilePath = outFilePath;
    }

    public String getSparkPath() {
        return sparkPath;
    }

    public void setSparkPath(String sparkPath) {
        this.sparkPath = sparkPath;
    }

    @Override
    public String toString() {
        return "AtddArguments{" +
                "inputfile='" + inputfile + '\'' +
                ", outputfile='" + outputfile + '\'' +
                ", Serialisedfolder='" + Serialisedfolder + '\'' +
                ", featurefile='" + featurefile + '\'' +
                ", jenkinsworkspace='" + jenkinsworkspace + '\'' +
                ", jarversion='" + jarversion + '\'' +
                ", inputdata='" + inputdata + '\'' +
                ", levelReleaseVersion='" + levelReleaseVersion + '\'' +
                ", baseFilePath='" + baseFilePath + '\'' +
                ", inputFilePath='" + inputFilePath + '\'' +
                ", outFilePath='" + outFilePath + '\'' +
                ", sparkPath='" + sparkPath + '\'' +
                '}';
    }

}

