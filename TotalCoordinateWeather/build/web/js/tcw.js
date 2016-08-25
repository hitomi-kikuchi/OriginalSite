/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    
    /*---- ページトップへ移動する ----*/
    /*-- history --*/
    $(".page-top").click(function(){
        $("html, body").animate({ 
            "scrollTop": 0 
        }, "slow");
    });
    
});