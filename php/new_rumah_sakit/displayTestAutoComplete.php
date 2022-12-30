<?php
    include "koneksi.php";

    $query = "SELECT * FROM pengguna";
    $result = mysqli_query($koneksi,$query);

    $optVal = array();
    while($row = mysqli_fetch_array($result)){
        array_push($optVal, substr($row['nama'], 0, strlen($row['nama'])));
    }

    $queryDetail = "SELECT * FROM medicine_data";
    $resultDetail = mysqli_query($koneksi,$queryDetail);

    $detVal = array();
    $medVal = array();
    while($row = mysqli_fetch_array($resultDetail)){
        $addArr = $row['kodeobat'].'|'.$row['namaobat'].'|'. $row['stock'].'|'.$row['harga'];
        array_push($detVal, $addArr);
        array_push($medVal, substr($row['namaobat'], 0, strlen($row['namaobat'])));
    }
?>