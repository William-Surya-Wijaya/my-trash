<?php

include 'koneksi.php';

if(isset($_GET['kodeTr'])){
    $kodeTr = $_GET['kodeTr'];

    $query = "UPDATE transparent SET deleted = 1 WHERE kodeTransaksi ='".$kodeTr."'";
    $result = mysqli_query($koneksi, $query);
}

header("Location: transactionListData.php");

?>