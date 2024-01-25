<?php

include("./controller-transaksi.php");

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST, OPTIONS');
header('Access-Control-Allow-Headers: Content-Type');

// ----- start master transaksi ----

if(isset($_GET['action']) && $_GET['action'] == 'transaksi-index') {
    transaksiIndex('./view-transaksi.php');
}

// ----- end master transaksi ----


// ----- start detail transaksi ----

if(isset($_GET['action']) && $_GET['action'] == 'transaksi-detail') {
    $idMaster = isset($_GET["id_master"]) ? (int)$_GET["id_master"] : 0;

    echo transaksiDetail($idMaster);
}

// ----- start master transaksi ----