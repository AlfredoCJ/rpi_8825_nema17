import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Rpi8825Nema {
	public static void unMotor() throws Exception {
		// Asigno los valores iniciales
		Pin pinDir = RaspiPin.GPIO_25;
		Pin pinStp = RaspiPin.GPIO_24;
		Pin pinRst = RaspiPin.GPIO_23;
		int numPas = 400;
		int tiempo = 500; // En nanosegundos
		
		GpioController gpio = GpioFactory.getInstance();
		// Habilito pines, Reset lo inicializo a alto y el resto a bajo
		GpioPinDigitalOutput gpioDir = gpio.provisionDigitalOutputPin(pinDir, "Direction", PinState.LOW);
		GpioPinDigitalOutput gpioStp = gpio.provisionDigitalOutputPin(pinStp, "Steep", PinState.LOW);
		gpio.provisionDigitalOutputPin(pinRst, "Reset", PinState.HIGH);
		
		// Giro en sentido antihorario
		gpioDir.high();
		for (int i=0 ; i<numPas ; i++) {
			gpioStp.high();
			Thread.sleep(0, tiempo);
			gpioStp.low();
			Thread.sleep(0, tiempo);
		}
		
		// Giro en sentido horario
		gpioDir.low();
		for (int i=0 ; i<numPas ; i++) {
			gpioStp.high();
			Thread.sleep(0, tiempo);
			gpioStp.low();
			Thread.sleep(0, tiempo);
		}
		// Finalizo
		gpio.shutdown();
	}
	
	public static void dosMotores() throws Exception {
		// Asigno los valores iniciales
		Pin pinDir1 = RaspiPin.GPIO_25;
		Pin pinStp1 = RaspiPin.GPIO_24;
		Pin pinDir2 = RaspiPin.GPIO_22;
		Pin pinStp2 = RaspiPin.GPIO_21;
		Pin pinRst  = RaspiPin.GPIO_23;
		int numPas  = 400;
		int tiempo  = 500; // En nanosegundos
		
		GpioController gpio = GpioFactory.getInstance();
		// Habilito pines, Reset lo inicializo a alto y el resto a bajo
		GpioPinDigitalOutput gpioDir1 = gpio.provisionDigitalOutputPin(pinDir1, "Direction 1", PinState.LOW);
		GpioPinDigitalOutput gpioDir2 = gpio.provisionDigitalOutputPin(pinDir2, "Direction 2", PinState.LOW);
		GpioPinDigitalOutput gpioStp1 = gpio.provisionDigitalOutputPin(pinStp1, "Steep 1", PinState.LOW);
		GpioPinDigitalOutput gpioStp2 = gpio.provisionDigitalOutputPin(pinStp2, "Steep 2", PinState.LOW);
		gpio.provisionDigitalOutputPin(pinRst, "Reset", PinState.HIGH);
		
		// Giro en sentido antihorario
		gpioDir1.high();
		gpioDir2.high();
		for (int i=0 ; i<numPas ; i++) {
			gpioStp1.high();
			gpioStp2.high();
			Thread.sleep(0, tiempo);
			gpioStp1.low();
			gpioStp2.low();
			Thread.sleep(0, tiempo);
		}
		
		// Giro en sentido horario
		gpioDir1.low();
		gpioDir2.low();
		for (int i=0 ; i<numPas ; i++) {
			gpioStp1.high();
			gpioStp2.high();
			Thread.sleep(0, tiempo);
			gpioStp1.low();
			gpioStp2.low();
			Thread.sleep(0, tiempo);
		}
		// Finalizo
		gpio.shutdown();
	}
	
	public static void main(String[] args) throws Exception {
		//unMotor();
		dosMotores();
	}
}
