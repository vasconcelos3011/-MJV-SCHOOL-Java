import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ContaCorrente {
    public static Scanner sc = new Scanner(System.in);

    static Double saldoConta = 1750.62;
    Long agenciaConta = 6451L;
    Long numeroConta = 45596L;
    String nomeCliente = "Maria";
    LocalDate dataNascimento = LocalDate.parse("1965-02-25");


    // Criação do array de extratos com valor e data
    static ArrayList<ExtratosAntigos> listaExtratos = new ArrayList<ExtratosAntigos>(){
        {
            // adicionando os extratos antigos no array            
            add(new ExtratosAntigos(0, 500.15, LocalDate.parse("2019-03-10")));
            add(new ExtratosAntigos(1, 200.56, LocalDate.parse("2019-11-30")));
            add(new ExtratosAntigos(2, 1000.34, LocalDate.parse("2020-04-30")));
            add(new ExtratosAntigos(3, 2000.00, LocalDate.parse("2021-05-15")));
            add(new ExtratosAntigos(4, 1460.55, LocalDate.parse("2022-12-11")));

            // criando uma variável de texto com a atual
            //String dataTexto = new Date().toString();
            add(new ExtratosAntigos(5, saldoConta, LocalDate.now()));      
    
        }
    };

    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        System.out.println("Para realizar alguma ação, pressione o número da mesma\n");
        System.out.println(
            "Pressione 1 para sacar um valor\n" +
            "Pressione 2 para realizar uma transferência\n" +
            "Pressione 3 para cancelar a conta com uma justificativa\n" +
            "Pressione 4 para consultar o extrato entre duas datas\n" +
            "Pressione 5 para consultar o saldo atual"
        );
        int selecao = sc.nextInt();

        switch (selecao){
            case 1:
                sacarValor();
            case 2:
                trasnferirValor();
            case 3:
                cancelarContaComJustificativa();
            case 4:
                consultarExtrato();
            case 5:
                consultarSaldo();
            default:
                System.out.println("Digite um dos valores selecionados");
                inicio();
        }
    }

    public static void sacarValor(){
        
    }

    public static void trasnferirValor(){

    }

    public static void cancelarContaComJustificativa(){

    }

    public static void consultarExtrato(){
        sc.nextLine();
        // obtendo as datas para filtrar
        System.out.println("Digite a primeira data em formato yyyy-mm-dd");
        String valor1 = sc.nextLine();
        System.out.println("Digite a segunda data em formato yyyy-mm-dd");
        String valor2 = sc.nextLine();

        // passando por cada data dos extratos para verificação
        for (int i = 0; i < listaExtratos.size(); i++){;
            LocalDate data1 = LocalDate.parse(valor1);
            LocalDate data2 = LocalDate.parse(valor2);

            if (listaExtratos.get(i).data.compareTo(data1) > 0 && listaExtratos.get(i).data.compareTo(data2) < 0) {
                System.out.printf("Data: "+ listaExtratos.get(i).data + ", Valor: %.2f\n", listaExtratos.get(i).valor);
            }      
        }

        inicio();
    }

    public static void consultarSaldo(){
        sc.nextLine();
        System.out.printf("Seu saldo é %.2f reais\n\n", saldoConta);
        inicio();
    }

}