import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        Musica musicaAtual = null;

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Adicionar Música");
            System.out.println("2. Remover Música");
            System.out.println("3. Alterar Música");
            System.out.println("4. Exibir Playlist");
            System.out.println("5. Próxima Música");
            System.out.println("6. Música Anterior");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o artista da música: ");
                    String artista = scanner.nextLine();
                    System.out.print("Digite a duração da música em minutos: ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();

                    playlist.inserirMusica(titulo, artista, duracao);
                    System.out.println("Música adicionada com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o título da música a ser removida: ");
                    String tituloRemover = scanner.nextLine();
                    playlist.removerMusica(tituloRemover);
                    break;

                case 3:
                    System.out.print("Digite o título da música a ser alterada: ");
                    String tituloAlterar = scanner.nextLine();
                    System.out.print("Digite o novo título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Digite o novo artista: ");
                    String novoArtista = scanner.nextLine();
                    System.out.print("Digite a nova duração em minutos: ");
                    int novaDuracao = scanner.nextInt();
                    scanner.nextLine();

                    playlist.alterarMusica(tituloAlterar, novoTitulo, novoArtista, novaDuracao);
                    break;

                case 4:
                    System.out.println("Playlist:");
                    playlist.exibirPlaylist();
                    break;

                case 5:
                    if (musicaAtual == null) {
                        musicaAtual = playlist.head;
                    } else {
                        musicaAtual = playlist.proximaMusica(musicaAtual);
                    }
                    if (musicaAtual != null) {
                        System.out.println("Música atual: " + musicaAtual.titulo);
                    }
                    break;

                case 6:
                    if (musicaAtual != null) {
                        musicaAtual = playlist.musicaAnterior(musicaAtual);
                    }
                    if (musicaAtual != null) {
                        System.out.println("Música atual: " + musicaAtual.titulo);
                    }
                    break;

                case 7:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}