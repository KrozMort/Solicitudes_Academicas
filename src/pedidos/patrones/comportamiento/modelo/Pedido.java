package pedidos.patrones.comportamiento.modelo;

public class Pedido {
    private int id;
    private String cliente;
    private String producto;
    private int cantidad;
    private double total;
    private EstadoPedido estado;

    public Pedido(int id, String cliente, String producto, int cantidad, double total) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = EstadoPedido.REGISTRADO;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", total=$" + total +
                ", estado=" + estado +
                '}';
    }
}
