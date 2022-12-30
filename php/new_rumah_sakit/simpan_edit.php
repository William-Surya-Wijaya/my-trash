<?php
    // if isset post then insert with mysqli
        //if(isset($_POST['submit'])){
            
            if(($_POST["nama"] == "" )||($_POST["username"] == "" ) ||($_POST["katasandi"] == "" )){
                echo '<script>alert("please fill in all the fields of the form.")</script>';
            }
            else {
                // server bisa localhost atai 
                // nama server host localhost /
                include 'koneksi.php';

                $user=$_POST['username'];
                // syntax query untuk mysql
                $data = mysqli_query($koneksi, "select * from pengguna where username='$user'");
                if(mysqli_num_rows($data)>0){
                    echo "<script>alert('Username telah dipakai, silahkan coba username lain.')</script>";
                }
                else{
                    $query = "UPDATE pengguna SET nama='".$_POST['nama']."',katasandi='".$_POST['katasandi']."',username='".$_POST['username']."',lastmodified=now() WHERE id=".$_POST['id'];
                    $result = mysqli_query($koneksi,$query);

                    if($result){
                        header("Location: index.php");
                    }
                }
                
            }
        //}
    ?>