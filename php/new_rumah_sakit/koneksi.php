<?php
    $koneksi = mysqli_connect('localhost','root','','rumah_sakit');

    if(mysqli_connect_errno()){
        echo "Koneksi database gagal : ". mysqli_connect_errno();
    }
?>