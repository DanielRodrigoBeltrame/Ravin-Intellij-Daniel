package ravin.view;

public class GeralView {

    public static String montarSubMenuGeral(String modulo) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Gestão de ");
        builder.append(modulo);
        builder.append(" ==================== ");
       // builder.append(QUEBRA_LINHA);
        builder.append("1 -  Cadastrar \n");
        builder.append("2 -  Alterar \n");
        builder.append("3 -  Excluir \n");
        builder.append("4 -  Consultar \n");
        builder.append("5 -  Listar todos \n");

        return builder.toString();
    }

}
