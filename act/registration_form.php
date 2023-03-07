<!DOCTYPE html>

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="author" content="Xmartlabs" />
    <meta content="width=device-width, initial-scale=1" name="viewport">

    <title>ACT VFM Registration</title>

    <link rel="shortcut icon" type="image/x-icon" href="https://media.discordapp.net/attachments/1003364577871937566/1080493253809405972/Fotor_AI_18.png?width=671&height=671" />
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="form.css?version=5" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.slim.min.js" integrity="sha256-ZwqZIVdD3iXNyGHbSYdsmWP//UBokj2FHAxKuSBKDSo=" crossorigin="anonymous"></script>
  </head>

  <body style="overflow-y: hidden;">
    <div class="container" id="container">

      <div class="section" id="0">
        <div class="marginLR">
          <div class="title-text">VALORANT - Fun Match !</div>
          <div class="desc-text">By ACT Discord Admins (No Fee, Have Fun !)</div>
          <a onclick="fadeOutIn('#1',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="1">
        <div class="marginLR">
          <div class="title-text">Hallo semuanya, berikut adalah form pendaftaran peserta untuk Fun Match Valorant yang diadakan oleh Admin dari discord ACT!</div>
          <a onclick="fadeOutIn('#2',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span><i class="fa fa-check-circle-o" aria-hidden="true"></i></a>
        </div>
      </div>

      <div class="section" id="2">
        <div class="marginLR">
          <div class="title-text">Berikut adalah peraturan dan ketentuan yang dapat kalian akses melalui link di bawah.</div>
          <div class="desc-text"><a style="text-decoration:underline; color:#b4b1a2;" onclick="javascript:window.open('https://act.marcellino.my.id')">https://act.marcellino.my.id</a></div>
          <a onclick="fadeOutIn('#3',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span><i class="fa fa-check-circle-o" aria-hidden="true"></i></a>
        </div>
      </div>

      <div class="section" id="3">
        <div class="marginLR">
          <div class="title-text">Dengan mengisi form ini, maka pendaftar setuju dengan segala peraturan dan ketentuan yang berlaku.</div>
          <div class="desc-text">Semua data form berikut adalah untuk keperluan pertandingan dan tidak akan disebarkan.</div>
          <a onclick="fadeOutIn('#4',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span><i class="fa fa-check-circle-o" aria-hidden="true"></i></a>
        </div>
      </div>

      <div class="section" id="4">
        <div class="marginLR">
          <div class="title-text">Masukan nama tim kamu ! (*)</div>
          <div class="desc-text">(Tidak mengandung kata kata tidak pantas)</div>
          <input type="text" class="input-field required" id="teamName" name="teamName" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#5',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="5">
        <div class="marginLR">
          <div class="title-text">Masukan email perwakilan tim kamu ! (*)</div>
          <div class="desc-text">(Kebutuhan email perwakilan untuk pengumuman dan komunikasi, kami tidak akan menyebarkan email kamu)</div>
          <input type="text" class="input-field required" id="teamEmail" name="teamEmail" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#6',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="6">
        <div class="marginLR">
          <div class="title-text">Masukan nomor telepon perwakilan tim kamu ! (*)</div>
          <div class="desc-text">(Kebutuhan nomor telepon perwakilan untuk pengumuman dan komunikasi)</div>
          <input type="text" class="input-field required" id="teamPhone" name="teamPhone" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#7',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="7">
        <div class="marginLR">
          <div class="title-text">Masukan nickname dan tag discord perwakilan tim kamu ! (*)</div>
          <div class="desc-text">(Kebutuhan nickname discord perwakilan untuk pemanggilan tim dan koordinasi)</div>
          <input type="text" class="input-field required" id="teamPhone" name="teamPhone" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#8',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="8">
        <div class="marginLR">
          <div class="title-text">Masukan Nickname beserta Tag dari 5 Pemain Utama dan 1 Pemain Cadangan dari tim kamu !</div>
          <div class="desc-text">Pemain Cadangan tidak wajib untuk diisi</div>
          <a onclick="fadeOutIn('#9',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="9">
        <div class="marginLR">
          <div class="title-text">Pemain 1 ! (*)</div>
          <div class="desc-text">(Nickname dan Tag)</div>
          <input type="text" class="input-field required" id="teamPlayer1" name="teamPlayer1" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#10',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="10">
        <div class="marginLR">
          <div class="title-text">Pemain 2 ! (*)</div>
          <div class="desc-text">(Nickname dan Tag)</div>
          <input type="text" class="input-field required" id="teamPlayer2" name="teamPlayer2" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#11',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="11">
        <div class="marginLR">
          <div class="title-text">Pemain 3 ! (*)</div>
          <div class="desc-text">(Nickname dan Tag)</div>
          <input type="text" class="input-field required" id="teamPlayer3" name="teamPlayer3" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#12',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="12">
        <div class="marginLR">
          <div class="title-text">Pemain 4 ! (*)</div>
          <div class="desc-text">(Nickname dan Tag)</div>
          <input type="text" class="input-field required" id="teamPlayer4" name="teamPlayer4" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#13',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="13">
        <div class="marginLR">
          <div class="title-text">Pemain 5 ! (*)</div>
          <div class="desc-text">(Nickname dan Tag)</div>
          <input type="text" class="input-field required" id="teamPlayer5" name="teamPlayer5" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#14',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="14">
        <div class="marginLR">
          <div class="title-text">Cadangan 1 !</div>
          <div class="desc-text">(Nickname dan Tag)</div>
          <input type="text" class="input-field" id="teamPlayer6" name="teamPlayer6" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#15',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="15">
        <div class="marginLR">
          <div class="title-text">Masukan rank tertinggi yang ada di tim kamu ! (*)</div>
          <div class="desc-text">(Rank tertinggi dari 5 / 6 Pemain)</div>
          <input type="text" class="input-field required" id="teamRank" name="teamRank" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Field ini perlu diisi !</p>
          <a onclick="fadeOutIn('#16',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="16">
        <div class="marginLR">
          <div class="title-text">Terima Kasih ! Kami akan memberitahukan tentang pendaftaran kamu melalui email !</div>
          <div class="desc-text">Kami melakukan seleksi ringan untuk memastikan Fun Match berjalan dengan baik</div>
          <a onclick="fadeOutIn('#17',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b> to Submit</span></a>
        </div>
      </div>

    </div>

    <div class="footer">
      <progress class="progress-bar" id="progress" max="" value=""></progress>
    </div>
  </body>
