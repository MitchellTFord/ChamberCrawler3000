package com.mitchelltford.game.entity.race.player_races;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.mitchelltford.game.effect.Effect;
import com.mitchelltford.game.effect.HealPerTurn;
import com.mitchelltford.game.entity.Creature;
import com.mitchelltford.game.entity.race.Race;
import com.mitchelltford.game.graphics.Assets;

public class Troll extends Race
{
	public Troll()
	{
		super("Troll", -5, 0, 0, "regains 5 HP every turn; HP is capped at 120");
	}
	
	@Override
	public Effect getEffect(Creature character)
	{
		//HP is capped at 120
		character.setHealthHardCap(120);
		
		//Regenerates 5 health per turn
		return new HealPerTurn(character, "Ritual of Regeneration (heal per turn)", 5, -1, null);
	}
	
	@Override
	public BufferedImage getRaceSprite() 
	{
		return Assets.raceSprites.getSprite(5, 0);
	}
	
	@Override
	public ImageIcon getRaceIcon() 
	{
		return Assets.raceSprites.getSpriteAsIcon(5, 0);
	}
}

/*
0	Shade:		125 HP, 25 Atk,	25 Def
1	Drow:		150 HP, 25 Atk, 15 Def, all potions have their effect magnified by 1.5
2	Vampire:	50 HP,	25 Atk, 25 Def, gains 5 HP every successful attack and has no maximum HP
3	Troll: 		120 HP, 25 Atk, 15 Def, regains 5 HP every turn; HP is capped at 120 HP
4	Goblin:		110 HP, 15 Atk, 20 Def, steals 5 gold from every slain enemy
*/