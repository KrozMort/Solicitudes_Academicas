package pedidos.patrones.comportamiento.observer;

import pedidos.patrones.comportamiento.modelo.Pedido;

public interface ObservadorPedido {
    void actualizar(Pedido pedido, String evento);
}
