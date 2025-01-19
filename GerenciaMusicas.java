import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static java.lang.Integer.parseInt;

public class GerenciaMusicas {
    public static void main(String[] args){
        var musicaDAO = new MusicaDAO();
        int op = -1;
        String menu = "1-Cadastrar música\n0-Sair";
        do{
            try{
                op = parseInt(showInputDialog(menu));
                switch (op) {
                    case 1:
                        String titulo = showInputDialog("Título?");
                        var musica = new Musica();
                        musica.setTitulo(titulo);
                        musicaDAO.cadastrar(musica);
                        showMessageDialog(null, "Música cadastrada!");
                        break;
                    case 0:
                    break;
                    default:
                    showMessageDialog(null, "Opção inválida!");
                        break;
                }
            }
            catch(Exception e){
                e.printStackTrace();
                showMessageDialog(null, "Não rolou!");
            }
        }
        while(op != 0);
    }
}
