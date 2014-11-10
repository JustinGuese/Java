import java.awt.event.KeyEvent;


public class Controller {
	private Model model;
	public Controller(Model m) {
		model = m;
	}
	protected void actionOccured(KeyEvent e){
		System.out.println("Controller: "+e.getKeyChar());
	}
	protected void upPushed(){
		model.movePlayerUp();
	}
	protected void downPushed(){
		model.movePlayerDown();
	}
}
