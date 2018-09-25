/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Diend
 */
public class KartuATM {
    public enum TypeKartu {
        SILVER(5000000L), GOLD(10000000L), PLATINUM(100000000L), NONE(1L);
        
        private final Long limit;
        
        TypeKartu(Long lim) {
            limit = lim;
        }

        public Long getLimit() {
            return limit;
        }
        
    }
    
    private TypeKartu type;
    private Tabungan tabungan;

    public KartuATM(Tabungan tabungan) {
        this.tabungan   = tabungan;
        type            = TypeKartu.NONE;
    }
    
    public TypeKartu getType() {
        return type;
    }

    public void setType(TypeKartu type) {
        this.type = type;
    }  

    public Tabungan getTabungan() {
        return tabungan;
    }
}
