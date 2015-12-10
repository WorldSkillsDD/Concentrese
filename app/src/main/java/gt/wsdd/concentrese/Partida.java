package gt.wsdd.concentrese;

/**
 * Created by WorldSkills on 09/12/2015.
 */
public class Partida {

    private int id;
    private String nickname;
    private String modoJuego;
    private int nivel;
    private String tiempo;
    private int intentos;

    public Partida(String nickname, String modoJuego, int nivel, String tiempo, int intentos) {
        this.nickname = nickname;
        this.modoJuego = modoJuego;
        this.nivel = nivel;
        this.tiempo = tiempo;
        this.intentos = intentos;
    }

    public Partida(int id, String nickname, String modoJuego, int nivel, String tiempo, int intentos) {
        this.id = id;
        this.nickname = nickname;
        this.modoJuego = modoJuego;
        this.nivel = nivel;
        this.tiempo = tiempo;
        this.intentos = intentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(String modoJuego) {
        this.modoJuego = modoJuego;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
