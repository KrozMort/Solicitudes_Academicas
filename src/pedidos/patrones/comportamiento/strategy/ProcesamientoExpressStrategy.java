package pedidos.patrones.comportamiento.strategy;

import pedidos.patrones.comportamiento.modelo.EstadoPedido;
import pedidos.patrones.comportamiento.modelo.Pedido;

public class ProcesamientoExpressStrategy implements EstrategiaProcesamientoPedido {
    @Override
    public EstadoPedido definirEstado(Pedido pedido) {
        return EstadoPedido.ENVIADO;
    }

    @Override
    public String generarMensaje(Pedido pedido) {
        return "Procesamiento express: el pedido " + pedido.getId() +
                " se marca como prioridad y se envia inmediatamente.";
    }
}
