package controller;

import br.com.ProjP2Java.Main;
import br.com.ProjP2Java.model.Carro;
import br.com.ProjP2Java.service.CarroService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class CarroControllerTest {

    @Autowired
    private CarroService carroService;

    @Test
    public void save() throws Exception {

        long qtd = 1234;

        carroService.deleteAll();

        File carrosCSV = new File("C:\\Users\\Deeniisz\\Documents\\modelos-carro.csv");

        try {
            Scanner leitor = new Scanner(carrosCSV);
            new String();
            leitor.nextLine();

            while (leitor.hasNext()) {
                String linhasDoArquivo = leitor.nextLine();
                String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
                carroService.sendProductRabbit(new Carro(valoresEntreVirgulas[0], valoresEntreVirgulas[1], valoresEntreVirgulas[2]));
            }
        } catch (FileNotFoundException var5) {
        }
        Thread.sleep(5000);

        Optional<Carro> lst;
        for (int i = 0; i <= 1234; i++) {
            lst = carroService.findById(String.valueOf(i));

        }
    }
}
