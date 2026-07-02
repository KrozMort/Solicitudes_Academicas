package pedidos.patrones.comportamiento.observer;

import pedidos.patrones.comportamiento.modelo.Pedido;

public class PanelVentas implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido, String evento) {
        System.out.println("[Observer - Panel] Se actualiza el panel de ventas con el pedido " +
                pedido.getId() + " -> " + pedido.getEstado());
    }
}
