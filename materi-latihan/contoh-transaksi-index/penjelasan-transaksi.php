<style>
    body{
        background-color: #3b4252;
        color: white;
    }

    .penjelasan {
        max-width: 50%;
    }

    .penjelasan > *{
        font-family: monospace;
    }

    img{
        width: 300px;
    }

    span{
        background-color: #566078;
        font-weight: bold;
        padding: 0 4px;
        border-radius: 5px;
    }
    
    p{
        color: rgba(255,255,255, 0.7);
    }

    ol, ul, li{
        width: fit-content;
    }
</style>

<div class="penjelasan">
<h1>SUBGRID</h1>
<p>Berikut adalah penjelasan sederhana Subgrid dalam Transaksi</p>
<hr />

<h2>Apa itu subgrid ?</h2>
<img src="./image/subgrid_1.png" />
<p>Penjelasan mudah dari <span>subgrid adalah adanya table kecil lain di dalam sebuah table besar</span>. Dimana isi dari table subgrid pada umumnya adalah data detail dari baris sebelumnya </p>
<hr />

<h2>Bagaimana ide utama dalam membuat subgrid ?</h2>
<p>Untuk membuat subgrid, pertama tama kita perlu memahami bahwa data subgrid atau data detail untuk transaksi tidak dibawa pada saat yang bersamaan dengan data master. <br><br>Data subgrid atau data detail diambil saat dibutuhkan saja dengan trigger tertentu yang pada umumnya adalah tombol 'lihat detail' dan sejenisnya. <br><br><span>Berikut adalah tahapan ide logika utama cara kerja subgrid.</span></p>

