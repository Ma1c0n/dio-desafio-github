import java.util.Scanner;

public class ExercicioCrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] perguntas = new String[]{
                "Telefonou para a vítima?",
                "Esteve no local do crime?",
                "Mora perto da vítima?",
                "Devia para a vítima?",
                "Já trabalhou com a vítima?"
        };
        int quantosSim = 0;

        for (int i = 0; i < perguntas.length; i++) {
            System.out.print(perguntas[i] + " = ");
            String resposta = scanner.nextLine().toLowerCase();
            if (resposta.equals("sim")) {
                quantosSim++;
            }
        }

        switch (quantosSim) {
            case 2:
                System.out.println("Suspeita");
                break;
            case 3:
            case 4:
                System.out.println("Cúmplice");
                break;
            case 5:
                System.out.println("Assassina");
                break;
            default:
                System.out.println("Inocente");
        }
    }
}