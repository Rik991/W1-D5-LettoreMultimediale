package LettoreMultimediale;

public class Audio extends ElementoMultimediale implements IRiproducibile{

    private int volume;
    private int durata;

    public Audio(String titolo, int durata) {
        super(titolo);
        this.volume = 5;  //setto il volume standard a livello 5 (metà)
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
    public void play() {
        String esclamativo = "";
        for (int i = 0; i < volume; i++) {
            esclamativo += "!";
        }
            System.out.println(getTitolo() + esclamativo);
    }

    @Override
    public void esegui() {
        for (int i = 0; i < durata; i++) {
            play();
        }
    }
}
