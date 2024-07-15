<style>
    body{
        font-family : monospace; font-size : 1em;
    }

    .width100{ 
        width : 95%;
    }

    table {
        margin : auto; border-spacing: 0; border-collapse: collapse;
    }

    table.tableTitle {
        width : 100%; overflow-x: auto; margin-bottom : 2em;
    }

    table.tableTitle tr td{
        text-align : center;
    }

    table.tableTitle tr:first-child td{
        font-size : 1.8em; font-weight : bold; text-align : center !important;
    }

    table.tableTitle tr:not(:nth-child(2)) td{
        text-align : left;
    }

    table.tableContent {
        width : 100%; overflow-x: auto; text-align : left;
    }

    table.tableContent tr:first-child th {
        font-weight : bold; border-top : 1px solid; border-bottom : 1px solid;
    }

    table.tableContent tr:first-child th:first-child {
        border-left: 1px solid;
    }

    table.tableContent tr:first-child th:last-child {
        border-right: 1px solid;
    }

    table.tableContent tr td:first-child {
        border-left : 1px solid; text-align : left !important;
    }

    table.tableContent tr td:last-child {
        border-right : 1px solid; text-align : right !important;
    }

    table.tableContent tr td:nth-last-child(3) {
        text-align : right !important;
    }

    table.tableContent tr.table-sum {
        font-weight: bold; border-top : 1px dashed; border-bottom : 1px solid;
    }

    .bold {
        font-weight: bold;
    }

    .align-left {
        text-align : left !important;
    }

    .align-right {
        text-align : right !important;
    }

    .align-center {
        text-align : center !important;
    }

</style>

<html>
    <table class='tableTitle flex width100'>
        <tr>
            <td colspan = '2'>LAPORAN PENJUALAN OBAT</td>
        </tr>
        <tr>
            <td colspan = '2'>RUMAH SAKIT DUDUNG PRATAMA</td>
        </tr>
        <tr>
            <td><span class = 'bold'>PERIODE : </span>XX/XX/XXXX - XX/XX/XXXX</td>
        </tr>
    </table>

    <table class='tableContent width100'>
        <tr>
            <th style="width : 8%">Tanggal</th>
            <th style="width : 8%">Kode Transaksi</th>
            <th style="width : 8%">Kode Barang</th>
            <th>Nama Barang</th>
            <th style="width : 2%">Qty</th>
            <th style="width : 5%">Satuan</th>
            <th style="width : 5%">Total</th>
        </tr>
        <tr>
            <td>XX/XX/XXXX</td>
            <td>XX-XX-XXXX</td>
            <td colspan='100%'></td>
        </tr>
        <tr>
            <td colspan='2'></td>
            <td>ALP01</td>
            <td>ALUPURINOL 200MG</td>
            <td>4</td>
            <td>PCS</td>
            <td>4000</td>
        </tr>
        <tr>
            <td colspan='2'></td>
            <td>SMC</td>
            <td>SLIMMING CAPSULE</td>
            <td>3</td>
            <td>KARTON</td>
            <td>30000</td>
        </tr>
        <tr>
            <td colspan='2'></td>
            <td>SMC</td>
            <td>SLIMMING CAPSULE</td>
            <td>3</td>
            <td>KARTON</td>
            <td>30000</td>
        </tr>
        <tr class='table-sum'>
            <td colspan='3'></td>
            <td>Total Per Nota</td>
            <td>10</td>
            <td></td>
            <td>64000</td>
        </tr>
        <tr>
            <td>XX/XX/XXXX</td>
            <td>XX-XX-XXXX</td>
            <td colspan='100%'></td>
        </tr>
        <tr>
            <td colspan='2'></td>
            <td>ALP01</td>
            <td>ALUPURINOL 200MG</td>
            <td>4</td>
            <td>PCS</td>
            <td>4000</td>
        </tr>
        <tr>
            <td colspan='2'></td>
            <td>SMC</td>
            <td>SLIMMING CAPSULE</td>
            <td>3</td>
            <td>KARTON</td>
            <td>30000</td>
        </tr>
        <tr>
            <td colspan='2'></td>
            <td>ALP01</td>
            <td>ALUPURINOL 200MG</td>
            <td>4</td>
            <td>PCS</td>
            <td>4000</td>
        </tr>
        <tr>
            <td colspan='2'></td>
            <td>SMC</td>
            <td>SLIMMING CAPSULE</td>
            <td>3</td>
            <td>KARTON</td>
            <td>30000</td>
        </tr>
        <tr class='table-sum'>
            <td colspan='3'></td>
            <td>Total Per Nota</td>
            <td>10</td>
            <td></td>
            <td>64000</td>
        </tr>
    </table>
</html>