import java.util.Scanner;

public class PassageCardRegistration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();

        System.out.println("Digite seu e-mail: ");
        String email = scanner.nextLine();

        System.out.println("Digite seu telefone: ");
        String phone = scanner.nextLine();

        System.out.println("Digite o saldo inicial do seu cartão: ");
        double balance = scanner.nextDouble();

        PassageCard passageCard = new PassageCard(0, name, email, phone, balance);
        System.out.println("Seu cartão de passagem foi cadastrado com sucesso! O número do seu cartão é: " + passageCard.getId());
    }

}
