package acme.entities.info;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	

	@NotBlank
	protected String			symbol;
	
	@NotNull
	protected Date 				deadline;
	
	@Valid
	protected Money				money;
	
	@NotNull
	protected Boolean			flag;
}
