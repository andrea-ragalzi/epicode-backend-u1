package main.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import java.util.List;
import main.enumerate.TipoEvento;

public class GaraDiAtletica extends Evento {
    private Set<Persona> setAtleti;
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(LocalDate dataEvento, String descrizione,
            TipoEvento tipoEvento, Integer numeroMassimoPartecipanti,
            Location location, Set<Persona> setAtleti) {
        super(dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.setAtleti = setAtleti;
        this.setVincitore();
    }

    public GaraDiAtletica(Long numeroEvento, LocalDate dataEvento,
            String descrizione, TipoEvento tipoEvento,
            Integer numeroMassimoPartecipanti, Location location,
            Set<Persona> setAtleti) {
        super(numeroEvento, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.setAtleti = setAtleti;
        this.setVincitore();
    }

    public void setVincitore() {
        if (this.setAtleti != null && !this.setAtleti.isEmpty()) {
            int randomIndex = new Random().nextInt(this.setAtleti.size());
            List<Persona> atletiList = new ArrayList<>(this.setAtleti);
            Persona atletaVincitore = atletiList.get(randomIndex);
            this.vincitore = atletaVincitore;
        }
    }

    public Set<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Set<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return String.format("GaraDiAtletica [numeroEvento=%d, dataEvento=%s, descrizione=%s, tipoEvento=%s, " +
                "numeroMassimoPartecipanti=%d, location=%s, vincitore=%s, setAtleti=%s]",
                super.getNumeroEvento(), super.getDataEvento(), super.getDescrizione(),
                super.getTipoEvento(), super.getNumeroMassimoPartecipanti(), super.getLocation(),
                this.vincitore, this.setAtleti);
    }
}
