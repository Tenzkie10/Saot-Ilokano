package com.app.amedina.saot_ilokano;

public class GeneralConversationModel {
    String english1;
    String ilokano1;
    String audiofile;
    int favourite;
    int imgFave;

    public GeneralConversationModel(String english1, String ilokano1) {
        this.english1 = english1;
        this.ilokano1 = ilokano1;
    }
    public GeneralConversationModel(String english1, String ilokano1, String audiofile, int favourite) {
        this.english1 = english1;
        this.ilokano1 = ilokano1;
        this.audiofile = audiofile;
        this.favourite = favourite;
    }
    public GeneralConversationModel(String english1, String ilokano1, String audiofile, int favourite,int imgFave) {
        this.english1 = english1;
        this.ilokano1 = ilokano1;
        this.audiofile = audiofile;
        this.favourite = favourite;
        this.imgFave = imgFave;
    }

    public String getEnglish1() {
        return english1;
    }

    public String getIlokano1() {
        return ilokano1;
    }

    public String getAudiofile() {return audiofile;}

    public int getFavourite() {return favourite;}

    public int getImgFave() {
        return imgFave;
    }
}
