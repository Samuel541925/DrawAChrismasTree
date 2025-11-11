interface Transporte {
    void entrega();
}

class Camion implements Transporte {
    @Override
    public void entrega() {
        System.out.println("Entrega por carretera");
    }
}

class Barco implements Transporte {
    @Override
    public void entrega() {
        System.out.println("Entrega por mar");
    }
}

abstract class Logistica {
    public abstract Transporte crearTransporte();

    public void planificarEntrega() {
        Transporte t = crearTransporte();
        t.entrega();
    }
}

class LogisticaTerrestre extends Logistica {
    @Override
    public Transporte crearTransporte() {
        return new Camion();
    }
}

class LogisticaMaritima extends Logistica {
    @Override
    public Transporte crearTransporte() {
        return new Barco();
    }
}

public class Main {
    public static void main(String[] args) {
        Logistica logistica1 = new LogisticaTerrestre();
        logistica1.planificarEntrega(); // → Entrega por carretera

        Logistica logistica2 = new LogisticaMaritima();
        logistica2.planificarEntrega(); // → Entrega por mar
    }
}
