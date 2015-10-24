package view;

import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer {
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	@Override
	public void update(Observable o, Object message) {
		printMessage((String) message);
	}

}
