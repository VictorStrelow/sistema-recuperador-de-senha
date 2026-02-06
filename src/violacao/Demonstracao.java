public class Demonstracao {

    public static void main(String[] args) {

        System.out.println("=".repeat(30));
        System.out.println("DEMONSTRAÇÃO FLEXIBILIDADE DIP");
        System.out.println("=".repeat(30));

        String emailUser = "usuario@email.com";
        String telefoneUser = "1111-2222";
        String celularUser = "(47) 91111-2222";

        // EMAIL
        System.out.println("\n Recuperação da Senha por Email");
        System.out.println("-".repeat(30));
        RecuperadorDeSenha recuperadorEmail = new RecuperadorDeSenha(new ServicoEmail());
        recuperadorEmail.recuperar(emailUser);

        // SMS
        System.out.println("\n Recuperação da Senha por SMS");
        System.out.println("-".repeat(30));
        RecuperadorDeSenha recuperadorSMS = new RecuperadorDeSenha(new ServicoSMS());
        recuperadorSMS.recuperar(telefoneUser);

        // MENSAGEM
        System.out.println("\n Recuperação da Senha por Mensagem");
        System.out.println("-".repeat(30));
        RecuperadorDeSenha recuperadorMsg = new RecuperadorDeSenha(new ServicoMensagem());
        recuperadorMsg.recuperar(celularUser);

    }

}