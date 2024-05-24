package com.saudeparatodos;

public class ClearConsole {
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Teste de limpeza de console
        System.out.println("Antes de limpar a tela");
        clear();
        System.out.println("Depois de limpar a tela");
    }
}


