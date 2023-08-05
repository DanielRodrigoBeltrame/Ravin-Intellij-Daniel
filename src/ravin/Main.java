package ravin;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JOptionPane;

import ravin.enumeradores.Cargo;
import ravin.enumeradores.Escolaridade;
import ravin.enumeradores.EstadoCivil;
import ravin.enumeradores.TipoProduto;
import ravin.modelos.Cliente;
import ravin.modelos.Funcionario;
import ravin.modelos.Pedido;
import ravin.modelos.Pessoa;
import ravin.modelos.Produto;
import ravin.utilidade.DateUtils;
import ravin.view.FuncionarioView;
import ravin.view.PessoaView;

/**
 *
 * @author mmichelluzzi
 *
 * Funcionalidades que devem ser contempladas no desenvolvimento do projeto
 *
 * 1 - Funcionario
 * Cadastrar
 * Alterar
 * Excluir
 * Consultar
 * Listar Todas
 * Consultar Garçons Disponíveis
2 - Cliente
 * Cadastrar
 * Alterar
 * Excluir
 * Consultar
 * Listar Todas
3 - Produto
 * Cadastrar
 * Alterar
 * Excluir
 * Consultar
 * Listar Todas
4 - Cardapio
 * Cadastrar
 * Alterar
 * Excluir
 * Consultar
 * Listar Todas
5 - Mesa
 * Cadastrar
 * Alterar
 * Excluir
 * Consultar
 * Listar Todas
 * Consultar Mesas Disponíveis
 * Reservar Mesa
 * Listar Mesas Por Status
6 - Pedido
 * Cadastrar
 * Alterar
 * Excluir
 * Consultar
 * Listar Todas
 * Realizar pedido
 * Consultar Status do pedido
 * Listar Comandas Por Status
 * Fechar Comanda
 * Cancelar Pedido
 *
 */
public class Main {

    public static void main(String[] args) {
        String selecaoOpcoes;
        do {
            String[] opcoes = {"Pessoa", "Funcionario", "Cliente", "Produto", "Pedido"};

            selecaoOpcoes = (String) JOptionPane.showInputDialog(
                    null, "Informe a classe", "Cadastro Restaurante", JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
            switch (selecaoOpcoes) {
                case "Pessoa" -> PessoaView.cadastrarPessoa();
                case "Funcionario" -> FuncionarioView.mostrarMenuCadastrarFuncionario();
                case "Cliente" -> cadastrarCliente();
                case "Produto" -> cadastrarProduto();
                case "Pedido" -> cadastrarPedido();
            }

        } while (JOptionPane.showConfirmDialog(null,"Continuar?") == JOptionPane.YES_OPTION);

    }




    public static Cliente cadastrarCliente() {

        Pessoa pessoa = PessoaView.cadastrarPessoa();

        Cliente cliente = new Cliente();
        cliente.setId(0);
        cliente.setAlergias(JOptionPane.showInputDialog("Digite a lista de alergias do cliente"));
        cliente.setAtivo(
                Boolean.parseBoolean(JOptionPane.showInputDialog("O cliente está ativo? \n[1 - Sim \n 0 - Não]")));

        cliente.setId(pessoa.getId());
        cliente.setCpf(pessoa.getCpf());
        cliente.setEndereco(pessoa.getEndereco());
        cliente.setDataNascimento(pessoa.getDataNascimento());
        cliente.setOberservacao(pessoa.getOberservacao());
        cliente.setTelefone(pessoa.getTelefone());

        return cliente;

    }

    public static Produto cadastrarProduto() {

        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
        String descricao = JOptionPane.showInputDialog("Digite a descrição do produto:");
        String codigo = JOptionPane.showInputDialog("Digite o código do produto");
        double precoCusto = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de custo do produto:"));
        double precoVenda = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de venda do produto:"));
        String tempoPreparo = JOptionPane.showInputDialog("Digite a descrição do tempo de preparo do produto");
        String observacoes = JOptionPane.showInputDialog("Digite as observações do produto:");
        TipoProduto tipoProduto = TipoProduto.values()[Integer.parseInt(
                JOptionPane.showInputDialog("Digite o tipo do produto \n 1 - Lanche \n 2 - Bebida \n 3 - Sobremesa"))];
        boolean ativo = Boolean
                .parseBoolean(JOptionPane.showInputDialog("O produto está ativo? \n 0 - Não \n 1 - Sim"));

        return new Produto(0, nome, descricao, codigo, precoCusto, precoVenda, tempoPreparo, observacoes, tipoProduto,
                ativo);

    }

    public static Pedido cadastrarPedido() {
        Pedido pedido = new Pedido();

        pedido.setDataHoraSolicitacao(new Timestamp(new Date().getTime()));
        pedido.setObservacao(JOptionPane.showInputDialog("Observações:"));
        pedido.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de items que você quer para esse pedido")));

        return pedido;
    }

}
