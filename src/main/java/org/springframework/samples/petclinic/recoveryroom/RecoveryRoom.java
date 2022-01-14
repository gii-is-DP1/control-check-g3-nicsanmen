package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_room")
public class RecoveryRoom extends BaseEntity{
    
	@NotNull
    @Min(3)
    @Max(50)
	@Column(name= "name")
	String name;
    
    @PositiveOrZero
    @NotNull
    @Column(name = "size")
    double size;
    
    @NotNull
    @Column(name = "secure")
    boolean secure;
    
    @Transient
    @ManyToOne(optional = false)
    @JoinColumn(name = "recovery_room_type")
    RecoveryRoomType roomType;
}
