package Bounded;

public class Main {

	public static void main(String[] args) {
		Tray tray = new Tray();
		tray.add(new Glass<Juice>());
		tray.add(new Glass<OrangeJuice>());
		tray.add(new Glass<String>());
	}
}
