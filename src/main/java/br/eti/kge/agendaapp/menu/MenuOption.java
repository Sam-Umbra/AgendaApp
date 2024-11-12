package br.eti.kge.agendaapp.menu;

/**
 *
 * @author kge
 */
public class MenuOption {
    
    private char opcao;
    private String textoOpcao;
    
    public MenuOption(char opcao, String textoOpcao) {
        this.opcao = opcao;
        this.textoOpcao = textoOpcao;
    }

    public char getOpcao() {
        return opcao;
    }

    public void setOpcao(char opcao) {
        this.opcao = opcao;
    }

    public String getTextoOpcao() {
        return textoOpcao;
    }

    public void setTextoOpcao(String textoOpcao) {
        this.textoOpcao = textoOpcao;
    }

    @Override
    public String toString() {
        return String.format("[%-3s]\t%s\n",this.opcao, this.textoOpcao);
    }
    
    
    
    
}
