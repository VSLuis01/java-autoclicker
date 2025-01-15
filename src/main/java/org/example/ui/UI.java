package org.example.ui;

public class UI {
    public static void showCommands() {
        String commands =
                """
                Aguardando comandos do teclado...
                
                ALT + J -> Iniciar configuração dos cliques
                ALT + A -> Finalizar configuração dos cliques
                ALT + R -> Iniciar auto clique
                ALT + P -> Pause auto clique
                ESQ     -> Sair do programa""";

        System.out.println(commands);
    }

    public static void showConfigCommands() {
        String commands =
                """
                Entrando no modo de configuração...
                
                ESPAÇO    -> Registrar uma posição do cursor
                BACKSPACE -> Remover a ultima posição registrada
                R         -> Limpar todas posições registradas""";

        System.out.println(commands);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
