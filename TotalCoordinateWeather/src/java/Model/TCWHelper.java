/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス
 * @author 1999itukinao
 */
public class TCWHelper {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static TCWHelper getInstance() {
        return new TCWHelper();
    }
    
    //リンクを定数として設定
    private final String topURL = "top.jsp";
    private final String historyURL = "History";
    private final String logoutURL = "Logout";
    
    //トップページのリンクを返却
    public String top() {
        return "<button type='button' onclick='location.href=\""+topURL+"\"'>Top</button>";
    }
    //利用履歴ページのリンクを返却
    public String history() {
        return "<button type='button' onclick='location.href=\""+historyURL+"\"'>History</button>";
    }
    //ログアウト
    public String logout() {
        return "<button type='button' onclick='location.href=\""+logoutURL+"\"'>Logout</button>";
    }
    
    /**
     * 年代は数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 年代
     */
    public String exAgenum(int i) {
        switch(i) {
            case 1: return "～19歳";
            case 2: return "20歳～29歳";
            case 3: return "30歳～39歳";
            case 4: return "40歳～49歳";
            case 5: return "50歳～59歳";
            case 6: return "60歳～";
        }
        return "";
    }
    
    /**
     * ヘアレングスは数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return ヘアスタイル
     */
    public String exLengthnum(int i) {
        switch(i) {
            case 1: return "ロング";
            case 2: return "セミロング";
            case 3: return "ミディアム";
            case 4: return "ショート";
        }
        return "";
    }
    
    /**
     * アイテムは数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 使用するアイテム
     */
    public String exItemnum(int i) {
        switch(i) {
            case 0: return "おまかせ";
            case 1: return "ダッフルコート";
            case 2: return "ムートンコート";
            case 3: return "ファーコート";
            case 4: return "ダウンジャケット/コート";
            case 5: return "ピーコート";
            case 6: return "ブルゾン・スカジャン";
            case 7: return "チェスターコート";
            case 8: return "トレンチコート";
            case 9: return "ライダースジャケット";
            case 10: return "モッズコート";
            case 11: return "テーラードジャケット";
            case 12: return "デニムジャケット";
            case 13: return "Tシャツ・カットソー";
            case 14: return "シャツ・ブラウス";
            case 15: return "ニット・セーター";
            case 16: return "ベスト";
            case 17: return "スウェット・ジャージ";
            case 18: return "カーディガン/パーカー";
            case 19: return "ノースリーブ・キャミソール";
            case 20: return "アンサンブル・セットアップ";
            case 21: return "ワンピース";
            case 22: return "ドレス";
            case 23: return "チュニック";
            case 24: return "シャツワンピース";
            case 25: return "オールインワン";
            case 26: return "サロペット";
            case 27: return "スカート";
            case 28: return "ロングスカート・ロングパンツ";
            case 29: return "デニムパンツ";
            case 30: return "カーゴパンツ";
            case 31: return "チノパンツ";
            case 32: return "スニーカー";
            case 33: return "サンダル";
            case 34: return "パンプス";
            case 35: return "ブーツ";
            case 36: return "ブーティ";
            case 37: return "モカシン・デッキシューズ";
            case 38: return "レインシューズ";
            case 39: return "ソックス";
            case 40: return "レギンス・スパッツ";
            case 41: return "タイツ・ストッキング";
            case 42: return "レッグウォーマー";
            case 43: return "クラッチバック";
            case 44: return "ハンドバック";
            case 45: return "トートバック";
            case 46: return "ショルダーバック";
            case 47: return "バックパック・リュック";
            case 48: return "かごバック";
            case 49: return "スーツケース・キャリーバック";
            case 50: return "ハット";
            case 51: return "キャスケット";
            case 52: return "ニットキャップ";
            case 53: return "ハンチング・ベレー帽";
        }
        return "";
    }
    
    /**
     * テイストは数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 
     */
    public String exTastenum(int i) {
        switch(i) {
            case 0: return "おまかせ";
            case 1: return "カジュアル";
            case 2: return "オフィス";
            case 3: return "フェミニン";
            case 4: return "モード";
        }
        return "";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、
     * チェックリストに従いどの項目が未入力なのかのhtml文を返却する
     * @param chkList
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList) {
        String output = "";
        for(String val : chkList) {
            if(val.equals("name")) {
                output += "NAME";
            }
            if(val.equals("pass")) {
                output += "PASS";
            }
            if(val.equals("age")) {
                output += "AGE";
            }
            if(val.equals("place")) {
                output += "PLACE";
            }
            if(val.equals("length")) {
                output += "HAIR LENGTH";
            }
            output += "が未記入です<br>";
        }
        return output;
    }
}
