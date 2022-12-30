<?php

    if(($_POST["kodeObat"] == "" )||($_POST["merkObat"] == "" )||($_POST["namaObat"] == "")||($_POST["typeObat"] == "")||($_POST["stockObat"] == "")||($_POST["expObat"] == "")){
        echo '<script>alert("please fill in all the fields of the form.")</script>';
    }

    else {

        include 'koneksi.php';

        $namaObat = $_POST['namaObat'];
        $query = "SELECT * FROM medicine_data WHERE namaobat='$namaObat'";

        $data = mysqli_query($koneksi, $query);

        $query = "UPDATE medicine_data SET kodeobat='".$_POST['kodeObat']."',namaobat='".$_POST['namaObat']."',merkobat='".$_POST['merkObat']."',typeobat='".$_POST['typeObat']."',tglexpire='".$_POST['tglexpire']."',stock='".$_POST['stock']."' WHERE id=".$_POST['id'];
                    $result = mysqli_query($koneksi,$query);

        if($result){
            header("Location: http://localhost/new_rumah_sakit/medicineFix.php");
        }
    }

?>