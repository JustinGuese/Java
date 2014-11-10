



public class GameRunner extends Thread {
	private Model model;
	public GameRunner(Model m){
		model = m;
	}
	@Override
	public void run() {
		while(true){
			model.posUp();
			model.refreshPane();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
