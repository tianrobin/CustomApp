package com.custom.modle.system;

import com.custom.common.BaseObject;

import javax.persistence.*;

/**
 * Created by robin.tian on 16-3-31.
 */
@Entity
@Table(name = "p_sequence")
public class Sequence extends BaseObject{

    private static final long serialVersionUID = 9155071788286413166L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "prefixion")
    private String prefixion;

    @Column(name = "current_value")
    private Integer current_value=0;

    @Column(name = "increment")
    private Integer increment=1;

    public String getName() {
        return name;
    }

    public Sequence setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrefixion() {
        return prefixion;
    }

    public Sequence setPrefixion(String prefixion) {
        this.prefixion = prefixion;
        return this;
    }

    public Integer getCurrent_value() {
        return current_value;
    }

    public Sequence setCurrent_value(Integer current_value) {
        this.current_value = current_value;
        return this;
    }

    public Integer getIncrement() {
        return increment;
    }

    public Sequence setIncrement(Integer increment) {
        this.increment = increment;
        return this;
    }

    public long getId() {
        return id;
    }

    public Sequence setId(long id) {
        this.id = id;
        return this;
    }
}
