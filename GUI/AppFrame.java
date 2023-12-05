package GUI;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AppFrame extends JFrame {

    public AppFrame(){
        

        setTitle("Cadastro de Estudantes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
        setLayout(null);

         JButton botaoCriar = new JButton("Criar Cadastro");
         botaoCriar.setBounds(600, 20, 200, 30);
         add(botaoCriar);


         botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ao clicar no botão, instancia e exibe o formulário de cadastro
                new FormularioCadastro().setVisible(true);
            }
        });

         JButton botaoEditar = new JButton("Editar Cadastro");
         botaoEditar.setBounds(800, 20, 200, 30);
         add(botaoEditar);

         JButton botaoDeletar = new JButton("Deletar Cadastro");
         botaoDeletar.setBounds(1000, 20, 200, 30);
         add(botaoDeletar);




       setVisible(true);
    }

}
