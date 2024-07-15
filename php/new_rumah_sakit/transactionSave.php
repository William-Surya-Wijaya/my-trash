<?php

    include 'koneksi.php';

    if(!isset($_POST['custName'])){
        echo '<script>alert("Please fill the Customer Name.");</script>';
        ?> <script>history.back();</script> <?php
    }
    else if(!isset($_POST['medicineName1'])){
        echo '<script>alert("Please fill atleast one item.");</script>';
        ?> <script>history.back();</script> <?php
    }
    else{
        // echo "<script>alert('".$_POST['customerName'].",".$_POST['transCode'].",".$_POST['transTime']."')</script>";
        // echo "<script>alert('".$_POST['totalRow']."')</script>";

        $time = str_replace("/","-",$_POST['transTime']);
        $queryParent = "INSERT INTO transparent (namaCustomer, kodeTransaksi, tglTransaksi, totalHargaTransaksi, totalItemTransaksi) VALUES ('".$_POST['custName']."','".$_POST['transCode']."','".$time."','".$_POST['transTotal']."','".$_POST['transItemTotal']."')";

        $result = mysqli_query($koneksi, $queryParent);

        for($i=1; $i<=$_POST['totalRow']; $i++){

            if((isset($_POST['medicineName'.$i]))and((int)($_POST['medicineQty'.$i])>0)){

                $query = "SELECT * FROM medicine_data WHERE namaobat='".$_POST['medicineName'.$i]."'";
                $result = mysqli_query($koneksi, $query);
                $mCode = mysqli_fetch_array($result);

                $queryChild = "INSERT INTO transchild (kodeTransaksi, namaObat, jumlahObat, idObat) VALUES ('".$_POST['transCode']."','".$_POST['medicineName'.$i]."','".$_POST['medicineQty'.$i]."','".$mCode[0]."')";

                $result = mysqli_query($koneksi, $queryChild);
            }
        }
        ?><script>location.href="http://localhost/new_rumah_sakit/transactionInterface.php"</script><?php
    }
?>