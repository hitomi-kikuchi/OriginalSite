/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author 1999itukinao
 */
public class Proposal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //セッションスタート
        HttpSession hs = request.getSession();
        
        try {
            //リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            
            //ユーザー情報を取得
            UserDataBeans udb = (UserDataBeans)hs.getAttribute("userdata");
            
            //フォームからの入力を取得して、ProposalDataBeansに格納
            ProposalDataBeans pdb = (ProposalDataBeans)hs.getAttribute("season");
            pdb.setTaste(request.getParameter("taste"));
            
            //ランダムの条件分岐がある為、フォームからの値と季節を格納
            pdb.setItem(request.getParameter("item"), pdb.getSeason());
             
            //PLACEが未入力の場合、登録地を格納するための処理
            String location = "";
            if(request.getParameter("place").equals("")) {
                location = udb.getPlace();
            }else {
                location = request.getParameter("place");
            }

            //OpenWeatherMap APIを用いて活動場所の天候情報を取得
            String result = JsonHelper.getResult(location);
                        
            //文字列からJSONへの変換
            JsonNode node = JsonHelper.getJsonNode(result);
                        
            //天候情報をWeatherDataBeansへ格納
            HistoryDataBeans weather = JsonHelper.getWeather(node);
            weather.setLocation(location);
                        
            //天候情報をProposalDataBeansへ渡す
            pdb.setTempNum(weather.getTemp());
            pdb.setHumidityNum(weather.getHumidity());
                        
            //各DTOオブジェクトにマッピング。DB専用パラメータに変換
            UserDataDTO udd = new UserDataDTO();
            udb.UDBDTOMapping(udd);
            ProposalDataDTO pdd = new ProposalDataDTO();
            pdb.PDBDTOMapping(pdd);
            HistoryDataDTO hdd = new HistoryDataDTO();
            weather.HDBHDDMapping(hdd);
            
            //DBへデーターの挿入
            ArrayList<ProposalDataDTO> wearList = DataDAO.getInstance().WearSearch(udd, pdd);
            ArrayList<ProposalDataDTO> hairList = DataDAO.getInstance().HairSearch(udd);
            
            //Beansオブジェクトにマッピング。
            ArrayList<ProposalDataBeans> pdbList = pdb.DTOPDBMapping(wearList);
            ProposalDataBeans hairdata = pdb.hairMapping(hairList);
            
            //履歴をDBに挿入
            DataDAO.getInstance().HistoryInsert(udd, pdd, hdd);
                        
            //セッションにセット
            hs.setAttribute("weardata", pdbList);
            hs.setAttribute("hairdata", hairdata);
            hs.setAttribute("weatherdata", weather);
            System.out.println("Session Update!!");
                        
        request.getRequestDispatcher("/proposal.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
