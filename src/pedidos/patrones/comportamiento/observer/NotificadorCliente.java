package pedidos.patrones.comportamiento.observer;

import pedidos.patrones.comportamiento.modelo.Pedido;

public class NotificadorCliente implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido, String evento) {
        System.out.println("[Observer - Cliente] Mensaje para " + pedido.getCliente() +
                ": " + evento + ". Estado actual: " + pedido.getEstado());
    }
}
