/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
    $(document).on("click", ".play-btn", function(){
        if($("img", this).attr("src") == "resources/image/icomoon/entypo-25px-ffffff/PNG/play.png"){
                $(".playBtnImage").attr("src", "resources/image/icomoon/entypo-25px-ffffff/PNG/play.png");
                $("img", this).attr("src", "resources/image/icomoon/entypo-25px-ffffff/PNG/pause.png");
            } else{
                $(".playBtnImage").attr("src", "resources/image/icomoon/entypo-25px-ffffff/PNG/play.png");
                $("#audio-player").pause();
        }
        $(".audio-player").animate({bottom: '0px'});
    });
});

   