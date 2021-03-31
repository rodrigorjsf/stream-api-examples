package streamTypes;

import java.util.List;

public class FindFirst {
    public static void main(String[] args) {

        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream()
                .filter(n -> n == 9)
                .findFirst()
                .ifPresentOrElse(FindFirst::printCrazy, FindFirst::printError);
    }

    private static void printCrazy(Integer i) {
        System.out.println(i);
    }

    private static void printError() {
        System.out.println("Not found");
    }
}

