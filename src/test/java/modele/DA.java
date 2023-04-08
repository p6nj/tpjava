package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class DA {
    @Test
    public void test() {
        try {
            Process process = Runtime.getRuntime().exec("date +%d/%m/%Y");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            assertEquals(new Date().toString(), reader.readLine());
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
