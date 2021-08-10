package com.example.carlist;

import java.util.HashMap;

public class CarroController {
    public Carro[] CARROS = { R34, SUPRA, PORSCHE911, CORVETTE, HUAYRA };
    public HashMap<String, Carro> CARRO_MAP = new HashMap<>();

    public CarroController() {
        for (Carro carro : CARROS) {
            CARRO_MAP.put(String.valueOf(carro.getCodigo()), carro);
        }
    }

    public static final Carro R34 = new Carro(1001, "Skyline R34", 11500.0, 15000.0, R.drawable.r34);
    public static final Carro SUPRA = new Carro(1002, "Supra", 17000.0, 20000.0, R.drawable.supra);
    public static final Carro PORSCHE911 = new Carro(1003, "911 Turbo S", 120500.0, 325000.0, R.drawable.porsche911);
    public static final Carro CORVETTE = new Carro(1004, "Corvette Stingray R34", 50000.0, 55000.0, R.drawable.corvette);
    public static final Carro HUAYRA = new Carro(1005, "Huayra", 1000000.0, 1500000.0, R.drawable.huayra);
}
