package pt.ipp.isep.dei.esoft.project;


public class Main {
    public static void main(String[] args) {
		Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
			pt.ipp.isep.dei.esoft.project.ui.Main.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
