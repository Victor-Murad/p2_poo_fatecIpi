import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Musica{
    private int codigo;
    private final String titulo;
    private final int avaliacao;

    @Override
    public String toString(){
        return String.format("A música se chama %s. A sua nota é %d.", titulo, avaliacao);
    }
}