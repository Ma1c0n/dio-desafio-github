import java.util.*;

public class ExercicioLancamentoDados {
    public static void main(String[] args) {
        int numeroLancamentos = 100;
        Random random = new Random();
        List<Integer> lancamentosList = new ArrayList<>();
        for (int i = 0; i < numeroLancamentos; i++) {
            lancamentosList.add(random.nextInt(6) + 1);
        }
        Map<Integer, Integer> lancamentosMap = new HashMap<>();
        for (int lancamento : lancamentosList) {
            lancamentosMap.put(lancamento, lancamentosMap.get(lancamento) == null ? lancamento : lancamentosMap.get(lancamento) + 1);
        }
        System.out.println(lancamentosMap);
    }
}
