package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Categoria extends ObjetoBase implements Serializable {

    @Column(name = "descricao")
    private String descricao;
    @Column(name = "admin")
    private boolean admin;

    public Categoria() {
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Categoria(int id, String descricao) {
        setId(id);
        this.descricao = descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public ObjetoBase toObjeto(String[] dados) {

        setId(Integer.parseInt(dados[0]));

        setDescricao(dados[1]);
        setAdmin(Boolean.parseBoolean(dados[2]));

        return this;
    }

    @Override
    public String[] toStringVetor() {
        String vetor[] = new String[3];
        vetor[0] = String.valueOf(getId());
        vetor[1] = getDescricao();
        vetor[2] = String.valueOf(isAdmin());
        return vetor;
    }

}
