public class ServicoMensagem implements Comunicador {

    @Override
    public void enviar(String msg) {
        System.out.println("Enviando por Mensagem: " + msg);
    }

}