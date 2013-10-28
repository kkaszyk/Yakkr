
public class Yakkr {
	private Engine engine;
	private yakkrgui gui;

    public Yakkr()
    {
		engine = new Engine();
		gui = new yakkrgui(engine);
		engine.setGUI(gui);
    }

    static public void main(String[] args) {
    	Yakkr yakkr = new Yakkr();

    }
}
