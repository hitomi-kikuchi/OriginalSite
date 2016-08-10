package Controller;

import Model.DataDAO;
import Model.UserDataBeans;
import Model.UserDataDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1999itukinao
 */
public class MydataUpdateResult extends HttpServlet {

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
        //セッションスタート
        HttpSession hs = request.getSession();
        
        try {
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)hs.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            UserDataBeans id = (UserDataBeans)hs.getAttribute("userdata");
            
            //フォームからの変更を取得して、JavaBeansに格納
            UserDataBeans udb = new UserDataBeans();
            udb.setUserID(String.valueOf(id.getUserID()));
            udb.setName(request.getParameter("name"));
            udb.setPassword(request.getParameter("pass"));
            udb.setAge(request.getParameter("age"));
            udb.setPlace(request.getParameter("place"));
            udb.setLength(request.getParameter("length"));
                        
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO updateData = new UserDataDTO();
            udb.UDBDTOMapping(updateData);
            
            //DBへデータの挿入
            DataDAO.getInstance().UserUpdate(updateData);
            
            //セッションに更新データをセット
            hs.setAttribute("userdata", udb);
                        
         request.getRequestDispatcher("/mydataupdateresult.jsp").forward(request, response);
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
