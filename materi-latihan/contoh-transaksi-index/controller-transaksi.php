<?php

include('./model-transaksi.php');

function transaksiIndex($view){
    $result = getDataTransaksi();
    include $view;
}

function transaksiDetail($idMaster){
    return getDetailTransaksi($idMaster);
};