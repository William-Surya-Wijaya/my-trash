<?php

    include "koneksi.php";
    include "displayTestAutoComplete.php";

    date_default_timezone_set("Asia/Jakarta");

    $queryMaster = "SELECT * FROM pengguna";
    $resultMaster = mysqli_query($koneksi,$queryMaster);

    $queryDetail = "SELECT * FROM medicine_data";
    $resultDetail = mysqli_query($koneksi, $queryDetail);

?>

<script src="jquery/dist/jquery.min.js"></script>

<script>

    var custName = [<?php foreach ($optVal as  $value){echo ('"'.$value.'",');}?>];
    var medName = [<?php foreach ($detVal as  $value){echo ('"'.$value.'",');}?>];
    var medVal = [<?php foreach ($medVal as  $value){echo ('"'.$value.'",');}?>];

    function convertTZ(date, tzString) {
        return new Date((typeof date === "string" ? new Date(date) : date).toLocaleString("en-US", {timeZone: tzString}));   
    }

    function formatDate(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();

        if (month.length < 2) 
            month = '0' + month;
        if (day.length < 2) 
            day = '0' + day;

        return [year, month, day].join('-');
    }

    function setTransCode(){
        if(document.masterForm.customerName.value == "NAMA"){

        }
        else{
            const date = new Date();
            var currentdate = convertTZ(date, "Asia/Jakarta"); var curday = currentdate.getDay(); var curyr = currentdate.getFullYear();
            document.masterForm.transCode.value = (document.masterForm.customerName.value).substring(0,4)+'/'+curday.toString().substring(0,3)+currentdate.getDate()+(currentdate.getMonth())+curyr.toString().substring(2,4)+'/'+currentdate.getHours()+currentdate.getMinutes();
            document.masterForm.transTime.value = formatDate(currentdate) +' '+ currentdate.toLocaleTimeString('en-US', {hour12:false});
            document.masterForm.custName.value = document.masterForm.customerName.value;
        }
    }

    // function setDetailValue(){
    //     let rawVal = document.masterForm.medicineName.value;
    //     const arrVal = rawVal.split("|");

    //     document.masterForm.medicineCode.value=arrVal[0];
    //     document.masterForm.medicineQty.max=arrVal[2];
    //     document.masterForm.medicineQty.placeholder=arrVal[2];
    //     document.masterForm.medicinePrice.value=arrVal[3];
    // }

    let xyz = 1;

    function setDetailValue(idVal){
        idVal = idVal.substring(12,idVal.length);
        var detIdx = medVal.indexOf(document.getElementById("medicineName"+idVal).value);
        let rawVal = medName[detIdx];
        const arrVal = rawVal.split("|");

        document.getElementById("medicineCode"+idVal).value=arrVal[0];
        document.getElementById("medicineQty"+idVal).max=arrVal[2];
        document.getElementById("medicineQty"+idVal).placeholder=arrVal[2];
        document.getElementById("medicinePrice"+idVal).value=arrVal[3];
    }

    // function setCurTransTotal(idVal){
    //     document.masterForm.curTransTotal.value = parseInt(document.masterForm.medicineQty.value)*parseInt(document.masterForm.medicinePrice.value);
    // }
    
    function setCurTransTotal(idVal){
        idVal = idVal.substring(11,idVal.length);
        document.getElementById("curTransTotal"+idVal).value = parseInt(document.getElementById("medicineQty"+idVal).value)*parseInt(document.getElementById("medicinePrice"+idVal).value);

        setTransTotal();
    }

    function setTransTotal(){
        document.getElementById("transTotal").value = 0;
        document.getElementById("transItemTotal").value = 0;

        for(var i = 1; i<=xyz; i++){
            if(document.getElementById("medicineQty"+i) != null){
                if((parseInt(document.getElementById("medicineQty"+i).value)>0)&&(parseInt(document.getElementById("curTransTotal"+i).value)>0)){

                document.getElementById("transItemTotal").value = parseInt(document.getElementById("transItemTotal").value)+parseInt(document.getElementById("medicineQty"+i).value);

                document.getElementById("transTotal").value = parseInt(document.getElementById("transTotal").value)+parseInt(document.getElementById("curTransTotal"+i).value);
                }
            }
        }
    }

    function addTransRowC(xyzc){
        var tab = document.querySelector('#transRow');
        var div = document.querySelector('#col0');
        var clone = div.cloneNode(true);

        clone.id = xyzc;
        clone.name = xyzc;
        clone.hidden = false;

        (((clone.children)[1].children)[0].id+=xyzc);(((((clone.children)[2].children)[0]).children)[0].id+=xyzc);(((clone.children)[3].children)[0].id+=xyzc);(((clone.children)[4].children)[0].id+=xyzc);(((clone.children)[5].children)[0].id+=xyzc);(((clone.children)[6].children)[0].id+=xyzc);

        (((clone.children)[1].children)[0].name+=xyzc);(((((clone.children)[2].children)[0]).children)[0].name+=xyzc);(((clone.children)[3].children)[0].name+=xyzc);(((clone.children)[4].children)[0].name+=xyzc);(((clone.children)[5].children)[0].name+=xyzc);(((clone.children)[6].children)[0].name+=xyzc);

        (((clone.children)[0].children)[0].value+=xyzc);

        tab.append(clone);

        autocompleteDet(document.getElementById("medicineName"+xyzc),medVal);
        
        document.getElementById("totalRow").value=xyz;
        xyz += 1;
    }

    function delTransRowC(xyzc){
        xyzc = xyzc.substring(3,xyzc.length);
        
        var row = document.getElementById('del'+xyzc).parentNode.parentNode.rowIndex;
        document.getElementById('transRow').deleteRow(row);
        document.getElementById("totalRow").value = parseInt(document.getElementById("totalRow").value) - 1;

        var nomor = 1;
        $('#transRow tr:gt("1")').each(function(){
            $(this).find('td:first-child input').val(nomor); nomor ++;
        });
    }

    // !! AUTOCOMPLETE MASTER FUNCTION !! //

    function autocomplete(inp,arr){
        var currentFocus;

        inp.addEventListener("input", function(e){
            var a, b, i, val = this.value;

            closeAllLists();
            if(!val){return false;}
            currentFocus = -1;

            a = document.createElement("div");
            a.setAttribute("id", this.id + "autocomplete-list");
            a.setAttribute("class", "autocomplete-items");
            this.parentNode.appendChild(a);

            for(i = 0; i<arr.length; i++){
                if(arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()){
                    b = document.createElement("div");
                    b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                    b.innerHTML += arr[i].substr(val.length);
                    b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                    b.addEventListener("click", function(e){
                        inp.value = this.getElementsByTagName("input")[0].value;
                        closeAllLists(); setTransCode();
                    });
                    a.appendChild(b);
                }
            }
        });

        inp.addEventListener("keydown", function(e){
            var x = document.getElementById(this.id + "autocomplete-list");
            if (x) x = x.getElementsByTagName("div");
            if (e.keyCode == 40){
                currentFocus ++;
                addActive(x);
            }
            else if (e.keyCode == 38){
                currentFocus --;
                addActive(x);
            }
            else if (e.keyCode == 13){
                e.preventDefault();
                if(currentFocus > -1){
                    if (x) x[currentFocus].click();
                }
            }
        });

        function addActive(x){
            if (!x) return false;

            removeActive(x);
            if(currentFocus >= x.length) currentFocus = 0;
            if(currentFocus < 0) currentFocus = (x.length - 1);

            x[currentFocus].classList.add("autocomplete-active");
        }

        function removeActive(x){
            for (var i = 0; i<x.length; i++){
                x[i].classList.remove("autocomplete-active");
            }
        }

        function closeAllLists(elmnt){
            var x = document.getElementsByClassName("autocomplete-items");
            for (var i = 0; i<x.length; i++){
                if(elmnt != x[i] && elmnt != inp){
                    x[i].parentNode.removeChild(x[i]);
                }
            }
        }
        document.addEventListener("click", function(e){
            closeAllLists(e.target);
        });
    }

    $(document).ready(function(){
        autocomplete(document.getElementById("customerName"),custName);
    });

    // !! AUTOCOMPLETE DETAIL FUNCTION !! //
    
    function autocompleteDet(inp,arr){
        var currentFocus;

        inp.addEventListener("input", function(e){
            var a, b, i, val = this.value;

            closeAllLists();
            if(!val){return false;}
            currentFocus = -1;

            a = document.createElement("div");
            a.setAttribute("id", this.id + "autocomplete-list");
            a.setAttribute("class", "autocomplete-items");
            this.parentNode.appendChild(a);

            for(i = 0; i<arr.length; i++){
                if(arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()){
                    b = document.createElement("div");
                    b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                    b.innerHTML += arr[i].substr(val.length);
                    b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                    b.addEventListener("click", function(e){
                        inp.value = this.getElementsByTagName("input")[0].value;
                        setDetailValue(inp.id); closeAllLists();
                    });
                    a.appendChild(b);
                }
            }
        });

        inp.addEventListener("keydown", function(e){
            var x = document.getElementById(this.id + "autocomplete-list");
            if (x) x = x.getElementsByTagName("div");
            if (e.keyCode == 40){
                currentFocus ++;
                addActive(x);
            }
            else if (e.keyCode == 38){
                currentFocus --;
                addActive(x);
            }
            else if (e.keyCode == 13){
                e.preventDefault();
                if(currentFocus > -1){
                    if (x) x[currentFocus].click();
                }
            }
        });

        function addActive(x){
            if (!x) return false;

            removeActive(x);
            if(currentFocus >= x.length) currentFocus = 0;
            if(currentFocus < 0) currentFocus = (x.length - 1);

            x[currentFocus].classList.add("autocomplete-active");
        }

        function removeActive(x){
            for (var i = 0; i<x.length; i++){
                x[i].classList.remove("autocomplete-active");
            }
        }

        function closeAllLists(elmnt){
            var x = document.getElementsByClassName("autocomplete-items");
            for (var i = 0; i<x.length; i++){
                if(elmnt != x[i] && elmnt != inp){
                    x[i].parentNode.removeChild(x[i]);
                }
            }
        }
        document.addEventListener("click", function(e){
            closeAllLists(e.target);
        });
    }

