<?php

    include "koneksi.php";

    $exportQuery = "SELECT * FROM medicine_data";

    $result = mysqli_query($koneksi, $exportQuery);

    header("Content-type: application/vnd-ms-excel");
    header("Content-Disposition: attachment; filename=Data Medicine.xls");

    echo '<table cellpadding = "0"  cellspacing = "0">
            <tr>
                <td style="border-top-left-radius : 8px">No</td><td>Kode</td><td>Nama</td><td>Merk</td><td>Type</td><td>Expire</td>
            </tr>';

    $i = 1;
    while($row = mysqli_fetch_array($result)){
        echo '<tr><td>'.$i.'</td><td>'.$row["kodeobat"].'</td><td>'.$row["namaobat"].'</td><td>'.$row["merkobat"].'</td><td>'.$row["typeobat"].'</td><td>'.$row["tglexpire"].'</td></tr>';
        $i += 1;
    }

    echo '</table>';

    exit;

?>