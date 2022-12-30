<html>

    <script>

        function confirmDelete(id){
            if(confirm("Are you sure want to delete this data ?") == true){
                location.href = "hapus.php?id="+id+"";
            }
        }

        function searchPage(){
            location.href = "paginationFix.php?halaman=1&search="+document.form.searchVal.value+"";
        }

        function printDataUser(){
            location.href = "printDataUser.php";

        }

    </script>

    <link rel="stylesheet" href="dataDisplay.css">

    <body>
        <div class="content-wrapper">
            <div id="title-text">
                USER DATA
            </div>
        </div>

        <center>
        <div class="content-wrapper" style="width : 90%; display : inline-block;">
            <div class="float-left" id="outer-button"><a href="input.php"><input type="button" id="inner-button" value="ADD" style="color : #333c57;"></input></a></div>
            <div class="float-left" id="outer-button" style="margin : 5px 10px;"><a href="exportDb.php" target="_blank"><input type="button" id="inner-button" value="XLS" style="color : #333c57;"></input></a></div>
            <div class="float-left" id="outer-button"><input type="button" onclick="window.print();" id="inner-button" value="PRINT" style="color : #333c57;"></input></a></div>
            <form name="form" method="post">
                <div class="float-right" id="outer-button"><input type="button" onclick="searchPage()" name="submit" id="inner-button" value="SEARCH" style="color : #333c57;"></input></div>
                <input class="float-right" type="text" id="answer-bar" value="" name="searchVal" placeholder="username" value=""></input>
            </form>
        </div></center>

    
        <table cellpadding = "0"  cellspacing = "0">
            <tr>
                <td style="border-top-left-radius : 8px">No</td><td>Nama</td><td>Username</td><td>Password</td><td>Last Modified</td><td>Modify</td><td style="border-top-right-radius : 8px">Delete</td>
            </tr>
            <?php
                include "koneksi.php";
                $limit = 25;

                if(!isset($_GET['search']) || $_GET["search"] == ""){
                    $page = isset($_GET["halaman"]) ? (int)$_GET["halaman"] : 1;
                    $mulai = ($page>1) ? ($page * $limit) - $limit : 0;

                    $query = "SELECT * FROM pengguna";

                    $result = mysqli_query($koneksi,$query);
                    $total = mysqli_num_rows($result);
                    $pages = ceil($total/$limit);

                    $query = "SELECT *, DATE_FORMAT(lastmodified, '%a %d %b %Y - %H:%i:%s') AS tgl FROM pengguna ORDER BY lastmodified DESC LIMIT $mulai, $limit";
                    $result = mysqli_query($koneksi,$query);
                }
                else{
                    $page = isset($_GET["halaman"]) ? (int)$_GET["halaman"] : 1;
                    $mulai = ($page>1) ? ($page * $limit) - $limit : 0;
                    
                    $searchVal = $_GET["search"];
                    $query = "SELECT * FROM pengguna WHERE username LIKE '%$searchVal%' OR nama LIKE '%$searchVal%' OR katasandi LIKE '%$searchVal%'";

                    $result = mysqli_query($koneksi,$query);
                    $total = mysqli_num_rows($result);
                    $pages = ceil($total/$limit);

                    $display = "SELECT *, DATE_FORMAT(lastmodified, '%a %d %b %Y - %H:%i:%s') AS tgl FROM pengguna WHERE username LIKE '%$searchVal%' OR nama LIKE '%$searchVal%' OR katasandi LIKE '%$searchVal%' ORDER BY lastmodified DESC LIMIT $mulai, $limit";
                    $result = mysqli_query($koneksi,$display);
                }

                $i = 1;
                while($row=mysqli_fetch_array($result)){
                    echo '<tr><td>'.$i.'</td><td>'.$row["nama"].'</td><td>'.$row["username"].'</td><td>'.$row["katasandi"].'</td><td>'.$row["tgl"].'</td><td><a href="edit.php?id='.$row["id"].'">Edit</a></td><td><a href="javascript:void(0);" onclick="confirmDelete('.$row["id"].')"><div class="content-wrapper"><div id="trashcan-logo" style="display:inline-block"></div>Hapus</div></a></td></tr>';
                    $i += 1;
                }
            ?>
        </table>
        <div style="margin : 10px;"></div><center>
        <?php
            for ($i=1; $i<=$pages ; $i++){
        ?>
            <a href="paginationFix.php?halaman=<?php echo $i; ?>" style="text-decoration:none">
                <div id="outer-button" style="display:inline-block;">
                    <div id="inner-button">
                        <?php echo $i; ?>
                    </div>
                </div>
            </a>
        <?php
            }
        ?>
        </center>
    </body>
</html>