import java.util.*;

public class ExercicioTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomeDosMeses = new String[]{"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho"};
        int numeroDeMeses = nomeDosMeses.length;
        List<TemperaturaMensal> temperaturaMensalLista = new ArrayList<>();

        for (int i = 0; i < numeroDeMeses; i++) {
            String mes = nomeDosMeses[i];
            System.out.print("Temperatura do mês de " + mes + " = ");
            float temperatura = scanner.nextFloat();
            TemperaturaMensal temperaturaMensal = new TemperaturaMensal(mes, temperatura);
            temperaturaMensalLista.add(temperaturaMensal);
        }

        List<TemperaturaMensal> temperaturaAcimaDaMediaLista = pegarTemperaturasAcimaDaMedia(temperaturaMensalLista);

        if (temperaturaAcimaDaMediaLista.size() == 0) {
            System.out.println("Nenhuma temperatura acima da media!");
        } else {
            for (int i = 0; i < temperaturaAcimaDaMediaLista.size(); i++) {
                TemperaturaMensal temperaturaMensal = temperaturaAcimaDaMediaLista.get(i);
                System.out.print(i + 1 + " - " + temperaturaMensal.getMes() + ", ");
            }
        }
    }

    private static List<TemperaturaMensal> pegarTemperaturasAcimaDaMedia(List<TemperaturaMensal> temperaturaMensalList) {
        List<TemperaturaMensal> temperaturaAcimaDaMediaLista = new ArrayList<>();
        int numeroDeMeses = temperaturaMensalList.size();
        float soma = 0f;
        float media = 0f;
        Iterator<TemperaturaMensal> iterator = temperaturaMensalList.iterator();
        while (iterator.hasNext()) {
            float next = iterator.next().getTemperatura();
            soma += next;
        }
        media = soma / numeroDeMeses;


        for (int i = 0; i < numeroDeMeses; i++) {
            TemperaturaMensal temperaturaMensal = temperaturaMensalList.get(i);
            if (temperaturaMensal.getTemperatura() > media)
                temperaturaAcimaDaMediaLista.add(temperaturaMensal);
        }
        return temperaturaAcimaDaMediaLista;
    }
}

class TemperaturaMensal {
    private final String mes;
    private final float temperatura;

    public TemperaturaMensal(String mes, float temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return mes;
    }

    public float getTemperatura() {
        return temperatura;
    }
}

