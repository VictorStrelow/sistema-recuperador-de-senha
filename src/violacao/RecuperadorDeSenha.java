public class RecuperadorDeSenha {

    private Comunicador comunicador;

    public RecuperadorDeSenha(Comunicador comunicador) {
        if (comunicador == null) {
            throw new IllegalArgumentException("Comunicador não pode estar vazio!");
        }

        this.comunicador = comunicador;
    }

    private String gerarToken() {
        return String.valueOf(System.currentTimeMillis());
    }

    public void recuperar(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O email não pode estar vazio");
        }

        String token = gerarToken();
        String link = "https://techstore.com/reset?token=" + token;
        String msg = "Clique no link para resetar sua senha: " + link;
        comunicador.enviar(msg);
    }

}