package Model;

import java.util.ArrayList;

/**
 * フォームから出入力されるデータを格納するBeansオブジェクト
 * DTOからの変換、逆にDTOへの変換を行うメソッドを保持する
 * @author 1999itukinao
 */
public class UserDataBeans {
    private int userID;
    private String name;
    private String password;
    private int age;
    private String place;
    private int length;
    
    public void UserDataBeans() {
        this.userID = 0;
        this.name = "";
        this.password = "";
        this.age = 0;
        this.place = "";
        this.length = 0;        
    }
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        //初期選択の場合0をセット
        if(userID.equals("")) {
            this.userID = 0;
        }else {
            this.userID = Integer.parseInt(userID);
        }
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.trim().length() == 0) {
            this.name = "";
        }else {
            this.name = name;
        }
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if(password.trim().length() == 0) {
            this.password = "";
        }else {
            this.password = password;
        }
    }
    
    public int getAge() {
        return age;
    }
    public void setAge(String age) {
        if(age.equals("")) {
            this.age = 0;
        }else {
            this.age = Integer.parseInt(age);
        }
    }
    
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        if(place.trim().length() == 0) {
            this.place = "";
        }else {
            this.place = place;
        }
    }
    
    public int getLength() {
        return length;
    }
    public void setLength(String length) {
        if(length.equals("")) {
            this.length = 0;
        }else {
            this.length = Integer.parseInt(length);
        }
    }
    
    /**
     * 新規登録フォームからの未入力項目チェック
     * @return chkList
     */
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("pass");
        }
        if(this.age == 0){
            chkList.add("age");
        }
        if(this.place.equals("")){
            chkList.add("place");
        }
        if(this.length == 0){
            chkList.add("length");
        }
        
        return chkList;
    }

    
    /**
     * DB専用パラメータに変換
     * @param udd
     */
    public void UDBDTOMapping(UserDataDTO udd) {
        udd.setUserID(this.userID);
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setAge(this.age);
        udd.setPlace(this.place);
        udd.setLength(this.length);
        
        System.out.println("UDB:"+udd.getUserID());
    }
    
    /**
     * View用パラメータに変換
     * @param udd
     */
    public void DTOUDBMapping(UserDataDTO udd) {
        //int型をString型に変換
        String UserID = String.valueOf(udd.getUserID());
        String Age = String.valueOf(udd.getAge());
        String Length = String.valueOf(udd.getLength());
        
        this.setUserID(UserID);
        this.setName(udd.getName());
        this.setPassword(udd.getPassword());
        this.setAge(Age);
        this.setPlace(udd.getPlace());
        this.setLength(Length);
    }
}
