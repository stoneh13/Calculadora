package cle.curso.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
public class Calculadora {
int sum(int a, int b) {
return a + b;
}

}
