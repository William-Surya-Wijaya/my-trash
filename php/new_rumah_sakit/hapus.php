<?php
    $id=$_GET['id'];
    include 'koneksi.php';

    $query = 'DELETE FROM pengguna WHERE id ='.$id.'';
    $result = mysqli_query($koneksi,$query);
    if($result){
        header("location: paginationFix.php");
    }
?>