import java.util.*;

public class ExercicioLinguagemFavorita {
    public static void main(String[] args) {

        Set<LinguagemFavorita> minhasLinguagensFavoritas = new HashSet<>(getLinguagensFavoritas());

        System.out.println("Ordem de Inserção:");
        Set<LinguagemFavorita> minhasLinguagensFavoritas2 = new LinkedHashSet<>(getLinguagensFavoritas());
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritas2) System.out.println(linguagem);

        System.out.println("Ordem Natural (nome):");
        Set<LinguagemFavorita> minhasLinguagensFavoritas3 = new TreeSet<>(minhasLinguagensFavoritas);
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritas3) System.out.println(linguagem);

        System.out.println("Ordem IDE:");
        Set<LinguagemFavorita> minhasLinguagensFavoritas4 = new TreeSet<>(new ComparatorIde());
        minhasLinguagensFavoritas4.addAll(minhasLinguagensFavoritas);
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritas4) System.out.println(linguagem);

        System.out.println("Ordem Ano de Criacao e Nome:");
        Set<LinguagemFavorita> minhasLinguagensFavoritas5 = new TreeSet<>(new ComparatorAnoCriadoENome());
        minhasLinguagensFavoritas5.addAll(minhasLinguagensFavoritas);
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritas5) System.out.println(linguagem);

        System.out.println("Ordem Nome - Ano de Criacao - IDE:");
        Set<LinguagemFavorita> minhasLinguagensFavoritas6 = new TreeSet<>(new ComparatorNomeEAnoCriadoEIde());
        minhasLinguagensFavoritas6.addAll(minhasLinguagensFavoritas4);
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritas6) System.out.println(linguagem);

    }

    private static List<LinguagemFavorita> getLinguagensFavoritas() {
        return Arrays.asList(
                new LinguagemFavorita("Kotlin", 2011, "Intellij"),
                new LinguagemFavorita("JavaScript", 1995, "Visual Studio Code"),
                new LinguagemFavorita("Java", 1991, "NetBeans")
        );
    }

    static class LinguagemFavorita implements Comparable<LinguagemFavorita> {
        public String nome;
        public Integer anoCriado;
        public String ide;

        public LinguagemFavorita(String nome, Integer anoCriado, String ide) {
            this.nome = nome;
            this.anoCriado = anoCriado;
            this.ide = ide;
        }

        @Override
        public String toString() {
            return "LinguagemFavorita{" +
                    "nome='" + nome + '\'' +
                    ", anoCriado=" + anoCriado +
                    ", ide='" + ide + '\'' +
                    '}';
        }

        @Override
        public int compareTo(LinguagemFavorita linguagemFavorita) {
            return this.nome.compareTo(linguagemFavorita.nome);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            LinguagemFavorita that = (LinguagemFavorita) obj;
            return nome.equals(that.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome);
        }
    }

    static class ComparatorIde implements Comparator<LinguagemFavorita> {
        @Override
        public int compare(LinguagemFavorita linguagemFavorita1, LinguagemFavorita linguagemFavorita2) {
            return linguagemFavorita1.ide.compareToIgnoreCase(linguagemFavorita2.ide);
        }
    }

    static class ComparatorAnoCriadoENome implements Comparator<LinguagemFavorita> {
        @Override
        public int compare(LinguagemFavorita linguagemFavorita1, LinguagemFavorita linguagemFavorita2) {
            int anoDeCriacao = Integer.compare(linguagemFavorita1.anoCriado, linguagemFavorita2.anoCriado);
            if (anoDeCriacao != 0) return anoDeCriacao;
            return linguagemFavorita1.nome.compareToIgnoreCase(linguagemFavorita2.nome);
        }
    }

    static class ComparatorNomeEAnoCriadoEIde implements Comparator<LinguagemFavorita> {
        @Override
        public int compare(LinguagemFavorita linguagemFavorita1, LinguagemFavorita linguagemFavorita2) {
            int nome = linguagemFavorita1.nome.compareToIgnoreCase(linguagemFavorita1.nome);
            int anoDeCriacao = Integer.compare(linguagemFavorita1.anoCriado, linguagemFavorita1.anoCriado);
            if (nome != 0) return nome;
            if (anoDeCriacao != 0) return anoDeCriacao;
            return linguagemFavorita1.ide.compareToIgnoreCase(linguagemFavorita1.ide);
        }
    }
}