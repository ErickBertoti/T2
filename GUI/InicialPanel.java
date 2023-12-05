package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InicialPanel extends JPanel {
    private AppFrame frame;
    private JButton alunosBtn; 

    public InicialPanel(AppFrame appFrame) {
        frame = appFrame;

        alunosBtn = new JButton("Alunos");  
        alunosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListaAlunos(); 
            }
        });
        add(alunosBtn);
    }
}

