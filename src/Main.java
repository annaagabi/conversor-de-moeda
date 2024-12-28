import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        String moedaOrigem = "";
        String moedaDestino = "";


        BuscarValor consultaValor = new BuscarValor();
        System.out.println("************************\nEscolha a moeda de origem\n************************\n1 - Dólar\n2 - Peso Argentino\n3 - Real\n4 - Peso Chileno\n5 - Boliviano da Bolívia\n6 - Peso Colombiano");
        int moeda1 = leitura.nextInt();

        System.out.println("************************\nEscolha a moeda de destino\n************************\n1 - Dólar\n2 - Peso Argentino\n3 - Real\n4 - Peso Chileno\n5 - Boliviano da Bolívia\n6 - Peso Colombiano");
        int moeda2 = leitura.nextInt();

        System.out.println("Digite o valor a ser convertido");
        double valor = leitura.nextDouble();

        if(moeda1 == moeda2){
            System.out.println("As moedas de origem e destino são iguais, não é possível fazer a conversão para a mesma moeda!");

        } else if (moeda1 < 1 || moeda1 > 6 || moeda2 < 1 || moeda2 > 6) {
            System.out.println("Opção de moeda inválida. Finalizando aplicação.");
            return;

        }
        else{
            switch(moeda1){
                case 1:
                    moedaOrigem = "USD";
                    break;

                case 2:
                    moedaOrigem = "ARS";
                    break;

                case 3:
                    moedaOrigem = "BRL";
                    break;

                case 4:
                    moedaOrigem = "CLP";
                    break;

                case 5:
                    moedaOrigem = "BOB";
                    break;

                case 6:
                    moedaOrigem = "COP";
                    break;
            }

            switch(moeda2){
                case 1:
                    moedaDestino= "USD";
                    break;

                case 2:
                    moedaDestino= "ARS";
                    break;

                case 3:
                    moedaDestino= "BRL";
                    break;

                case 4:
                    moedaDestino= "CLP";
                    break;

                case 5:
                    moedaDestino= "BOB";
                    break;

                case 6:
                    moedaDestino= "COP";
                    break;
            }

        }

        try{
            double resultado = BuscarValor.converter(moedaOrigem, moedaDestino, valor);
            System.out.printf("O valor convertido é: %.2f %s%n", resultado, moedaDestino);

        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage() +"\nFinalizando a aplicação!");
        }

    }
}