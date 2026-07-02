package pedidos.patrones.comportamiento.strategy;

import pedidos.patrones.comportamiento.modelo.EstadoPedido;
import pedidos.patrones.comportamiento.modelo.Pedido;

public interface EstrategiaProcesamientoPedido {
    EstadoPedido definirEstado(Pedido pedido);
    String generarMensaje(Pedido pedido);
}
