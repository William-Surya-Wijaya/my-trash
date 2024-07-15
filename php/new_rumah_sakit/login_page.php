<?php
    if(isset($_GET['pesan'])){
        if($_GET['pesan']=="berhasil"){
            header("Location: web_page.php");
        }
        else if($_GET['pesan']=="gagal"){
            echo "<script>alert('Login gagal, silahkan periksa Username dan Password anda.')</script>";
            header("Location : web_page.php?pesan=belum_login");
        }
    }
?>

<html>

    <link rel="Stylesheet" href="font-fam.css">

    <style>

    @font-face{
        font-family : "uha";
        src : url("UH.ttf") format("ttf");
        src : url("UH.woff") format("woff");
    }

    body {
        background-color : white;
    }

    table tr td{
        padding : 5px
    }

    table{
        padding : 5px 38px 5px 0px;
    }

    a{
        float : right; color : black;
        text-decoration : none; font-family : "Ciutadella R";
    }

    a:hover {
        color : blue;
    }

    .web-page{
        width : 100%;
    }

    .outer-card {
        background-color : transparent;
        height : content; width : 50%;
        border : 2px solid #333c57; border-radius : 10px;
        position : absolute; top : 45%; left : 50%; transform : translate(-50%,-50%);
    }

    .inner-card {
        background-color : transparent;
        height : content; width : 50%;
        border : 0px; border-radius : 10px;
    }

    .card-content {
        padding : 20px;
    }

    #card-title {
        text-align : center; letter-spacing : 1px;
    }

    #hospital-logo {
        content : url("hospital-logo.png");
        width : 88px; height : 88px; margin : auto;
    }

    #password-ic{
        content : url("password-ic.png");
        width : 20px; height : 20px;
    }

    #user-pp-def{
        content : url("user-pp-def.png");
        width : 20px; height : 20px;
    }

    #id-ic{
        content : url("id-ic.png");
        width : 20px; height : 20px;
    }

    #ha-er{
        background-color : #3baaa1;
        height : 3px; width : content; border-radius : 5px;
        margin : 15px 15px;
    }

    #form-name{
        font-family : "Ciutadella R SB";
    }

    #form-answer-bar{
        font-family : "superstar"; font-size : 20px;
        background-color : white; color :#3baaa1;
        border : 1px solid #3baaa1; border-radius : 10px;
        text-align : center;
        width : 445px;
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

    #true-button {
        background-color : #333c57; color : white;
        border : 0px; border-radius : 10px;
        font-family : "superstar"; font-size : 20px;
        padding : 3px 50px; margin : 5px auto;
        transition : 0.25s;
    }

    #true-button:hover {
        background-color : #45cabf; cursor : pointer;
    }

    </style>

    <body>
        <div class="web-page">
            <div class="outer-card">
                <div class="card-content">
                    <div id="hospital-logo"></div>
                    <div id="card-title" style="font-family : uha; font-size : 36px; color : #3baaa1;">RUMAH SAKIT</div>
                    <div id="card-title"style="font-family : uha; font-size : 27.5px">DUDUNG PRATAMA</div>
                    <div id="ha-er"></div>
                    <div id="card-title" style="font-family : uha; font-size : 20px; color : #3baaa1;">input user data</div>
                    <div id="ha-er" style="height : 1px; margin : 5px 150px;"></div>
                    <div id="ha-er"></div>
                    <center><table><form action="login_check.php" method="post">
                        <tr>
                            <td><div id="user-pp-def"></div></td><td><input tpye="text" name="username" placeholder="Username" id="form-answer-bar" maxlength="16" style="display : inline-table"></td>
                        </tr>
                        <tr>
                            <td><div id="password-ic"></div></td><td><input type="password" name="katasandi" placeholder="Password" id="form-answer-bar" maxlength="16" style="display : inline-table"></td>
                        </tr>
                    </table>
                        <input type="submit" name="submit" id="true-button" value="LOGIN">
                    </form></center>
                    <a href="register_page.html" id="card-title" style="display : inline-table">Don't have account yet ?</a>
                </div>
            </div>
        </div>
    </body>
</html>