package LettoreMultimediale;

public class Video extends ElementoMultimediale implements IRiproducibile, ILuminosita {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata) {
        super(titolo);
        this.volume = 5;  //setto il volume standard a livello 5 (metà)
        this.luminosita = 5;  //setto la luminosita standard a livello 5 (metà)
        this.durata = durata;
    }

    @Override
    public void abbassaVolume() {
        if(volume>0){
            volume--;
        }else{
            System.out.println("Il volume è al minimo");
        }
    }

    @Override
    public void alzaVoulme() {
        if(volume<10){
            volume++;
        }else{
            System.out.println("Il volume è al massimo");
        }
    }

    @Override
    public void abbassaLuminosita() {
        if(luminosita>0){
            luminosita--;
        }else{
            System.out.println("La luminosità è al minimo");
        }
    }

    @Override
    public void alzaLuminosita() {
        if(luminosita<10){
            luminosita++;
        }else{
            System.out.println("La luminosità è al massimo");
        }
    }

    @Override
    public void play() {
        String esclamativo = "";
        String asterisco = "";
        for (int i = 0; i < volume; i++) {
            esclamativo += "!";
        }
        for (int i = 0; i < luminosita; i++) {
            asterisco += "*";
        }
        System.out.println(getTitolo() + esclamativo + asterisco);
    }

    @Override
    public void esegui() {
        for (int i = 0; i < durata; i++) {
            play();
        }


    }
}
