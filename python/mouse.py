import random as rd; import pyautogui as pag; import time;

while True :
    x = rd.randint(600,700);
    y = rd.randint(200,600);
    pag.moveTo(x,y,0.5);
    
    time.sleep(1);