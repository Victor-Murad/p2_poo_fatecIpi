import java.sql.PreparedStatement;

public class MusicaDAO {
    public void cadastrar(Musica musica) throws Exception{
        String sql = "INSERT INTO tb_musica(titulo) VALUES(?)";
        var conexao = ConnectionFactory.conectar();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, musica.getTitulo());
        ps.execute();
        ps.close();
        conexao.close();
    }
}
