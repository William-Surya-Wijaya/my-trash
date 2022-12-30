;<?php

// include "transactionListDataDetail.php";

// $kodeTr = "marc/624822/1429";

// $printArr = array();

// $printArr = getDetailKodeList($kodeTr);
// echo $printArr;
// foreach ($printArr as $row){echo $row.'<br>';}

// $printArr = getDetailMedicineList($kodeTr);
// foreach ($printArr as $row){echo $row.'<br>';}

// $printArr = getDetailPriceList($kodeTr);
// foreach ($printArr as $row){echo $row.'<br>';}

// $printArr = getDetailQtyList($kodeTr);
// foreach ($printArr as $row){echo $row.'<br>';}

?>

<script src="jquery/dist/jquery.min.js"></script>

<script>

    var sendTr = 'sims/422822/1821';

    var retVal = [];

    $.ajax({
            type : 'post',
            url : 'http://localhost/new_rumah_sakit/transactionListDataDetail.php',
            datatype : 'text',
            data : {'action': 'getKode', 'sendVal' : sendTr},
            success : function(data){
                retVal = data.split("|"); retVal.pop();
            }
        });
</script>
