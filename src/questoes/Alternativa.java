package questoes;

/**
 *
 * @author Gustavo B. Paulus, Iulisloi Zacarias, Rafael A. Vitalli
 */
public class Alternativa {
    
    private String texto;
    private String correta;
    private String resposta;

    public Alternativa(String texto, String correta) {
        this.texto = texto;
        this.correta = correta;
    }

    public String getTexto() {
        return texto;
    }

    public String getCorreta() {
        return correta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
}
