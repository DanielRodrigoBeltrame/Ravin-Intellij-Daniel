package ravin.view;

import ravin.controladores.FuncionarioController;
import ravin.enumeradores.Cargo;
import ravin.enumeradores.Escolaridade;
import ravin.enumeradores.EstadoCivil;
import ravin.modelos.Funcionario;
import ravin.modelos.Pessoa;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class FuncionarioView {

    public static String montarSubMenuFuncionarios() {
        String subMenuGeral = GeralView.montarSubMenuGeral("Funcionarios");

        StringBuilder builder = new StringBuilder();
        builder.append(subMenuGeral);
        builder.append("6 - Consultar Garçons Disponíveis \n");
        builder.append("7 - Voltar");

        return builder.toString();
    }

    private static void operacaoFuncionario(int opcao, FuncionarioController funcionarioController) {
        Funcionario funcionario = null;
        List<Funcionario> funcionarios = null;

        int id;
        switch (opcao) {
            case 1: // cadastrar Funcionario
                funcionario = mostrarMenuCadastrarFuncionario();

                try {// inserir
                    funcionarioController.salvar(funcionario);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                break;
            case 2: // alterar

                funcionarios = funcionarioController.listarTodos();
                int idFuncionarioAlterar = mostrarMenuLerIdFuncionarioAlterar(funcionarios);
                Funcionario funcionarioAlterar = funcionarioController.consultar(idFuncionarioAlterar);
                mostrarMenuAlterarFuncionario(funcionarioAlterar);
                try {
                    funcionarioController.salvar(funcionarioAlterar);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;

            case 3: //excluir
                id = mostrarMenuExcluirFuncionario();
                funcionarioController.excluir(id);
                break;

            case 4: //consultar
                id = mostrarMenuConsultarFuncionario();
                Funcionario funcionarioBuscado = funcionarioController.consultar(id);
                JOptionPane.showMessageDialog(null, funcionarioBuscado);
                break;

            case 5:
                funcionarios = funcionarioController.listarTodos();
                listarFuncionarios(funcionarios);
                break;

            case 6:
                funcionarios = funcionarioController.listarGarconsDisponiveis();
                listarGarconsDisponiveis(funcionarios);
                break;

            default:

        }
    }

    public static Funcionario mostrarMenuCadastrarFuncionario() {
        Pessoa pessoa = PessoaView.cadastrarPessoa();

        Funcionario funcionario = new Funcionario();
        funcionario.setRg(JOptionPane.showInputDialog("Digite o RG do funcionário:"));
        funcionario.setEstadoCivil(EstadoCivil.values()[Integer.parseInt(JOptionPane.showInputDialog(
                "Digite o estado civíl do funcionario: \n [1 - Solteiro \n 2 - Casado \n 3 - Viúvo \n 4 - Divorciado \n 5 - Separado]"))]);
        funcionario.setCargo(Cargo.values()[Integer.parseInt(JOptionPane.showInputDialog(
                "Digite o cargo do funcionário: \n 1 - Faxineiro \n 2 - Garçom \n 3 - Cozinheiro \n 4 - Gerente"))]);
        funcionario.setEscolaridade(Escolaridade.values()[Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a escolaridade do funcionario: \n 1 - Fundamental \n 2 - Médio \n 3 - Superior "))]);
        funcionario.setPis(Integer.parseInt(JOptionPane.showInputDialog("Digite o PIS do funcionário")));
        funcionario.setDataAdmissao(new Date());

        funcionario.setId(pessoa.getId());
        funcionario.setCpf(pessoa.getCpf());
        funcionario.setEndereco(pessoa.getEndereco());
        funcionario.setDataNascimento(pessoa.getDataNascimento());
        funcionario.setOberservacao(pessoa.getOberservacao());
        funcionario.setTelefone(pessoa.getTelefone());

        return funcionario;
    }

    private static int mostrarMenuLerIdFuncionarioAlterar(List<Funcionario> funcionarios) {

        var builder = new StringBuilder();

        builder.append(" ==================== Lista de funcionários ==================== ");
        builder.append(QUEBRA_LINHA);

        for (Funcionario funcionario : funcionarios) {
            builder.append(funcionario.getId());
            builder.append(" - ");
            builder.append(funcionario.getNome());
            builder.append(QUEBRA_LINHA);
        }

        builder.append("Digite o id do funcionário que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }
}
