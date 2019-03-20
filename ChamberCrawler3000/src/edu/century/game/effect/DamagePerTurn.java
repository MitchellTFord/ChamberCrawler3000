package edu.century.game.effect;

import edu.century.game.entity.Character;
import edu.century.game.entity.DamageType;

//This class is intended to serve as an template for creating new Effects
public class DamagePerTurn extends Effect
{
	DamageType damageType;
	
	public DamagePerTurn(Character affectedCharacter, String effectName, double magnitude, int duration, DamageType damageType, Character caster) 
	{
		super(affectedCharacter, effectName, magnitude, duration);
		this.damageType = damageType;
		this.caster = caster;
	}
	
	@Override
	public void applyEffect() 
	{
		Character.doDamage(caster, affectedCharacter, damageType, magnitude);
	}

	@Override
	public void applyStatChange() 
	{
		
	}
}