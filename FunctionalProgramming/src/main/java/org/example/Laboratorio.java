package org.example;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Laboratorio
{
    public static List<Integer> createRandomList(int qty)
    {
        var random = new Random();
        List<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < qty; i++)
        {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    public static boolean isPrimeNumber(int n)
    {
        if(n <= 1)
        {
            return false;
        }

        var contador = 0;

        for (int i = n - 1; i > 1; i--)
        {
            if(n % i == 0)
                contador++;
        }

        return contador <= 0;
    }

    public static BigInteger fibonacci(int n)
    {
        BigInteger p1 = BigInteger.valueOf(0);
        BigInteger p2 = BigInteger.valueOf(1);
        BigInteger ans = BigInteger.valueOf(1);

        for (int i = 1; i < n; i++)
        {
            ans = p1.add(p2);
            p1 = p2;
            p2 = ans;
        }
        return ans;
    }

    public static void main(String args[])
    {
        System.out.println("Calculando Primos...");

        var value = Integer.valueOf(args[0]);

        var listadoPrimos =
                createRandomList(value).parallelStream()
                .filter(n -> isPrimeNumber(n))
                .sorted()
                .collect(Collectors.toList());

        //System.out.println("Numeros primos: " + listadoPrimos);

        System.out.println("Calculando Fibonacci...");

        var listadoFibonacci =
                listadoPrimos.parallelStream()
                .map(n -> fibonacci(n))
                .collect(Collectors.toList());

        System.out.println("Calculo Finalizado");
        //System.out.println("Resultado Fibonacci: " + listadoFibonacci);
    }
}
