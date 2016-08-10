/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import base.DBManager;
import java.sql.*;
import java.util.*;

/**
 * ユーザー・コーディネート・ヘアスタイル・履歴の情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * @author 1999itukinao
 */
public class DataDAO {
    
    //インスタンスオビジェクトを返却させてコードの簡略化
    public static DataDAO getInstance() {
        return new DataDAO();
    }
    
    /**
     * ユーザーデータの挿入処理を行う。
     * @param udd
     * @throws SQLException 
     */
    public void UserInsert(UserDataDTO udd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,password,age,place,length) VALUE(?,?,?,?,?)");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setInt(3, udd.getAge());
            st.setString(4, udd.getPlace());
            st.setInt(5, udd.getLength());
            st.executeUpdate();
            
            System.out.println("user_t insert complete!!");
            
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    /**
     * ユーザーデータの検索処理を行う。
     * @param udd
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO UserSearch(UserDataDTO udd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM user_t WHERE name=? AND password=?");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setPassword(rs.getString(3));
            resultUd.setAge(rs.getInt(4));
            resultUd.setPlace(rs.getString(5));
            resultUd.setLength(rs.getInt(6));
            
            System.out.println("user_t search completed!!");
            
            return resultUd;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    /**
     * ユーザーIDによるデータの更新処理を行う。更新日時は更新する直前に生成
     * @param udd
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void UserUpdate(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "UPDATE user_t SET name=?, password=?, age=?, place=?, length=? WHERE userID= ?" ;
            st =  con.prepareStatement(sql);
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setInt(3, udd.getAge());
            st.setString(4, udd.getPlace());
            st.setInt(5, udd.getLength());
            st.setInt(6,udd.getUserID());
            st.executeUpdate();
            
            System.out.println("update completed!!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        } 
    }
    
    /**
     * ユーザーIDによる削除処理を行う
     * @param udd
     * @throws SQLException 
     */
    public void UserDelete(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "DELETE FROM user_t WHERE userID = ?" ;
            st =  con.prepareStatement(sql);
            st.setInt(1, udd.getUserID());
            st.executeUpdate();
            
            System.out.println("delete completed!!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        } 
    }
    
    /**
     * ユーザー情報・選択条件・気温によりコーディネートを取得する
     * @param udd　ユーザーの年代
     * @param pdd　
     * @return iddList　条件に沿ったコーディネート
     * @throws SQLException 
     */
    public ArrayList WearSearch(UserDataDTO udd,ProposalDataDTO pdd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ArrayList<ProposalDataDTO> pddList = new ArrayList<ProposalDataDTO>();
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM wear_t WHERE age = ? AND taste = ? AND temp = ? AND item = ? ");
            st.setInt(1, udd.getAge());
            st.setInt(2, pdd.getTaste());
            st.setInt(3, pdd.getTempNum());
            st.setInt(4, pdd.getItem());
            
            ResultSet rs = st.executeQuery();
            
            //検索結果全てをArrayListに格納
            while(rs.next()){
                ProposalDataDTO resultPd = new ProposalDataDTO();
                resultPd.setWearID(rs.getInt(1));
                resultPd.setAge(rs.getInt(2));
                resultPd.setItem(rs.getInt(3));
                resultPd.setTaste(rs.getInt(4));
                resultPd.setTempNum(rs.getInt(5));
                resultPd.setWearImg(rs.getString(6));
                
                pddList.add(resultPd);
            }
            
            System.out.println("WearSearch Completed!!");
            
            return pddList;
            
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    /**
     * ユーザー情報・天候情報によって条件に適したヘアスタイルを取得する
     * @param udd ユーザーの年代・髪の長さ
     * @return
     * @throws SQLException 
     */
    public ArrayList HairSearch(UserDataDTO udd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        ArrayList<ProposalDataDTO> pddList = new ArrayList<ProposalDataDTO>();
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM hair_t WHERE length = ? AND age = ?");
            st.setInt(1, udd.getLength());
            st.setInt(2, udd.getAge());
            
            ResultSet rs = st.executeQuery();
            
            //検索結果全てをArrayListに格納
            while(rs.next()) {
                ProposalDataDTO resultPd = new ProposalDataDTO();
                resultPd.setHairID(rs.getInt(1));
                resultPd.setTempNum(rs.getInt(2));
                resultPd.setHumidityNum(rs.getInt(3));
                resultPd.setAge(rs.getInt(4));
                resultPd.setLength(rs.getInt(5));
                resultPd.setHairImg(rs.getString(6));
                resultPd.setUrl(rs.getString(7));
                
                pddList.add(resultPd);
            }
            
            System.out.println("HairSearch Completed!!");
            
            return pddList;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    /**
     * ユーザー情報・選択条件・天候情報を利用履歴としてDBへ挿入する
     * @param udd
     * @param pdd
     * @param hdd
     * @throws SQLException 
     */
    public void HistoryInsert(UserDataDTO udd, ProposalDataDTO pdd, HistoryDataDTO hdd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO history_t(userID,location,item,taste,icon,temp_max,temp_min,humidity,speed,date) VALUE(?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, udd.getUserID());
            st.setString(2, hdd.getLocation());
            st.setInt(3, pdd.getItem());
            st.setInt(4, pdd.getTaste());
            st.setString(5, hdd.getIcon());
            st.setFloat(6, hdd.getTemp_max());
            st.setFloat(7, hdd.getTemp_min());
            st.setFloat(8, hdd.getHumidity());
            st.setFloat(9, hdd.getSpeed());
            st.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            
            System.out.println("history_t insert complete!!");
            
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    /**
     * ユーザーが利用した全ての履歴を検索する
     * @param udd
     * @return
     * @throws SQLException 
     */
    public ArrayList HistorySearch(UserDataDTO udd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        ArrayList<HistoryDataDTO> hddList = new ArrayList<HistoryDataDTO>();
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM history_t WHERE userID = ?");
            st.setInt(1, udd.getUserID());
                        
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                HistoryDataDTO resultHd = new HistoryDataDTO();
                resultHd.setHistoryID(rs.getInt(1));
                resultHd.setUserID(rs.getInt(2));
                resultHd.setLocation(rs.getString(3));
                resultHd.setItem(rs.getInt(4));
                resultHd.setTaste(rs.getInt(5));
                resultHd.setIcon(rs.getString(6));
                resultHd.setTemp_max(rs.getFloat(7));
                resultHd.setTemp_min(rs.getFloat(8));
                resultHd.setHumidity(rs.getFloat(9));
                resultHd.setSpeed(rs.getFloat(10));
                resultHd.setComment(rs.getString(11));
                resultHd.setDate(rs.getTimestamp(12));
                
                hddList.add(resultHd);
                
                System.out.println(resultHd.getHistoryID());
            }
            
            System.out.println("history_t search completed!!");
            
            return hddList;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    /**
     * 履歴IDを用いて履歴情報を検索する
     * @param hdd
     * @return
     * @throws SQLException 
     */
    public HistoryDataDTO HistoryIDSearch(HistoryDataDTO hdd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM history_t WHERE historyID = ?");
            st.setInt(1, hdd.getHistoryID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
                HistoryDataDTO resultHd = new HistoryDataDTO();
                resultHd.setHistoryID(rs.getInt(1));
                resultHd.setUserID(rs.getInt(2));
                resultHd.setLocation(rs.getString(3));
                resultHd.setItem(rs.getInt(4));
                resultHd.setTaste(rs.getInt(5));
                resultHd.setIcon(rs.getString(6));
                resultHd.setTemp_max(rs.getFloat(7));
                resultHd.setTemp_min(rs.getFloat(8));
                resultHd.setHumidity(rs.getFloat(9));
                resultHd.setSpeed(rs.getFloat(10));
                resultHd.setComment(rs.getString(11));
                resultHd.setDate(rs.getTimestamp(12));
            
            System.out.println("historyID search complete!!");
            
            return resultHd;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            
        }
    }
    
    /**
     * 履歴IDを用いてコメントを追加する
     * @param hdd
     * @throws SQLException 
     */
    public void CommentUpdate(HistoryDataDTO hdd) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE history_t SET comment=? where historyID=?");
            st.setString(1, hdd.getComment());
            st.setInt(2, hdd.getHistoryID());
            st.executeUpdate();
            
            System.out.println("comment update complete!!");
            
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null) {
                con.close();
            }
        }
    }
}
