package com.saudeparatodos;

import Model.*;
import DAO.*;
import java.util.*;
import java.sql.*;

public class App {
    private static Usuario usuario = null;
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao SUTD");

        while (!loggedIn) {
            System.out.println("Digite 'Cadastrar' para criar uma nova conta ou 'Login' para acessar sua conta:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Cadastrar")) {
                UsuarioDAO.cadastrarUsuario(scanner);
            } else if (input.equalsIgnoreCase("Login")) {
                usuario = LoginDAO.fazerLogin(scanner);
                if (usuario != null) {
                    loggedIn = true;
                } else {
                    System.out.println("Login ou senha inválidos. Por favor, tente novamente.");
                }
            } else {
                System.out.println("Comando inválido. Por favor, tente novamente.");
            }
        }
        
        System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.getNome());
        ClearConsole.clear();
        boolean running = true;
        while (running) {
            ClearConsole.clear();
            System.out.println("Escannerolha uma opção: \nPerfil \nHelp \nAgendamento \nCalendario \nSair");
            String option = scanner.nextLine();

            switch (option.toLowerCase()) {
                case "help":
                    Help();
                    break;
                case "perfil":
                    Perfil(scanner);
                    break;
                case "agendamento":
                    Agendamentos(scanner);
                    break;
                case "calendario":
                    Calendario(scanner);
                    break;
                case "sair":
                    running = false;
                    break;
                default:
                    System.out.println("Comando inválido");
            }
        }

        scanner.close();
        ConexaoBD.fecharConexao();
    }

    public static void Perfil(Scanner scanner) {
        boolean viewingProfile = true;

        while (viewingProfile) {
            System.out.println("Perfil do usuário:");
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Idade: " + usuario.getIdade());
            System.out.println("Sexo: " + usuario.getSexo());
            System.out.println("Endereço: " + usuario.getEndereco());
            System.out.println("Telefone: " + usuario.getTelefone());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("SUS: " + usuario.getSus());

            System.out.println("\nEscolha uma opção: \n1. Voltar \n2. Editar Perfil \n3. Excluir seu Perfil \n4. Ver consultas");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    viewingProfile = false;
                    break;
                case "2":
                    Perfil.editarPerfil(scanner);
                    break;
                case "3":

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    public class Perfil {

        public static void editarPerfil(Scanner scanner) {
            // Criação do objeto Usuario
            usuario.getId();
            usuario.setId(Integer.parseInt(scanner.nextLine())); 
            if(!loggedIn) {
            System.out.println("Editar Perfil:");
    
            System.out.print("Novo Nome: ");
            usuario.setNome(scanner.nextLine());
    
            System.out.print("Novo Email: ");
            usuario.setEmail(scanner.nextLine());
    
            System.out.print("Nova Senha: ");
            usuario.setSenha(scanner.nextLine());
    
            System.out.print("Nova Idade: ");
            usuario.setIdade(scanner.nextLine());
    
            System.out.print("Novo Sexo: ");
            usuario.setSexo(scanner.nextLine());
    
            System.out.print("Novo Endereço: ");
            usuario.setEndereco(scanner.nextLine());
    
            System.out.print("Novo Telefone: ");
            usuario.setTelefone(scanner.nextLine());
    
            System.out.print("Novo CPF: ");
            usuario.setCpf(scanner.nextLine());
    
            System.out.print("Novo SUS: ");
            usuario.setSus(scanner.nextLine());
            }
            // Verifique se o ID do usuário é válido e definido
            // System.out.print("ID do Usuário: ");
            //
    
            // Obtenção da conexão com o banco de dados
            try (Connection connection = ConexaoBD.obterConexao()) {
                UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                usuarioDAO.atualizarUsuario(usuario);
                System.out.println("Perfil atualizado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao atualizar perfil.");
            }
        }
    }
    public static void Help() {
        System.out.println("Comandos disponíveis:");
        System.out.println("Perfil - Ver ou editar seu perfil");
        System.out.println("Help - Ver esta mensagem de ajuda");
        System.out.println("Agenda - Gerenciar ou Realizar seus agendamentos");
        System.out.println("Calendario - Ver o calendário de especialidades");
        System.out.println("Sair - Sair do sistema");
    }

    public static void Agendamentos(Scanner scanner) {
        // Implementação do método Agendamentos
        System.out.println("Aqui você pode gerenciar seus agendamentos.");
        // Adicione mais lógica para gerenciar os agendamentos.
    }

    public static void Calendario(Scanner scanner) {
        // Implementação do método Calendario
        System.out.println("Aqui você pode ver o calendário de especialidades.");
        // Adicione mais lógica para visualizar o calendário.
    }


}
