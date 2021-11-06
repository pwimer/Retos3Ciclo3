package co.usa.retosciclo3.model.reportes;

import co.usa.retosciclo3.model.Cliente;

public class ContClientes {
    private long total;
    private Cliente cliente;

    public ContClientes(long total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
