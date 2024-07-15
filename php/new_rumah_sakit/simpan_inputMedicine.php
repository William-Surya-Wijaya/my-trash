<?php

    if(($_POST["kodeObat"] == "" )||($_POST["merkObat"] == "" )||($_POST["namaObat"] == "")||($_POST["typeObat"] == "")||($_POST["stockObat"] == "")||($_POST["expObat"] == "")||($_POST["hargaObat"] == "")){
        echo '<script>alert("please fill in all the fields of the form.")</script>';
    }

    else {

        include 'koneksi.php';

        $namaObat = $_POST['namaObat'];
        $query = "SELECT * FROM medicine_data WHERE namaobat='$namaObat'";

        $data = mysqli_query($koneksi, $query);

        if(mysqli_num_rows($data)>0){
            echo "<script>alert('Data obat tersebut telah tercantum, silahkan edit data yang ada.')</script>";
        }
        else{
            $query = "INSERT INTO medicine_data (kodeobat, namaobat, merkobat, typeobat, tglexpire, stock, harga) VALUES ('".$_POST['kodeObat']."','".$_POST['namaObat']."','".$_POST['merkObat']."','".$_POST['typeObat']."','".$_POST['expObat']."','".$_POST['stockObat']."','".$_POST['hargaObat']."')";
            // eksekusi query mysqli
            $result = mysqli_query($koneksi,$query);

            if($result){
                header("Location: http://localhost/new_rumah_sakit/medicineFix.php");
            }
        }
    }

?>