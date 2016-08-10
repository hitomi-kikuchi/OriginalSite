/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 * 選択条件と提案された情報を格納するBeansオブジェクト
 * DTOからの変換、逆にDTOへの変換を行うメソッドを保持する
 * @author 1999itukinao
 */
public class ProposalDataBeans {
    
    private int age; //年代
    private int tempNum; //気温
    private String location; //本日の活動場所
    private int season; //季節
    
    //wear_t
    private int wearID;
    private int taste; //テイスト    
    private int item; //使用したいアイテム
    private String wearimg; //コーディネート画像
    
    //hair_t
    private int hairID;
    private int length; //髪の長さ
    private int humidityNum;
    private String hairimg; //ヘアスタイル画像
    private String url; //How to URL

    
    public void Information() {
        this.age = 0;
        this.location = "";
        this.wearID = 0;
        this.taste = 0;
        this.tempNum = 0;
        this.item = 0;
        this.wearimg = "";
        this.hairID = 0;
        this.length = 0;
        this.humidityNum = 0;
        this.hairimg = "";
        this.url = "";
    }
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    public int getSeason() {
        return season;
    }
    public void setSeason(Calendar cal) {
        int seasonNum = cal.get(Calendar.MONTH)+1;
        if(seasonNum < 4) {
            this.season = 1; //冬
        }else if(seasonNum < 6) {
            this.season = 2; //春
        }else if(seasonNum < 9) {
            this.season = 3; //夏
        }else if(seasonNum < 11) {
            this.season = 4; //秋
        }else {
            this.season = 1; //冬
        }
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
    public void setTaste(String taste) {
        //おまかせ(teste=0)を選択した場合、ランダムでテイストを選択する
        int tst = Integer.parseInt(taste);
        if(tst == 0) {
            Random rnd = new Random();
            int intrust = rnd.nextInt(4)+1;
            this.taste = intrust;
        }else {
            this.taste = Integer.parseInt(taste);
        }
    }    
    
    public int getTempNum() {
        return tempNum;
    }
    public void setTempNum(float temp) {
        if(temp < 0) { //真冬日
            this.tempNum = 0;
        }else if(temp < 15) {
            this.tempNum = 1;
        }else if(temp <25) { //夏日
            this.tempNum = 2;
        }else if(temp <30) { //真夏日
            this.tempNum = 3;
        }else if(temp <35) { //猛暑日
            this.tempNum = 5;
        }else if(temp >35) {
            this.tempNum = 5;
        }else if(temp == 50) { //隠し
            this.tempNum = 6;
        }
    }
    
    public int getItem() {
        return item;
    }
    public void setItem(String item, int seasonNum) {
        //おまかせ(item=0)を選択した場合、季節に応じたアイテムをランダムで選択する
        int itm = Integer.parseInt(item);
        if(itm == 0) {
            Random rnd = new Random();
            switch (seasonNum) {
                case 1: //冬服
                    {
                        int intrust = rnd.nextInt(54)+1;
                        this.item = intrust;
                        break;
                    }
                case 3: //夏服
                    {
                        int intrust = rnd.nextInt(54)+14;
                        this.item = intrust;
                        break;
                    }
                default: //冬・秋服
                    {
                        int intrust = rnd.nextInt(54)+7;
                        this.item = intrust;
                        break;
                    }
            }
        }else {
            this.item = Integer.parseInt(item);
        }
    }    
    
    public int getHairID() {
        return hairID;
    }
    public void setHairID(int hairID) {
        this.hairID = hairID;
    }
    
    public String getWearImg() {
        return wearimg;
    }
    public void setgetWearImg(String wearimg) {
        this.wearimg = wearimg;
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
    public void setHumidityNum(float humidity) {
        if(humidity > 30) {
            this.humidityNum = 2;
        }else if(humidity > 50) {
            this.humidityNum = 2;
        }else if(humidity > 70) {
            this.humidityNum = 3;
        }else if(humidity > 90) {
            this.humidityNum = 4;
        }
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
    
    /**
     * DTOオブジェクトにマッピング(PDB→DTO)
     * DB専用パラメータに変換
     * @param pdd 
     */
    public void PDBDTOMapping(ProposalDataDTO pdd) {
        pdd.setItem(this.item);
        pdd.setTaste(this.taste);
        pdd.setLocation(this.location);
        pdd.setTempNum(this.tempNum);
    }
    
    /**
     * コーディネートデータをBeansオブジェクトにマッピング(DTO→PDB)
     * @param wearList
     * @return pdbList
     */
    public ArrayList DTOPDBMapping(ArrayList<ProposalDataDTO> wearList) {
        ArrayList<ProposalDataBeans> pdbList = new ArrayList<ProposalDataBeans>();
        
        for(int i = 0; i < 3; i++) {
            ProposalDataBeans pdb = new ProposalDataBeans();
            
            Random rnd = new Random();
            int wear = rnd.nextInt(wearList.size());
            
            //int型をString型に変換
            String Taste = String.valueOf(wearList.get(wear).getTaste());
            String Item = String.valueOf(wearList.get(wear).getItem());
            
            pdb.setTaste(Taste);
            pdb.setItem(Item, this.season);
            pdb.setgetWearImg(wearList.get(wear).getWearImg());
            
            pdbList.add(pdb);
            wearList.remove(wear);
        }    
        return pdbList;
    }
    
    /**
     * ヘアスタイルデータをBeansオブジェクトにマッピング(DTO→PDB)
     * hair_t
     * @param hairList 
     * @return pdb
     */
    public ProposalDataBeans hairMapping(ArrayList<ProposalDataDTO> hairList) {
        ProposalDataBeans pdb = new ProposalDataBeans();
        
        Random rnd = new Random();
        int hair = rnd.nextInt(hairList.size());
        
        pdb.setHairImg(hairList.get(hair).getHairImg());
        pdb.setUrl(hairList.get(hair).getUrl());
        
        return pdb;
    }
}