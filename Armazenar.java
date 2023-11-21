import java.util.ArrayList;

public class Armazenar {

    private ArrayList<Aluno> alunos;
    private static int incremento;


    public Armazenar() {
        this.alunos = new ArrayList<>();
        Armazenar.incremento = 1;
    }
    
    public void inserir(Aluno aluno){
        aluno.setId(Armazenar.incremento++);
        this.alunos.add(aluno);
    }

    public void atualizar(Aluno aluno){
        int index = this.alunos.indexOf(aluno);
        if (index >= 0) {
            this.alunos.set(index, aluno);
        }
    }

    public void remover(Aluno aluno){

    }

    public ArrayList<Aluno> listar(){
        return this.alunos;
    }
}

