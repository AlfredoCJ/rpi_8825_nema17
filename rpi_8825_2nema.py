import RPi.GPIO as GPIO
import time

# Variables y constantes
pinDir1=26
pinStp1=19
pinDir2=6
pinStp2=5
pinAct=13
numPas=400
tiempo=0.001

# Establecemos direcciones de los pines a usar
GPIO.setmode(GPIO.BCM)
GPIO.setup(pinDir1, GPIO.OUT)
GPIO.setup(pinStp1, GPIO.OUT)
GPIO.setup(pinDir2, GPIO.OUT)
GPIO.setup(pinStp2, GPIO.OUT)
GPIO.setup(pinAct,  GPIO.OUT)

# Hacemos giro en sentido antihorario
GPIO.output(pinDir1, GPIO.HIGH)
GPIO.output(pinDir2, GPIO.HIGH)
for i in range(0,numPas):
    GPIO.output(pinStp1, GPIO.HIGH)
    GPIO.output(pinStp2, GPIO.HIGH)
    time.sleep(tiempo)
    GPIO.output(pinStp1, GPIO.LOW)
    GPIO.output(pinStp2, GPIO.LOW)
    time.sleep(tiempo)

# Hacemos giro en sentido horario
GPIO.output(pinDir1, GPIO.LOW)
GPIO.output(pinDir2, GPIO.LOW)
for i in range(0,numPas):
    GPIO.output(pinStp1, GPIO.HIGH)
    GPIO.output(pinStp2, GPIO.HIGH)
    time.sleep(tiempo)
    GPIO.output(pinStp1, GPIO.LOW)
    GPIO.output(pinStp2, GPIO.LOW)
    time.sleep(tiempo)

GPIO.cleanup()

