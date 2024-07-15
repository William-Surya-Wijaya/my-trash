<!DOCTYPE html>

<?php

    session_start();

?>

<script>

    function logOut(){
        if(confirm("Logout ?") == true){
            window.open("logOut.php", "_parent");
        }
    }

</script>
    


<link rel="stylesheet" href="font-fam.css">

<style>
    @font-face{
        font-family : "UH";
        src : url("UH.ttf") format("ttf");
        src : url("UH.woff") format("woff");
    }

    body{
        background-color : #ebf5f4;
    }

    .web-heading{
        height : content; width : 95%;
    }

    .web-heading > *{
        display: "inline-block";
    }

    .content-wrapper{
        height : content; width : content;
    }

    .float-left{
        float : left;
    }

    .float-right{
        float : right;
    }

    .float-middle{
        position : absolute; top : 50%; left : 50%; transform : translate(-50%,-50%);
    }

    .vertical-center{
        position : absolute; top : 50%; transform : translateY(-50%);
    }

    #hospital-logo{
        content: url("hospital-logo.png");
        width : 88px; height : 88px; margin : auto 20px;
    }

    #web-title{
        letter-spacing: 1px;
    }

    #session{
        color : #3baaa1; font-family : "superstar"; font-size : 30px;
        margin : 0px 20px; padding  : 5px;
    }

    #outer-button{
        background-color : #333c57; border : 2px solid #333c57; border-radius : 10px;
        height : 32.7px; width : fit-content; min-width : 30px;
        margin : 5px auto;
    }

    #inner-button{
        background-color : #ebf5f4; color : #333c57;
        font-family : "superstar"; font-size : 20px;
        border : 0px; border-radius : 7px; box-shadow : 0px 6px 0px #c8e8e6;
        padding : 0px 6px; width : content; height : max-content;
        transition : 0.5s;
    }

    #inner-button:hover{
        background-color : #c8e8e6; box-shadow : 0px 6px 0px #3baaa1;
        cursor : pointer;
    }

</style>

<html>
    <body>
        <div class="web-heading">
            <div class="content-wrapper float-middle"></div>
            <div class="float-left" id="hospital-logo"></div>
            <div class="content-wrapper float-left">
                <div class="content-wrapper vertical-center">
                    <div id="web-title" style="font-family : UH; font-size : 36px; color : #3baaa1;">RUMAH SAKIT</div>
                    <div id="web-title" style="font-family : UH; font-size : 27.5px; color : #333c57; ">DUDUNG PRATAMA</div>
                </div>
            </div>
            <div class="content-wrapper float-right">
                <div class="content-wrapper float-right" style="padding : 15px 0px">
                    <div id="outer-button">
                        <input onclick="logOut()" type="button" id="inner-button" value="LOG OUT">
                    </div>
                </div>
                <div class="content-wrapper float-right" style="padding : 15px 0px;">
                    <div id="session"><span style="color : #333c57;">WELCOME, </span><?php echo $_SESSION['username']; ?></div>
                </div>
            </div>
        </div>
    </body>
</html>