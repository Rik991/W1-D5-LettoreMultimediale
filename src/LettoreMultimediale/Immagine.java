package LettoreMultimediale;

public class Immagine extends ElementoMultimediale implements ILuminosita{
    private int luminosita;
    public Immagine(String titolo) {
        super(titolo);
        this.luminosita = 5;  //setto la luminosita standard a livello 5 (metà)
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

    public void show(){
        String asterisco = "";
        for (int i = 0; i < luminosita; i++) {
            asterisco += "*";
        }
        System.out.println(getTitolo() + asterisco);
    }

    @Override
    public void esegui() {
        show();
    }

}
