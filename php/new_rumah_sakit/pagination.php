<html>
<head>
    <title>Cara Membuat Pagination Dengan PHP MySQL</title>    
</head>
<body>
    <h2>Tutorial Cara Membuat Pagination Dengan PHP MySQL - Paging PHP</h2>
    <h5>Daftar Surat Masuk</h5>
    <table border="1" cellpadding="2">
        <tr height="32">
            <td width="40" align="center">NO</td>
            <td>TANGGAL
            <td>NOMOR SURAT</td>
            <td>PENGIRIM</td>
            <td>PERIHAL</td>
        </tr>
            <?php
                include "koneksi.php";
                $halaman = 5; /* page halaman*/
                $page    =isset($_GET["halaman"]) ? (int)$_GET["halaman"] : 1;
                $mulai    =($page>1) ? ($page * $halaman) - $halaman : 0;

                $query = "SELECT *, DATE_FORMAT(lastmodified, '%a %b %Y - %H:%i:%s') AS tgl FROM pengguna ORDER BY lastmodified DESC";
                
                $result    =mysqli_query($koneksi,$query);
                $total = mysqli_num_rows($result);
                $pages = ceil($total/$halaman);
                
                $tampilMas    =mysqli_query($koneksi,"SELECT *, DATE_FORMAT(lastmodified, '%a %b %Y - %H:%i:%s') AS tgl FROM pengguna ORDER BY lastmodified DESC LIMIT $mulai, $halaman");
                $no    =$mulai+1;
                while($mas    =mysqli_fetch_array($tampilMas)){
                    $i = 1;
                    while($row = mysqli_fetch_array($tampilMas)){
                        echo '<tr><td>'.$i.'</td><td>'.$row["nama"].'</td><td>'.$row["username"].'</td><td>'.$row["katasandi"].'</td><td>'.$row["tgl"].'</td><td><a href="javascript:void(0);" onclick="confirmDelete('.$row["id"].')">Hapus</a></td><td><a href="edit.php?id='.$row["id"].'">Edit</a></td></tr>';
                        $i += 1;
                    }
                }
            ?>
    </table>
    <br />
    <div style="font-weight:bold;">
        Paging
        <?php
            for ($i=1; $i<=$pages ; $i++){
        ?>
            <a href="pagination.php?halaman=<?php echo $i; ?>" style="text-decoration:none">   <u><?php echo $i; ?></u></a>
        <?php
            }
        ?>
    </div>
</body>
</html>