package pedidos.patrones.comportamiento.observer;

import pedidos.patrones.comportamiento.modelo.Pedido;
import pedidos.patrones.comportamiento.repository.PedidoRepository;
import pedidos.patrones.comportamiento.strategy.EstrategiaProcesamientoPedido;
import pedidos.patrones.comportamiento.strategy.ProcesadorPedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProcesadorPedido procesadorPedido;
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public PedidoService(PedidoRepository pedidoRepository, EstrategiaProcesamientoPedido estrategiaInicial) {
        this.pedidoRepository = pedidoRepository;
        this.procesadorPedido = new ProcesadorPedido(estrategiaInicial);
    }

    public void agregarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }

    public void registrarPedido(Pedido pedido) {
        pedidoRepository.guardar(pedido);
        notificar(pedido, "Pedido registrado correctamente");
    }

    public void cambiarEstrategia(EstrategiaProcesamientoPedido estrategia) {
        procesadorPedido.cambiarEstrategia(estrategia);
        System.out.println("[Strategy] Estrategia actual: " + procesadorPedido.obtenerNombreEstrategia());
    }

    public void procesarPedido(int id) {
        Pedido pedido = pedidoRepository.buscarPorId(id);

        if (pedido == null) {
            System.out.println("No existe un pedido con id " + id);
            return;
        }

        String resultado = procesadorPedido.procesar(pedido);
        pedidoRepository.actualizar(pedido);
        System.out.println("[Accion principal] " + resultado);
        notificar(pedido, "Pedido procesado");
    }

    private void notificar(Pedido pedido, String evento) {
        for (ObservadorPedido observador : observadores) {
            observador.actualizar(pedido, evento);
        }
    }
}
