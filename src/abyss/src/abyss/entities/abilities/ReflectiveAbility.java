package abyss.entities.abilities;

import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.entities.abilities.Ability;

public class ReflectiveAbility extends Ability {
	public float damage, radius;
	public boolean damagesAir, damagesGround;
	public Effect damageEffect;
	float health = -1f;

	public ReflectiveAbility(float damage, float radius, boolean damagesAir, boolean damagesGround, Effect damageEffect) {
		this.damage = damage;
		this.radius = radius;
		this.damagesGround = damagesGround;
		this.damagesAir = damagesAir;
		this.damageEffect = damageEffect;
	}
	public ReflectiveAbility(float damage, float radius, boolean damagesAir, boolean damagesGround) {
		this.damage = damage;
		this.radius = radius;
		this.damagesGround = damagesGround;
		this.damagesAir = damagesAir;
		this.damageEffect = Fx.none;
	}
	public ReflectiveAbility(float damage, float radius) {
		this.damage = damage;
		this.radius = radius;
		this.damagesGround = true;
		this.damagesAir = true;
		this.damageEffect = Fx.none;
	}

	@Override
	public void update(Unit unit) {
		if (health > unit.health) {
			Damage.damage(unit.team, unit.x, unit.y, radius, damage, damagesAir, damagesGround);
			damageEffect.at(unit.x, unit.y);
		}
		health = unit.health;
	}
}