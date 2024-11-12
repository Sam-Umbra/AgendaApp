package br.eti.kge.agendaapp;

import br.eti.kge.agendaapp.menu.MenuOption;
import br.eti.kge.agendaapp.menu.MenuManager;
import br.eti.kge.agendaapp.model.Agenda;
import br.eti.kge.agendaapp.model.Contato;
import java.util.Scanner;

/**
 * Aplicação inicial objeto de estudo do componente Programação Orientada a Objetos
 * Prof. KGe
 * @author kge
 */
public class AgendaApp {

    public static MenuManager menuPrincipal;
    public static Agenda minhaAgenda;

    public static void main(String[] args) {
        
        minhaAgenda = new Agenda("Samuel");
        
        char opcao;
        boolean continua = true;
        preparaMenu();

        while (continua) {

            opcao = menuPrincipal.showMenu();

            switch (opcao) {
                case '1':
                    System.out.println("Adicionar Contato");
                    adicionaContato();
                    break;
                case '2':
                    System.out.println("Alterar Contato");
                    alteraContato();
                    break;
                case '3':
                    System.out.println("Remover Contato");
                    excluiContato();
                    break;
                case '4':
                    System.out.println("\nListar contato (geral)\n");
                    listarContatos();
                    break;
                case '5':
                    System.out.println("Filtrar contato");
                    filtrarContato();
                    break;
                case 'X':
                    System.out.println("Sair do Sistema");
                    continua = false;
                    break;
                default:
                    System.out.println("Opção não tratada. Verifique!");
            }
        }
    }

    private static void preparaMenu() {
        String cabecalho = "+-------------------------------+\n";
        cabecalho += "| Agenda Telefonica v1.0        |\n";
        cabecalho += "| Menu Principal                |\n";
        cabecalho += "+-------------------------------+\n\n";

        menuPrincipal = new MenuManager(cabecalho, "");

        menuPrincipal.addOpcao(new MenuOption('1', "Adicionar Contato"));
        menuPrincipal.addOpcao(new MenuOption('2', "Alterar Contato"));
        menuPrincipal.addOpcao(new MenuOption('3', "Remover Contato"));
        menuPrincipal.addOpcao(new MenuOption('4', "Listar Contatos"));
        menuPrincipal.addOpcao(new MenuOption('5', "Filtrar Contato"));
        menuPrincipal.addOpcao(new MenuOption('X', "Sair do Sistema"));

    }

    public static void adicionaContato() {
        Scanner teclado = new Scanner(System.in);
        Contato contatoAux = new Contato();
        
        System.out.println("Informe nome: ");
        contatoAux.setNome(teclado.nextLine());
        
        System.out.println("Informe telefone: ");
        contatoAux.setTelefone(teclado.nextLine());
        
        System.out.println("Informe email: ");
        contatoAux.setEmail(teclado.nextLine());
        
        System.out.println("Informe endereço: ");
        contatoAux.setEndereco(teclado.nextLine());
        
        System.out.println("Informe cidade: ");
        contatoAux.setCidade(teclado.nextLine());
        
        System.out.println("Informe UF: ");
        contatoAux.setUf(teclado.nextLine());
        
        System.out.println("Informe CEP: ");
        contatoAux.setCep(teclado.nextLine());
        
        System.out.println("Informe data de nascimento (dd/mm/yyyy): ");
        contatoAux.setDataNascimento(teclado.nextLine());
        
        minhaAgenda.adicionaContato(contatoAux);
    }
    
    // TODO Implementar os outros métodos para alterar, remover e listar contatos.
    public static void alteraContato() {
        Scanner teclado = new Scanner(System.in);
        char opcaoContinua = 'N';
        String temp;
        
        if (minhaAgenda.getListaContatos().isEmpty()) {
            System.out.println("A agenda está vazia.\n");
        } else {
            
            System.out.println("Informe o nome:");
            String auxName = teclado.nextLine();
            int id = minhaAgenda.buscaNome(auxName);
            
            //System.out.println("Busca: " + busca);
            if (id < 0) {
                System.out.println("Nome não encontrado!");
                return;
            }
            
            Contato cAux = minhaAgenda.getContato(id);
            System.out.println(cAux.toString());

            System.out.println("Você deseja alterar esse contato [S/N]");
            opcaoContinua = teclado.next().toUpperCase().charAt(0);

            if (opcaoContinua == 'S'){

                teclado.nextLine();
                System.out.printf("Nome: %s\n", cAux.getNome());
                System.out.printf("Novo Nome: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setNome(temp);
                }

                System.out.printf("\nTelefone: %s\n", cAux.getTelefone());
                System.out.printf("Novo Telefone: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setTelefone(temp);
                }

                System.out.printf("\nEmail: %s\n", cAux.getEmail());
                System.out.printf("Novo Email: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setEmail(temp);
                }

                System.out.printf("\nEndereço: %s\n", cAux.getEndereco());
                System.out.printf("Novo Endereço: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setEndereco(temp);
                }

                System.out.printf("\nCidade: %s\n", cAux.getCidade());
                System.out.printf("Nova Cidade: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setCidade(temp);
                }

                System.out.printf("\nUF: %s\n", cAux.getUf());
                System.out.printf("Novo UF: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setUf(temp);
                }

                System.out.printf("\nCEP: %s\n", cAux.getCep());
                System.out.printf("Novo CEP: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setCep(temp);
                }

                System.out.printf("\nData de Nascimento: %s\n", cAux.getDataNascimento());
                System.out.printf("Nova Data de Nascimento: ");
                temp = "";
                temp = teclado.nextLine();
                if (!temp.isEmpty()) {
                    cAux.setDataNascimento(temp);
                }
                System.out.println("\n\nContato Alterado!");
                minhaAgenda.alteraContato(id, cAux);  
            } 
        }
    }
    
    public static void excluiContato() {
        Scanner teclado = new Scanner(System.in);
        char opcaoContinua = 'N';
        
        if (minhaAgenda.getListaContatos().isEmpty()) {
            System.out.println("A agenda está vazia.\n");
        } else {
            System.out.println("Informe o nome:");
            String auxName = teclado.nextLine();
            int id = minhaAgenda.buscaNome(auxName);
            
            //System.out.println("Busca: " + busca);
            if (id < 0) {
                System.out.println("Nome não encontrado!");
                return;
            }
            
            Contato cAux = minhaAgenda.getContato(id);
            System.out.println(cAux.toString());

            System.out.println("Você deseja excluir esse contato [S/N]");
            opcaoContinua = teclado.next().toUpperCase().charAt(0);

            if (opcaoContinua == 'S'){
                System.out.println("\n\nContato excluido!");
                minhaAgenda.excluiContato(id);   
            }
        }
    }
    
    public static void listarContatos() {
        if (minhaAgenda.getListaContatos().isEmpty()) {
            System.out.println("A agenda está vazia.\n");
        } else {
            System.out.printf("%s", minhaAgenda.listarContatos());
        }
    }
    
    public static void filtrarContato() {
        Scanner teclado = new Scanner(System.in);
        String filtro;
        
        if (minhaAgenda.getListaContatos().isEmpty()) {
            System.out.println("A agenda está vazia.\n");
        } else {
            System.out.println("Informe o nome do contato:");
            filtro = teclado.nextLine();
            
            for (Contato c : minhaAgenda.filtrarContato(filtro) ) {
                System.out.println(c.toString());
            }
        }
    }
}
