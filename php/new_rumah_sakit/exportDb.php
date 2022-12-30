<?php

    include "koneksi.php";

    $exportQuery = "SELECT *, DATE_FORMAT(lastmodified, '%a %b %Y - %H:%i:%s') AS tgl FROM pengguna ORDER BY lastmodified DESC";

    $result = mysqli_query($koneksi, $exportQuery);

    header("Content-type: application/vnd-ms-excel");
    header("Content-Disposition: attachment; filename=Data Pegawai.xls");

    echo '<table border="1"><tr><td style="background-color : #3baaa1">No</td><td style="background-color : #3baaa1">Nama</td><td style="background-color : #3baaa1">Username</td><td style="background-color : #3baaa1">Password</td><td style="background-color : #3baaa1">Last Modified</td></tr>';

    while($mas=mysqli_fetch_array($result)){
        $i = 1;
        while($row = mysqli_fetch_array($result)){
            echo '<tr><td>'.$i.'</td><td>'.$row["nama"].'</td><td>'.$row["username"].'</td><td>'.$row["katasandi"].'</td><td>'.$row["tgl"].'</td></tr>';
            $i += 1;
        }
    }

    echo '</table>';

    exit;

?>