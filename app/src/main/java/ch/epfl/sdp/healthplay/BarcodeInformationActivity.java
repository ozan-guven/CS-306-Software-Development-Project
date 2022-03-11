package ch.epfl.sdp.healthplay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import ch.epfl.sdp.healthplay.model.Product;
import ch.epfl.sdp.healthplay.model.ProductInfoClient;

public class BarcodeInformationActivity extends AppCompatActivity {

    private final AtomicReference<String> productName = new AtomicReference<>("");
    private final AtomicReference<String> energy = new AtomicReference<>("");

    private Thread pullInformation(String barcode) {
        return new Thread(() -> {
            try {
                ProductInfoClient client = new ProductInfoClient(barcode);
                Optional<Product> p = Product.of(client.getInfo());
                if (p.isPresent()) {
                    Product product = p.get();
                    productName.set(product.getName());
                    int value = product.getKCalEnergy();
                    energy.set(value < 0 ? "Unkown" : Integer.toString(value));
                }

            } catch (IOException e) {
                productName.set("Unknown");
                energy.set("Unknown");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_information);

        Intent intent = getIntent();
        String barcode = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Thread t = pullInformation(barcode);
        t.start();
        try {
            t.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        TextView pName = findViewById(R.id.pName);
        pName.setText(productName.get());

        TextView pEnergy = findViewById(R.id.pEnergy);
        pEnergy.setText(energy.get());

    }
}