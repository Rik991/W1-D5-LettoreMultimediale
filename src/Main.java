import LettoreMultimediale.ElementoMultimediale;
import LettoreMultimediale.Audio;
import LettoreMultimediale.Immagine;
import LettoreMultimediale.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ElementoMultimediale[] multimediaUtente = new ElementoMultimediale[5];

        System.out.println("Benvenuto, inserisci i 5 elementi nel Riproduttore Multimediale");
        //ciclo la lunghezza dell'array così da popolarlo ogni giro con l'elemento scelto
        for (int i = 0; i < multimediaUtente.length; i++) {
            ElementoMultimediale elemento;
            System.out.println("Elemento " + (i + 1));
            System.out.println("Inserisci il tipo: -1-Immagine; -2-Audio; -3-Video");
            int tipo = scanner.nextInt(); //memorizzo il tipo scelto dall'utente
            scanner.nextLine();//svuoto lo scanner per evitare bug
            switch (tipo) {
                case 1:
                case 2:
                case 3:
                    //  memorizzo il titolo
                    System.out.println("Inserisci il titolo dell'elemento");
                    String titolo = scanner.nextLine();
                    if (tipo == 1) multimediaUtente[i] = new Immagine(titolo);
                    //se è un elemento audio o video chiedo anche la durata
                    if (tipo == 2) {
                        System.out.println("Inserisci la durata dell' audio");
                        int durata = scanner.nextInt();
                        multimediaUtente[i] = new Audio(titolo, durata);
                    }
                    if (tipo == 3) {
                        System.out.println("Inserisci la durata del video");
                        int durata = scanner.nextInt();
                        multimediaUtente[i] = new Video(titolo, durata);
                    }
                    break;
                default:
                    System.out.println("Inserisci un numero valido tra 1 e 3");
                    i--; // Decrementa l'indice per ripetere l'inserimento
                    break;
            }
        }
        ;

        //mostro all'utente cosa ha inserito nella libreria multimediale
        System.out.println("Perfetto! Abbiamo riempito la nostra libreria multimediale, ecco cosa abbiamo: ");
        for (int i = 0; i < multimediaUtente.length; i++) {
            System.out.println((i+1) + ") " + multimediaUtente[i].getTitolo());
        }

        //ciclo l'array di elementi e permetto di riprodurli (con metodi volume e luminosità annessi) finchè l'utente non preme lo 0
        while (true) {
            System.out.println("inserisci un numero da 1 a 5 per riprodurre un elemento multimediale, 0 per stoppare il programma! Luminosità e volume sono di default a 5 ma potrai settarli dopo la scelta!");
            int sceltaUtente = scanner.nextInt();
            if (sceltaUtente > 5 || sceltaUtente < 0) {
                System.out.println("Elemento Multimediale non trovato!");
            } else if (sceltaUtente != 0) {
                ElementoMultimediale elementoScelto = multimediaUtente[sceltaUtente - 1];
                elementoScelto.esegui();

                //chiedo all'utente se vuole interagire con volume e luminosità in base all'istanza dell'oggetto scelto,
                //qualora decida di modifica un parametro (volume o luminosità), rilancio il play con i parametri aggiornati
                if (elementoScelto instanceof Immagine) {
                    Immagine immagine = (Immagine) elementoScelto;
                    System.out.println("Vuoi modificare la luminosità dell'immagine? 1 per aumentare, 2 per diminuire, 0 per ignorare");
                    int scelta = scanner.nextInt();
                    scanner.nextLine();
                    if (scelta == 1)
                        immagine.alzaLuminosita();
                    else if (scelta == 2) immagine.abbassaLuminosita();immagine.show();
                } else if (elementoScelto instanceof Audio) {
                    Audio audio = (Audio) elementoScelto;
                    System.out.println("Vuoi modificare il volume dell'audio? 1 per aumentare, 2 per diminuire, 0 per ignorare");
                    int scelta = scanner.nextInt();
                    scanner.nextLine();
                    if (scelta == 1)
                        audio.alzaVoulme();
                    else if (scelta == 2) audio.abbassaVolume();audio.play();
                } else if (elementoScelto instanceof Video) {
                    Video video = (Video) elementoScelto;
                    System.out.println("Vuoi modificare la luminosità o il volume del video? 1 per luminosità, 2 per volume, 0 per ignorare");
                    int scelta = scanner.nextInt();
                    scanner.nextLine();
                    if (scelta == 1) {
                        System.out.println("1 per aumentare luminosità, 2 per diminuire");
                        int sceltaLuminosita = scanner.nextInt();
                        scanner.nextLine();
                        if (sceltaLuminosita == 1)
                            video.alzaLuminosita();
                        else if (sceltaLuminosita == 2) video.abbassaLuminosita();video.play();
                    } else if (scelta == 2) {
                        System.out.println("1 per aumentare volume, 2 per diminuire");
                        int sceltaVolume = scanner.nextInt();
                        scanner.nextLine();
                        if (sceltaVolume == 1)
                            video.alzaVoulme();
                        else if (sceltaVolume == 2) video.abbassaVolume();video.play();
                    }
                } else {
                    break;
                }
            }


        }
        scanner.close();

    }
}




