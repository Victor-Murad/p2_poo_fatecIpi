import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import static java.lang.Integer.parseInt;

public class GerenciaMusicas {
    public static void main(String[] args) {
        var musicaDAO = new MusicaDAO();
    int op = -1;
    String menu = "1-Cadastrar música\n2-Avaliar Música\n3-Listar Músicas\n4-Remover Música\n0-Sair";
    do {
      try {
        op = parseInt(showInputDialog(menu));
        switch (op) {
            case 1: {
              String titulo = showInputDialog("Titulo?");
              var musica = new Musica(titulo, 0);
              musicaDAO.cadastrar(musica);
              showMessageDialog(null, "Música cadastrada!");
              break;
            }
            case 2: {
              String titulo = showInputDialog("Titulo?");
              int nota = parseInt(showInputDialog("Nota?"));
              musicaDAO.avaliar(new Musica(titulo, nota));
              showMessageDialog(null, "Música avaliada!!");
              break;
            }
            case 3: {
              musicaDAO.listar();
              break;
            }
            case 4: {
              String titulo = showInputDialog("Digite o título da música que será excluída.");
              musicaDAO.desativar(titulo);
              JOptionPane.showMessageDialog(null, "Música " + titulo + " excluída com sucesso!");
              break;
            }
            case 0:
            showMessageDialog(null, "Até logo");
            break;
          default:
            showMessageDialog(null, "Opção inválida");
            break;
        }
    } catch (Exception e) {
        e.printStackTrace();
        showMessageDialog(null, "Não rolou");
      }
    } while (op != 0);
}
}