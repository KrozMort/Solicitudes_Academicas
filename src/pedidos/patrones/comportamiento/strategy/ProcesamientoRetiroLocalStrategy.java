package pedidos.patrones.comportamiento.strategy;

import pedidos.patrones.comportamiento.modelo.EstadoPedido;
import pedidos.patrones.comportamiento.modelo.Pedido;

public class ProcesamientoRetiroLocalStrategy implements EstrategiaProcesamientoPedido {
    @Override
    public EstadoPedido definirEstado(Pedido pedido) {
        return EstadoPedido.LISTO_PARA_RETIRO;
    }

    @Override
    public String generarMensaje(Pedido pedido) {
        return "Retiro en local: el pedido " + pedido.getId() +
                " queda listo para que el cliente lo retire.";
    }
}
