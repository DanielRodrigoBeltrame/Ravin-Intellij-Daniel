package ravin.view;

import ravin.modelos.Pessoa;
import ravin.utilidade.DateUtils;

import javax.swing.*;
import java.util.Date;

public class PessoaView {

    public static Pessoa cadastrarPessoa() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite um id pessoa"));
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa");
        String endereco = JOptionPane.showInputDialog("Digite o endereço da pessoa");
        String telefone = JOptionPane.showInputDialog("Digite o telefone da pessoa");
        String cpf = JOptionPane.showInputDialog("Digite o CPF da pessoa");
        Date dataNascimento = DateUtils.stringToDate(
                JOptionPane.showInputDialog("Qual a data de nascimento da pessoa? \n Formato: dd/MM/yyyy"));
        String observacao = JOptionPane.showInputDialog("Digite alguma possível observação");
        boolean ativo = Boolean
                .parseBoolean(JOptionPane.showInputDialog("O usuário está ativo? \n[1 - Sim \n 0 - Não]"));

        return new Pessoa(id, nome, endereco, telefone, cpf, dataNascimento, observacao, ativo);
    }

}
