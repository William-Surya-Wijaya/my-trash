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

      <div class="section" id="0" style="animation: scroll-animation 2s;">
        <div class="marginLR">
          <div class="title-text">VALORANT - Fun Match !</div>
          <div class="desc-text">By ACT Discord Admins (No Fee, Have Fun !)</div>
          <a onclick="fadeOutIn('#1',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
        </div>
      </div>

      <div class="section" id="1" style="animation: scroll-animation 2s;">
        <div class="marginLR">
          <div class="title-text">Hi Everyone, here is the registration form for Valorant Fun Match that hosted by the ACT Discord Admin !</div>
          <a onclick="fadeOutIn('#2',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span><i class="fa fa-check-circle-o" aria-hidden="true"></i></a>
        </div>
      </div>

      <div class="section" id="2" style="animation: scroll-animation 2s;">
        <div class="marginLR">
          <div class="title-text">The following are the terms and conditions that you can access via the link below.</div>
          <div class="desc-text"><a style="text-decoration:underline; color:#b4b1a2;" onclick="javascript:window.open('https://act.marcellino.my.id')">https://act.marcellino.my.id</a></div>
          <a onclick="fadeOutIn('#3',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span><i class="fa fa-check-circle-o" aria-hidden="true"></i></a>
        </div>
      </div>

      <div class="section" id="3" style="animation: scroll-animation 2s;">
        <div class="marginLR">
          <div class="title-text">By filling out this form, you agree to the existing rules, conditions and requirements.</div>
          <a onclick="fadeOutIn('#4',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span><i class="fa fa-check-circle-o" aria-hidden="true"></i></a>
        </div>
      </div>

      <div class="section" id="4" style="animation: scroll-animation 2s;">
        <div class="marginLR">
          <div class="title-text">Enter your team name ! (*)</div>
          <div class="desc-text">(Please do not contain inappropriate words)</div>
          <input type="text" class="input-field required" id="teamName" onchange="dangerCheck(this)"/>
          <p class="danger hidden">Please fill this in</p>
          <a onclick="fadeOutIn('#5',300)"><span class="button">Continue</span><span class="button-helper">press <b>Enter</b></span></a>
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