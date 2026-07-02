package pedidos.patrones.comportamiento.strategy;

import pedidos.patrones.comportamiento.modelo.EstadoPedido;
import pedidos.patrones.comportamiento.modelo.Pedido;

public class ProcesadorPedido {
    private EstrategiaProcesamientoPedido estrategia;

    public ProcesadorPedido(EstrategiaProcesamientoPedido estrategia) {
        this.estrategia = estrategia;
    }

    public void cambiarEstrategia(EstrategiaProcesamientoPedido estrategia) {
        this.estrategia = estrategia;
    }

    public String procesar(Pedido pedido) {
        EstadoPedido nuevoEstado = estrategia.definirEstado(pedido);
        pedido.setEstado(nuevoEstado);
        return estrategia.generarMensaje(pedido);
    }

    public String obtenerNombreEstrategia() {
        return estrategia.getClass().getSimpleName();
    }
}
