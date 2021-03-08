package gt.edu.url;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculadoraTest
{
    Calculadora calculadora;

    @BeforeAll
    public static void startup()
    {
        System.out.println("Inicializador global");
    }

    @BeforeEach
    public void init()
    {
        calculadora = new Calculadora();
        System.out.println("Inicializando test");
    }

    @Test
    public void probarSuma()
    {
        System.out.println("Sumando...");
        assertEquals(25.0, calculadora.sumar(5.0, 20.0));
    }

    @Test
    public void probarResta()
    {
        System.out.println("Restando...");
        assertEquals(30.0, calculadora.restar(50, 20.0));
    }

    @Test
    public void probarMultiplicacion()
    {
        System.out.println("Multiplicando...");
        assertEquals(25.0, calculadora.multiplicar(5.0, 5.0));
    }

    @AfterEach
    public void shutdown()
    {
        System.out.println("Finalizando test");
    }

    @AfterAll
    public static void destroy()
    {
        System.out.println("Finalizacion global");
    }
}
