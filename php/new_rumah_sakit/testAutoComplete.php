<?php

include "displayTestAutoComplete.php";

?>

<style>
    * {
        box-sizing: border-box;
    }

    body {
        font: 16px Arial;  
    }

    .autocomplete {
        position: relative;
        display: inline-block;
    }

    input {
        border: 1px solid transparent;
        background-color: #f1f1f1;
        padding: 10px;
        font-size: 16px;
    }

    input[type=text] {
        background-color: #f1f1f1;
        width: 100%;
    }

    input[type=submit] {
        background-color: DodgerBlue;
        color: #fff;
        cursor: pointer;
    }

    .autocomplete-items {
        position: absolute;
        border: 1px solid #d4d4d4;
        border-bottom: none;
        border-top: none;
        z-index: 99;
        /*position the autocomplete items to be the same width as the container:*/
        top: 100%;
        left: 0;
        right: 0;
    }

    .autocomplete-items div {
        padding: 10px;
        cursor: pointer;
        background-color: #fff; 
        border-bottom: 1px solid #d4d4d4; 
    }

    /*when hovering an item:*/
    .autocomplete-items div:hover {
        background-color: #e9e9e9; 
    }

    /*when navigating through the items using the arrow keys:*/
    .autocomplete-active {
        background-color: DodgerBlue !important; 
        color: #ffffff; 
    }
</style>

<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale = 1.0">
    </head>

    <body>
        <form autocomplete="off" action="/action_page.php"><div class="autocomplete" style="width:300px;">
            <input id="myInput" type="text" name="myCountry" placeholder="Country">
        </div><input type="submit"></form>
    </body>
        
    <script>

    function autocomplete(masukan, arr){
        var currentFocus;

        masukan.addEventListener("input", function(e) {
            var a, b, i, val = this.value;
            currentFocus = -1;

            closeAllLists();
            if (!val) {return false;}

            a = document.createElement("div");
            a.setAttribute("id", this.id + "autocomple-list");
            a.setAttribute("class", "autocomplete-list");

            this.parentNode.appendChild(a);

            for (i = 0; i<arr.length; i++){
                if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
                    b = document.createElement("div");
                    b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                    b.innerHTML += arr[i].substr(val.length);
                    b.innerHTML += "<input type='hidde' value='" + arr[i] + "'>";
                    b.addEventListener("click",function(e){
                        masukan.value = this.getElementByTagName("input")[0].value;
                        closeAllList();
                    });
                    a.appendChild(b);
                }
            }
        });

        masukan.addEventListener("keydown", function(e){
            var x = document.getElementById(this.id + "autocomplete-list");
            if (x) x = x.getElementByTagName("div");

            if (e.keyCode == 40){
                currentFocus ++; addActive(x);
            }
            else if (e.keyCode == 38){
                currentFocus --; addActive(x);
            }
            else if (e.keyCode == 13){
                e.preventDefault();
                if (currentFocus > -1){
                    if (x) x[currentFocus].click();
                }
            }
        });

        function addActive(x){
            if (!x) return false;

            removeActive(x);
            if (currentFocus >= x.length) currentFocus = 0;
            if (currentFocus < 0) currentFocus = (x.length - 1);

            x[currentFocus].classList.add("autocomplete-active");
        }

        function removeActive(x){
            for(var i = 0; i<x.length; i++){
                x[i].classList.remove("autocomplete-active");
            }
        }

        function closeAllLists(elmnt) {
            var x = document.getElementsByClassName("autocomplete-items");
            for (var i = 0; i < x.length; i++) {
                if (elmnt != x[i] && elmnt != inp) {
                    x[i].parentNode.removeChild(x[i]);
                }
            }
        }

        document.addEventListener("click", function (e){
            closeAllLists(e.target);
        });
    }

    var countries = [<?php foreach ($optVal as  $value){echo ('"'.$value.'",');}?>];

    autocomplete(document.getElementById("myInput"),countries);
    </script>

</html>