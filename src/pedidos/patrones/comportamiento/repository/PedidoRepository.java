package pedidos.patrones.comportamiento.repository;

import pedidos.patrones.comportamiento.modelo.Pedido;
import java.util.List;

public interface PedidoRepository {
    void guardar(Pedido pedido);
    List<Pedido> listar();
    Pedido buscarPorId(int id);
    void actualizar(Pedido pedido);
}