<ol type="1">
    <li><h3>Buat trigger untuk memulai process pembuatan subgrid</h3></li>
    <button>Lihat Detail</button>
    <p>&lt;name="&lt;?= $row['id_trans'] ?&gt;" class="button-detail">Lihat Detail&gt;</p>
    <br>
    <p>Biasanya trigger dibuat dengan membuat tombol pada kolom paling kiri dari setiap baris data.</p>
    <p>Anda harus memikirkan bagaimana cara anda agar bisa mengetahui <span>tombol tersebut berada pada baris berapa atau tombol tersebut milik data master mana</span> untuk melakukan tahapan selanjutnya. Dari contoh yang saya berikan di atas, tombol tersebut dinamai dengan id milik data master.</p>
    <br>
    <p><span>Perlu dicatat bahwa cara yang saya lakukan bukan merupakan cara satu satunya untuk membuat subgrid.</span></p>
    <br>

    <li><h3>Buat baris baru saat trigger ditekan</h3></li>
    <p>Saat tombol ditekan, anda harus memikirkan bagaimana caranya menambahkan sebuah baris dibawah baris tombol tersebut ditekan.</p>
    <p>Salah satu cara adalah dengan melakukan create element.</p>
    <span>const barisBaruBuatDetail = document.createElement('tr');</span>
    <p>Selalu ingat bahwa ini bukanlah cara satu satunya untuk membuat element baru atau menambah baris baru.</p>
    <br>

    <li><h3>Ambil data detail milik master</h3></li>
    <p>Disinilah guna anda <span>mengetahui tombol tersebut berada pada baris berapa atau tombol tersebut milik data master mana</span> mulai terasa penting.</p>
    <p>Ambil data detail dengan contoh yang saya berikan yaitu dengan menembak ke route /transaksi-detail/:id_master</p>

    <h3>Process pada backend</h3>
    <p>Setelah route berhasil ditembak dan mengenai sasaran dengan baik maka, disinilah process pengambilan data pada back-end dimulai</p>
    <ol type="A">
        <li><h3>Route</h3></li>
        <p>Pastikan route anda ada dan bisa menerima permintaan sesuai dengan kebutuhan. (Pada kasus ini dapat permintaan meminta data detail milik transaksi dengan id_master tertentu)</p>
        <p>Berikut adalah contoh route sederhana yang tentunya perlu Anda modifikasi karena route dibawah tidak menangani 'searching' dan 'pagination'.</p>
        <p>if(isset($_GET['action']) && $_GET['action'] == 'transaksi-detail') {<br>
            &nbsp;&nbsp;&nbsp;&nbsp;$idMaster = isset($_GET["id_master"]) ? (int)$_GET["id_master"] : 0;<br>

            &nbsp;&nbsp;&nbsp;&nbsp;echo transaksiDetail($idMaster);<br>
        }</p>
        <li><h3>Controller</h3></li>
        <p>Pastikan controller anda siap mengerjakan process dari route dan melakukan pengolahan data sesuai kebutuhan.</p>
        <p>Berikut adalah contoh controller sederhana yang tentunya perlu Anda modifikasi karena controller dibawah tidak menangani 'searching' dan 'pagination'.</p>
        <p>function transaksiDetail($idMaster){<br>
            &nbsp;&nbsp;&nbsp;&nbsp;return getDetailTransaksi($idMaster);<br>
        };</p>
        <li><h3>Model</h3></li>
        <p>Pastikan model anda siap mengambil data dari database sesuai dengan kebutuhan (Dalam kasus ini membuat query select untuk mengambil data detail dengan $idMaster).</p>
        <p>Berikut adalah contoh model sederhana yang tentunya perlu Anda modifikasi karena model dibawah tidak menangani 'searching' dan 'pagination'.</p>
        <p>Pada contoh yang saya berikan, model mengembalikan data dengan format json. Metode ini merupakan metode paling umum digunakan oleh developer. Namun, tidak menutup kemungkinan adanya metode lain yang dapat digunakan untuk mengembalikan data.</p>
        <p>function getDetailTransaksi($idMaster){<br>
            &nbsp;&nbsp;&nbsp;&nbsp;include("koneksi-transaksi.php");<br>

            &nbsp;&nbsp;&nbsp;&nbsp;$data = array();<br>

            &nbsp;&nbsp;&nbsp;&nbsp;$result = mysqli_query($koneksi, "SELECT * FROM trans_detail WHERE id_trans='$idMaster' AND deleted_at IS NULL");<br>

            &nbsp;&nbsp;&nbsp;&nbsp;if ($result) {<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;while ($row = mysqli_fetch_assoc($result)) {<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$data[] = $row;<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mysqli_free_result($result);<br>
                &nbsp;&nbsp;&nbsp;&nbsp;}<br>

                &nbsp;&nbsp;&nbsp;&nbsp;return json_encode($data);<br>
        }
        </p>
    </ol>
    <br>
    <li><h3>Tangani data yang didapat dari route</h3></li>
    <p>Pada contoh yang saya berikan hasil return data akan berformat json. Dengan begitu dapat digunakan metode map() pada javascript untuk membentuk 'tampilan element html' yang akan di render.</p>
    <br>
    <li><h3>Tampilkan data yang telah ditangani</h3></li>
    <p>Jangan lupa menampilkan data yang telah ditangani. Lanjutkan pada baris yang telah kita buat pada langkah 2. Buatlah sedemikian rupa format yang diperlukan untuk menampilkan data detail</p>
    <br>
    <li><h3>Penanganan toggle button 'lihat detail'</h3></li>
    <p>Pergunakan nama button yang telah kita siapkan pada langkah 1 dengan baik untuk menandai beberapa hal berikut.</p>
    <ul>
        <li>Nama / ID milik Baris Master untuk mempermudah permainan logika pemrosesan anda pada javasript. Ibaratkan manusia yang memiliki nama, kita hanya perlu memanggil namanya (Marcell, tolong ke sini sebentar) dan tidak perlu memanggil secara kaku seperti (Kamu yang ada diurutan ke tiga, tolong ke sini sebentar)</li>
        <br>
        <li>Kondisi Baris Master (Data Master Transaksi) apakah subgridnya sedang terbuka atau tidak. Agar tidak terjadinya double subgrid, baris master yang sedang dibuka, bila tombol 'lihat detail' ditekan kembali maka, subgrid akan tertutup dan juga berlaku sebaliknya.</li>
        <br>
        <li>Menghapus / menutup Subgrid. Kita butuh mengetahui subgrid mana dari data master mana yang ingin kita hapus. Kembali lagi pada perumpamaan manusia dengan nama.</li>
    </ul>
</ol>

</div>