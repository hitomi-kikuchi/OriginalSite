/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 利用履歴情報を格納するBeansオブジェクト
 * セットされたTimestampを年・月・日・曜日に振り分けて表示させる
 * DTOからの変換、逆にDTOへの変換を行うメソッドを保持する
 * @author 1999itukinao
 */
public class HistoryDataBeans {
    private int historyID; //履歴ID
    private int userID; //ユーザーID
    private String location; //活動場所
    private int item; //アイテム
    private int taste; //テイスト
    private float temp; //平均気温
    private float temp_max; //最高気温
    private float temp_min; //最低気温
    private float humidity; //湿度
    private String icon; //天気アイコン
    private float speed; //風速
    private String comment; //コメント
    private int year; //年
    private int month; //月
    private int day; //日
    private String week; //曜日
    
    
    public void Weather() {
        this.historyID = 0;
        this.userID = 0;
        this.location = "";
        this.item = 0;
        this.taste = 0;
        this.temp = 0;
        this.temp_max = 0;
        this.temp_min = 0;
        this.humidity = 0;
        this.icon = "";
        this.speed = 0;
        this.comment = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.week = "";       
    }
    
    public int getHistoryID() {
        return historyID;
    }
    public void setHistoryID(String historyID) {
        this.historyID = Integer.parseInt(historyID);
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
    
    public float getTemp() {
        return temp;
    }
    public void setTemp(float temp) {
        this.temp = temp;
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
    
    public int getYear() {
        return year;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    
    public String getWeek() {
        return week;
    }
    
    public void setCalendar(Timestamp date) {
        //Timestamp型をCalendar型に変換して各要素をセット
        Date d = new Date(date.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        String[] week_name = {"<font color=\"blue\">SAT</font>", "<font color=\"red\">SUN</font>", "MON", "TUE", "WED", "THU", "FRI"};

        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH)+1;
        this.day = cal.get(Calendar.DATE);        
        this.week = week_name[cal.get(Calendar.DAY_OF_WEEK)];
    }
    
    
    /**
     * 利用データDTOオブジェクトにマッピング(HDB→DTO)
     * @param hdd 
     */
    public void HDBHDDMapping(HistoryDataDTO hdd) {
        hdd.setLocation(this.location);
        hdd.setIcon(this.icon);
        hdd.setTemp_max(this.temp_max);
        hdd.setTemp_min(this.temp_min);
        hdd.setHumidity(this.humidity);
        hdd.setSpeed(this.speed);
    }
    
    /**
     * ユーザーの利用履歴データをBeansオブジェクトにマッピング(DTO→HDB)
     * @param hddList
     * @return hdbList
     */
    public ArrayList DTOHDBMapping(ArrayList<HistoryDataDTO> hddList) {
        ArrayList<HistoryDataBeans> hdbList = new ArrayList<HistoryDataBeans>();
        
        for(int i = 0; i < hddList.size(); i++) {
            HistoryDataBeans hdb = new HistoryDataBeans();
            //int型をString型に変換
            String ID = String.valueOf(hddList.get(i).getHistoryID());
            
            hdb.setHistoryID(ID);
            hdb.setLocation(hddList.get(i).getLocation());
            hdb.setItem(hddList.get(i).getItem());
            hdb.setTaste(hddList.get(i).getTaste());
            hdb.setIcon(hddList.get(i).getIcon());
            hdb.setTemp_max(hddList.get(i).getTemp_max());
            hdb.setTemp_min(hddList.get(i).getTemp_min());
            hdb.setHumidity(hddList.get(i).getHumidity());
            hdb.setSpeed(hddList.get(i).getSpeed());
            hdb.setComment(hddList.get(i).getComment());
            hdb.setCalendar(hddList.get(i).getDate());
            
            hdbList.add(hdb);
        }
        return hdbList;
    }
    
    /**
     * DBから検索した1件の履歴データをBeansオブジェクトにマッピング(DTO→HDB)
     * @param hdd 
     */
    public void DTOHDBComeentMapping(HistoryDataDTO hdd) {
        //int型をString型に変換
        String HistoryID = String.valueOf(hdd.getHistoryID());
        
        this.setHistoryID(HistoryID);
        this.setCalendar(hdd.getDate());
    }
    
    public void HDBDTOCommentMapping(HistoryDataDTO hdd) {
        hdd.setHistoryID(this.historyID);
        hdd.setComment(this.comment);
    }
}
