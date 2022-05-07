import java.util.*;

public class ExercicioArcoiris {
    public static void main(String[] args) {
        System.out.println("Crie uma conjunto contendo as cores do arco-íris:");
        Set<String> coresDoArcoIris = new HashSet<>(getCoresArcoIris());
        System.out.println("Exiba todas as cores uma em baixo da outra:");
        for (String cor : coresDoArcoIris) {
            System.out.println(cor);
        }
        System.out.println("A quantidade de cores que o arco-íris tem:");
        System.out.println("quantidade :" + coresDoArcoIris.size());
        System.out.println("Exiba as cores em ordem alfabética:");
        Set<String> coresArcoIris2 = new TreeSet<>(coresDoArcoIris);
        System.out.println(coresArcoIris2);
        System.out.println("Exiba as cores na ordem inversa da que foi informada");
        List<String> coresDoArcoIrisList = new ArrayList<>(coresDoArcoIris);
        System.out.println(coresDoArcoIris);
        Collections.reverse(coresDoArcoIrisList);
        System.out.println(coresDoArcoIrisList);
        System.out.println("Exiba todas as cores que começam com a letra ”v”:");
        for (String cor : coresDoArcoIris) {
            if (cor.startsWith("v")) System.out.println(cor);
        }
        System.out.println("Remova todas as cores que não começam com a letra “v”:");
        coresDoArcoIris.removeIf(s -> !s.startsWith("v"));
        System.out.println(coresDoArcoIris);
        System.out.println("Limpe o conjunto:");
        coresDoArcoIris.clear();

        System.out.print("Confira se o conjunto está vazio: ");
        if (coresDoArcoIris.isEmpty()) System.out.println("sim");
        else System.out.println("não");
    }

    private static List<String> getCoresArcoIris() {
        return Arrays.asList(
                "vermelho",
                "laranja",
                "amarelo",
                "verde",
                "azul",
                "anil",
                "violeta"
        );
    }
}
