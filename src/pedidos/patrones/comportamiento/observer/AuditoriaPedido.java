package pedidos.patrones.comportamiento.observer;

import pedidos.patrones.comportamiento.modelo.Pedido;

public class AuditoriaPedido implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido, String evento) {
        System.out.println("[Observer - Auditoria] Pedido " + pedido.getId() +
                " registrado en bitacora. Evento: " + evento);
    }
}
