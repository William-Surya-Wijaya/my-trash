<?php
    // if isset post then insert with mysqli
        // if(isset($_POST['submit'])){
            
            if(($_POST["nama"] == "" )||($_POST["username"] == "" ) ||($_POST["katasandi"] == "" )){
                echo '<script>alert("please fill in all the fields of the form.")</script>';
                ?> <script>
                    history.back();
                </script> <?php
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
                    $query = "INSERT INTO pengguna (nama,katasandi,username,lastmodified) VALUES ('".$_POST['nama']."','".$_POST['katasandi']."','".$_POST['username']."',now())";
                    // eksekusi query mysqli
                    $result = mysqli_query($koneksi,$query);

                    if($result){
                        header("Location: http://localhost/new_rumah_sakit/paginationFix.php");
                    }
                }
                
            }
        // }
    ?>