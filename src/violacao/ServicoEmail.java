public class ServicoEmail implements Comunicador {

    @Override
    public void enviar(String msg) {
        System.out.println("Enviando pelo Email: " + msg);
    }

}