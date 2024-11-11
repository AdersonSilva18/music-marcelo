class Musica {
    String titulo;
    String artista;
    int duracao;
    Musica next;
    Musica prev;

    public Musica(String titulo, String artista, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.next = null;
        this.prev = null;
    }
}