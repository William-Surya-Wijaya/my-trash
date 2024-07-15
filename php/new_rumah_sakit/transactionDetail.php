<?php
    include 'koneksi.php';

    if(isset($_POST['sendVal'])){
        $retPar = $_POST['sendVal'];
        $queryDetail = "SELECT * FROM transchild LEFT JOIN medicine_data ON transchild.idObat = medicine_data.id WHERE kodeTransaksi ='".$retPar."'";

        $result = mysqli_query($koneksi, $queryDetail);

        $retVal = array();

        while($row = mysqli_fetch_array($result)){
            array_push($retVal, $row);
        }

        echo JSON_encode($retVal);
    }
?>