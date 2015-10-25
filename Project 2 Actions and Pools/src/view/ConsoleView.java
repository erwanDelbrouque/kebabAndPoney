package view;

import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer {

	public void printlnMessage(String message) {
		if(!message.isEmpty()) {
			System.out.println(message);
		}
	}

	@Override
	public void update(Observable o, Object message) {
		printlnMessage((String) message);
	}

}
