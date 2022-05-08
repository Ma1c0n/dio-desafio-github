import java.util.*;

public class ExercicioEstadoEPopulacao {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Crie um dicionário e relacione os estados e sua populações:");
        Map<String, Integer> estadosMap = estadosLista();

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Substitua a população do estado do RN por 3.534.165:");
        estadosMap.put("RN", 3_534_165);
        System.out.println(estadosMap);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277:");
        Map<String, Integer> estadosMap2 = estadosLista();
        if (!estadosMap2.containsKey("PB")) estadosMap2.put("PB", 4_039_277);
        System.out.println(estadosMap2);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Exiba a população PE:");
        System.out.println("população do PE = " + estadosMap.get("PE"));

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado:");
        Map<String, Integer> estadosMap3 = new LinkedHashMap<>() {{
            put("PE", 9_616_621);
            put("AL", 3_351_543);
            put("CE", 9_187_103);
            put("RN", 3_534_265);
        }};
        System.out.println(estadosMap3);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Exiba os estados e suas populações em ordem alfabetica:");
        Map<String, Integer> estadosMap4 = new TreeMap<>(estadosLista());
        System.out.println(estadosMap4);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Exiba o estado com o menor população e sua quantidade:");
        Integer menorPopulacao = Collections.min(estadosLista().values());
        String estadoQueTemMenorPopulacao = "";
        for (Map.Entry<String, Integer> estado : estadosLista().entrySet()) {
            if (Objects.equals(estado.getValue(), menorPopulacao)) estadoQueTemMenorPopulacao = estado.getKey();
        }
        System.out.println(estadoQueTemMenorPopulacao + "=" + menorPopulacao);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Exiba o estado com a maior população e sua quantidade:");
        Integer maiorPopulacao = Collections.max(estadosLista().values());
        String estadoQueTemMaiorPopulacao = "";
        for (Map.Entry<String, Integer> estado : estadosLista().entrySet()) {
            if (Objects.equals(estado.getValue(), maiorPopulacao)) estadoQueTemMaiorPopulacao = estado.getKey();
        }
        System.out.println(estadoQueTemMaiorPopulacao + "=" + maiorPopulacao);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Exiba a soma da população desses estados:");
        Collection<Integer> populacaoLista = estadosLista().values();
        int somaPopulacao = 0;
        for (Map.Entry<String, Integer> estado : estadosLista().entrySet()) {
            somaPopulacao += estado.getValue();
        }
        System.out.println("resultado da soma : " + somaPopulacao);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Exiba a média da população deste dicionário de estados:");
        int mediaPopulacao = somaPopulacao / estadosLista().size();
        System.out.println("resultado da media : " + mediaPopulacao);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Remova os estados com a população menor que 4.000.000:");
        Map<String, Integer> estados5 = estadosLista();
        Iterator<Integer> iterator = estados5.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4_000_000) iterator.remove();
        }
        System.out.println(estados5);
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Apague o dicionário de estados:");
        Map<String, Integer> estados6 = estadosLista();
        estados6.clear();
        System.out.println(estados6);

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Confira se o dicionário está vazio");
        if (estados6.isEmpty()) {
            System.out.println("Esta vazio");
        } else {
            System.out.println("Não esta Vazio");
        }
    }

    private static HashMap<String, Integer> estadosLista() {
        HashMap<String, Integer> estadosMap = new HashMap<>();
        estadosMap.put("PE", 9_616_621);
        estadosMap.put("AL", 3_351_543);
        estadosMap.put("CE", 9_187_103);
        estadosMap.put("RN", 3_534_265);
        return estadosMap;
    }
}