</html>

<script>
  location.href="#0";

  function dangerCheck(element){
    if($(element).val() == ""){
      $(element).next().removeClass('hidden');
    }
    else{
      if($(element).next().hasClass('hidden')){

      }else{
        $(element).next().addClass('hidden');
      }
    }
  }

  function checkRequired(idx){
    const checkElement = $('div#'+idx+' > div.marginLR > input');
    if(checkElement.hasClass('required')){
      if(checkElement.val() == ""){
        $('div#'+idx+' > div.marginLR > p.danger').removeClass('hidden');
        return false;
      }
      else{
        return true;
      }
    }
    else{
      return true;
    }
  }

  function fadeOutIn(link ,duration) {
    const body = document.getElementById('container');

    if(checkRequired(parseInt(link.substring(1))-1)){
      body.style.opacity = 1;
      let fadeOutInterval = setInterval(() => {
        if (body.style.opacity > 0) {
          body.style.opacity -= 0.1;
        } else {
          clearInterval(fadeOutInterval);

          body.style.opacity = 0;
          location.href = link;

          $('#progress').val(parseInt(link.substring(1)));
          $('#progress').html(parseInt(link.substring(1)));

          let fadeInInterval = setInterval(() => {
            if (body.style.opacity < 1) {
              body.style.opacity = parseFloat(body.style.opacity) + 0.1;
            } else {
              clearInterval(fadeInInterval);
            }
          }, duration / 10);
        }
      }, duration / 10);
    }
    else{
      $('div#'+(parseInt(link.substring(1))-1)+' > div.marginLR > p.danger').removeClass('hidden');
    }
  }

  $(document).ready(function(){
    $('#progress').attr('max', parseInt($('.section').last().attr('id'))+1);

    $('div.container').on('mousewheel',function(event){
        return false;
    });

    $('div.container').on('scroll',function(event){
        return false;
    });

    document.addEventListener('keydown', function(event) {
      const currentSectionId = location.hash.substring(1);

      if (event.code === 'Enter') {
        if(checkRequired(currentSectionId)){
          const currentSection = document.getElementById(currentSectionId);
          const nextSection = currentSection.nextElementSibling;
          if (nextSection) {
            fadeOutIn(`#${nextSection.id}`, 400);
          }
        };
      }
    });
  });
</script>