package edu.century.game.entity;

import edu.century.game.Tile;
import edu.century.game.effect.Effect;
import edu.century.game.race.Race;


public class Character extends Entity
{
	private double health, maxHealth, attack, defence;
	private Item armor, weapon;
	private Race race;
	private Tile currentTile;
	private Effect[] effects = new Effect[64];
	private double potionPower;

	public Character(Tile currentTile, Race race)
	{
		this.entityType = EntityType.CHARACTER;

		this.currentTile = currentTile;
		this.race = race;

		this.health = this.maxHealth = 125 + this.race.getHealthMod();
		this.attack = 25 + this.race.getAttackMod();
		this.defence = 25 + this.race.getDefenceMod();
		
		addEffect(race.getEffect(this));

	}

	public static void damage(Character caster, Character target, DamageType damageType, double damage)
	{
		switch(damageType)
		{
		case PHYSICAL:
			// Damage(defender) =
			// ceiling((100/(100+Def(defender)))*Atk(Attacker))
			target.takeDamage(Math.ceil((100 / (100 + target.getDefence())) * damage));
			break;
		case ELEMENTAL:
			target.takeDamage(damage);
			// Elemental damage goes through armor for now
			break;
		}
	}

	public void addEffect(Effect effect)
	{
		if(effect != null)
		{
			for(int i = 0; i < effects.length; i++)
			{
				if (effects[i] == null)
				{
					effects[i] = effect;
					return;
				}
			}
			// TODO: handle the case where effects[] is full
		}
		//This character's race doesn't have a special effect
	}

	public void takeDamage(double amount)
	{
		this.health -= amount;
		// Check if dead, handle it
	}

	public void takeHeal(double amount)
	{
		this.health = Math.min(this.health + amount, this.maxHealth);
	}

	public void updateStats()
	{
		potionPower = 1;
		maxHealth = 100 + race.getHealthMod();
		attack = race.getAttackMod();
		defence = race.getDefenceMod();
		for(int i = 0; i < effects.length; i++)
		{
			if (effects[i] != null)
			{
				effects[i].applyEffect(this);
			}
		}
	}

	public double getAttack()
	{
		return attack;
	}

	public double getDefence()
	{
		return defence;
	}
	
	public void modMaxHealth(double amount)
	{
		potionPower += amount;
	}
	
	public void modAttack(double amount)
	{
		attack += amount;
	}
	
	public void modDefence(double amount)
	{
		defence += amount;
	}
	
	public void modPotionPower(double amount)
	{
		potionPower += amount;
	}
	
	//Called at end of turn
	public void decrementEffectDurations(Effect[] effects)
	{
		for(int i = 0; i < effects.length; i++)
		{
			if (effects[i].getDuration() == 0)
			{
				//TODO: Destroy Effect object

				// Remove object from effects array
				effects[i] = null;
			}
		}
	}
}