<?php

  include 'koneksi.php';

  $teamName     = $_POST['teamName'];
  $teamEmail    = $_POST['teamEmail'];
  $teamPhone    = $_POST['teamPhone'];
  $teamPlayer1  = $_POST['teamPlayer1'];
  $teamPlayer2  = $_POST['teamPlayer2'];
  $teamPlayer3  = $_POST['teamPlayer3'];
  $teamPlayer4  = $_POST['teamPlayer4'];
  $teamPlayer5  = $_POST['teamPlayer5'];
  $teamPlayer6  = $_POST['teamPlayer6'];
  $teamRank     = $_POST['teamRank'];

  $query        = "INSERT INTO `vfm_registration` (`team`, `email`, `phone`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `rank`) SET ($teamName, $teamEmail, $teamPhone, $teamPlayer1, $teamPlayer2, $teamPlayer3, $teamPlayer4, $teamPlayer5, $teamPlayer6, $teamRank)"

  $run          = mysqli_query($koneksi, $query);

?>

<script>
  document.referrer ? window.location = document.referrer : history.back()
</script>