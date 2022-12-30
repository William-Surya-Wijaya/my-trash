<?php

    if(isset($_POST['submit'])){
        session_start();

        include 'koneksi.php';

        $username = $_POST['username'];
        $password = $_POST['katasandi'];

        $data = mysqli_query($koneksi, "select * from pengguna where username='$username' and katasandi='$password'");

        if(mysqli_num_rows($data)>0){
            $_SESSION['username'] = $username;
            header("Location: login_page.php?pesan=berhasil");
        }
        else {
            
            header("Location: login_page.php?pesan=gagal");
            session_destroy();
        }
    }
?>