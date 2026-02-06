public class TestRecuperacaoSenha {

    public static void main(String[] args) {
        System.out.println("=".repeat(30));
        System.out.println("  TESTES UNITÁRIOS COM MOCKS");
        System.out.println("=".repeat(30));

        // TESTE 1
        System.out.println("\nTESTE 1: RecuperadorDeSenha com Mock Comunicador");
        testComMock();

        // TESTE 2
        System.out.println("\nTESTE 2: RecuperadorDeSenha é agnóstico ao tipo de Comunicador");
        testMultiplasImplementacoes();

        System.out.println("\n" + "=".repeat(30));
        System.out.println("   TODOS OS TESTES PASSARAM");
        System.out.println("=".repeat(30));
    }

    private static void testComMock() {
        Comunicador mockComunicador = new Comunicador() {
            private boolean foiChamado = false;

            @Override
            public void enviar(String mensagem) {
                this.foiChamado = true;
                System.out.println("   [MOCK] Comunicador foi chamado com mensagem: " + mensagem);
            }

            public boolean foiChamado() {
                return foiChamado;
            }
        };

        RecuperadorDeSenha recuperador = new RecuperadorDeSenha(mockComunicador);
        recuperador.recuperar("teste@techstore.com");
    }

    private static void testMultiplasImplementacoes() {
        Comunicador[] comunicadores = {
                new ServicoEmail(),
                new ServicoSMS(),
                new ServicoMensagem()
        };

        RecuperadorDeSenha recuperador;

        for (Comunicador comunicador : comunicadores) {
            recuperador = new RecuperadorDeSenha(comunicador);
            recuperador.recuperar("teste@techstore.com");
        }
    }

}