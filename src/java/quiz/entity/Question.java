/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titre;
    private int ordre;
    private String rep1;
    private String rep2;
    private String rep3;
    private String rep4;
    private byte numRepCorrecte;
    
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(byte ordre) {
        this.ordre = ordre;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public String getRep4() {
        return rep4;
    }

    public void setRep4(String rep4) {
        this.rep4 = rep4;
    }

    public byte getNumRepCorrecte() {
        return numRepCorrecte;
    }

    public void setNumRepCorrecte(byte numRepCorrecte) {
        this.numRepCorrecte = numRepCorrecte;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quiz.entity.Question[ id=" + id + " ]";
    }
    
}
