package streamTypes;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapAndReduce {
    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var numbers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var numbers3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var n = List.of(numbers, numbers2, numbers3);

        //Calcula a soma dos valores de uma lista usando reduce (Não totalmente funcional)
        var sum = numbers.stream().reduce((a, b) -> {
            System.out.print("Estado Atual (a): " + a + ", ");
            System.out.println("Próximo a ser comparado (b): " + b);
            return a + b;
        });

        //Calcula a soma dos valores de uma lista usando mapToInt (Totalmente funcional)
        var sum1 = numbers.stream().mapToInt(integer -> integer).sum();

        //Resultado das somas
        sum.ifPresent(integer -> System.out.println("Resultado do reduce: " + integer));
        System.out.println("Resultado do reduce: " + sum1);

        //Conversão de uma lista de listas em uma unica lista utilizando flatMap
        var result = n.stream().flatMap(List::stream).collect(Collectors.toList());

        System.out.println("Quantidade de listas: " + n.size());
        System.out.println("Quantidade de valores da lista após união: " + result.size());
    }
}
