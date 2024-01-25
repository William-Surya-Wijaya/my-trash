<?php

function getDataTransaksi(){
    include("koneksi-transaksi.php");
    $data = mysqli_query($koneksi,"SELECT * FROM trans_mst WHERE deleted_at IS NULL LIMIT 10");
    return $data;
}

function getTotalHalaman(){
    include("koneksi-transaksi.php");
    $data = mysqli_query($koneksi,"SELECT COUNT(*) FROM trans_mst WHERE deleted_at IS NULL");
    return $data;
}

function getDetailTransaksi($idMaster){
    include("koneksi-transaksi.php");

    $data = array();

    $result = mysqli_query($koneksi, "SELECT * FROM trans_detail WHERE id_trans='$idMaster' AND deleted_at IS NULL");

    if ($result) {
        while ($row = mysqli_fetch_assoc($result)) {
            $data[] = $row;
        }

        mysqli_free_result($result);
    }

    return json_encode($data);
}
