import javax.crypto.spec.PSource;

public class ServicoSMS implements Comunicador {

    @Override
    public void enviar(String msg) {
        System.out.println("Enviando por SMS: " + msg);
    }

}