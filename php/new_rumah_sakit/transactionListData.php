<?php

include "transactionListDataDetail.php";

?>

<link rel="stylesheet" href="generalStylesheet.css">
<script type="text/javascript" src="jquery/dist/jquery.min.js"></script>

<script>
    var tempTable;

    function isset(val){
        if(typeof val == "undefined"){
            return false;
        }
        else{
            return true;
        }
    }

    function detailTable(idVal){
        var detTable = (document.createElement("table"));
        detTable.cellSpacing = 0; detTable.cellPadding = 0;

        document.getElementById(idVal).appendChild(detTable);

        var detIndex = 0;
        var headingRow = detTable.insertRow(detIndex);

        var colIdx = 0;
        var r0c0 = headingRow.insertCell(colIdx).id="r0c"+colIdx;
        document.getElementById("r0c"+colIdx).style.borderTopLeftRadius = '8px';
        document.getElementById("r0c"+colIdx).innerHTML = 'no'; colIdx ++;

        var r0c1 = headingRow.insertCell(colIdx).id="r0c"+colIdx;
        document.getElementById("r0c"+colIdx).innerHTML = 'Kode'; colIdx ++;

        var r0c2 = headingRow.insertCell(colIdx).id="r0c"+colIdx;
        document.getElementById("r0c"+colIdx).innerHTML = 'Nama'; colIdx ++;

        var r0c3 = headingRow.insertCell(colIdx).id="r0c"+colIdx;
        document.getElementById("r0c"+colIdx).innerHTML = 'Harga'; colIdx ++;

        var r0c4 = headingRow.insertCell(colIdx).id="r0c"+colIdx;
        document.getElementById("r0c"+colIdx).style.borderTopRightRadius = '8px';
        document.getElementById("r0c"+colIdx).innerHTML = 'Qty'; colIdx ++;

        var sendTr = (document.getElementById(idVal.substring(4)).children)[2].innerHTML;

        var kodeVal = [];

        $.ajax({
            type : 'post',
            url : 'http://localhost/new_rumah_sakit/transactionListDataDetail.php',
            datatype : 'text',
            data : {'sendVal' : sendTr},
            success : function(data){
                var tempVal = JSON.parse(data);
                var html = "";
                for(var i = 0; i<tempVal.length; i++){
                    html += "<tr><td>" + (i+1) + "</td><td>" + tempVal[i]['kodeTransaksi'] + "</td><td>" + tempVal[i]['namaObat'] + "</td><td style='width : 5%;'><span style='float : left;'>" + "Rp" + "</span><span style='float : right;'>" + Intl.NumberFormat("id-ID").format(tempVal[i]['harga']) + "</span></td><td>" + tempVal[i]['jumlahObat'] + "</td></tr>";
                    (detTable.children)[0].innerHTML += html;
                    html = "";
                }
                // $('#tempVal').val(data);
            }
        });

    }

    function showDetail(idVal){
        if(isset(tempTable)){
            document.getElementById("mainTable").deleteRow(tempTable);
        }

        idVal = parseInt(idVal.substring(7, idVal.length));

        var table = document.getElementById("mainTable");
        var row = table.insertRow(idVal+1);
        var cell = ((row.insertCell(0)).id="cell"+idVal);

        document.getElementById("cell"+idVal).colSpan = "8";
        tempTable = idVal+1;

        detailTable("cell"+idVal);
    }

    function deleteDb(idVal){
        if(confirm("Are you sure want to delete this data ?") == true){
            var delPar = 'codeRow'+idVal;
                location.href = "hapusParentChild.php?kodeTr="+document.getElementById(delPar).innerHTML+"";
            }
    }

    function editDb(idVal){
        if(confirm("Are you sure want to edit this data ?") == true){
            var delPar = 'codeRow'+idVal;
                location.href = "editParentChild.php?kodeTr="+document.getElementById(delPar).innerHTML+"";
        }
    }
</script>

<html>
    <head>
        
    </head>

    <input type="text" id="tempVal" value="" hidden>

    <div class="web-page">
        <div class="card-content" style="width : 100%;">
            <div class="content-wrapper fixed-element">
                <div id="hospital-logo"></div>
                <div id="card-title" style="font-family : uha; font-size : 36px; color : #3baaa1;">RUMAH SAKIT</div>
                <div id="card-title"style="font-family : uha; font-size : 27.5px">DUDUNG PRATAMA</div>
                <div id="ha-er"></div>
                <div id="card-title" style="font-family : uha; font-size : 20px; color : #3baaa1;">TRANSACTION DATA</div>
                <div id="ha-er" style="height : 1px; margin : 5px 150px; "></div>
                <div id="ha-er"></div>
            </div>
            <div style="margin : 225px auto 0px auto"><table cellpadding=0 cellspacing=0 id="mainTable">
                <tr>
                    <td style="border-top-left-radius : 8px;">No</td><td>Nama Customer</td><td>Kode Transaksi</td><td>Tanggal Transaksi</td><td>Total Harga</td><td>Total Item</td><td>Edit</td><td style="border-top-right-radius : 8px;">Delete</td>
                </tr>
                <?php
                    include 'koneksi.php';

                    $query = "SELECT * FROM transparent WHERE deleted = 0";
                    $result = mysqli_query($koneksi,$query);

                    $i = 1;
                    while($row = mysqli_fetch_array($result)){
                        echo "<tr id=".$i."><td>".$i.".</td><td><a id=".'listRow'.$i." href='javascript:void(0)' onclick='showDetail(this.id)'>".$row['namaCustomer']."</a></td><td id=".'codeRow'.$i.">".$row['kodeTransaksi']."</td><td>".$row['tglTransaksi']."</td><td>".$row['totalHargaTransaksi']."</td><td>".$row['totalItemTransaksi']."</td><td><a class='true-small-button' href='javascript:void(0)' onclick='editDb(".$i.")'>EDIT</a></td><td><a class='true-small-button' href='javascript:void(0)' onclick='deleteDb(".$i.")'>DELETE</a></td></tr>";
                        $i++;
                    }
                ?>
            </table></div>
        </div>
    </div>
</html>