<!DOCTYPE html>
<htmL>

<?php
    include 'koneksi.php';

    $limit = 10;
    $counter = 0;

?>

<script>

    function confirmDelete(id){
        if(confirm("Are you sure want to delete this data ?") == true){
            location.href = "hapus.php?id="+id+"";
        }
    }

    function makeTable1(counter){
        <?php
            echo '<script>document.write("$counter = "+counter);</script>';
            echo '<script>document.write("$limit = "+10);</script>';
            $query = "SELECT *, DATE_FORMAT(lastmodified, '%a %b %Y - %H:%i:%s') AS tgl FROM pengguna ORDER BY lastmodified DESC LIMIT ".$counter*$limit.",".$limit."";

            $result = mysqli_query($koneksi,$query);

            $returnValue = "";

            $i = 1;
            while($row = mysqli_fetch_array($result)){
                $returnValue .= '<tr><td>'.$i.'</td><td>'.$row["nama"].'</td><td>'.$row["username"].'</td><td>'.$row["katasandi"].'</td><td>'.$row["tgl"].'</td><td><a href="javascript:void(0);" onclick="confirmDelete('.$row["id"].')">Hapus</a></td><td><a href="edit.php?id='.$row["id"].'">Edit</a></td></tr>';
                $i += 1;
            }
            return $returnValue;
        ?>
    }

</script>

<style>

    @font-face {
        font-family : "Feather B";
        src : url('feather_bold.ttf') format('ttf');
        src : url('feather_bold.woff') format('woff');
    }

    @font-face {
        font-family : "Ciutadella R SB";
        src : url('Ciutadella\ Rounded\ Semi\ Bold.ttf') format('tff');
        src : url('Ciutadella_Rounded_Semi_Bold.woff') format('woff');
    }

    @font-face {
        font-family : "Ciutadella R";
        src : url('Ciutadella\ Rounded.ttf') format('tff');
        src : url('Ciutadella_Rounded.woff') format('woff');
    }

    .web-heading {
        width : 90%; margin : 0px auto;
    }
    .web-heading > * {
        display : inline-block;
    }

    .float-left {
        float : left;
    }

    .float-right {
        float : right;
    }

    #answer-bar {
        border : 1px solid lightslategrey ; border-radius : 15px ; margin : auto;
        width : 200px ; height : content; font-size : 15px; font-family : "Ciutadella R";
    }

    #heading-button {
        padding : 10px 0px; margin : 0px 10px;
        font-family : "Feather B"; font-size : 20px;
        background-color : transparent; color : #afafaf; border : 0px;
        transition : 0.25s;
    }

    #heading-button:hover{
        color : lightslategrey;
        cursor : pointer;
    }

    body::-webkit-scrollbar {
        display : none;
    }

    table{
        margin : 0px 30px;
        font-family : "Ciutadella R"; color : #4b4b4b;
        border : 1px solid #afafaf ;
        border-radius : 15px ;
        box-shadow : 0px 4px 0px #afafaf; 
        table-layout : fixed ;
        overflow : auto ;
        width : 90%;
    }

    a {
        text-decoration : none; color : #3baaa1;
    }

    a:hover {
        color : blue;
    }

    tr, td {
        padding : 5px 10px;
    }

    table tr td:first-child{
        width : 1%;
    }

    table tr td:last-child{
        width : 4%;
    }

    table tr td:nth-last-child(2){
        width : 4%;
    }

    table tr td {
        width : content;
    }

    table tr:first-child td{
        background-color : #3baaa1 ;
        border-right : 0px ;
        color : white ;
        position : sticky ;
    }

    table tr:last-child td{
        border-bottom : 0px ;
    }

    table td {
        border-right : 1px solid #afafaf;
        border-bottom : 1px solid #afafaf;
    }

    table td:last-child{
        border-right : 0px;
    }

    p {
        font-family : 'Ciutadella R SB'; color : #3baaa1;
        line-height : 0px ; margin  : 15px auto; padding : 15px 0px 0px 0px; font-size : 30px;
    }

</style>

<center>
<p>User Data<p>
</center>

<div class="web-heading">
    <a href="input.php"><input type="button" class="float-left" id="heading-button" value="ADD"></input></a>
    <div class="float-right">
        <form name="form" method="post">
            <input type="text" id="answer-bar" value="" name="searchVal" placeholder="username"></input>
            <a href="input.php" target="webContent"><input type="submit" name="submit" id="heading-button" value="SEARCH"></input></a>
        </form>
    </div>
</div>


<center>
<table cellspacing = 0 cellpadding = 0>
    <tr><td style="border-top-left-radius:15px">NO</td><td>Nama</td><td>Username</td><td>Kata Sandi</td><td >Last Modified</td><td>Delete</td><td style="border-top-right-radius:15px">Modify</td></tr>
    <?php
        $query = "SELECT * FROM pengguna";
        $result = mysqli_query($koneksi,$query);

        $button = ceil(mysqli_num_rows($result)/$limit);

        if(!isset($_POST['submit'])){

            echo $returnValue;

            echo '<table style="border : 0px; box-shadow : none; width: 10%; margin : 10px 0px;"><tr style="width: content;">';

            for($z = 0; $z<$button; $z++){
                echo '<td style="border : 0px; background-color : transparent; width: 3%;"><a href="javascript:void(0);" onclick="makeTable1('.$z*$limit.')">'.($z+1).'</a></td>';
            }

            echo '</tr></table>';
        }

        else {
            if($_POST["searchVal"] == ""){
                $query = "SELECT *, DATE_FORMAT(lastmodified, '%a %b %Y - %H:%i:%s') AS tgl FROM pengguna ORDER BY lastmodified DESC";

                $result = mysqli_query($koneksi,$query);

                $i = 1;
                while($row = mysqli_fetch_array($result)){
                    echo '<tr><td>'.$i.'</td><td>'.$row["nama"].'</td><td>'.$row["username"].'</td><td>'.$row["katasandi"].'</td><td>'.$row["tgl"].'</td><td><a href="javascript:void(0);" onclick="confirmDelete('.$row["id"].')">Hapus</a></td><td><a href="edit.php?id='.$row["id"].'">Edit</a></td></tr>';
                    $i += 1;
                }
            }
            
            else {
                $searchVal = $_POST["searchVal"];
                $query = "SELECT *, DATE_FORMAT(lastmodified, '%a %b %Y - %H:%i:%s') AS tgl FROM pengguna WHERE username='$searchVal' ORDER BY lastmodified DESC";
    
                $result = mysqli_query($koneksi,$query);
    
                $i = 1;
                while($row = mysqli_fetch_array($result)){
                    echo '<tr><td>'.$i.'</td><td>'.$row["nama"].'</td><td>'.$row["username"].'</td><td>'.$row["katasandi"].'</td><td>'.$row["tgl"].'</td><td><a href="javascript:void(0);" onclick="confirmDelete('.$row["id"].')">Hapus</a></td><td><a href="edit.php?id='.$row["id"].'">Edit</a></td></tr>';
                    $i += 1;
                }
            }
        }
    ?>
</table>
</center>
</html>