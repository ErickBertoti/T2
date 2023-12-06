import javax.swing.SwingUtilities;

import resources.src.GUI.AppFrame;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Rodar();
			}
		});
	}

        private static void Rodar() {
            AppFrame frame = new AppFrame();    
            
            frame.mostrar();
    }



} 

