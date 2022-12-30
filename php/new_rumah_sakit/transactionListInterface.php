<link rel="stylesheet" href="generalStylesheet.css">

<script>
    function showList(idVal){
        var checkId = document.getElementById("list"+idVal);
        if(checkId.style.display == "none"){
            checkId.style.display = "block";
        }
        else{
            checkId.style.display = "none";
        }
    }
</script>

<html>

    <head>
        <meta name=”viewport” content=”width=device-width, initial-scale=1.0”>
    </head>

    <div class="web-page disInlineBlock">
        <div class="nav-holder float-left"><div class="card-content">
            <ul><li><button class="nav-button" id="1" onclick="showList(this.id)">
                <span id="folder-icon"></span>User Data</button>
                <ul id="list1" style="display: none;"><li>
                    <button class="nav-button"><a class="nav-button" href="paginationFix.php"><span id="document-icon"></span>User List</a></button>
                </li></ul>
            </li><li><button class="nav-button" id="2" onclick="showList(this.id)">
                <span id="folder-icon"></span>Medicine Data</button>
                <ul id="list2" style="display: none;"><li>
                    <button class="nav-button"><a class="nav-button" href="medicineFix.php"><span id="document-icon"></span>Medicine List</a></button>
                </li></ul>
            </li><li><button class="nav-button" id="3" onclick="showList(this.id)">
                <span id="folder-icon"></span>Transaction Data</button>
                <ul id="list3" style="display: none;"><li>
                    <button class="nav-button"><a class="nav-button" href=""><span id="document-icon"></span>Transaction List</a></button>
                </li><li style="display : inline-block;">
                    <button class="nav-button"><a class="nav-button" href="transactionInterface.php"><span id="document-icon"></span>Transaction Menu</a></button>
                </li></ul>
            </li></ul>
        </div></div>
    </div>
</html>