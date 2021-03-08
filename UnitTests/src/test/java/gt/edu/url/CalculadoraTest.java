package gt.edu.url;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest
{
    @Test
    public void probarSuma()
    {
        //Esperado
        double esperado = 25.0;
        //Ejecutar y obtener
        var calculadora = new Calculadora();
        double obtenido = calculadora.sumar(5.0, 20.0);
        //Comparar esperado vs obtenido
        assertEquals(esperado, obtenido);
    }
}
