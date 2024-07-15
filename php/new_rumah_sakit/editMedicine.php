<?php

    $id=$_GET['id'];

    include 'koneksi.php';

    $query = "SELECT * FROM medicine_data WHERE id='$id'";
    $result = mysqli_query($koneksi,$query);
    $row = mysqli_fetch_array($result);

?>

<script>
    function confirmedit(){
        if(confirm("Are you sure to save this changes ?")){
            document.getElementById("test").submit();
        }
    }
</script>

<html>
    <style>

    @font-face{
        font-family : "superstar";
        src : url("superstar.ttf") format("ttf");
        src : url("superstar.woff") format("woff");
    }

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

    .card {
        background-color : transparent;
        height : content;
        border : 2px solid #333c57; border-radius : 8px;
        position : absolute; top : 45%; left : 50%; transform : translate(-50%,-50%);
        box-shadow : 0px 4px 0px #333c57;
    }

    .nav-holder {
        height : content; width : 100%;
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
        font-family : "uha";
    }

    .form-answer-bar{
        font-family : "superstar"; font-size : 20px;
        background-color : white; color :#3baaa1;
        border : 1px solid #3baaa1; border-radius : 10px;
        text-align : center;
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
            <div class="card">
                <div class="card-content">
                    <div id="hospital-logo"></div>
                    <div id="card-title" style="font-family : uha; font-size : 36px; color : #3baaa1;">RUMAH SAKIT</div>
                    <div id="card-title"style="font-family : uha; font-size : 27.5px">DUDUNG PRATAMA</div>
                    <div id="ha-er"></div>
                    <div id="card-title" style="font-family : uha; font-size : 20px; color : #3baaa1;">edit medicine data</div>
                    <div id="ha-er" style="height : 1px; margin : 5px 150px; "></div>
                    <div id="ha-er"></div>
                    <center><table><form id="test" action="simpan_editMedicine.php" method="post">
                        <tr>
                            <td><input type="hidden" name="id" id="id" value="<?php echo $id?>" style="display : inline-table; width : 445px;"></td>
                        </tr>
                        <tr>
                            <td><div id="id-ic"></div></td><td><input tpye="text" name="kodeObat" class="form-answer-bar" id="kodeObat" maxlength="16" style="display : inline-table; width : 200px;" value="<?php echo $row['kodeobat'] ?>"></td>
                            <td><div id="id-ic"></div></td><td><input tpye="text" name="merkObat" class="form-answer-bar" id="merkObat" maxlength="16" style="display : inline-table; width : 200px;" value="<?php echo $row['merkobat'] ?>"></td>
                        </tr>
                        <tr>
                            <td><div id="user-pp-def"></div></td><td colspan="3"><input tpye="text" name="namaObat" id="namaObat" class="form-answer-bar" maxlength="16" style="display : inline-table; width : 445px;" value="<?php echo $row['namaobat'] ?>"></td>
                        </tr>
                        <tr>
                            <td><div id="password-ic"></div></td><td colspan="3"><select required id="typeObat" name="typeObat" class="form-answer-bar" style="display : inline-table; width : 445px;"><option value="Obat Cair">Obat Cair</option></a><option value="Tablet">Tablet</option><option value="Kapsul">Kapsul</option><option value="Obat Oles">Obat Oles</option><option value="Suppostoria">Suppostoria</option><option value="Obat Tetes">Obat Tetes</option><option value="Inhaler">Inhaler</option><option value="Obat Suntik">Obat Suntik</option><option value="Implan">Implan</option><option value="<?php echo $row['typeobat'] ?>"selected hidden><?php echo $row['typeobat'] ?></option></select></td>
                        </tr>
                        <tr>
                            <td><div id="password-ic"></td><td colspan="3"><input type="number" name="stockObat" id="stockObat" class="form-answer-bar" style="display: inline-tabled; width : 445px;" value="<?php echo $row['stock'] ?>"></td>
                        </tr>
                        <tr>
                            <td><div id="password-ic"></div></td><td colspan="3"><input type="date" name="expObat" id="expObat" class="form-answer-bar" style="display : inline-table;  width : 445px;" value="<?php echo $row['tglexpire'] ?>"></td>
                        </tr>
                    </table>
                    <div id="ha-er"></div>
                    <input type="button" onclick="confirmedit()" name="btnsubmit" id="true-button" value="MODIFY">
                    </form></center>
                    <a href="medicineFix.php" id="card-title" style="font-family : superstar">Cancel Editing.</a>
                </div>
            </div>
        </div>
    </body>
</html>