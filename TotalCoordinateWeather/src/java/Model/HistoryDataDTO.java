/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author 1999itukinao
 */
public class HistoryDataDTO {
    private int historyID;
    private int userID;
    private String location;
    private int item;
    private int taste;
    private String icon; //天気アイコン
    private float temp_max; //最高気温
    private float temp_min; //最低気温
    private float humidity; //湿度
    private float speed; //風速
    private String comment;
    private Timestamp date;
    
    
    public int getHistoryID() {
        return historyID;
    }
    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    public int getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
    
    public int getTaste() {
        return taste;
    }
    public void setTaste(int taste) {
        this.taste = taste;
    }
    
    public float getTemp_max() {
        return temp_max;
    }
    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
    
    public float getTemp_min() {
        return temp_min;
    }
    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }
    
    public float getHumidity() {
        return humidity;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
}
