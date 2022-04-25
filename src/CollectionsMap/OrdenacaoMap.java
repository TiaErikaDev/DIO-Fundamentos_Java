package CollectionsMap;

import java.util.*;

public class OrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21",432));
        }};
        for(Map.Entry<String, Livro> Livro : meusLivros.entrySet())
            System.out.println(Livro.getKey() + " - " + Livro.getValue().getNome());


        System.out.println("--\tOrdem inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21",432));
        }};
        for(Map.Entry<String, Livro> Livro : meusLivros1.entrySet())
            System.out.println(Livro.getKey() + " - " + Livro.getValue().getNome());


        System.out.println("--\tOrdem alfabética autores\t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for(Map.Entry<String, Livro> Livro : meusLivros2.entrySet())
            System.out.println(Livro.getKey() + " - " + Livro.getValue().getNome());


        System.out.println("--\tOrdem alfabética livros\t--");

        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> Livro : meusLivros3)
            System.out.println(Livro.getKey() + " - " + Livro.getValue().getNome());


        System.out.println("--\tOrdem natural de paginas\t--");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> Livro : meusLivros4)
            System.out.println(Livro.getKey() + " - " + Livro.getValue().getPaginas());
    }
}
class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';


    }
}
class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{


    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}
class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> p1, Map.Entry<String, Livro> p2) {
        return p1.getValue().getPaginas().compareTo(p2.getValue().getPaginas());
    }
}