</script>

<link rel="stylesheet" href="generalStylesheet.css">

<div name="0" id="0"></div>

<html>

    <div class="web-page">
        <div class="card">
            <div class="card-content">
                <div id="hospital-logo"></div>
                <div id="card-title" style="font-family : uha; font-size : 36px; color : #3baaa1;">RUMAH SAKIT</div>
                <div id="card-title"style="font-family : uha; font-size : 27.5px">DUDUNG PRATAMA</div>
                <div id="ha-er"></div>
                <div id="card-title" style="font-family : uha; font-size : 20px; color : #3baaa1;">transaction</div>
                <div id="ha-er" style="height : 1px; margin : 5px 150px; "></div>
                <div id="ha-er"></div>
                <center><form name="masterForm" id="masterForm" action="transactionSave.php" method="post" autocomplete="off"><table cellspacing=0 cellpadding=0>
                    <input hidden id="totalRow" name="totalRow" value=""><input hidden id="custName" name="custName" value="">
                    <tr>
                        <td id="form-name" style="border-top-left-radius : 8px; width : 210px;">customer</td><td><div class="autocomplete" style="width : content;"><input class="mform-answer-bar" id="customerName" nama="customerName" type="text" placeholder = "NAMA" onchange=""></div></td><td id="form-name" style="width : 210px;">kode transaksi</td>
                        <td style="border-top-right-radius : 8px;"><input class="mform-answer-bar" name="transCode" style="width : 200px; display : inline-table;" value="" readonly></td>
                    </tr>
                    <tr>
                        <td id="form-name" style="width : 210px;">surat jalan</td><td></td><td id="form-name" style="width : 210px;">tanggal</td><td><input class="mform-answer-bar" name="transTime" style="width : 200px; display : inline-table; color : #3baaa1;" value="" readonly></td>
                    </tr>
                </table>
                <div id="ha-er"></div>
                <div class="content-wrapper" style="display : inline-block; width : 90%;">
                    <input class="float-left" type="button" onclick="addTransRowC(xyz);" id="true-button" value="ADD ROW"><input class="float-left" type="button" onclick="javascript:document.getElementById('masterForm').submit();" id="true-button" value="SAVE" style="margin : 5px 10px;"><input class="float-right" type="button" id="true-button" value="CANCEL">
                </div>
                <table cellspacing=0 cellpadding=0 id="transRow">
                    <tr>
                        <td style="border-top-left-radius : 8px;">No</td><td>Kode</td><td>Nama</td><td>Jumlah</td><td>Harga</td><td>Total</td><td style="border-top-right-radius : 8px;">Delete</td>
                    </tr>
                    <?php $i=1; ?>
                    <tr id="col0" name="col0" hidden>
                        <td><input value="" class="mform-answer-bar" style="color : #333c57; display : inline-table; width : 50px;"></td>
                        <td><input name="medicineCode" id="medicineCode" class="mform-answer-bar" readonly value="" style="color : #333c57; display : inline-table; width : 85px;"></td>
                        <td><div class="autocomplete" stylle="width : content;"><input class="mform-answer-bar" id="medicineName" name="medicineName" type="text" placeholder="MEDICINE"></div></td>
                        <td><input type="number" onchange="setCurTransTotal(this.id)" id="medicineQty" name="medicineQty" class="mform-answer-bar" placeholer="STOCK = " value="" min="0" max="" onkeydown="return false" style="display : inline-table; color : #333c57; width : 85px"></td>
                        <td><input type="number" name="medicinePrice" id="medicinePrice" class="mform-answer-bar" value="" readonly style="display : inline-table; color : #333c57; width : 120px"></td>
                        <td><input type="number" name="curTransTotal" id="curTransTotal" class="mform-answer-bar" value="" readonly style="display : inline-table; color : #333c57; width : 120px"></td>
                        <td><input type="button" class="true-small-button" id="del" name="del" value="DELETE" onclick="delTransRowC(this.id)"></td>
                    </tr>
                    </form>
                </table><table cellpadding = 0 cellspacing = 0 style="margin : 10px auto;">
                    <tr style="border-radius : 8px;">
                        <td>TOTAL HARGA</td><td><input class="mform-answer-bar" name="transTotal" id="transTotal" value="0" readonly></td><td>TOTAL ITEMS</td><td><input class="mform-answer-bar" name="transItemTotal" id="transItemTotal" value="0" readonly></td>
                    </tr>
                </table></center>
            </div>
        </div>
    </div>

</html>