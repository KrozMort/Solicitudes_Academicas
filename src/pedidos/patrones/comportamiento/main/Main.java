package pedidos.patrones.comportamiento.main;

import pedidos.patrones.comportamiento.modelo.Pedido;
import pedidos.patrones.comportamiento.observer.AuditoriaPedido;
import pedidos.patrones.comportamiento.observer.NotificadorCliente;
import pedidos.patrones.comportamiento.observer.PanelVentas;
import pedidos.patrones.comportamiento.observer.PedidoService;
import pedidos.patrones.comportamiento.repository.PedidoRepository;
import pedidos.patrones.comportamiento.repository.PedidoRepositoryMemoria;
import pedidos.patrones.comportamiento.strategy.ProcesamientoExpressStrategy;
import pedidos.patrones.comportamiento.strategy.ProcesamientoNormalStrategy;
import pedidos.patrones.comportamiento.strategy.ProcesamientoRetiroLocalStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" SISTEMA DE GESTION DE PEDIDOS");
        System.out.println(" Patrones: Repository, Strategy y Observer");
        System.out.println("==============================================");

        PedidoRepository repository = new PedidoRepositoryMemoria();
        PedidoService pedidoService = new PedidoService(repository, new ProcesamientoNormalStrategy());

        pedidoService.agregarObservador(new NotificadorCliente());
        pedidoService.agregarObservador(new AuditoriaPedido());
        pedidoService.agregarObservador(new PanelVentas());

        System.out.println("\n1) REGISTRO DE DATOS CON REPOSITORY");
        Pedido pedido1 = new Pedido(1, "Ana Torres", "Laptop", 1, 850.00);
        Pedido pedido2 = new Pedido(2, "Luis Vera", "Mouse inalambrico", 2, 34.50);
        Pedido pedido3 = new Pedido(3, "Carla Ruiz", "Teclado mecanico", 1, 75.00);

        pedidoService.registrarPedido(pedido1);
        pedidoService.registrarPedido(pedido2);
        pedidoService.registrarPedido(pedido3);

        System.out.println("\n2) CONSULTA DE DATOS DESDE EL REPOSITORY");
        for (Pedido pedido : repository.listar()) {
            System.out.println(pedido);
        }

        System.out.println("\n3) ACCION PRINCIPAL CON ESTRATEGIA NORMAL");
        pedidoService.procesarPedido(1);

        System.out.println("\n4) CAMBIO DE STRATEGY A PROCESAMIENTO EXPRESS");
        pedidoService.cambiarEstrategia(new ProcesamientoExpressStrategy());
        pedidoService.procesarPedido(2);

        System.out.println("\n5) CAMBIO DE STRATEGY A RETIRO EN LOCAL");
        pedidoService.cambiarEstrategia(new ProcesamientoRetiroLocalStrategy());
        pedidoService.procesarPedido(3);

        System.out.println("\n6) CONSULTA FINAL DE PEDIDOS ACTUALIZADOS");
        for (Pedido pedido : repository.listar()) {
            System.out.println(pedido);
        }
    }
}
