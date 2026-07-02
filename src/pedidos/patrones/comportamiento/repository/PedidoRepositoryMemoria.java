package pedidos.patrones.comportamiento.repository;

import pedidos.patrones.comportamiento.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepositoryMemoria implements PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void guardar(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public List<Pedido> listar() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public Pedido buscarPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Pedido pedidoActualizado) {
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getId() == pedidoActualizado.getId()) {
                pedidos.set(i, pedidoActualizado);
                return;
            }
        }
    }
}
