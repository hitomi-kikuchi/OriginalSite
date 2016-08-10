/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * コーディネートとヘアスタイルの情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @author 1999itukinao
 */
public class ProposalDataDTO {

    private int age; //年代
    private int tempNum;
    private String location; //本日の活動場所
    private int season; //季節
    
    //wear_t
    private int wearID; 
    private int taste;
    private int item;
    private String wearimg; //写真データ
    
    //hair_t
    private int hairID;
    private int length;
    private int humidityNum;
    private String hairimg; //
    private String url;
    
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getSeason() {
        return season;
    }
    public void setSeason(int season) {
        this.season = season;
    }
    
    public String getWearImg() {
        return wearimg;
    }
    public void setWearImg(String wearimg) {
        this.wearimg = wearimg;
    }
    
    public int getWearID() {
        return wearID;
    }
    public void setWearID(int wearID) {
        this.wearID = wearID;
    }
    
    public int getTaste() {
        return taste;
    }
    public void setTaste(int taste) {
        this.taste = taste;
    }
    
    public int getTempNum() {
        return tempNum;
    }
    public void setTempNum(int tempNUm) {
        this.tempNum = tempNUm;
    }
    
    public int getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
    
    public int getHairID() {
        return hairID;
    }
    public void setHairID(int hairID) {
        this.hairID = hairID;
    }
    
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getHumidityNum() {
        return humidityNum;
    }
    public void setHumidityNum(int humidityNum) {
        this.humidityNum = humidityNum;
    }
    
    public String getHairImg() {
        return hairimg;
    }
    public void setHairImg(String hairimg) {
        this.hairimg = hairimg;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
}
