<?php
    $id=$_GET['id'];
    include 'koneksi.php';

    $query = 'DELETE FROM medicine_data WHERE id ='.$id.'';
    $result = mysqli_query($koneksi,$query);
    if($result){
        header("location: medicineFix.php");
    }
?>