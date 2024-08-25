import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Classe Cliente
class Cliente {
    private int codigo;
    private String razaoSocial;
    private String cnpj;
    private String nomeComprador;
    private String telefone;
    private String email;
    private String diaCotacao;
    private String formaPagamento;
    private String segmentoEstabelecimento;

    public Cliente(int codigo, String razaoSocial, String cnpj, String nomeComprador,
            String telefone, String email, String diaCotacao,
            String formaPagamento, String segmentoEstabelecimento) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeComprador = nomeComprador;
        this.telefone = telefone;
        this.email = email;
        this.diaCotacao = diaCotacao;
        this.formaPagamento = formaPagamento;
        this.segmentoEstabelecimento = segmentoEstabelecimento;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaCotacao() {
        return diaCotacao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getSegmentoEstabelecimento() {
        return segmentoEstabelecimento;
    }

    @Override
    public String toString() {
        
        return codigo
                + razaoSocial
                + cnpj
                + nomeComprador
                + email
                + formaPagamento
                + segmentoEstabelecimento;
    }
}

// Classe para gerenciar os clientes
class GerenciadorClientes {
    private List<Cliente> listaClientes;

    public GerenciadorClientes() {
        this.listaClientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void ordenarPorRazaoSocial() {
        Collections.sort(listaClientes, Comparator.comparing(Cliente::getRazaoSocial));
    }

    public Cliente buscarPorCodigo(int codigo) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null; // Se não encontrar
    }

    public void exibiCabecalho() {
        String format = "|%1$-8.9s|%2$-13s|%3$-20.9s|%4$-15s|%5$-13s|%6$-20s|%7$-10s|%8$-10s|%9$-10s\n";
        System.out.format(format,
                "Código",
                "Razão Social",
                "CNPJ",
                "NomeComprador",
                "Telefone",
                "Email",
                "DiaCotação",
                "FormaPagamento",
                "Segmento");
    }

    public void exibiLinhaClienteFormatada(Cliente cliente) {
        String formatLinha = "|%1$-9s|%2$-14s|%3$-20s|%4$-14s|%5$-14s|%6$-22s|%7$-10s|%8$-10s|%9$-10s\n";
        System.out.format(formatLinha,
                cliente.getCodigo(),
                cliente.getRazaoSocial(),
                cliente.getCnpj(),
                cliente.getNomeComprador(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getDiaCotacao(),
                cliente.getFormaPagamento(),
                cliente.getSegmentoEstabelecimento());
    }

    public void exibirClientes() {
        System.out.println("\n\n----------------------Lista de Clientes Cadastrados-----------------------\n");
        exibiCabecalho();

        for (Cliente cliente : listaClientes) {
            exibiLinhaClienteFormatada(cliente);
        }
    }

    public static void main(String[] args) {
        GerenciadorClientes gerenciador = new GerenciadorClientes();

        // Adicionando alguns clientes
        gerenciador.adicionarCliente(new Cliente(1, "Empresa A", "12.345.678/0001-99",
                "João Silva", "1234-5678",
                "joao@empresaA.com", "10/08/2024",
                "Boleto", "Varejo"));
        gerenciador.adicionarCliente(new Cliente(2, "Empresa B", "98.765.432/0001-11",
                "Maria Souza", "8765-4321",
                "maria@empresaB.com", "12/08/2024",
                "Cartão de Crédito", "Atacado"));
        gerenciador.adicionarCliente(new Cliente(3, "Empresa C", "456489", "Josefina", "32564564", "dsdhhssdhskj", "5",
                "Dinheiro", "Varejo"));
        // Ordenando e exibindo os clientes
        gerenciador.ordenarPorRazaoSocial();
        gerenciador.exibirClientes();

        // Buscando um cliente específico pelo código
        Cliente clienteBuscado = gerenciador.buscarPorCodigo(1);
        System.out.println("\n\n----------------------Resultado da Pesquisa-----------------------\n");

        if (clienteBuscado != null) {
            gerenciador.exibiCabecalho();
            gerenciador.exibiLinhaClienteFormatada(clienteBuscado);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
