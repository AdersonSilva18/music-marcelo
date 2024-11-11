class Playlist {
    public Musica head;
    public Musica tail;

    public Playlist() {
        this.head = null;
        this.tail = null;
    }

    public void inserirMusica(String titulo, String artista, int duracao) {
        Musica novaMusica = new Musica(titulo, artista, duracao);
        if (head == null) {
            head = novaMusica;
            tail = novaMusica;
        } else {
            tail.next = novaMusica;
            novaMusica.prev = tail;
            tail = novaMusica;
        }
    }

    public void removerMusica(String titulo) {
        Musica atual = head;

        while (atual != null) {
            if (atual.titulo.equals(titulo)) {
                if (atual.prev != null) {
                    atual.prev.next = atual.next;
                } else {
                    head = atual.next;
                }

                if (atual.next != null) {
                    atual.next.prev = atual.prev;
                } else {
                    tail = atual.prev;
                }
                System.out.println("Música removida: " + titulo);
                return;
            }
            atual = atual.next;
        }
        System.out.println("Música não encontrada: " + titulo);
    }

    public void alterarMusica(String titulo, String novoTitulo, String novoArtista, int novaDuracao) {
        Musica atual = head;

        while (atual != null) {
            if (atual.titulo.equals(titulo)) {
                atual.titulo = novoTitulo;
                atual.artista = novoArtista;
                atual.duracao = novaDuracao;
                System.out.println("Música alterada: " + novoTitulo);
                return;
            }
            atual = atual.next;
        }
        System.out.println("Música não encontrada para alteração: " + titulo);
    }

    public void exibirPlaylist() {
        Musica atual = head;
        while (atual != null) {
            System.out.println("Título: " + atual.titulo + ", Artista: " + atual.artista + ", Duração: " + atual.duracao + " min");
            atual = atual.next;
        }
    }

    public Musica proximaMusica(Musica atual) {
        if (atual != null && atual.next != null) {
            return atual.next;
        }
        System.out.println("Não há próxima música.");
        return null;
    }

    public Musica musicaAnterior(Musica atual) {
        if (atual != null && atual.prev != null) {
            return atual.prev;
        }
        System.out.println("Não há música anterior.");
        return null;
    }
}