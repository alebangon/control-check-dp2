package acme.entities.info;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Info extends DomainEntity {
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	@Length(min=5,max=250)
	@NotBlank
	protected String			information;
	
	@NotNull
	protected Date 				moment;
	
	@Valid
	protected Money				money;
	
	@NotNull
	protected Boolean			flag;
}
