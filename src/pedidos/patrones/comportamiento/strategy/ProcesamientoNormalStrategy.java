package pedidos.patrones.comportamiento.strategy;

import pedidos.patrones.comportamiento.modelo.EstadoPedido;
import pedidos.patrones.comportamiento.modelo.Pedido;

public class ProcesamientoNormalStrategy implements EstrategiaProcesamientoPedido {
    @Override
    public EstadoPedido definirEstado(Pedido pedido) {
        return EstadoPedido.EN_PREPARACION;
    }

    @Override
    public String generarMensaje(Pedido pedido) {
        return "Procesamiento normal: el pedido " + pedido.getId() +
                " pasa a preparacion para despacho estandar.";
    }
}
