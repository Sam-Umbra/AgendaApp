package br.eti.kge.agendaapp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar menus de interação com o usuário.
 * @author kge
 */
public class MenuManager {
    
    // Cabeçalho do Menu
    private String header;
    
    // Rodape do Menu
    private String footer;
    
    // Gerencia as opções do Menu.
    private List<MenuOption> opcoesMenu;

    /**
     * Inicializa o MenuManager apenas com a lista de opções.
     * @param opcoesMenu Lista de opções para o Menu.
     */
    public MenuManager() {
        this.header = "Menu Principal\n\n";
        this.footer = "";
        this.opcoesMenu = new ArrayList<>();
    }
    
    /**
     * Inicializa MenuManager com cabecalho (header) e lista de opções.
     * @param header Texto do cabeçalho do menu
     * @param footer Rodape do menu.
     */
    public MenuManager(String header, String footer) {
        this.header = header;
        this.footer = footer;
        this.opcoesMenu = new ArrayList<>();
    }
    
    /**
     * Inicializa MenuManager com todas as opções.
     * @param header
     * @param footer
     * @param opcoesMenu 
     */
    public MenuManager(String header, String footer, List<MenuOption> opcoesMenu) {
        this.header = header;
        this.footer = footer;
        this.opcoesMenu = opcoesMenu;
    }
    
    /**
     * Exibe o Menu para o usuário e aguarda ele digitar uma opção.
     * Valida se a opção digitada existe ou não. 
     * Caso não exista solicita novamente a opção.
     * @return opcao digitada.
     */
    public char showMenu() {
        
        char opcaoDigitada;
        
        // Acesso ao teclado
        Scanner teclado = new Scanner(System.in);
        
        // Exibe cabeçalho
        System.out.printf("%s", this.header);
        
        // Exibe as opções do menu
        for(MenuOption opcaoItem : opcoesMenu) {
            
            System.out.printf(opcaoItem.toString());
            
        }
        
        // Solicita entrada do usuario.
        do {
            
            System.out.print("\n>>> Informe opção: ");
            opcaoDigitada = teclado.next().toUpperCase().charAt(0);
            
        } while (!isOpcaoValida(opcaoDigitada));
        
        return opcaoDigitada;
    }

    /**
     * Identifica se a opção digitada no menu é válida.
     * @param opcaoDigitada
     * @return 
     */
    public boolean isOpcaoValida(char opcaoDigitada) {
        
        // Todas as opções digitadas são INVALIDAS até que se prove ao contrario.
        boolean isOk = false;
        //Varre a lista de opções. Se algum for falso já retorna falso.
        for (MenuOption opcao : opcoesMenu) {
            if (opcao.getOpcao() == opcaoDigitada) {
                isOk = true;
                break;
            }
        }
        return isOk;
    }
    
    /**
     * Adicionar um item de menu ao menu.
     * @param itemMenu 
     */
    public void addOpcao(MenuOption itemMenu) {
        this.opcoesMenu.add(itemMenu);
        
    }

    
    
    
}
