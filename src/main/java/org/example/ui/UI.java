package org.example.ui;

public class UI {
    public static void showCommands() {
        String commands =
                """
                ALT + J -> Iniciar configuração dos cliques
                ALT + A -> Finalizar configuração dos cliques
                ALT + R -> Iniciar auto clique
                ALT + P -> Pause auto clique
                ESQ     -> Sair do programa""";

        System.out.println(commands);
    }
}
