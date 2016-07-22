import RPi.GPIO as GPIO
import time

# Variables y constantes
pinDir=26
pinStp=19
pinAct=13
numPas=400
tiempo=0.001

# Establecemos direcciones de los pines a usar
GPIO.setmode(GPIO.BCM)
GPIO.setup(pinDir, GPIO.OUT)
GPIO.setup(pinStp, GPIO.OUT)
GPIO.setup(pinAct, GPIO.OUT)

# Hacemos giro en sentido antihorario
GPIO.output(pinDir, GPIO.HIGH)
for i in range(0,numPas):
    GPIO.output(pinStp, GPIO.HIGH)
    time.sleep(tiempo)
    GPIO.output(pinStp, GPIO.LOW)
    time.sleep(tiempo)

# Hacemos giro en sentido horario
GPIO.output(pinDir, GPIO.LOW)
for i in range(0,numPas):
    GPIO.output(pinStp, GPIO.HIGH)
    time.sleep(tiempo)
    GPIO.output(pinStp, GPIO.LOW)
    time.sleep(tiempo)

GPIO.cleanup()
