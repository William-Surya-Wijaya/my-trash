<!DOCTYPE html>

<?php

    session_start();

?>

<html>
    <frameset rows="100px,*" framespacing="0">
        <frame noresize src="heading_page.php" frameborder="0"></frame>
        <frameset cols="10%,*" framespacing="0">
            <frame noresize src="nav_page.html" frameborder="0"></frame>
            <frame noresize src="home_page.html" name="web-content" frameborder="0"></frame>
        </frameset>
    </frameset>
</html>