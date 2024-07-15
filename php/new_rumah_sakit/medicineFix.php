<html>

    <script

    <script>

        function confirmDelete(id){
            if(confirm("Are you sure want to delete this data ?") == true){
                location.href = "hapusMedicine.php?id="+id+"";
            }
        }

        function searchPage(){
            location.href = "medicineFix.php?halaman=1&search="+document.form.searchVal.value+"";
        }

    </script>

    <link rel="stylesheet" href="dataDisplay.css">

    <body>
        <div class="content-wrapper">
            <div id="title-text">
                MEDICINE DATA
            </div>
        </div>

        <center>
        <div class="content-wrapper" style="width : 90%; display : inline-block;">
            <div class="float-left" id="outer-button"><a href="inputMedicine.php"><input type="button" id="inner-button" value="ADD" style="color : #333c57;"></input></a></div>
            <div class="float-left" id="outer-button" style="margin : 5px 10px;"><a href="exportDbMedicine.php" target="_blank"><input type="button" id="inner-button" value="XLS" style="color : #333c57;"></input></a></div>
            <div class="float-left" id="outer-button"><input type="button" onclick="window.print()" id="inner-button" value="PRINT" style="color : #333c57;"></input></a></div>
            <form name="form" method="post">
                <div class="float-right" id="outer-button"><input type="button" onclick="searchPage()" name="submit" id="inner-button" value="SEARCH" style="color : #333c57;"></input></div>
                <input class="float-right" type="text" id="answer-bar" value="" name="searchVal" placeholder="username" value=""></input>
            </form>
        </div></center>

    
        <table cellpadding = "0"  cellspacing = "0">
            <tr>
                <td style="border-top-left-radius : 8px">No</td><td>Kode</td><td>Nama</td><td>Merk</td><td>Type</td><td>Harga</td><td>Expire</td><td>Modify</td><td style="border-top-right-radius : 8px">Delete</td>
            </tr>
            <?php
                include "koneksi.php";
                $limit = 25;

                if(!isset($_GET['search']) || $_GET["search"] == ""){
                    $page = isset($_GET["halaman"]) ? (int)$_GET["halaman"] : 1;
                    $mulai = ($page>1) ? ($page * $limit) - $limit : 0;

                    $query = "SELECT * FROM medicine_data";

                    $result = mysqli_query($koneksi,$query);
                    $total = mysqli_num_rows($result);
                    $pages = ceil($total/$limit);

                    $query = "SELECT *, DATE_FORMAT(tglexpire, '%a %d %b %Y') AS tglexpire FROM medicine_data ORDER BY tglexpire ASC LIMIT $mulai, $limit";
                    $result = mysqli_query($koneksi,$query);
                }
                else{
                    $page = isset($_GET["halaman"]) ? (int)$_GET["halaman"] : 1;
                    $mulai = ($page>1) ? ($page * $limit) - $limit : 0;
                    
                    $searchVal = $_GET["search"];
                    $query = "SELECT * FROM medicine_data WHERE kodeobat LIKE '%$searchVal%' OR namaobat LIKE '%$searchVal%' OR merkobat LIKE '%$searchVal%'OR typeobat LIKE '%$searchVal%'OR tglexpire LIKE '%$searchVal%'OR harga LIKE '%$searchVal%'";

                    $result = mysqli_query($koneksi,$query);
                    $total = mysqli_num_rows($result);
                    $pages = ceil($total/$limit);

                    $display = "SELECT *, DATE_FORMAT(tglexpire, '%a %d%b %Y') AS tglexpire FROM medicine_data WHERE kodeobat LIKE '%$searchVal%' OR namaobat LIKE '%$searchVal%' OR merkobat LIKE '%$searchVal%'OR typeobat LIKE '%$searchVal%'OR tglexpire LIKE '%$searchVal%' OR harga LIKE '%$searchVal%' ORDER BY tglexpire ASC LIMIT $mulai, $limit";
                    $result = mysqli_query($koneksi,$display);
                }

                $no = $mulai+1;

                $i = 1;
                while($row=mysqli_fetch_array($result)){
                    echo '<tr><td>'.$i.'</td><td>'.$row["kodeobat"].'</td><td>'.$row["namaobat"].'</td><td>'.$row["merkobat"].'</td><td>'.$row["typeobat"].'</td><td>'."Rp ".$row["harga"].'</td><td>'.$row["tglexpire"].'</td><td><a href="editMedicine.php?id='.$row["id"].'">Edit</a></td><td><a href="javascript:void(0);" onclick="confirmDelete('.$row["id"].')"><div class="content-wrapper"><div id="trashcan-logo" style="display:inline-block"></div>Hapus</div></a></td></tr>';
                    $i += 1;
                }
            ?>
        </table>
        <br /><center>
        <?php
            for ($i=1; $i<=$pages ; $i++){
        ?>
            <a href="medicineFix.php?halaman=<?php echo $i; ?>" style="text-decoration:none">
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