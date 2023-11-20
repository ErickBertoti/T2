package GUI;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class AppFrame extends JFrame {

    public AppFrame(){

        setTitle("Cadastro de Estudantes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
        setLayout(null);

         JButton botaoCriar = new JButton("Criar Cadastro");
        botaoCriar.setBounds(100, 200, 250, 70);
         add(botaoCriar);

         JButton botaoEditar = new JButton("Editar Cadastro");
        botaoEditar.setBounds(100, 200, 250, 70);
         add(botaoEditar);

         JButton botaoDeletar = new JButton("Deletar Cadastro");
        botaoDeletar.setBounds(100, 200, 250, 70);
         add(botaoDeletar);




       
    }
    
}
