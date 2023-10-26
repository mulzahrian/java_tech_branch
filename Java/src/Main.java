import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Baca file input
            //BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("D:/Test/Java/txt/bank.txt"));

            String line;

            Map<String, StringBuilder> offlineOutputs = new HashMap<>();
            Map<String, StringBuilder> onlineOutputs = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String bankCode = parts[0];
                    String env = parts[2];
                    String status = parts[4];

                    // Buat output untuk setiap bank jika belum ada
                    offlineOutputs.putIfAbsent(bankCode, new StringBuilder("Selamat Siang Rekan Bank " + bankCode + ",\n\nMohon bantuan untuk sign on pada envi berikut :\n"));
                    onlineOutputs.putIfAbsent(bankCode, new StringBuilder("Selamat Siang Rekan Bank " + bankCode + ",\n\nEnvi MP PORT berikut terpantau Online :\n"));

                    if (status.equals(" offline")) {
                        offlineOutputs.get(bankCode).append("- Envi MP PORT ").append(env).append(" terpantau Offline\n");
                    } else if (status.equals(" online")) {
                        onlineOutputs.get(bankCode).append("- Envi MP PORT ").append(env).append(" terpantau Online\n");
                    }
                }
            }

            // Tampilkan output untuk setiap bank
            for (String bankCode : offlineOutputs.keySet()) {
                if (offlineOutputs.get(bankCode).toString().contains("Offline")) {
                    System.out.println(offlineOutputs.get(bankCode).toString());
                } else {
                    System.out.println(onlineOutputs.get(bankCode).toString());
                }
            }

            // Tutup file
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
